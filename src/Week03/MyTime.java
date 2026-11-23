package Week03;
import java.util.Scanner;


public class MyTime {
    private int hour;
    private int minute;

    // resets the time to 00:00 if the hour or min is out of range
    public MyTime(int hour, int minute) {
        if (hour < 0 || hour > 23 || minute < 0 || minute > 59) {
            hour = 0;
            minute = 0;
        }
        this.hour = hour;
        this.minute = minute;
    }

    // defining the 24h clock
    public String twentyFourClock(){
        String h = "" + hour;
        String m = "" + minute;

        if (hour < 10){
            h = "0" + hour;
        }
        if (minute < 10){
            m = "0" + minute;
        }
        return h + ":" + m;
    }

    // defining the 12h clock
    public String twelveClock() {
        int h = hour % 12;
        if (h == 0) {
            h = 12;
        }

        String m = "" + minute;
        if (minute < 10) {
            m = "0" + minute;
        }

        String suffix = "am";
        if (hour >= 12) {
            suffix = "pm";
        }

        return h + ":" + m + suffix;
    }


    // using user input 3
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the hour (0-23): ");
        int hour = input.nextInt();

        System.out.print("Enter the minute (0-59): ");
        int minute = input.nextInt();

        MyTime t = new MyTime(hour, minute);

        System.out.println("12-hour clock: " + t.twelveClock());
        System.out.println("24-hour clock: " + t.twentyFourClock());

        input.close();
    }
}