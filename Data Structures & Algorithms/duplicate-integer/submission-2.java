class Solution {
    public boolean hasDuplicate(int[] nums) {
        HashMap<Integer,Integer> seen= new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(seen.containsKey(nums[i])){
                return true;
            }
            seen.put(nums[i],1);
        } 
        return false;
    }
}