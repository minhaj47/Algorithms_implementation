#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
const int N = 100005;
int n, capacity, item[N], profit[N], dp[105][N];


int knap(int w, int index){
    
    if(w<=0 || index>=n){
        return 0;
    }
    if(dp[index][w]!=-1){
        return dp[index][w];
    }
    int prof = knap(w, index +1);
    if(w - item[index] >=0){
        prof = max(prof, profit[index] + knap(w - item[index], index+1));
    }
    return dp[index][w] = prof;

}

int main()
{
    ios_base::sync_with_stdio(false);cin.tie(NULL);

    std:: cin >> n >> capacity;
    for(int i=0; i<n; i++ ){
        std::cin >> item[i];
        std::cin >> profit[i]; 
    }
    memset(dp, -1, sizeof(dp));
    int ans = knap(capacity, 0);
    std :: cout << ans << endl;
    return 0;
}