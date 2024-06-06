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
                    dp[i][j] = 0;
                }
                else if (i==0)
                {
                    dp[i][j] = Integer.MAX_VALUE-1;
                }
                else if (i==1)
                {
                    if (j%coins[i]==0)
                    {
                        dp[i][j] = j/coins[i];
                    }
                    else
                    {
                        dp[i][j] = Integer.MAX_VALUE-1;
                    }
                }
            }
        }
        for(int i = 2; i <= coins.length; i++)
        {
            for(int j = 1; j <= n; j++)
            {
                if (coins[i - 1] <= j)
                {
                    dp[i][j] = Math.min( dp[i][j - coins[i - 1]] + 1,  dp[i - 1][j]);
                }
                else
                {
                    dp[i][j] = dp[i - 1][j];
                }
            }
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
