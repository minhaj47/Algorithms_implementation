#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
const int N = 100005;

int main()
{
    ios_base::sync_with_stdio(false);cin.tie(NULL);
    
    string a = "adfjdafkjbjdopcfudsopfodspifdabcdeesopfiddspfopdfjsdopfsdpaofjaopfjopcd";
    string b = "abcde";

    // string a = "longest";
    // string b = "stone";
    int dp[100][100];
    memset(dp,0, sizeof(dp));

    int p = a.size();
    int q = b.size();

    for(int i=1; i<=p; i++){
        for(int j=1; j<=q; j++){
            if(a[i-1]==b[j-1]){
                dp[i][j] = 1 + dp[i-1][j-1];
            }
            else dp[i][j] = max(dp[i-1][j], dp[i][j-1]);
        }
    } 
    
    std :: cout << dp[p][q] << endl;
    
    return 0;
}