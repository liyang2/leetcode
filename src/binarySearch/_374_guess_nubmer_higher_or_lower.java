package binarySearch;

public class _374_guess_nubmer_higher_or_lower {
    public static void main(String[] args) {
        Solution s = new Solution(662351799);
        s.guessNumber(1182691386);
    }
}
class GuessGame {
    int pick;
    public GuessGame(int pick) {
        this.pick = pick;
    }
    int guess(int num) {
        if(pick == num)
            return 0;
        else if(pick < num)
            return -1;
        else
            return 1;
    }
}
class Solution extends GuessGame {
    public Solution(int pick) {
        super(pick);
    }
    public int guessNumber(int n) {
        int low = 1, high = n;
        int myGuess = low + (high - low)/2;
        do {
            int res = guess(myGuess);
            if (res == 0)
                return myGuess;
            else if (res < 0) {
                high = myGuess-1;
            } else {
                low = myGuess + 1;
            }
            myGuess = low + (high - low)/2;
        } while(true);
    }
}