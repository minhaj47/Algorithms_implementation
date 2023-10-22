#include <bits/stdc++.h>
using namespace std;

typedef long long ll;

int main()
{
    ios_base::sync_with_stdio(false);cin.tie(NULL);

    const int N = 1e5+7;
    const int m = 1e9+7;
    const int p = 65;
    ll hash_value[N];
    ll power [N];

    string text = "The Rabin-Karp string matching algorithm calculates a hash value for the pattern, as well as for each M-character subsequences of text to be compared. If the hash values are unequal, the algorithm will determine the hash value for next M-character sequence. If the hash values are equal, the algorithm will analyze the pattern and the M-character sequence. In this way, there is only one comparison per text subsequence, and character matching is only required when the hash values match.";
    int t = text.size();
    string pattern = "a";
    int s = pattern.size();


    //calculating powers 0 th to t th 
    power[0] = 1;
    for(int i=0; i<t; i++){
        power[i+1] = (power[i]*p)%m;
    }
    // calculating hash for pattern 
    ll hash_p = 0;

    for(int i=0; i<s; i++){
        int val = pattern[i] - 'a'+ 1;
        hash_p = (hash_p + power[i] * val) % m;
    }
    //cout << hash_p << endl;

    // compute_hash value for size 1 to n 
    ///notable: started from 1 : first hash value is on index 1 and last hash is on t th index

    for(int i=0; i<=t; i++){
        int val1 = text[i] - 'a'+ 1;
        hash_value[i+1] = (hash_value[i] + power[i] * val1) % m;
        //cout << hash_value[i] << " ";
    }

    //cout << endl;
    
    // finding ans
    vector<ll>ans;

    for(int i=0; i<t-s+1; i++){
        
        ll cur_h = (hash_value[i+s] + m - hash_value[i])%m;  // i+s th - i th
        //cout << cur_h << " ";
        if(cur_h == hash_p * power[i] % m){  // i
            ans.push_back(i);
        }
    }
    std :: cout << ans.size() << endl;
    for(auto x : ans){
        std :: cout << x << " ";
    }
    std :: cout << endl;
    
    return 0;
}
