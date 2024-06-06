class Main
{
    public static int calc(int[] coins, int n)
    {
        int dp[][] = new int[coins.length + 1][n + 1];

        for(int i = 0; i <= coins.length; i++)
        {
            for(int j = 0; j <= n; j++)
            {
                if (j==0)
                {
                    dp[i][j] = 1;
                }
                else if (i==0)
                {
                    dp[i][j] = 0;
                }
                else if (coins[i - 1] <= j)
                {
                    dp[i][j] = dp[i][j - coins[i - 1]] + dp[i - 1][j];
                }
                else
                {
                    dp[i][j] = dp[i - 1][j];
                }
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        return dp[coins.length][n];
    }

    public static void main(String[] args)
    {
        int coins[] = {1,2,3};
        int n = 5;

        int ways = calc(coins, n);
        System.out.println(ways);
    }
}
