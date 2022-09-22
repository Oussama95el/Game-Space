import game_space.Game;
import game_space.Player;
import helpers.SystemHelper;

public class Main extends SystemHelper {


    static public void main(String[] args){

        int selection =  mainMenu();
        print(String.valueOf(selection));
        if (selection == 1){
//            String player1 = new Player();
//            print(player1);

        }
        Game games = new Game();
        print(games.toString());

    }
}
