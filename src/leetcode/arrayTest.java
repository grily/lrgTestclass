package leetcode;

public class arrayTest {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
//        给你两个按 非递减顺序 排列的整数数组 nums1 和 nums2，另有两个整数 m 和 n ，分别表示 nums1 和 nums2 中的元素数目。
//        请你 合并 nums2 到 nums1 中，使合并后的数组同样按 非递减顺序 排列
//        输入：nums1 = [1,2,7,0,0,0], m = 3, nums2 = [2,5,6], n = 3
//        输出：[1,2,2,3,5,6]
          int i = m-1;
          int j = n-1;
          int k = m+n-1;
          while(j>=0 || i>=0){
              if(nums2[j] > nums1[i]){
                 nums1[k--] = nums2[j--];
              }else{
                  nums1[k--] = nums1[i--];
              }
          }




    }
}
