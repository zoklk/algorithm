#include <string>
#include <vector>

using namespace std;

pair<int,int> pos(int n){
    if(n==0) return {3, 1};
    return {(n-1)/3, (n-1)%3};
}

int dist(pair<int, int> a, pair<int, int> b) {
    return abs(a.first - b.first) + abs(a.second - b.second);
}
    
    
string solution(vector<int> numbers, string hand) {
    string answer = "";
    pair<int, int> L={3, 0}, R{3, 2};
    
    for(int n : numbers){
        int col=pos(n).second;
        char use;
        
        if(col == 0){
            use = 'L';  
        }
        else if(col == 2){
            use = 'R';
        }
        else{
            int caseL = dist(pos(n), L);
            int caseR = dist(pos(n), R);
            if (caseL < caseR){
                use = 'L';
            }
            else if (caseL > caseR){
                use = 'R';
            }
            else{
                if(hand == "left") use = 'L';
                else use = 'R';
            }
        }
        answer += use;
        if (use == 'L'){
            L=pos(n);
        } else{
            R=pos(n);
        }        
    }
    return answer;
}