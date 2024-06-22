// Longest Common Subsequence using Memoization
import java.util.*;

class Main
{
    static int t[][];
    public static int LCS_Recursion(String s1, String s2, int n, int m)
    {
        if (n==0 || m==0)
        {
            return 0;
        }
        if (t[n][m]!=-1)
        {
            return t[n][m];
        }
        if(s1.charAt(n-1)==s2.charAt(m-1))
        {
            t[n][m] = 1 + LCS_Recursion(s1, s2, n-1, m-1);
        }
        else
        {
            t[n][m] = Math.max(LCS_Recursion(s1, s2, n-1, m), LCS_Recursion(s1, s2, n, m-1));
        }
        return t[n][m];
    }
    public static void main(String[] args)
    {
        String s1 = "abdfh", s2 = "acbdefrgt";
        t = new int[s1.length()+1][s2.length()+1];

        for(int i=0; i<=s1.length(); i++)
        {
            Arrays.fill(t[i], -1);
        }
        int count = LCS_Recursion(s1, s2, s1.length(), s2.length());
        System.out.println(count);
    }
}