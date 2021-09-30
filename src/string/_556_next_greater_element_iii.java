package string;

public class _556_next_greater_element_iii {
    public int nextGreaterElement(int number) {
        String str = ""+number;
        char[] arr = str.toCharArray();
        int n = arr.length;
        int i = n-2;
        while(i >= 0 && arr[i] >= arr[i+1]) { // try to find the first increase slope from the end
            i--;
        }
        if(i < 0) {
            return -1;
        }
        int j = n -1;
        while(j >= i && arr[j] <= arr[i]) {
            j--;
        }
        swap(arr, i, j);
        reverse(arr, i+1);

        int res = -1;
        try {
            res = Integer.valueOf(new String(arr));
        } catch(Exception ex) {
            res = -1;
        }
        return res;
    }

    void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    void reverse(char[] arr, int start) {
        int end = arr.length-1;
        while(start < end) {
            swap(arr, start++, end--);
        }
    }
}
