//Count subsets with target "targetSum"

class Main
{
    public static int count_subsets(int[] arr, int targetSum)
    {
        int dp[][] = new int[arr.length+1][targetSum+1];
        for(int i=0; i<=arr.length; i++)
        {
            for(int j=0; j<=targetSum; j++)
            {
                if (j==0)
                {
                    dp[i][j] = 1;
                }
                else if (i==0)
                {
                    dp[i][j] = 0;
                }
                else if (arr[i-1]<=j)
                {
                    dp[i][j] = dp[i-1][j] + dp[i-1][j-arr[i-1]];
                }
                else
                {
                    dp[i][j] = dp[i-1][j];
                }
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
        return dp[arr.length][targetSum];
    }
    public static void main(String[] args)
    {
        int arr[] = {2, 3, 5, 6, 8, 10};
        int targetSum = 10;
        int count = count_subsets(arr, targetSum);
        System.out.println("\nSubsets count : "+count);
    }
}