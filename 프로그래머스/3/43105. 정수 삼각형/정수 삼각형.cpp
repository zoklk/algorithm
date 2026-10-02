#include <string>
#include <vector>
#include <iostream>

using namespace std;

// 이거는 유명한 dp임. -> 2^500 완탐 불가.
// 점화식은?
// dp[i][j] = dp[i][j]+max(dp[i-1][j-1], dp[i-1][j])
// 왼쪽 정렬했다고 치면, 아래는 위 + 왼쪽꺼. 흠.. 사각형으로 가정해야하나?
// 7 0 0 0 0 0 0 0 0
// 3 8 0 0 0 0 0 0 0
// 8 1 0 0 0 0 0 0 0
// n 500까지 되니까 500x500을 탑다운으로 하긴 좀 그런거같기도 그리고 하면서 mx가 갱신될수 있는 구조인가? 아닌거같은데

int dp[504][504];

int solution(vector<vector<int>> triangle) {
    int ans = 0;
    for(int i=0; i<triangle.size(); i++){
        for(int j=0; j<=i; j++){
            dp[i][j]=triangle[i][j];
        }
    }
    
    for(int i=1; i<triangle.size(); i++){
        for(int j=0; j<=i; j++){
            if(j-1 >=0){
                dp[i][j] = dp[i][j]+max(dp[i-1][j-1], dp[i-1][j]);
            } else {
                dp[i][j] = dp[i][j]+dp[i-1][j];
            }    
        }
    }
    for(int i=0; i<triangle.size(); i++){
        ans = max(ans, dp[triangle.size()-1][i]);
    }
    
    return ans;
}