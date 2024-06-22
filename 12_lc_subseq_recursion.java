// Longest Common Subsequence using Recursion
class Main
{
    public static int LCS_Recursion(String s1, String s2, int n, int m)
    {
        if (n==0 || m==0)
        {
            return 0;
        }
        if(s1.charAt(n-1)==s2.charAt(m-1))
        {
            return 1 + LCS_Recursion(s1, s2, n-1, m-1);
        }
        else
        {
            return Math.max(LCS_Recursion(s1, s2, n-1, m), LCS_Recursion(s1, s2, n, m-1));
        }
    }
    public static void main(String[] args)
    {
        String s1 = "abdfgh", s2 = "acbdefrgth";
        int count = LCS_Recursion(s1, s2, s1.length(), s2.length());
        System.out.println(count);
    }
}