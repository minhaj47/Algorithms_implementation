#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
const int N = 100005;
int dp[N];
vector<int>a(N);

int lis(int n){
    if(dp[n]!=-1)
        return dp[n];
    int ans = 1;
    for(int i=n-1; i>=0; i--){
        if(a[i]<a[n]){
            ans = max(ans, lis(i)+1);
        }
    }
    return dp[n] = ans;
}

int main()
{
    ios_base::sync_with_stdio(false);cin.tie(NULL);

    int n;
    cin >> n; 

    for(int i= 0; i<n; i++){
        cin >> a[i];
    }

    memset(dp, -1, sizeof(dp));

    int ans =1;
    for(int i=0; i<n; i++){
         ans = max(ans, lis(i));
    }
    cout << ans << endl;

    return 0;
}
