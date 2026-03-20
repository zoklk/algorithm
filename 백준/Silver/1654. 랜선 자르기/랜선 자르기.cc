#include<iostream>
#include<vector>
#include<algorithm>

int main() {
    std::ios_base::sync_with_stdio(false);
    std::cin.tie(nullptr);

    int K, N;
    long long left=1, right=0;
    std::cin >> K >> N;
    std::vector<long long> v(K);
    for(int i=0; i<K; i++){
        std::cin >> v[i];
        right+=v[i];
    }

    right/=N;
    while(left<=right){
        long long mid = (left+right)/2;
        long long count=0;
        for(int i=0; i<K; i++){
            count+=v[i]/mid;
        }
        if(count>=N) left = mid+1;
        else right = mid-1;
    }

    std::cout << right;
    return 0;
}