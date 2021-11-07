package divideConquer;

public class _sort_colors_ii {
    public void sortColors2(int[] colors, int k) {
        // write your code here
        int n = colors.length;
        partition(colors, 0, n - 1, 1, k);
    }

    void partition(int[] colors, int start, int end, int colorStart, int colorEnd) {
        if (start >= end || colorStart >= colorEnd)
            return;
        int colorMid = colorStart + (colorEnd - colorStart) / 2;
        int i = start, j = end;
        while (i <= j) {
            while (i <= j && colors[i] <= colorMid)
                i++;
            while (i <= j && colors[j] > colorMid)
                j--;
            if (i <= j)
                swap(colors, i, j);
        }
        partition(colors, start, j, colorStart, colorMid);
        partition(colors, i, end, colorMid + 1, colorEnd);
    }

    void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}
