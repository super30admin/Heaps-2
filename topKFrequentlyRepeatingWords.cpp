class Solution {
public:
    bool static compare(const pair<int,int> a,const pair<int,int> b){
        return a.second>b.second;           
    }
    vector<int> topKFrequent(vector<int>& nums, int k) {
        if(nums.size()==1)
            return nums;
        
        unordered_map<int,int> um;
        for(auto x:nums) {
            um[x]++;
        }
        vector<pair<int,int>> p(um.begin(),um.end());
        sort(p.begin(),p.end(),compare);
        vector<int> answer;
        int i=0;
        for(auto x:p) {
            if(i>=k) break;
           answer.push_back(x.first); 
            i++;
        }
        return answer;
    }
};