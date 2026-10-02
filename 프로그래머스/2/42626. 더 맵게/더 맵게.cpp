#include <string>
#include <vector>
#include <queue>
#include<iostream>

// 완탐 불가.. -> dp인가?
// dp라면 top down? 정렬은 가능함.
// k보다 높은 숫자의 애들이 영향을 줄일이 있나? <- 모르겠네;
// 항상 최소인것끼리 더하다보면 되나?..? 점점 커지긴 하는데 일단 pq로 해봐야하나


using namespace std;

int solution(vector<int> scoville, int K) {
    int ans = 0;
    priority_queue<int, vector<int>, greater<int>> pq;
    for(int i : scoville){
        pq.push(i);
    }
    
    while(pq.top() < K){
        if(pq.size() == 1){
            ans = -1;
            break;
        }
        int mn = pq.top(); pq.pop();
        int mn2 = pq.top(); pq.pop();
        pq.push(mn + mn2*2);
        ans++;
    }
    
    return ans;
}