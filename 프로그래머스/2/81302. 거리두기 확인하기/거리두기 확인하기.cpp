#include <string>
#include <vector>
#include <iostream>
#include <queue>

// 25 * 5 가 탐색시간, 모든 사람에 대해서 해도 될듯? 
// 사람이 대기실 25명이라 쳤을때 25에 대해서 25칸을 탐색하는거니까 그리고 그게 5개라 5^5 가능하다.

using namespace std;

vector<vector<int>> vis(5, vector<int>(5, 0));
vector<vector<char>> mp(5, vector<char>(5, 0));

int dy[] = {-1, 0, 1, 0};
int dx[] = {0, 1, 0, -1};


int bfs(int y, int x){
    int ret = 10;
    vis[y][x] = 1;
    queue<pair<int, int>> q;
    q.push({y, x});
    while(!q.empty()){
        auto [cy, cx] = q.front();
        q.pop();
        for(int d=0; d<4; d++){
            int ny = cy+dy[d], nx=cx+dx[d];
            if(ny<0 || ny>=5 || nx<0 || nx>=5) continue;
            if(vis[ny][nx]) continue;
            if(mp[ny][nx] == 'X') continue;
            vis[ny][nx] = vis[cy][cx]+1;
            q.push({ny, nx});
            if(mp[ny][nx] == 'P') {
                ret = min(ret, vis[ny][nx]);
            }
        }
    }
    return ret;
}


vector<int> solution(vector<vector<string>> p) {
    vector<pair<int, int>> per;
    vector<int> ans;
    
    int t=0;
    while(t<5){
        int mn = 10;
        
        for(int i=0; i<5; i++){
            for(int j=0; j<5; j++){
                mp[i][j] = p[t][i][j];
                if(p[t][i][j] == 'P'){
                    per.push_back({i, j});
                }
            }
        }
        
        for(auto [y, x] : per){
            mn = min(mn, bfs(y, x));
            for(int i=0; i<5; i++){
                for(int j=0; j<5; j++){
                    vis[i][j] =0;
                }
            }
        }
        // cout << q.front().first << " : " << q.front().second;
        
        
        per.clear();
        
        if(mn <= 3) ans.push_back(0);
        else ans.push_back(1);
        
        t++;
    }

    return ans;
}