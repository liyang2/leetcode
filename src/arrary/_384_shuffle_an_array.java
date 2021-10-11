package arrary;
import java.util.*;
public class _384_shuffle_an_array {
    private int[] array;
    private int[] original;

    Random rand = new Random();

    private int randRange(int min, int max) {
        return rand.nextInt(max - min) + min;
    }

    private void swapAt(int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public _384_shuffle_an_array(int[] nums) {
        array = nums;
        original = Arrays.copyOf(nums, nums.length);
    }

    public int[] reset() {
        array = original;
        original =  Arrays.copyOf(original, original.length);
        return original;
    }

    public int[] shuffle() {
        for (int i = 0; i < array.length; i++) {
            swapAt(i, randRange(i, array.length));
        }
        return array;
    }
}
