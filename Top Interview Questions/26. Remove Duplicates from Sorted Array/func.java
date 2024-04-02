class Solution {
    public int removeDuplicates(int[] nums) {
        int read = 0 , write = 0, len = nums.length;

        while(read < len){
            if(nums[write] == nums[read]){
                read++;
            }
            else{
                swap(write + 1 , read, nums);
                read++;
                write++;
            }
        }

        return write + 1;

    }

    public void swap(int i , int j , int[] nums){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
