public class ProductOfArray {

    public int[] productExceptSelf(int[] nums) {

        int[] prefixes = new int[nums.length];
        int[] suffixes = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            if (i == 0) {
                prefixes[i] = nums[i];
            } else {
                prefixes[i] = prefixes[i - 1] * nums[i];
            }
        }

        for(int i = nums.length - 1; i > 0; i--) {
            if (i == nums.length - 1) {
                suffixes[i] = nums[i];
            } else {
                suffixes[i] = suffixes[i+1] * nums[i];
            }
        }


        for(int i = 0; i < nums.length; i++) {
            if (i == 0) {
                nums[i] = suffixes[i+1];
            } else if (i == nums.length - 1) {
                nums[i] = prefixes[i-1];
            } else {
                nums[i] = prefixes[i - 1] * suffixes[i + 1];
            }
        }

        return nums;
    }
}
