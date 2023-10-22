#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
const int N = 100005;

bool compare(pair<int,int>p1, pair<int, int>p2){
    return ((double)p1.second/p1.first) > ((double)p2.second/p2.first);
}

int main()
{
    ios_base::sync_with_stdio(false);cin.tie(NULL);

    int n;
    cin >> n;
    map<double , string>mp;
    vector<pair<int, int>>items(n);
    for(int i=0; i<n; i++){
        string item;
        cin >> item >> items[i].first >> items[i].second;
        mp[(double)items[i].second/items[i].first]= item;
    }
    sort(items.begin(), items.end(), compare);
    for(int i=0; i<n; i++){
        cout << mp[(double)items[i].second/items[i].first] << " " << items[i].first << " " << items[i].second << endl;
    }
    cout << endl;
    double wt, profit = 0;
    cin >> wt;
    for(int i=0; i<n and wt; i++){
        if(wt<items[i].first){
            profit+=(wt/items[i].first)*items[i].second;
            cout << mp[(double)items[i].second/items[i].first] << " " << wt/ (items[i].first) << " " << wt/items[i].first*items[i].second << endl;
            wt=0;
        }
        else {
            wt-=items[i].first;
            profit+=items[i].second;
            cout << mp[(double)items[i].second/items[i].first] << " " << items[i].first << " " << items[i].second << endl;
        }
    }
    cout << profit << endl;
    return 0;
}