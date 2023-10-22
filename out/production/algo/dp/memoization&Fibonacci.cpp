#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
const int N = 1000005;

ll dp[N];

//TOP DOWN APPROach
// big problem --> many smaller problems
ll fib(int n){
    if(n==0)return 0;
    if(n==1)return 1;
    if(dp[n]!=-1)return dp[n];

    return dp[n] = fib(n-1)+fib(n-2);
}

int main()
{
    ios_base::sync_with_stdio(false);cin.tie(NULL);
    memset(dp, -1, N);

    int t;
    cin >> t ;

    // BOTTOM UP APPROACH
    //small problem --> big one

    // dp[0] = 0;
    // dp[1] = 1;

    // for(int i=2; i<=N; i++){
    //     dp[i]= dp[i-2]+dp[i-1];
    // }

    cout << fib(t) << endl;
    //cout << dp[t] << endl;

    return 0;
}