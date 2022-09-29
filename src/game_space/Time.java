package game_space;

import java.sql.Timestamp;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import static helpers.SystemHelper.print;
import static helpers.SystemHelper.println;

public class Time {
    private Timestamp currentTime;
    private String niche;
    private double cost;

    private static final ArrayList<String> nicheList = new ArrayList<>(Arrays.asList("30min","60min","120min","300min","540min","VIP"));

    public Time(String niche) {
        this.niche = niche;
        this.cost = cost;
    }
    //getters
    public Timestamp getCurrentTime(){
        return this.currentTime;
    }
    public static ArrayList<String> getNicheList(){
        return nicheList;
    }
    public static void getAllNiche(){
        int index = 1;
        println("*************************************");
        for (String i:nicheList){
            print(index++ +" "+i+"\n");
        }
    }

    public Time(){

    }
    @Override
    public String toString(){
        return listToString(nicheList);
    }
    public static String listToString(List<?> list) {
        String result = "+";
        for (int i = 0; i < list.size(); i++) {
            result += " " + list.get(i);
        }
        return result;
    }
    public static String nowTime(){
        Calendar now = Calendar.getInstance();
        int hour = now.get(Calendar.HOUR_OF_DAY);
        int minutes = now.get(Calendar.MINUTE);
        return hour + ":" + minutes;
    }
    public static double getCost(int choice){
        double price = 0;
        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        switch (choice) {
            case 1 -> price = 5;
            case 2 -> price = 10;
            case 3 -> price = 18;
            case 4 -> price = 40;
            case 5 -> price = 65;
            default -> {
            }
        }
        return price;
    }
    public static String getCostInCurrency(int choice){
        double price = 0;
        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        switch (choice) {
            case 1 -> price = 5;
            case 2 -> price = 10;
            case 3 -> price = 18;
            case 4 -> price = 40;
            case 5 -> price = 65;
            default -> {
            }
        }
        return formatter.format(price);
    }
//    public static boolean dateRangeValidator(LocalTime checkDate, LocalTime startDate, LocalTime endDate){
//        return  checkDate.getTime() >= startDate.getTime() &&
//                checkDate.getTime() <= endDate.getTime();
//    }

    /**
     * Calculate if play time is valid between open hours and return string message
     * @param timeToPlay
     */
    public static void validatePlayTime(String timeToPlay) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm");
        LocalTime closedMorning = LocalTime.parse("12:00");
        LocalTime closedEvening = LocalTime.parse("20:00");
        LocalTime openEvening = LocalTime.parse("14:00");
        LocalTime endTime = LocalTime.parse(getPlayEndTime(timeToPlay).format(DateTimeFormatter.ofPattern("HH:mm")));
        try {
            if (endTime.compareTo(closedEvening)>0){
                print("We will close at 20:00");
                System.exit(204);
            }else if (endTime.compareTo(closedMorning) > 0){
                print("We will close at 12:00");
                System.exit(204);
            }else {
                print("\n");
            }
        }catch (Exception e){
            e.getStackTrace();
        }

    }
    public static void setNicheList(){

        int index = 1;
        nicheList.add("30min");
        nicheList.add("60min");
        nicheList.add("120min");
        nicheList.add("300min");
        nicheList.add("540min");
        nicheList.add("Special Offer");

    }

    public static boolean runTimeMorning(int now){
        int start = 9;
        int end   = 12;
        return (now <= start) || (now >= end);
    }
    public static boolean runTimeEvening(int now){
        int start = 14;
        int end   = 20;
        return (now <= start) || (now >= end);
    }
    public static LocalTime getPlayEndTime(String minutes) {
        LocalTime now = LocalTime.now();
        long longMinutes = Long.parseLong(minutes.replaceAll("[^0-9]", ""));
        return now.plusMinutes(longMinutes);
    }
}
