package arrary;

public class _941_valid_mountain_array {
    public boolean validMountainArray(int[] arr) {
        if(arr.length < 3) return false;

        boolean found = false;
        for(int i = 1; i < arr.length-1; i++) {
            if(!found && arr[i-1] >= arr[i]) return false;
            if(!found && arr[i] > arr[i+1]) {
                found = true;
            }
            if(found && arr[i] <= arr[i+1]) return false;
        }
        return found;
    }
}
