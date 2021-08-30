import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

//import java.time.Month;
import java.time.format.DateTimeFormatter;


public class DateAndTime{
    private int year = Calendar.getInstance().get(Calendar.YEAR);
    private int month = Calendar.getInstance().get(Calendar.MONTH);
    private int day_of_month = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
    private int hour;
    private int minute;
    private LocalDateTime date_time;

    public DateAndTime(int year, int month ,int day_of_month, int hour, int minute) {
        setYear(year);
        setMonth(month);
        setDay_of_month(month);
        setHour(hour);
        setMinute(minute);
        LocalDateTime date_time = LocalDateTime.of(year, month, day_of_month, hour, minute);
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        Date d = new Date();
        int cur_year = Calendar.getInstance().get(Calendar.YEAR);
        if(year >= cur_year && year <= cur_year + 2)
            this.year = year;
        else{
            this.year = cur_year;
        }
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        if(month >=1 && month <= 12)
            this.month = month;
        else
        {
            int cur_month = Calendar.getInstance().get(Calendar.MONTH);
        }
    }

    public int getDay_of_month() {
        return day_of_month;
    }

    public void setDay_of_month(int day_of_month) {

        this.day_of_month = day_of_month;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        if (hour >= 0 && hour <= 23)
            this.hour = hour;
        else
        {
            this.hour = Calendar.getInstance().get(Calendar.HOUR) + 5;
        }
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        if(minute >= 0 && minute <= 59)
            this.minute = minute;
        else{
            this.minute = 0;
        }
    }
}
