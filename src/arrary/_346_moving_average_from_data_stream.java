package arrary;

public class _346_moving_average_from_data_stream {
    int[] arr;
    int sum = 0;
    int nextIdx = 0;
    int size;
    int curSize = 0;

    /** Initialize your data structure here. */
    public _346_moving_average_from_data_stream(int size) {
        arr = new int[size];
        this.size = size;
    }

    public double next(int val) {
        sum -= arr[nextIdx];
        arr[nextIdx] = val;
        sum += val;
        nextIdx = (nextIdx+1)% size;
        curSize++;
        if(curSize > size) {
            curSize = size;
        }
        return (double) sum/curSize;
    }
}
