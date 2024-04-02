class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        
        int idx = m;
        for(int i : nums2){
            nums1[idx++] = i;
        }

        Arrays.sort(nums1);
    }
}
