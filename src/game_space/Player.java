package game_space;

import java.util.UUID;

import static helpers.SystemHelper.*;

/**
 * this class is used to keep track of the players using the game space
 * and keep track of the time of use, price, post and game.
 */
public class Player {
    private String name;
    private String id;

    /**
     * To create a new Player by initializing the values and generating unique ID
     * @param name String name for player
     */
    public Player(String name){
        this.name = name;
        this.id = setPlayerId().toUpperCase();
    }

    private String setPlayerId() {
        String longId = UUID.randomUUID().toString();
        String[] id =   longId.split("-");
        return id[0];
    }

    //getters
    public String getName(){
        return this.name;
    }
    public String getId(){
        return this.id;
    }
    //Setters
    public void setName(String name){
        this.name = name;
    }

@Override
    public String toString(){
        return "Name :"+this.name+"\n"+"Player ID :"+this.id+"\n";
    }
//    public String playerGame() {
//        println("*********************** Add Player ***********************");
//        println(game.toString());
//        print("Player Game : ");
//        setName(input().nextLine().trim());
//        return game;
//    }


}
