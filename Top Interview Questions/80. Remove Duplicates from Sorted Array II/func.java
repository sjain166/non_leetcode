class Solution {
    public int removeDuplicates(int[] nums) {
        int write = 0 , read = 1 , len = nums.length, ct = 0;
        
        while(read < len){
            if(nums[read] == nums[write]){
                ct++;
                if(ct < 2){
                    swap(write + 1 , read , nums);
                    write++;
                    read++;
                }
                else
                    read++;
            }
            else{
                ct = 0;
                swap(write + 1 , read , nums);
                write++;
                read++;
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
