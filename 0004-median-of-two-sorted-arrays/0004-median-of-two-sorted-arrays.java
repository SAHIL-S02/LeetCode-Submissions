class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double result = 0;
        int n1 = nums1.length;
        int n2 = nums2.length;
        int[] na = new int[n1 + n2];
        int i = 0;
        int j = 0;
        int k = 0;

        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] <= nums2[j]) {
                na[k++] = nums1[i++];
            } else {
                na[k++] = nums2[j++];
            }
        }
        while (i < nums1.length) {
            na[k++] = nums1[i++];
        }

        while (j < nums2.length) {
            na[k++] = nums2[j++];
        }
        if(na.length % 2 == 0){
            System.out.println(na[(na.length/2)-1]);
            System.out.println(na[(na.length/2)]);
            result = (na[(na.length/2)-1] + na[(na.length/2)]);
            result /= 2;
        }else{
            result = na[(na.length/2)];
        }
        return result;
    }
}