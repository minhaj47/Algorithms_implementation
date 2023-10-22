#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
const int N = 100005;
const int INF = 1e9+5;

vector<pair<int, int>>g[N];
int parent[N], dist[N];
bool isAddedToMST[N];
int totalCost;

void PrimsMST(int vertex){
    // for(int i=0; i<N; i++){
    //     dist[i]=INF;
    // }
    set<pair<int,int>> st;
    dist[vertex]= 0;
    st.insert({0, vertex});
    while(!st.empty()){
        auto cur_v = *(st.begin());
        st.erase(cur_v);
        int v = cur_v.second;
        int wt = cur_v.first;
        int par = parent[v];

        if(!isAddedToMST[v]){
            isAddedToMST[v]= true;
            cout << par << " " << v << " " << wt << endl;
            totalCost+=wt;
        }
        

        for(auto child : g[v]){
            int child_v = child.second;
            int w = child.first;
            if(child_v)continue;
            if(dist[N])
            parent[child_v] = v;

            for (auto pair_cost_node : g[child_v]) {
                int adj_node = pair_cost_node.second;
                if (isAddedToMST[adj_node] == false) {
                    st.insert(pair_cost_node);
                }
            }
        }
    }
}

int main()
{
    ios_base::sync_with_stdio(false);cin.tie(NULL);

    int n, m;
    cin >> n >> m;

    for(int i=0; i<m; i++){
        int a, b, w;
        cin >> a >> b >> w;
        g[a].push_back({w, b});
        g[b].push_back({w, a});
    }
    
    PrimsMST(0);

    cout << endl << totalCost << endl;

    return 0;
}