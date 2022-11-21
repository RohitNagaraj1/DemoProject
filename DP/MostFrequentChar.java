public class MostFrequentChar {
    
    public static char FindMostFrequentVowel(String str)
    {
        int[] arr = new int[26];

        for (char ch : str.toCharArray())
        {
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u')
            {
                int index = ch - 'a';
                arr[index]++;
            }
        }

        char res = 'a';
        int count = 0;
        for (int i = 0; i < 26; i++)
        {
            if (count < arr[i])
            {
                count = arr[i];
                res = (char)('a' + i);
            }
        }

        return res;
    }

    public static int LengthContiguousBinary(String binary)
    {
        int max = 0;
        int current = 0;

        for (char ch : binary.toCharArray())
        {
            if (ch == '1')
            {
                current++;
                max = Math.max(max, current);
            }
            else
            {
                current = 0;
            }
        }

        return max;
    }

    
    public static void main(String[] args) 
    {
        System.out.println(FindMostFrequentVowel("eeeeeee"));
        System.out.println(LengthContiguousBinary("10111111111101111111111"));
    }
}
