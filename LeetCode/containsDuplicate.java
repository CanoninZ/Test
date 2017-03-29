public class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> s = new HashSet<Integer>();
        if(nums.length == 0 || nums.length == 1 || nums == null) return false;
        for(int i = 0; i < nums.length; i++){
            if(s.contains(nums[i])) return true;
            else
            s.add(nums[i]);
        }
        return false;
    }
}