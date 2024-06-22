// Longest Common Subsequence print subsequence
import java.util.*;

class Main
{
    static int dp[][];
    public static int lc_substring(String s1, String s2, int m, int n)
    {
        int maxLength = 0;
        for(int i=0; i<=m; i++)
        {
            for(int j=0; j<=n; j++)
            {
                if(i==0 || j==0)
                {
                    dp[i][j] = 0;
                }
                else if (s1.charAt(i-1)==s2.charAt(j-1))
                {
                    dp[i][j] = dp[i-1][j-1] + 1;
                    maxLength = Math.max(maxLength, dp[i][j]);
                }
                else
                {
                    dp[i][j] = 0;
                }
            }
        }

        int i=m, j=n;
        String s = "";
        while(i>0 && j>0)
        {
            if (s1.charAt(i-1)==s2.charAt(j-1))
            {
                s+=s1.charAt(i-1);
                i-=1;
                j-=1;
            }
            else
            {
                if(dp[i][j-1] > dp[i-1][j])
                {
                    j--;
                }
                else{
                    i--;
                }
            }
        }
        System.out.println(s);
        
        return maxLength;
    }
    public static void main(String[] args)
    {
        String s1 = "abcdf", s2 = "abcgde";
        dp = new int[s1.length()+1][s2.length()+1];
        int count = lc_substring(s1, s2, s1.length(), s2.length());
        System.out.println(count);
    }
}