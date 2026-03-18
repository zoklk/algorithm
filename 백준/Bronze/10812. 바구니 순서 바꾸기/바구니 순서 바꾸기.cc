#include<iostream>
#include<vector>
#include<algorithm>

int main(){
    std::ios_base::sync_with_stdio(false);
    std::cin.tie(nullptr); std::cout.tie(nullptr);

    int n, m;
    std::cin >> n >> m;
    std::vector<int> v(n);
    for(int i=0; i<n; i++) v[i]=i+1;

    while(m--){
        int i, j, k;
        std::cin >> i >> j >> k;
        std::rotate(v.begin()+i-1, v.begin()+k-1, v.begin()+j);
    }

    for(int i=0; i<n; i++) std::cout << v[i] << " ";

    return 0;
}