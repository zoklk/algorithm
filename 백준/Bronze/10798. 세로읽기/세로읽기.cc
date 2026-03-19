#include<iostream>
#include<vector>
#include<string>

int main() {
    std::ios_base::sync_with_stdio(false);
    std::cin.tie(nullptr);

    std::vector<std::string> v(5);

    for(int i=0; i<5; i++){
        std::cin >> v[i];
    }

    for(int j=0; j<15; j++){
        for(int i=0; i<5; i++){
            if(j < v[i].size()) std::cout << v[i][j];
        }
    }

    return 0;
}