package string;

public class _917_reverse_only_letters {
    public static void main(String[] args) {
        new _917_reverse_only_letters().reverseOnlyLetters("a-bC-dEf-ghIj");
    }
    public String reverseOnlyLetters(String s) {
        char[] arr = s.toCharArray();
        int i = 0, j = arr.length-1;
        while(i < j) {
            while(i < j && !Character.isLetter(arr[i]))
                i++;
            while(i < j && !Character.isLetter(arr[j]))
                j--;

            char tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
            i++;
            j--;
        }

        StringBuilder sb = new StringBuilder();
        for(char ch : arr) {
            sb.append(ch);
        }
        return sb.toString();
    }
}
