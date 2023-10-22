#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
const int N = 100005;

static bool comp(const pair<int, pair<int, int>> a, const pair <int, pair<int, int>>b){
    return a.second.second < b.second.second;
}

vector<int> maxMeetings(int start[], int end[], int n){
    vector<pair<int, pair<int,int>>>v;
    for(int i=0; i<n; i++){
        v.push_back({i+1,{start[i], end[i]}});
    }
    sort(v.begin(), v.end(), comp);
    vector<int>ans;
    ans.push_back(v[0].first);
    int prevEnd = v[0].second.second;
    for(auto i = 1; i<n; i++){
        if(v[i].second.first > prevEnd){
            ans.push_back(v[i].first);
            prevEnd = v[i].second.second;
        } 
    }
    return ans;
}

int main()
{
    ios_base::sync_with_stdio(false);cin.tie(NULL);

    int n=6;
    int start[] = {1,3,0,5,8,5};
    int end[] =  {2,4,6,7,9,9};
    vector<int> ans = maxMeetings(start, end, n);
    for(auto x:ans){
        cout << x << " ";
    }
    cout << endl;

    return 0;
}