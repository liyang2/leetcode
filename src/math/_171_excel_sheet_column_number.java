package math;

public class _171_excel_sheet_column_number {
    public int titleToNumber(String str) {
        int multiplyBy = 1;
        int res = 0;
        for(int i = str.length()-1; i >= 0; i--) {
            char ch = str.charAt(i);
            int d = (ch - 'A' + 1) * multiplyBy;
            res += d;
            multiplyBy *= 26;
        }
        return res;
    }
}
