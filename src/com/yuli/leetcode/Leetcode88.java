package com.yuli.leetcode;

/**
 * 两数组排序
 * 采用双指针原地排序，将两数组最大的数，放在nums1最后，往前遍历
 */
public class Leetcode88 {
    public void merge(int[] nums1, int[] nums2){
        merge(nums1,nums1.length,nums2,nums2.length);
    }
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int k = m + n;
        for (int index = k - 1,nums1Index = m - 1, nums2Index = n - 1; index >= 0; index--) {
            if(nums1Index < 0){//num1取完，完全取nums2的值
                nums1[index] = nums2[nums2Index--];
            }else if(nums2Index < 0){//num2取完，完全取num1的值
//                nums1[index] = nums1[nums1Index--];
                break;
            }else if(nums1[nums1Index] > nums2[nums2Index]){ //nums1的值大于nums2的值，取nums1的值
                nums1[index] = nums1[nums1Index--];
            }else {//nums2的值大于nums1的值，取nums2的值
                nums1[index] = nums2[nums2Index--];
            }
        }
    }
}
