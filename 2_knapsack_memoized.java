//Get knapsack max profit using Memoization

//Store values found in a 2D table

class Main1
{
    static int t[][];
    public static int recurse(int[] weights, int[] values, int w, int n)
    {
        if (n == 0 || w == 0)
        {
            return 0;
        }
        if (t[n][w] != -1)
        {
            return t[n][w];
        }
        if (weights[n-1] <= w)
        {
            t[n][w] = Math.max(values[n-1] + recurse(weights, values, w-weights[n-1], n-1), recurse(weights, values, w, n-1));
        }
        else
        {
            t[n][w] = recurse(weights, values, w, n-1);
        }
        System.out.println(n+" "+w+" "+t[n][w]);
        return t[n][w];
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = 3;
        int weight[] = {1,3,4,5};
        int values[] = {1,4,5,7};
        int capacity = 7;

        t = new int[n+1][capacity+1];
        for(int i = 0; i < n+1; i++)
        {
            Arrays.fill(t[i], -1);
        }
        
        System.out.println(recurse(weight, values, capacity, n));
    }
}
