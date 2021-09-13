package math;

public class _836_rectangle_overlap {
    public boolean isRectangleOverlap(int[] rect1, int[] rect2) {

        int maxLeft = Math.max(rect1[0], rect2[0]);
        int minRight = Math.min(rect1[2], rect2[2]);
        int maxBot = Math.max(rect1[1], rect2[1]);
        int minTop = Math.min(rect1[3], rect2[3]);
        return maxLeft < minRight && minTop > maxBot;
    }
}
