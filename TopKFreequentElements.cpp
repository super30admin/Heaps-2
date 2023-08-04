// Time Complexity -> O(n*log(k)), n is the size of 'nums' vector
// Space Complexity -> O(n+k), n is the size of 'nums' vector
class Solution {
    struct cmp{
      bool operator()(const vector<int>& n1, const vector<int>& n2){
          return n1[1] > n2[1];
      }  
    };
    
public:
    vector<int> topKFrequent(vector<int>& nums, int k) {
        int n = nums.size();
        unordered_map<int, int> myMap;
        
        for(int num : nums)
            myMap[num]++;
        
        priority_queue<vector<int>, vector<vector<int>>, cmp> pq;
        
        for(auto& itr : myMap){
            pq.push({itr.first, itr.second});
            if(pq.size() >= k+1)
                pq.pop();
        }
        
        vector<int> topK;
        while(!pq.empty()){
            vector<int> curr = pq.top(); pq.pop();
            topK.push_back(curr[0]);
        }
        
        return topK;
    }
};