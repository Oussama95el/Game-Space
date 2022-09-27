package game_space;

import java.time.LocalTime;
import java.util.Date;

public class Ticket {
    private Player player;
    private LocalTime startTime;
    private LocalTime endTime;

    private String time;
    private Post post;
    private String game;

    public Ticket(Player player, LocalTime start, LocalTime end, String time, Post post, String game){
        this.player = player;
        this.startTime = start;
        this.endTime = end;
        this.time = time;
        this.post = post;
        this.game = game;
    }
    //getters
    public Post getPost(){
        return this.post;
    }
    public LocalTime getStartTime(){
        return this.startTime;
    }
    public LocalTime getEndTime(){
        return this.endTime;
    }
@Override
public String toString(){
        return "**************************************\n"
                +this.player +""
                + this.post +""
                + this.time +"\n"
                +this.game+"\n"
                +this.startTime+"\n"
                +this.endTime+"\n";
}



}
