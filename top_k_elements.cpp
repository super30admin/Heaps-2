// Time Complexity : O(nlogk)
// Space Complexity : O(n)
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
//1. Create a hashmap with frequenecy count
//2. Create a min heap where you sort based on the frequency, but only put in numbers from the input
//3. Return the elements of the queue 


class Solution {
public:
    vector<int> topKFrequent(vector<int>& nums, int k) {
        //edge
        vector<int> result;
        if(nums.size()==0){
            return result;
        }
        
        //logic
        unordered_map<int,int> my_map;
        for(int i=0; i<nums.size();i++){
            ++my_map[nums[i]];
           // cout<<my_map[nums[i]]<<" "<<nums[i]<<endl;
        }
        //min_heap
        priority_queue<int, vector<int>, function<bool(const int, const int)>> my_queue([&my_map] (const int &a, const int &b){return my_map[a] > my_map[b];});
        
        for(auto i: my_map){
           // cout<<i.first<<"\t";
            my_queue.push(i.first);
            //cout<<my_queue.top()<<endl;
            if(my_queue.size()>k){
                //cout<<my_queue.top()<<endl;
                my_queue.pop();
            }
        }
        
        while(my_queue.size()>0){
            result.push_back(my_queue.top());
            my_queue.pop();
        }
        
        return result;
    }
};


// Time Complexity : O(n)
// Space Complexity : O(1)
// Any problem you faced while coding this :

//Create the input frequency count for 1 greater than expected

// Your code here along with comments explaining your approach
//1. Create a hashmap of frequency count
//2. Create an vector of vectors for each frequency components. As we know the max frequency can be the length of the array
//3. We create an array of that length
//4. Add elements at respective frequency
//5. Add top k elements to the result and return.

class Solution {
public:
    vector<int> topKFrequent(vector<int>& nums, int k) {
        //edge
        vector<int> result;
        if(nums.size()==0){
            return result;
        }
        result.assign(k,0);
        //logic
        unordered_map<int,int> my_map;
        for(int i=0; i<nums.size();i++){
            ++my_map[nums[i]];
           // cout<<my_map[nums[i]]<<" "<<nums[i]<<endl;
        }
        //bucket_sort
        vector<vector<int>> my_array(nums.size()+1);
        //cout<<my_array.size()<<endl;
        for(auto i: my_map){
           my_array[i.second].push_back(i.first);
        }
        
        for(int i=my_array.size()-1; i>=0; i--){
            if(!my_array[i].empty()){
                int j=0;
                while(k>0 && j<my_array[i].size()){
                    result[k-1] = my_array[i][j];
                    k--;
                    j++;
                }
                if(k==0){
                    return result;
                }
            }
        }
        
        return result;
    }
};
