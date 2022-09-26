package game_space;

import java.util.UUID;

import static helpers.SystemHelper.*;

/**
 * this class is used to keep track of the players using the game space
 * and keep track of the time of use, price, post and game.
 */
public class Player {
    private String name;
    private String game;
    private Post post;
    private String time;

    /**
     * To create a new Player object by initializing the values
     * @param name String name for player
     * @param game String containing the game information (type, name ...)
     * @param post String containing the post information (console, monitor ...)
     * @param time String containing time information (time ...)
     */
    public Player(String name, String game,Post post, String time){
        this.name = name;
        this.game = game;
        this.post = post;
        this.time = time;
    }
    //getters
    public String getName(){
        return this.name;
    }
    //Setters
    public void setName(String name){
        this.name = name;
    }

@Override
    public String toString(){
        return "Name :"+this.name+"\n"+"Play Time :"+this.time+"\n"+"Game :"+this.game+"\n"+"Post :"+this.post+"\n";
    }
    public String playerGame() {
        println("*********************** Add Player ***********************");
        println(game.toString());
        print("Player Game : ");
        setName(input().nextLine().trim());
        return game;
    }


}
