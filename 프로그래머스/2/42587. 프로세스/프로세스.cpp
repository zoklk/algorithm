#include <string>
#include <vector>
#include <queue>

using namespace std;

int solution(vector<int> priorities, int location) {
    int answer = 0;
    int t=0;
    // 1. Priority queue에 삽입 + {priorities, idx}인 vector생성
    priority_queue<int> pq;
    vector<pair<int, int>> v;
    for(int i=0; i<priorities.size(); i++){
        pq.push(priorities[i]);
        v.push_back({priorities[i], i});
    }
    
    while(!answer){
        if(v[0].first == pq.top()){
            if(v[0].second == location){
                answer = t+1;
            }
            v.erase(v.begin());
            pq.pop();
            t++;
        } else if(v[0].first < pq.top()){
            v.push_back(v[0]);
            v.erase(v.begin());
        }
        
    }
    
    // 2. queue에서 location의 프로세스가 실행될때까지 반복
    
    
    return answer;
}