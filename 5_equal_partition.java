// Divide subsets into equal partitions such that sum is  0

// if sum(arr)%2 is not 0, return false
// else return subset_sum(arr, sum(arr)/2)

class Main{
    public static boolean subsetSumDP(int[] arr, int targetSum) {
        int n = arr.length;
        boolean[][] dp = new boolean[n + 1][targetSum + 1];

        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= targetSum; j++) {
                if (arr[i - 1] <= j) {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - arr[i - 1]];
                } 
                else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[n][targetSum];
    }
    public static void main(String[] args)
    {
        int[] arr = {1, 5, 12, 6};
        int sum = 0;
        for(int i : arr)
        {
            sum+=i;
        }
        if (sum%2!=0)
        {
            System.out.println("False");
            return;
        }
        else{
            System.out.println(subsetSumDP(arr, sum/2)==true ? "True" : "False");
            return;
        }

    }
}