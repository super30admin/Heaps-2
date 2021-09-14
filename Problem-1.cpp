//nlogk  + O(k) space
class Solution {
public:
    vector<int> topKFrequent(vector<int>& nums, int k) {
        unordered_map<int, int> umap;
        for(auto num: nums){
            umap[num]++;
        }
        vector<int> ans;
        // pair<first, second>: first is frequency,  second is number
        priority_queue<pair<int,int>> pq;
        for(auto mp: umap){
            pq.push(make_pair(mp.second, mp.first));
        }
        int count  = 0;
        while(count < k){
            count++;
            ans.push_back(pq.top().second);
            pq.pop();
        }
        return ans;
    }
};
