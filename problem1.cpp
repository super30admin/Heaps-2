#include<iostream>
#include<vector>
#include<queue>
#include<unordered_set>

using namespace std;

/*
// Time Complexity : O(nlogn)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
Build hashmap for frequency 
Insert them into heap on the basis of their frequency 
pop the first k elements
*/


struct CustomComparator{
    bool operator()(vector<int>& n1,vector<int>& n2){
        return n1.at(1)<n2.at(1); //decreasing order.
    }
};


class Solution {
    
public:
    vector<int> topKFrequent(vector<int>& nums, int k){
        unordered_map<int,int> hash_map{};
        priority_queue<vector<int>,vector<vector<int>>,CustomComparator> pq;
        int sz = nums.size();
        for(int& num:nums){
            if(hash_map.find(num) == hash_map.end()){
                hash_map[num] = 0;
            }
            hash_map[num]++;
        }
        for(auto x:hash_map){
            vector<int> temp{x.first,x.second};
            pq.push(temp);
        }
        vector<int> res{};
        for(int i{};i<k;++i){
            res.push_back(pq.top().at(0));
            pq.pop();
        }
        return res;
    }
};