package string;

public class _151_reverse_words_in_a_string {
    // O(n) extra space
    public String reverseWords(String s) {
        String[] arr = s.trim().split("\\s+");
        StringBuilder sb = new StringBuilder();
        for(int i = arr.length-1; i>= 0; i--) {
            sb.append(arr[i]+" ");
        }
        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }

    // in place
    public String reverseWordsInplace(String s) {
        char[] chars = s.trim().toCharArray();
        int n = chars.length;
        reverse(chars, 0, n - 1);

        // remove extra spaces
        int validEnd = 0;
        for (int i = 0; i < n; i++) {
            if (i > 0 && chars[i] == ' ' && chars[i - 1] == ' ') {
                continue;
            }
            chars[validEnd++] = chars[i];
        }

        // reverse each word
        int wordStart = 0;
        for (int i = 0; i < validEnd; i++) {
            int wordEnd = -1;
            if (chars[i] == ' ' ) {
                wordEnd = i - 1;
            } else if (i == validEnd - 1) {
                wordEnd = i;
            }
            if (wordEnd != -1) {
                reverse(chars, wordStart, wordEnd);
                wordStart = i + 1;
            }
        }
        return new String(chars, 0, validEnd);
    }

    void reverse(char[] chars, int start, int end) {
        while (start < end) {
            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;
            start++;
            end--;
        }
    }
}
