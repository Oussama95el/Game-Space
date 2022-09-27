package game_space;

import java.util.ArrayList;
import java.util.Arrays;

import static helpers.SystemHelper.print;

public class Game {

    private static final ArrayList<String> games = new ArrayList<>(Arrays.asList("FIFA22","PES22","Counter-Strike","Assassin's Creed"));

    //getters

    public static ArrayList<String> getGames(){
        return games;
    }


    public Game() {

    }

    public static void getGameList(){
        int index = 1;
        print("*************************************\n");
        for (Object i:games){
            print( index++ +" "+i+"\n");
        }
    }

}
