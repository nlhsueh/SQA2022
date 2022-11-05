package lab;

import java.util.Arrays;
import org.apache.commons.lang3.StringUtils;

public class MyDate {

    int y, d;
    int m;
    String month;
    static Integer [] solarMonth = {1, 3, 5, 7, 8, 10, 12};
    static Integer [] lunarMonth = {4, 6, 9, 11};
    static int [] leapDays = {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    static int [] normalDays = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    
    public MyDate(int y, String m, int d) {
        this.y = y;
        this.month = m;
        this.m = to_m(month);
        this.d = d;
    }

    public MyDate(int y, int m, int d) {
        this.y = y;
        this.m = m;
        this.d = d;
    }

    public MyDate tomorrow() {
        int _y = y;
        int _d = d;
        int _m = m;

        boolean isLeap = (y%400 == 0) || (y%4==0 && y%100 != 0);
        boolean isFeb = (m == 2);
        boolean isSolar = Arrays.asList(solarMonth).contains(m);
        boolean isLunar = Arrays.asList(lunarMonth).contains(m);

        boolean isNormal228 = !isLeap && isFeb && d==28;
        boolean isLeap229 = isLeap && isFeb && d==29;
        boolean isEndOfMonth = (isSolar && d == 31) || (isLunar && d == 30) || isNormal228 || isLeap229;

        String[] r = {String.valueOf(y), String.valueOf(m), String.valueOf(d), "solar", String.valueOf(isSolar), "end of month", String.valueOf(isEndOfMonth)};
        System.out.println(StringUtils.join(r, "-"));

        if (isEndOfMonth) {
            _m++;
            _d=1;
        }
        else _d++;

        if (_m==13) {
            _m=1; _y++;
        }    

        return new MyDate(_y, _m, _d);
    }

    // difference to 1900/1/1
    public static int diff1900 (MyDate d) {
        int diff=0;
        if (d.y == 1900) {
            diff = diff11(d);
        }
        else if (d.y > 1900) {
            diff = 365-1;
            for (int i=1901; i< d.y; i++) {
                diff += year_days(i);
            }
            diff += diff11(d) + 1;
            // System.out.println("---");
            // System.out.println(diff);
        }
        return diff;
    }

    // diff to 1/1 of same year
    public static int diff11 (MyDate d) {
        int diff = 0;
        if (d.m == 1) 
            diff += (d.d - 1);
        else {
            diff += (31-1);
            for (int i=2; i<d.m; i++) {
                diff += normalDays[i];                    
            }
            diff += d.d;
        }    
        return diff;
    }        

    public static int year_days(int y) {
        return leap(y) ? 366 : 365;
    }

    public static boolean leap(int y) {
        return (y%400 == 0) || (y%4==0 && y%100 != 0);
    }

    public static int to_m(String month) {
        return Integer.parseInt(month);
    }

    public static String to_Month(int m) {
        return String.valueOf(m); 
    }
    
    public String tomorrowDay() {
        return "";
    }

    public String toString() {
        String[] r = {String.valueOf(y), String.valueOf(m), String.valueOf(d)};
        return StringUtils.join(r, "-");
    }
}

