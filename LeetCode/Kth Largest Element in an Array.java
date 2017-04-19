// public class Solution {
/** 
方法一：recursion， 单边 quickselect
*/
//     public int findKthLargest(int[] nums, int k) {
//         return QuickSelet(nums, 0, nums.length - 1, k);
//     }
//      public int QuickSelet(int[] arr, int low, int high, int k){
         // if (low == high && 1 == k) return arr[high];
//          int i = low;
//          int j = high;
//          int pivot = arr[high];
//          while(i < j){
//             if(arr[i++] < pivot) swap(arr,--i,--j);
//          }
//         //  System.out.println(i + " " );

//          swap(arr,i,high);
//         //  pt(arr);
//          if(i == (k - 1) + low) return arr[i];
//          else if(i > (k - 1) + low) return QuickSelet(arr, low, i-1, k);
//          else return QuickSelet(arr,i+1 ,high, k - i - 1 + low);
//      }
//     public void swap(int[] arr, int x, int y){
//         int tmp = arr[x];
//         arr[x] = arr[y];
//         arr[y] = tmp;
//     }
//     // public void pt(int[] arr){
//     //     for(int i =0 ;i < arr.length;i++){
//     //         System.out.print(arr[i] + "\t");
//     //     }
//     //     System.out.println();
//     // }
// }

public class Solution {
  /**
  这个啊还是别人的答案，和方法一一样的
  */
//   public int findKthLargest(int[] a, int k) {
//     int n = a.length;
//     int p = quickSelect(a, 0, n - 1, n - k + 1);
//     return a[p];
//   }
  
//   // return the index of the kth smallest number
//   int quickSelect(int[] a, int lo, int hi, int k) {
//     // use quick sort's idea
//     // put nums that are <= pivot to the left
//     // put nums that are  > pivot to the right
//     int i = lo, j = hi, pivot = a[hi];
//     while (i < j) {
//       if (a[i++] > pivot) swap(a, --i, --j);
//     }
//     swap(a, i, hi);
    
//     // count the nums that are <= pivot from lo
//     int m = i - lo + 1;
    
//     // pivot is the one!
//     if (m == k)     return i;
//     // pivot is too big, so it must be on the left
//     else if (m > k) return quickSelect(a, lo, i - 1, k);
//     // pivot is too small, so it must be on the right
//     else            return quickSelect(a, i + 1, hi, k - m);
//   }
        public void pt(int[] arr){
        for(int i =0 ;i < arr.length;i++){
            System.out.print(arr[i] + "\t");
        }
        System.out.println();
    }
  void swap(int[] a, int i, int j) {
    int tmp = a[i];
    a[i] = a[j];
    a[j] = tmp;
  }
  /**
  方法二，iteration， 单边搜索法
  */
    public int findKthLargest(int[] A, int k) {
        k = A.length - k; // convert to index of k largest
        int l = 0, r = A.length - 1;
        while (l <= r) {
            int i = l; // partition [l,r] by A[l]: [l,i]<A[l], [i+1,j)>=A[l]
            for (int j = l + 1; j <= r; j++)
                if (A[j] < A[l]) {
                    swap(A, j, ++i);
                    pt(A);
                    
                }
            swap(A, l, i);
                    pt(A);

            if (k < i) r = i - 1;
            else if (k > i) l = i + 1;
            else return A[i];
        }
        return -1; // k is invalid
    }
}