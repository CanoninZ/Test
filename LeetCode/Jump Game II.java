
public class Solution {
    // public int jump(int[] nums) {
    //     int[] res = new int[nums.length];
    //     for(int i = 0; i < nums.length;i++){
    //         res[i] = Integer.MAX_VALUE;
    //     }
    //     //DP: 
           //VERY SLOW!!!! 
    //     //index i : 0 <= j <= nums[i] res[i] = min{res[j + i]}  + 1;
    //     //initial state: res[nums.length - 1] = 0;
    //     //return res[0];
    //     //do it iteratively
    //     res[nums.length - 1] = 0;
    //     for(int i = nums.length - 2; i >=0; i-- ){
           
    //         for(int j = 1; j <= nums[i]; j ++){
    //             if((j + i) > nums.length - 1)
    //             break;
    //             else if ((j + i) == nums.length - 1){
    //             res[i] = 1;
    //             break;
    //             }
    //             else{
    //                 if(res[i + j] < res[i] - 1)
    //                     res[i] = res[i + j]  + 1;
       
    //             }
    //         }
    //     }
    //     return res[0];
    // }
    //Greedy Algo.
    //2,2,1,1,4
    //2
// public int jump(int[] A) {
// 	int jumps = 0, curEnd = 0, curFarthest = 0;
// 	for (int i = 0; i < A.length - 1; i++) {
// 		curFarthest = Math.max(curFarthest, i + A[i]);
// 		if(curFarthest == A.length - 1) return jumps  + 1;
// 		if (i == curEnd) {//curEnd 有点像i已经到过的上一个milestone
//          last curEnd< i < new curEnd
// 			jumps++;
// 			curEnd = curFarthest;
// 		}
// 	}
// 	return jumps;
// }

// public int jump(int[] A){
//     int level = 1;
//     int i = 0;
//     int num_ele = A[0];
//     i++;
//     while(i< A.length){
//         level++;
//         int tmp = -1;
//         int ii = i;
//         int counter = 1;
//         while(i < ii + num_ele){
//             tmp = (tmp < (A[i] - (num_ele - counter)))? A[i] - (num_ele - counter):tmp;
//                 //   System.out.println(tmp);
//             i++;
//             counter++;
//             if(i == A.length ) return level - 1;
//         }
//         num_ele = tmp;
//         // if((tmp+i) == A.length) return level ;
  
//     }
//     return level - 1;
// }


// public int jump(int[] nums) {
//     // If nums.length < 2, means that we do not
//     // need to move at all.
//     if (nums == null || nums.length < 2) {
//         return 0;
//     }

//     // First set up current region, which is
//     // from 0 to nums[0].
//     int l = 0;
//     int r = nums[0];
//     // Since the length of nums is greater than
//     // 1, we need at least 1 step.
//     int step = 1;

//     // We go through all elements in the region.
//     while (l <= r) {

//         // If the right of current region is greater
//         // than nums.length - 1, that means we are done.
//         if (r >= nums.length - 1) {
//             return step;
//         }

//         // We should know how far can we reach in current
//         // region.
//         int max = Integer.MIN_VALUE;
//         for (; l <= r; l++) {
//             max = Math.max(max, l + nums[l]);
//         }

//         // If we can reach far more in this round, we update
//         // the boundary of current region, and also add a step.
//         if (max > r) {
//             l = r;
//             r = max;
//             step++;
//         }
//     }

//     // We can not finish the job.
//     return -1;
// }
// public int jump(int[] nums) {
//     if(nums.length == 1) return 0;
//     int level=0,currentMax=0,i=0,nextMax=0;

// 	 while(currentMax-i+1>0){		//nodes count of current level>0
// 		 level++;
// 		 for(;i<=currentMax;i++){	//traverse current level , and update the max reach of next level
// 			nextMax=max(nextMax,nums[i]+i);
// 			if(nextMax>=nums.length-1)return level;   // if last element is in level+1,  then the min jump=level 
// 		 }
// 		 currentMax=nextMax;
// 	 }
// 	 return -1;
// }
//  public int max(int a, int b){
//      return (a>b)? a:b;
//  }
}