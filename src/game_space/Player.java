package game_space;

import static helpers.SystemHelper.*;

/**
 * this class is used to keep track of the players using the game space
 * and keep track of the time of use, price, post and game.
 */
public class Player {
    private int id;
    private String name;
    private Game game;
    private Post post;
    private Time time;

    /**
     * To create a new Player object by initializing the values
     * @param id  id for player : Unique
     * @param name name for player
     * @param game object containing the game information (type, name ...)
     * @param post object containing the post information (console, monitor ...)
     * @param time object containing time information (time ...)
     */
    public Player(int id, String name, Game game,Post post, Time time){
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

    public String playerName() {
        println("*********************** Add Player ***********************");
        print("Player Name : ");
        setName(input().nextLine().trim());
        return name;
    }
    public String playerGame() {
        println("*********************** Add Player ***********************");
        print("Player Game : ");
        setName(input().nextLine().trim());
        return name;
    }
}
