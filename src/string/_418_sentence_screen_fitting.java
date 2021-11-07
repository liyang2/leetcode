package string;
/*
 * Imagine an infinite sentence that are concatenated by words from the given sentence, infiStr.
    We want to cut the infiStr properly and put a piece at each row of the screen.
    We maintain a pointer ptr. The ptr points to a position at infiStr, where next row will start.
    Cutting the infiStr and putting one piece in a row can be simulated as advancing the pointer by cols positions.
    After advancing the pointer, if ptr points to a space, it means the piece can fit in row perfectly.
    If ptr points to the middle of a word, we must retreat the pointer to the beginning of the word, because a word cannot be split into two line
 */
public class _418_sentence_screen_fitting {
    public int wordsTyping(String[] sentence, int rows, int cols) {
        int start = 0;
        String s = String.join(" ", sentence) + " ";
        int l = s.length();

        for(int i = 0; i < rows; i++) {
            start += cols;
            if(s.charAt(start % l) == ' ')
                start++;
            else {
                while(start > 0 && s.charAt((start-1) % l) != ' ')
                    start--;
            }
        }
        return start / l;
    }
}
