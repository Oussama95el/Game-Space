import game_space.Game;
import game_space.Player;
import game_space.Post;
import game_space.Time;
import helpers.SystemHelper;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.util.Calendar;
import java.util.Date;

public class Main extends SystemHelper {


    static public void main(String[] args){
        Calendar now = Calendar.getInstance();
        int hour = now.get(Calendar.HOUR_OF_DAY);




        if (Time.runTimeMorning(hour) || Time.runTimeEvening(hour)) {
            int selection = mainMenu();
            if (selection == 1) {
                do {
                    println("*********************** Add Player ***********************");
                    Time.setNicheList();
                    String selectedTime = (String) Time.getNicheList().get(input().nextInt()-1);
                    print("Player Name : ");
                    String playerName = input().nextLine().trim();
                    Game.gameList();
                    print("Choose Game : ");
                    String selectedGame = (String) Game.getGames().get(input().nextInt() - 1);
                    print(selectedGame);
                    Post.setPosts();
                    print("Choose Post : ");
                    Post selectedPost = Post.getPosts().get(input().nextInt() - 1);
                    //creat player instance
                    Player player = new Player(playerName,selectedGame,selectedPost,selectedTime);
                    print(String.valueOf(player));


                    SystemHelper.mainMenu();
                }while (true);
            }
        }else{
            Time.getMinutes("30min");
        }





    }


}
