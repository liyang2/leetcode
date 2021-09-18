package string;

public class _1360_number_of_days_between_two_dates {
    boolean isLeapYear(int y) {
        return y % 4==0 && (y % 100 != 0 || y % 400 == 0);
    }

    int[] days = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

    int daysAfter1971(String date) {
        String[] parts = date.split("-");
        int year = Integer.valueOf(parts[0]);
        int month = Integer.valueOf(parts[1]);
        int dayOfMonth = Integer.valueOf(parts[2]);

        int res = 0;
        for(int y = 1971; y < year; y++) {
            res += isLeapYear(y) ? 366 : 365;
        }
        for(int m = 1; m < month; m++) {
            res += days[m-1];
            if(m == 2 && isLeapYear(year))
                res++;
        }
        res += dayOfMonth;
        return res;
    }

    public int daysBetweenDates(String date1, String date2) {
        return Math.abs(daysAfter1971(date1) - daysAfter1971(date2));
    }
}
