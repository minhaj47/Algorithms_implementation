#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
const int N = 100005;

int lcs(int i, int j, string a, string b){
    if(i==a.size() or j==b.size()){
        return 0;
    }
    if(a[i]==b[j]){
        return 1 + lcs(i+1, j+1, a, b);
    }
    return max(lcs(i+1, j, a, b), lcs(i, j+1, a, b));
}

int main()
{
    ios_base::sync_with_stdio(false);cin.tie(NULL);

    string a = "adfjdafkjbjdopcfudsopfodspifdsopfiddspfopdfjsdopfsdpaofjaopfjopcd\0";
    string b = "abcd\0";
    int dp[100][100];
    memset(dp, -1, sizeof(dp));

    int ans = lcs(0, 0, a, b);
    std :: cout << ans << endl;
    return 0;
}