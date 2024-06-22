// Longest Common Subsequence using Top Down
import java.util.*;

class Main
{
    static int t[][];
    public static int LCS_Recursion(String s1, String s2, int n, int m)
    {
        for(int i=0; i<=n; i++)
        {
            for(int j=0; j<=m; j++)
            {
                if(i==0 || j==0)
                {
                    t[i][j] = 0;
                }
                else if (s1.charAt(i-1)==s2.charAt(j-1))
                {
                    t[i][j] = 1 + t[i-1][j-1];
                }
                else
                {
                    t[i][j] = Math.max(t[i][j-1], t[i-1][j]);
                }
            }
        }
        return t[n][m];
    }
    public static void main(String[] args)
    {
        String s1 = "abdfdh", s2 = "acbdefdrgt";
        t = new int[s1.length()+1][s2.length()+1];

        int count = LCS_Recursion(s1, s2, s1.length(), s2.length());
        System.out.println(count);
    }
}