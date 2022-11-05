package lab;

import java.util.Arrays;
import org.apache.commons.lang3.StringUtils;

public class MyDate {

    int y, m, d;
    String month; //January, etc.
    static Integer [] solarMonth = {1, 3, 5, 7, 8, 10, 12};
    static Integer [] lunarMonth = {4, 6, 9, 11};
    static int [] leapDays = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    static int [] normalDays = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    
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

    /**
        計算星期
        只要知道這天和 1900 的日期差即可推算。我們知道 1900/1/1 是 Monday。
     */
    public String dayOfWeek() {
        String dayOfWeekString [] = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Satursday", "Sunday"};

        int diffTo1900 = diff1900(this);
        int r = 1 + (diffTo1900 % 7); // 1 becase 1900/1/1 is Monday
        assert r<=7: "day of week error!!"; 

        return dayOfWeekString[r-1];
    }

    /** 
        計算明天
        原則上都是 d++, 但遇到月底的時候需要 reset,
        要特別注意閏二月和十二月
     */
    public MyDate tomorrow() {
        int _y = y;
        int _d = d;
        int _m = m;

        boolean isLeap = (y%400 == 0) || (y%4==0 && y%100 != 0); // 閏年
        boolean isFeb = (m == 2);
        boolean isSolar = Arrays.asList(solarMonth).contains(m); // 大月
        boolean isLunar = Arrays.asList(lunarMonth).contains(m); // 小月

        boolean isNormal228 = !isLeap && isFeb && d==28;    // 平年二月底
        boolean isLeap229 = isLeap && isFeb && d==29;       // 閏年二月底
        boolean isEndOfMonth = (isSolar && d == 31) || (isLunar && d == 30) || isNormal228 || isLeap229;    // 月底

        if (isEndOfMonth) {
            _m++; _d=1; // advanced to next month
        }
        else _d++;

        if (_m==13) {   // case of 12/31
            _m=1; _y++; // advanced to next year
        }    

        return new MyDate(_y, _m, _d);
    }

    /**
        因為我們知道 1900/1/1 是星期一，所以用計算日期和 1900/1/1 的天數差，
        再來推算星期。
     */
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
        }
        return diff;
    }

    /**
        距離該年度 1/1 的天數。
        例如 d 為 2020/4/5，會回傳 4/5-1/1 的天數
     */
    public static int diff11 (MyDate d) {
        int diff = 0;
        if (d.m == 1) 
            diff += (d.d - 1);
        else {
            diff += (31-1);
            for (int i=2; i<d.m; i++) {
                if (isLeapYear(d.y)) 
                    diff += leapDays[i-1];                    
                else diff += normalDays[i-1];     
            }
            diff += d.d;
        }    
        return diff;
    }        

    public static int year_days(int y) {
        return isLeapYear(y) ? 366 : 365;
    }

    public static boolean isLeapYear(int y) {
        return (y%400 == 0) || (y%4==0 && y%100 != 0);
    }

    public static int to_m(String month) {
        return Integer.parseInt(month);
    }

    public static String to_Month(int m) {
        return String.valueOf(m); 
    }
    
    public String tomorrowDay() {
        return this.tomorrow().dayOfWeek;
    }

    public String toString() {
        String[] r = {String.valueOf(y), String.valueOf(m), String.valueOf(d)};
        return StringUtils.join(r, "-");
    }
}