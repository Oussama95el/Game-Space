package game_space;

import java.io.*;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Statistics {
    private  double dayRevenue = 0;
    private  double monthRevenue = 0;

    //getters
    public double getDayRevenue(){
        return dayRevenue;
    }
    public double getMonthRevenue(){
        return monthRevenue;
    }
    // setters
    public void setDayRevenue(double dayRevenue){
        dayRevenue = this.dayRevenue;
    }
    public void setMonthRevenue(double monthRevenue){
        monthRevenue = this.monthRevenue;
    }

    /**
     * Send data to file.dat
     */
    public void save(){
        try {
            FileOutputStream fos = new FileOutputStream("save.dat");
            BufferedOutputStream bos = new BufferedOutputStream(fos);
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            DataStorage dataStorage = new DataStorage();
            //reffenrece data to store it
            dataStorage.dayRevenue = this.dayRevenue;
            dataStorage.monthRevenue = this.monthRevenue;
            //write object to output stream
            oos.writeObject(dataStorage);
            oos.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    /**
     * Load data file containing object data to consume
     */
    public void load(){
        try {
            FileInputStream fis = new FileInputStream("save.dat");
            BufferedInputStream bis = new BufferedInputStream(fis);
            ObjectInputStream ois = new ObjectInputStream(bis);
            DataStorage dataStorage = new DataStorage();
            //Read Object data in file and store it to variable
            DataStorage data = (DataStorage) ois.readObject();
            //write object to output stream
            this.dayRevenue = data.dayRevenue;
            this.monthRevenue = data.monthRevenue;
            ois.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void sumDayRevenue(double cost){
        this.dayRevenue+=cost;
    }
    public void sumMonthRevenue(double cost){
        this.monthRevenue+=cost;
    }
}
