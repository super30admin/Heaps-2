//time complexity O(N) where n is the total number of nested elements in the given list
//space complexity O(D) where D is the max depth since thats the size of the recursive stack

class Solution {
    int sum = 0;
    public int depthSum(List<NestedInteger> nestedList) {
        dfs(nestedList, 1);
        return sum;
    }
    private void dfs(List<NestedInteger> nestedList, int depth){
        //base

        //logic
        for(NestedInteger ele: nestedList){
            if(ele.isInteger()){
                sum += depth*ele.getInteger();
            } else{
                dfs(ele.getList(), depth + 1);
            }
        }
    }
}
