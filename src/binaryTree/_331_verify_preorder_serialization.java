package binaryTree;

public class _331_verify_preorder_serialization {
    public boolean isValidSerialization(String preorder) {
        int slots = 1;
        for(int i = 0; i < preorder.length(); ) {
            if(preorder.charAt(i) == ',') {
                i++;
                continue;
            }
            else if(preorder.charAt(i) == '#') {
                if(slots <= 0) return false;
                slots--;
                i++;
            }
            else {
                while(i < preorder.length() && Character.isDigit(preorder.charAt(i))) i++;
                if(slots <= 0) return false;
                slots --;
                slots += 2;
            }
        }
        return slots == 0;
    }
}
