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
        // load statistics file
        Statistics loadStatistics = new Statistics();
        loadStatistics.load();
        // get time instance now
        Calendar now = Calendar.getInstance();
        // get Hour value of time
        int hour = now.get(Calendar.HOUR_OF_DAY);
        // get Minutes value
        int minutes = now.get(Calendar.MINUTE);
        String nowTime = hour+":"+minutes;
        LocalTime currentTime = LocalTime.parse(LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm")));
        // setup posts liste
        Post.setPosts();


        if (Time.runTimeMorning(hour) || Time.runTimeEvening(hour)) {

            int selection;
            do {
                selection = mainMenu();
                switch (selection) {
                    case 1:

                        println("*********************** Add Player ***********************");

                        // display time and store input in variable
                        Time.getAllNiche();
                        print("Select time duration :");
                        int durationChoice = input().nextInt();
                        String selectedTime = (String) Time.getNicheList().get(durationChoice - 1);
                        // store player finish time in a variable
                        LocalTime endTime = LocalTime.parse(Time.getPlayEndTime(selectedTime).format(DateTimeFormatter.ofPattern("HH:mm")));
                        Time.validatePlayTime(selectedTime);
                        String cost = Time.getCostInCurrency(durationChoice);

                        // display all Posts and store the choice in variable
                        Post.getAllPosts();
                        print("Choose Post : ");
                        Post selectedPost = Post.getPosts().get(input().nextInt() - 1);
//                      Check queue for post selected
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
                        Ticket ticket = new Ticket(player, currentTime, endTime, selectedTime, selectedPost, selectedGame, cost);

                        Queue.addTicket(ticket);

                        Queue.viewOccupiedPost();
                        Queue.viewWaitList();

                        // initialize current Time
                        currentTime = LocalTime.parse(LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm")));
                        // add the income of day and month to statistics
                        Statistics statistics = new Statistics();

                    statistics.sumDayRevenue(Time.getCost(durationChoice));
                    statistics.sumMonthRevenue(Time.getCost(durationChoice));
                    statistics.save();
                    // Display main menu
                        break;


                    case 2:
                            println("*********************** Statistics ***********************");
                            int choice = statisticMenu();
                            switch (choice) {
                                case 1:
                                    print("\n***********************************\n");
                                    println("\n Daily income  =  "+ String.valueOf(loadStatistics.getDayRevenue()));
                                    mainMenu();
                                    break;

                                case 2:
                                    print("\n***********************************\n");
                                    println("\n Monthly income  =  " + String.valueOf(loadStatistics.getMonthRevenue()));
                                    selection = Integer.parseInt(null);
                                    mainMenu();
                                    break;
                            }
                            break;

                    case 3:
                        System.exit(200);


                }
            } while (selection != 0);
        }


}}
