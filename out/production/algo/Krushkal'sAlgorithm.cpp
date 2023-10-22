// #include <bits/stdc++.h>
// using namespace std;
// typedef long long ll;
// const int N = 100005;

// int parent[N];
// int Size[N];

// void make(int v){
//     parent[v]= v;
//     Size[v]= 1;

// }
// int find(int v){
//     if(parent[v]==v)
//         return v;
//     return parent[v] = find(parent[v]);
// }
// void Union(int a, int b){
//     a = find(a);
//     b = find(b);
//     if(Size[a] < Size[b]){
//         swap(a, b);
//     }
//     //if(a==b)return;
//     parent[b] = a;
//     Size[a]+=Size[b];
// }

// int main()
// {
//     ios_base::sync_with_stdio(false);cin.tie(NULL);

//     int n, m;
//     cin >> n >> m;
//     vector<pair<int, pair<int, int>>>edges;
//     for(int i=0; i<m; i++){
//         int a, b, w;
//         cin >> a >> b >> w;
//         edges.push_back({w, {a, b}});
//     }
//     sort(edges.begin(), edges.end());

//     for(auto x: edges){
//         cout << x.first << " " << x.second.first << " " << x.second.second << endl; 
//     }
//     cout << endl;

//     for(int i=1; i<=n; i++){
//         make(i);
//     }
//     int totalCost = 0;

//     for(auto x: edges){
//         int a = x.second.first;
//         int b = x.second.second;
//         if(find(a)==find(b))continue;
//         Union(a, b);
//         cout << a << " " << b << endl;
//         totalCost += x.first;
//     }

//     cout << endl << totalCost << endl;

//     return 0;
// }

#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
const int N = 100005;

int parent[N], Size[N];

void make(int i){
    parent[i]= i;
    Size[i]= 1;
}
int find(int v){
    if(parent[v]==v){
        return v;
    }
    return parent[v] = find(parent[v]);
}
void Union(int a, int b){
    int a = find(a);
    int b = find(b);
    if(a==b)return;
    if(Size[a]<Size[b])
        swap(a,b);
    parent[b]= a;
    Size[a]+=Size[b];
}


int main()
{
    ios_base::sync_with_stdio(false);cin.tie(NULL);

    int n, e;
    vector<pair<int, pair<int,int>>>edges;
    // freopen("input.txt", "r", stdin);
    // freopen("output.txt", "w", stdout);

    cin >> n >> e;
    for(int i=0; i<n; i++){
        int a, b, w;
        cin >> a >> b >> w;
        edges.push_back({w, {a, b}});
    }
    sort(edges.begin(), edges.end());

    for(int i=1; i<=n; i++){
        make(i);
    }
    int total = 0;

    for(auto it : edges){
        int a = it.second.first;
        int b = it.second.second;
        if(find(a)==find(b))continue;
        Union(a, b);
        total+=it.first;
    }
    cout << total << endl;
    
    return 0;
}