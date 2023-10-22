#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
const int N = 100005;
ll  h[N];
ll dp[N];

ll func(int n){ //returns the minimum cost to reach n 
    if(n==1)return 0;
    if(dp[n]!=-1){
        return dp[n];
    }
    ll cost = INT_MAX;

    for(int i=1; i<n; i++){
        return min(cost, func(n-i)+ abs(h[n]-h[n-i]));
    }
    return dp[n] = cost;
}

int main()
{
    ios_base::sync_with_stdio(false);cin.tie(NULL);

    int n;
    cin >> n;
    memset(dp, -1, sizeof(dp));
    for(int i=1; i<=n;i++){
        cin >> h[i];
    }

    cout << func(n) << endl;
    return 0;
}