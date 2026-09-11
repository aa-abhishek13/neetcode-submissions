class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> box= new HashMap<>();
        for(int i=0; i<nums.length;i++){
            int remaining= target-nums[i];
            if(box.containsKey(remaining)){
                return new int[] {box.get(remaining),i};
            }
            box.put(nums[i],i);
        }
            return new int[] {-1,-1};
     }
 }

