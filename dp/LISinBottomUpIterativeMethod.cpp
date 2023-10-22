
#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
const int N = 100005;
int dp[N];  // store the LIS till the index
vector<int>a(N);

int main()
{
    ios_base::sync_with_stdio(false);cin.tie(NULL);

    int n;
    cin >> n; 

    for(int i= 0; i<n; i++){
        cin >> a[i];
    }

    int ans =1;
    for(int i=0; i<n; i++){
        dp[i]=1;
        for(int j=0; j<i; j++){
            if(a[i]>a[j]){
                dp[i]= max(dp[j]+1, dp[i]);
                ans = max(ans, dp[i]);  
            }  
        }
    }
    cout << ans << endl;

    return 0;
}