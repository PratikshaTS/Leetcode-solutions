class Solution {
    List<List<Integer>>result=new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        //step 1 deal with duplicates
        Arrays.sort(nums);
        //backtracking
        backtrack(nums,0,new ArrayList<>());
        return result;
    }
    void backtrack(int[] nums, int start,List<Integer>path){
        result.add(new ArrayList<>(path));
        //step save the current subset
        for (int i=start;i<nums.length;i++){
            //dealing with duplicates
            if(i>start && nums[i]==nums[i-1])
                continue;
            path.add(nums[i]);
            backtrack(nums,i+1,path);
            path.remove(path.size()-1);
        }
    }
}