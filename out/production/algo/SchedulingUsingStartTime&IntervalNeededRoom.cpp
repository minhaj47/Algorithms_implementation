#include <bits/stdc++.h>
using namespace std;
int occupied[9][7];
int main()
{
    int n, total_room = 0;
    cin >> n;
    set<pair<int, pair<string, int>>> s;
    for(int i = 0; i < n; i++)
    {
        string s1;
        int time_span, deadline;
        cin >> s1 >> time_span >> deadline;
        s.insert({deadline, {s1, time_span}});
    }
    for(auto &x : s)
    {
        bool if_checked = 1;
        int d = x.first - 10;
        string ct = x.second.first;
        for(int i = 0; if_checked; i++)
        {
            if(!occupied[i][d] && ct[0] == 'T') occupied[i][d] = 1, if_checked = 0;
            if(ct[0] == 'L' && !occupied[i][d-2] && !occupied[i][d-1] && !occupied[i][d]) occupied[i][d-2] = 1, occupied[i][d-1] = 1, occupied[i][d] = 1, if_checked = 0;
        }
    }
    for(int i = 0; i < 9; i++){
        for(int j = 0; j < 7; j++)
            cout << occupied[i][j] << " ";
        cout << endl;
    }
    for(int i = 0; i < 9; i++)
        for(int j = 0; j < 7; j++)
            if(occupied[i][j]) {
                total_room++;
                break;
            }
    cout << total_room << endl;
    return 0;
}