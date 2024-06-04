// Get knapsack maximum profit using Tabulation

class Main
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = 4;
        int weight[] = {1,3,4,5};
        int values[] = {1,4,5,7};
        int capacity = 7;
        int dp[][] = new int[n+1][capacity+1];
        
        for(int i=0; i<n+1; i++)
        {
            for(int j=0; j<capacity+1; j++)
            {
                if (i==0 || j==0)
                {
                    dp[i][j] = 0;
                }
                else if (weight[i-1]<=j)
                {
                    dp[i][j] = Math.max(values[i-1]+dp[i-1][j-weight[i-1]],dp[i-1][capacity]);
                }
                else
                {
                    dp[i][j] = dp[i-1][j];
                }
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println("Max Profit : "+dp[n][capacity]);
    }
}