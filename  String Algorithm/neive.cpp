#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
const int N = 100005;

int main()
{
    ios_base::sync_with_stdio(false);cin.tie(NULL);

    string s = "dfkaaludoiugjdlfkjgalualufdaalu";
    string pattern = "alu";
    int S = s.size();
    vector<int>ans;

    for(int i=0; i<S; i++){
        if(s[i]==pattern[0]){
            int k = i;
            bool flag = true;
            for(int j=0; j<pattern.size(); j++){
                if(pattern[j]!=s[k++]){
                    flag = false;
                    break;
                }
            }
            if(flag)ans.push_back(i);
        }
    }
    std :: cout << ans.size() << endl;
    for(int x: ans){
        std :: cout << x << " ";
    }
    std:: cout << endl;
    return 0;
}