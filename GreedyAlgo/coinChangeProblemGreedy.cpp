#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
const int N = 100005;

int main()
{
    ios_base::sync_with_stdio(false);cin.tie(NULL);

    int coin [25] = {1, 2, 5, 10, 50, 100, 500, 1000};
    int sum, count = 0;
    int n = 7;
    vector<int>ans;
    cin >> sum;
    for(int i=n; i>=0 and n; i--){
        if(sum<coin[i])continue;
        int p = sum/coin[i];
        sum = sum - p*coin[i];
        count+=p;
        while(p--){
            ans.push_back(coin[i]);
        }
    }
    
    if(sum)
        cout << "Impossible\n";
    else{
        cout << count << endl;
        for(int x: ans){
            cout << x << " ";
        }
        cout << endl;
    }
    return 0;
}