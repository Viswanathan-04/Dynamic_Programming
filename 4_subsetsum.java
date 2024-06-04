// Count no of subsets with sum = targetSum

// if (arr[i-1]<=j) dp[i][j] = dp[i - 1][j] || dp[i - 1][j - arr[i - 1]]
// else dp[i][j] = dp[i - 1][j]
// Returns True/False

public class SubsetSum {
    public static boolean[][] subsetSumDP(int[] arr, int targetSum) {
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

        return dp;
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 7, 8, 10};
        int targetSum = 11;

        boolean[][] dpTable = subsetSumDP(arr, targetSum);

        for (int i = 0; i <= arr.length; i++) {
            for (int j = 0; j <= targetSum; j++) {
                System.out.print(dpTable[i][j] ? "T" : "F");
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}
