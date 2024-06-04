// Minimum Difference in a given subset

// Calculate sum(arr) and consider last row of dp table
// Create array v ans set min = Integer.MAX_VALUE
// if dp[arr.length-1][j]==True, add j to array v
// traverse through v and set min = min(min1, sum(arr)-2*v[i])

public class SubsetSum {
    public static boolean subsetSumDP(int[] arr, int targetSum, int a, int b) {
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

        return dp[a][b];
    }

    public static void main(String[] args) {
        int[] arr = {1, 5, 11, 6};
        int targetSum = 0;

        for(int i: arr)
        {
            targetSum+=i;
        }

        int minval = Integer.MAX_VALUE;
        int arr1[] = new int[targetSum/2];

        int i = arr.length-1, k=0;
        for (int j = 0; j <= targetSum/2; j++) {
            boolean v = subsetSumDP(arr,targetSum,i,j);
            if (v==true)
                arr1[k++] = j;
        }
        for(int j=0; j<k; j++)
        {
            minval = Math.min(minval,targetSum-(2*arr1[j]));
        }
        System.out.println(minval);
    }
}
