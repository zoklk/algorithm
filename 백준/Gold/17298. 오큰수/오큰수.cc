#include<iostream>
#include<vector>
#include<stack>

int main(){
    std::ios_base::sync_with_stdio(false);
    std::cin.tie(nullptr);

    int A;
    std::cin >> A;
    std::vector<int> v(A);
    std::vector<int> ans(A, -1);
    std::stack<int> s;

    for(int i=0; i<A; i++){
        std::cin >> v[i];
    }

    for(int i=0; i<A; i++){
        while(!s.empty() && v[s.top()] < v[i]){
            ans[s.top()]=v[i];
            s.pop();
        }
        s.push(i);
    }

    for(int a : ans){
        std::cout << a << ' ';
    }

    return 0;
}