#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
const int N = 100005;
ll  h[N];
ll dp[N];

ll func(int n){ //returns the minimum cost to reach n 
    if(n==1)return 0;
    if(n==2)return abs(h[2]-h[1]);

    if(dp[n]!=-1){
        return dp[n];
    }
    ll cost1 = func(n-1)+abs(h[n-1]-h[n]);
    ll cost2 = func(n-2)+abs(h[n-2]-h[n]);

    return dp[n] = min(cost1, cost2);
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