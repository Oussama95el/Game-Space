package game_space;

import java.util.ArrayList;
import java.util.Date;

public class Ticket {
    private Player player;
    private Date startTime;
    private Date endTime;



    public Ticket(Player player,Date start,Date end){
        this.player = player;
        this.startTime = start;
        this.endTime = end;
    }

    public boolean creatTicket(){
        return false;
    }
}
