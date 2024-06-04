// Count no of subsets with sum equal to given target

// Assign +/- to each number in arr such that their sum is target
// Same as count subsets with given difference

class Solution {
    public static void main(String[] args){
        int nums[] = {1, 1, 2, 3};
        int target = 1;
        int sum = findSum(nums);
        int tsum = (sum+target)/2;
        if((sum+target)%2!=0  || sum<Math.abs(target)) {
            System.out.println("0");
            return;
        }
        System.out.println(dpPartition(nums, nums.length, tsum));
        
    }
    public static int findSum(int[] nums){
        int sum = 0;
        for(int i=0; i< nums.length; i++){
            sum += nums[i];
        }
        return sum;
    }
    public static int dpPartition(int[] nums, int N, int sum){
        int[][] dp = new int[N+1][sum+1];

        for(int i=0; i<=N; i++){
            dp[i][0] = 1; 
        }
        for(int i=1; i<=sum; i++){
            dp[0][i] = 0; 
        }

        for(int i=1; i<=N; i++){
            for(int j=0; j<=sum; j++){
                if(nums[i-1]<=j){
                    dp[i][j] = dp[i-1][j-nums[i-1]] + dp[i-1][j];
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[N][sum];
    }
}