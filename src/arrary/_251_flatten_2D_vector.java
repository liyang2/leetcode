package arrary;

public class _251_flatten_2D_vector {
}
class Vector2D {

    int[][] v;
    int i = 0;
    int j = 0;

    public Vector2D(int[][] vec) {
        v = vec;
    }

    public int next() {
        while(i< v.length && v[i].length == 0)
            i++;
        int d = v[i][j];
        if(j < v[i].length-1){
            j++;
        } else {
            j = 0;
            i++;
        }
        return d;
    }

    public boolean hasNext() {
        while(i< v.length && v[i].length == 0)
            i++;
        return i < v.length && j < v[i].length;
    }
}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D obj = new Vector2D(vec);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */