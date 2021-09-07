package math;

public class _168_excel_column_sheet_title {
    public String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();
        while(--n >= 0) {
            int d = n % 26;
            char ch = (char)('A' + d);
            sb.append(ch);
            n /= 26;
        }
        return sb.reverse().toString();
    }
}
