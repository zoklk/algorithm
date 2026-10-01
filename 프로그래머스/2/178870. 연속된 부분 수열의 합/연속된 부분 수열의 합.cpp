#include <string>
#include <vector>

//연속 부분수열
// 합은 k
// k이면서 길이가 제일 짧은 수열.
// 길이가 여러개면 앞에 있는거 찾기
// 투포인터 + 누적합? 한쪽으로 2개 돌리고, i-j가 작으면 그거로 갱신 + ans백터 갱신

using namespace std;

vector<int> solution(vector<int> s, int k) {
    
    int j=0, mn=1e6+4, sum=0;
    int l=0, r=0;
    for(int i=0; i<s.size(); i++){
        sum+=s[i];
        while(sum > k && j<s.size()){
            sum -= s[j++];
        }
        if(sum == k){
            if(i-j+1 < mn){
                mn = i-j+1;
                l=j;
                r=i;
            }
        }
    }
    
    vector<int> ans;
    ans.push_back(l);
    ans.push_back(r);
    
    
    return ans;
}