class Main
{
    public static int calc(int[] lengths, int[] prices, int n)
    {
        int capacity = n;
        int dp[][] = new int[lengths.length + 1][capacity + 1];

        for(int i = 0; i <= lengths.length; i++)
        {
            for(int j = 0; j <= capacity; j++)
            {
                if (i == 0 || j == 0)
                {
                    dp[i][j] = 0;
                }
                else if (lengths[i - 1] <= j)
                {
                    dp[i][j] = Math.min(prices[i - 1] + dp[i][j - lengths[i - 1]], dp[i - 1][j]);
                }
                else
                {
                    dp[i][j] = dp[i - 1][j];
                }
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        return dp[lengths.length][capacity];
    }

    public static void main(String[] args)
    {
        int lengths[] = {1,2,3,4};
        int prices[] = {5,6,8,8};
        int n = 8;

        int price = calc(lengths, prices, n);
        System.out.println(price);
    }
}
