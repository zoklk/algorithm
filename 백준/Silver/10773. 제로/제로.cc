#include<iostream>
#include<vector>

int main() {
    std::ios_base::sync_with_stdio(false);
    std::cin.tie(nullptr);

    int K, x, sum=0;
    std::cin >> K;
    std::vector<int> v;

    while(K--){
        std::cin >> x;
        if(x!=0) v.push_back(x);
        else v.pop_back();
    }

    for(int x : v) sum+=x;
    std::cout << sum;

    return 0;
}