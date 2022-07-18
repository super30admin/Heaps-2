/* 
    Time Complexity                              :  O(Nlog k)
    Space Complexity                             :  O(k) to hold the values in the priority queue
    Did this code successfully run on Leetcode   :  Yes
    Any problem you faced while coding this      :  No
*/

#include <bits/stdc++.h> 
using namespace std;  

class Solution {
public:
    vector<int> topKFrequent(vector<int>& nums, int k) {
        unordered_map<int,int> mp;
        // O(N)
        for(auto num : nums) {
            mp[num]++;
        }
        
        auto cmp = [&mp](int n1, int n2) {
            return mp[n1] > mp[n2];
        };
        
        priority_queue<int,vector<int>,decltype(cmp)> pq(cmp);
        // O(Nlog k)
        for(auto [key, value] : mp) {
            pq.push(key);
            if(pq.size() > k) pq.pop();
        }

        vector<int> ans;
        //O(k log k)
        while(!pq.empty()) {
            ans.push_back(pq.top());
            pq.pop();
        }
        
        return ans;
    }
};