#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
const int N = 100005;
vector<int>coins(N);
int dp[10005];

int minCoin(int amount, vector<int>& coins){
    if(amount == 0)return 0;
    if(dp[amount]!=-1)return dp[amount];
    int ans = INT_MAX;
    for(auto coin: coins){
        if(amount<coin)
            continue;
        ans = min(ans + 0LL, minCoin(amount-coin, coins) +1LL);
    }
    return dp[amount] = ans;
}

int coinChange(vector<int>& coins, int amount) {
    memset(dp, -1, sizeof(dp));
    int ans = minCoin(amount, coins);
    return ans == INT_MAX?-1: ans;
    }

int main()
{
    ios_base::sync_with_stdio(false);cin.tie(NULL);
    coins = {1, 3, 4, 10};
    int amount;
    cin >> amount;

    cout << coinChange(coins, amount);
    
    return 0;   
}