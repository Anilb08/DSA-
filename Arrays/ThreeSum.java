public class ThreeSum {
    
}  

// time complexity is O(n^2)


class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // corner case 
        if(nums.length < 3 || nums == null){
            return new ArrayList<>();
        }

        Set<List<Integer>>result = new HashSet<>();
        Arrays.sort(nums);

        for(int i=0; i<nums.length-2; i++){
            int left = i+1;
            int right = nums.length-1;

           
            while(left < right){
                int sum = (nums[i]+nums[left]+nums[right]);
               if(sum == 0){
                result.add(Arrays.asList(nums[i],nums[left],nums[right]));
                left++;
                right--;
               }else if(sum < 0){
                left++;
               }else{
                right--;
               }
            
            }
        }

        return new ArrayList<>(result);

    }
}