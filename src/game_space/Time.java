package game_space;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import static helpers.SystemHelper.print;
import static helpers.SystemHelper.println;

public class Time {
    private Timestamp currentTime;
    private String niche;
    private static final ArrayList<String> nicheList = new ArrayList<>();

    public Time(String niche) {
        this.niche = niche;
    }
    //getters
    public Timestamp getCurrentTime(){
        return this.currentTime;
    }
    public static ArrayList<String> getNicheList(){
        return nicheList;
    }

    public Time(){

    }
    public static void setNicheList(){

        int index = 1;
        nicheList.add("30min");
        nicheList.add("60min");
        nicheList.add("120min");
        nicheList.add("300min");
        nicheList.add("540min");
        nicheList.add("Special Offer");
        println("*************************************");
        for (String i:nicheList){
            print(index++ +" "+i+"\n");
        }
    }
    public static void getMinutes(String time){
        time.split("",0);
        print(time);
    }
    public static boolean runTimeMorning(int now){
        int start = 9;
        int end   = 12;
        if ((now <= start) || (now >= 12)) {
            return false;
        } else {
            return true;
        }
    }
    public static boolean runTimeEvening(int now){
        int start = 14;
        int end   = 20;
        if ((now <= start) || (now >= 12)) {
            return false;
        } else {
            return true;
        }
    }
    public static String getPlayEndTime(int minutes,String now) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm");
        Date d = dateFormat.parse(now);
        Calendar cal = Calendar.getInstance();
        cal.setTime(d);
        cal.add(Calendar.MINUTE, minutes);
        return dateFormat.format(cal.getTime());
    }
}
