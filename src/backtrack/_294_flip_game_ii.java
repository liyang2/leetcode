package backtrack;

// of course, you can use memoization to speed it up a bit

public class _294_flip_game_ii {
    public boolean canWin(String s) {
        // write your code here
        char[] chars = s.toCharArray();
        return canWinRecur(chars);
    }

    private boolean canWinRecur(char[] chars) {
        for (int i = 0; i < chars.length - 1; i++) {
            if (chars[i] == '+' && chars[i + 1] == '+') {
                chars[i] = chars[i + 1] = '-';
                boolean otherCanWin = canWinRecur(chars);
                chars[i] = chars[i + 1] = '+';
                if (!otherCanWin) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        new _294_flip_game_ii().canWin("++++");
    }
}
