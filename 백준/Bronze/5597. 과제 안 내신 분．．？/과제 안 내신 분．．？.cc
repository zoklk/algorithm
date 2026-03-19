#include<iostream>
#include<vector>

int main(){
    std::ios_base::sync_with_stdio(false);
    std::cin.tie(nullptr); std::cout.tie(nullptr);

    int n;
    std::vector<int> v(30,0);

    for(int i=0; i<28; i++){
        std::cin >> n;
        v[n-1]++;
    }

    for(int i=0; i<30;i++){
        if(v[i]!=1) std::cout << i+1 << "\n";
    }

    return 0;
}