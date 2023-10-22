#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
vector<pair<int, pair<int, string>>>job;

int main()
{
    ios_base::sync_with_stdio(false);cin.tie(NULL);

    int n, cnt=0;
    cin >> n ;
    for(int i=0; i<n; i++){
        int a, b;
        string s;
        cin >> s >> a >> b;
        job.push_back({b,{a, s}});
    }
    sort(job.begin(), job.end());
    auto t = *job.begin();
    int p = t.first;
    cnt++;
    cout << t.first << " " <<  t.second.first << " " <<  t.second.second << endl;
    for(auto it = job.begin()+1; it!= job.end(); it++){ 
        auto q = *it;
        cout << q.first << " " <<  q.second.first << " " << q.second.second << endl;
        if(q.second.first>=p){
            cnt++;
            p=q.first;
        }
    }
    cout << cnt << endl;
    
    return 0;
}