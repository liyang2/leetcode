package string;

import java.util.*;

// 简单的实现题
public class _68_text_justification {
    String[] words;
    int maxWidth;

    public List<String> fullJustify(String[] words, int maxWidth) {
        this.words = words;
        this.maxWidth = maxWidth;
        List<String> res = new ArrayList<>();

        int i = 0;
        while(i < words.length) {
            int right = findRight(i);
            res.add(justify(i, right));
            i = right+1;
        }
        return res;
    }

    void fillWithSpace(StringBuilder sb, int fullWidth) {
        while(sb.length() < fullWidth)
            sb.append(" ");
    }

    String justifyLastLine(int start, int end) {
        StringBuilder sb = new StringBuilder();
        for(int i = start; i <= end; i++) {
            sb.append(words[i]);
            if(sb.length() < maxWidth)
                sb.append(" ");
        }
        fillWithSpace(sb, maxWidth);
        return sb.toString();
    }

    String justify(int start, int end) {
        StringBuilder sb = new StringBuilder();
        if(end == words.length-1 || start == end) {
            return justifyLastLine(start, end);
        }
        int nonSpace =0;
        for(int i = start; i <= end; i++) {
            nonSpace += words[i].length();
        }
        int space = maxWidth - nonSpace;
        int avg = space / (end - start);
        String spaceChars = generateSpace(avg);
        int left = space % (end - start);

        for(int i = start; i <= end; i++) {
            sb.append(words[i] + (i < end ? spaceChars : ""));
            if(left-- > 0) {
                sb.append(" ");
            }
        }
        fillWithSpace(sb, maxWidth);
        return sb.toString();
    }

    int findRight(int start) {
        int curUsed = 0;
        while(start < words.length && curUsed + words[start].length() <= maxWidth) {
            curUsed += words[start++].length() + 1;
        }
        return start-1;
    }

    String generateSpace(int n) {
        StringBuilder sb = new StringBuilder();
        while(n-->0){
            sb.append(" ");
        }
        return sb.toString();
    }
}
