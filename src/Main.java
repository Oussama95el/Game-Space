import game_space.*;
import helpers.SystemHelper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Objects;

public class Main extends SystemHelper {


    static public void main(String[] args) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm");
        Calendar now = Calendar.getInstance();
        int hour = now.get(Calendar.HOUR_OF_DAY);
        int minutes = now.get(Calendar.MINUTE);
        String nowTime = hour+":"+minutes;
        LocalTime currentTime = LocalTime.parse(LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm")));
        // setup posts liste
        Post.setPosts();


        if (Time.runTimeMorning(hour) || Time.runTimeEvening(hour)) {
            int selection = mainMenu();
            if (selection == 1) {
                do {
                    println("*********************** Add Player ***********************");

                    // display time and store input in variable
                    Time.getAllNiche();
                    print("Select time duration :");
                    int durationChoice = input().nextInt();
                    String selectedTime = (String) Time.getNicheList().get(durationChoice-1);
                    // store player finish time in a variable
                    LocalTime endTime = LocalTime.parse(Time.getPlayEndTime(selectedTime).format(DateTimeFormatter.ofPattern("HH:mm")));
//                    Time.validatePlayTime(selectedTime);
                    String cost = Time.getCost(durationChoice);
                    println(cost);
                    // display all Posts and store the choice in variable
                    Post.getAllPosts();
                    print("Choose Post : ");
                    Post selectedPost = Post.getPosts().get(input().nextInt() - 1);
//                    (!Queue.checkPostIsOccupied(selectedPost)) ?
                    Queue queue = new Queue();
                    Ticket checkQueue = queue.getTicket(selectedPost);
                    if (checkQueue == null) {
                        print("\n***********************************\n");
                    } else {
                        currentTime = checkQueue.getEndTime();
                    }

                    // get player initials and creat a new object of player
                    print("Player Name : ");
                    String playerName = input().nextLine().trim();
                    Player player = new Player(playerName);

                    //display list of the game and store the choice input in variable
                    Game.getGameList();
                    print("Choose Game : ");
                    String selectedGame = (String) Game.getGames().get(input().nextInt() - 1);

                    //creat a new ticket object to gather all data in a class
                    Ticket ticket = new Ticket(player,currentTime,endTime,selectedTime,selectedPost,selectedGame,cost);

                    Queue.addTicket(ticket);

                    Queue.viewOccupiedPost();
                    Queue.viewWaitList();

                    // initialize current Time
                    currentTime = LocalTime.parse(LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm")));
                    // Display main menu
                    SystemHelper.mainMenu();
                }while (true);
            }
        }else{
            println("We re Closed !!!!");
        }





    }


}
