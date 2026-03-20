#include<iostream>
#include<vector>
#include<algorithm>

int main() {
    std::ios_base::sync_with_stdio(false);
    std::cin.tie(nullptr);

    int N, M, tmp;
    std::cin >> N;
    std::vector<int> v(N);
    for(int i=0; i<N; i++){
        std::cin >> v[i];
    }
    std::sort(v.begin(), v.end());

    std::cin >> M;
    while(M--){
        std::cin >> tmp;
        bool found = std::binary_search(v.begin(), v.end(), tmp);
        std::cout << (int)found << ' ';
    }

    return 0;
}