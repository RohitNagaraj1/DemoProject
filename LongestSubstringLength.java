import java.util.*;
public class LongestSubstringLength 
{
    public static void main(String[] args) 
    {
        System.out.println(lengthOfLongestSubstring("abcabcdbb")); 
    }

    public static int lengthOfLongestSubstring(String str) 
    {
        String current = "";
        int max = 0;
  
        for (char ch : str.toCharArray())
        {
            String temp = Character.toString(ch);
            if (current.contains(temp))
            {
                int index = current.indexOf(ch);
                current = current.substring(index+1);
            }
            current += temp;
            max = Math.max(max, current.length());
        }
  
        return max;
    } 
}