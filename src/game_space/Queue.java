package game_space;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Objects;

import static helpers.SystemHelper.print;
import static helpers.SystemHelper.println;

public class Queue {
    private static final ArrayList<Ticket> occupiedPost = new ArrayList<>(9);
    private static final ArrayList<Ticket> waitList = new ArrayList<>(8);
    private Ticket ticket;


    /**
     * Check ticket and add it to the Array list required
     * @param ticket Object containing ticket information (post, player, startTime, endTime...)
     */
    public static void addTicket(Ticket ticket) {
        if (occupiedPost.isEmpty()) {
            occupiedPost.add(ticket);
        } else {
            // if post is not occupied Add to occupied post
            if (checkPostIsOccupied(ticket.getPost())) {
                occupiedPost.add(ticket);
            } else {
                // Add to wait list
                waitList.add(ticket);
                print("\n???");
            }
        }
    }

    public Ticket getTicket(Post post) {
        for (Ticket ticket : occupiedPost) {
            if (Objects.equals(post.getId(), ticket.getPost().getId())) {
                this.ticket = ticket;
            }
        }
        return this.ticket;
    }

    @Override
    public String toString() {
        return String.valueOf(occupiedPost);
    }

    public static boolean checkPostIsOccupied(Post post) {
        boolean occupied = false;
        for (Ticket ticket : occupiedPost) {
            if (!Objects.equals(post.getId(), ticket.getPost().getId())) {
                occupied = !occupied;
            } else {
                println("\nPost occupied");
            }
        }
        return occupied;
    }

    /**
     * Display Object list of occupied post
     */
    public static void viewOccupiedPost() {
        print("\n---------- List of post occupied ------------- ");
        for (Ticket post : occupiedPost) {
            print(
                    "\n__________________________________" +
                            "\nPost Id   =      " + String.valueOf(post.getPost().getId())
                            + "\nStart Time  =    " + String.valueOf(post.getStartTime())
                            + "\nEnd Time  =      " + String.valueOf(post.getEndTime())
                            + "\n__________________________________"
            );
        }
    }
    /**
     * Display Object list of wait list post
     */
    public static void viewWaitList() {
        if (waitList.isEmpty()){
            print("\n Wait list is empty \n");
        }else {
            print("\n---------- Wait List ------------- ");
            for (Ticket post : waitList) {
                print(
                        "\n__________________________________" +
                                "\nPost Id   =      " + String.valueOf(post.getPost().getId())
                                + "\nStart Time  =    " + String.valueOf(post.getStartTime())
                                + "\nEnd Time  =      " + String.valueOf(post.getEndTime())
                                + "\n__________________________________"
                );
            }
        }
    }
}
