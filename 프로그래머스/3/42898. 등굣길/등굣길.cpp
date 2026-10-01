#include <string>
#include <vector>
#include <queue>
#include <iostream>

using namespace std;

// m, n이 둘다 100이하 총 칸수 10^4 이하
// 오른쪽이랑 아래만 간다 -> 최단거리 -> bfs
// 경우의수 문제 -> 완탐, dp
// 오른쪽으로 가거나 아래로 가거나 완탐 -> 2^100(m이나 n중 작은쪽.) -> dp
// dp[i][j] = 경우의 수.
int dp[101][101];

int solution(int m, int n, vector<vector<int>> puddles) {
    const int MOD = 1000000007;
    vector<vector<int>> blocked(n + 1, vector<int>(m + 1, 0));
    for(auto& p : puddles) blocked[p[1]][p[0]] = 1;   // p[0]=열, p[1]=행

    dp[1][1] = 1;
    for(int i = 1; i <= n; i++){
        for(int j = 1; j <= m; j++){
            if(i == 1 && j == 1) continue;
            if(blocked[i][j]) continue;
            dp[i][j] = (dp[i-1][j] + dp[i][j-1]) % MOD;
        }
    }
    return dp[n][m];
}