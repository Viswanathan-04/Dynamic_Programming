// Get knapsack maximum profit using recursion

class Main
{
    public static int recurse(int[] weights, int[] values, int w, int n)
    {
        if (n==0 || w==0)
        {
            return 0;
        }
        if (weights[n-1]<=w)
        {
            return Math.max(values[n-1]+ recurse(weights, values, w-weights[n-1], n-1),recurse(weights, values, w, n-1));
        }
        return 0;
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = 4;
        int weight[] = {1,3,4,5};
        int values[] = {1,4,5,7};
        int capacity = 7;
        
        System.out.println(recurse(weight, values, capacity, n));
    }
}