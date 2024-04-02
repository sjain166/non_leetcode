class Solution {
    public int removeElement(int[] nums, int val) {

        int write = 0;
        int read = 0;
        int len = nums.length;

        while(read < len){
            if(nums[read] == val){
                read++;
            }
            else{
                int temp = nums[read];
                nums[read] = nums[write];
                nums[write] = temp;
                write++;
                read++;
            }
        }

        return write;
    }
}
