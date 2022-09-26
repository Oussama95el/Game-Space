package game_space;

import java.util.ArrayList;

import static helpers.SystemHelper.print;

/**
 * this class will have purpose defining each post and keep track of
 * the material like (console, monitor ...)
 */
public class Post {


    private Console console;
    private Monitor monitor;
    private static final ArrayList<Post> allPosts = new ArrayList<>();

    private static ArrayList<Post> occupiedPost = new ArrayList<>();
    /**
     * Class Constructor
     *
     *
     * @param monitor Object containing monitor information
     * @param console Object containing monitor information
     */
    public Post(Monitor monitor, Console console){
        this.monitor = monitor;
        this.console = console;
    }
    // default constructor
    public Post(){
    }
    // Getters
    public Console getConsole(){     // get post console
        return this.console;
    }
    public Monitor getMonitor(){     // get post console
        return  this.monitor;
    }
    public static ArrayList<Post> getPosts(){
        return allPosts;
    }

//    Override toString method of String class
    @Override
    public String toString(){
        return   this.console +" | " + this.monitor+"\n";
    }

    static public void setPosts() {
        // set default values for post class
        Post post1 = new Post(Monitor.Asus, Console.NS);
//        Post post2 = new Post(Monitor.Asus, Console.NS);
//        Post post3 = new Post(Monitor.Asus, Console.PS5);
        Post post4 = new Post(Monitor.HP ,Console.PS5);
//        Post post5 = new Post(Monitor.Samsung, Console.PS5);
//        Post post6 = new Post(Monitor.Samsung,Console.Xbox);
//        Post post7 = new Post(Monitor.Dell,Console.Xbox);
//        Post post8 = new Post(Monitor.Dell,Console.Xbox);
//        Post post9 = new Post(Monitor.Dell,Console.Xbox);
        // add all posts to array list for display
        allPosts.add(post1);
//        allPosts.add(post2);
//        allPosts.add(post3);
        allPosts.add(post4);
//        allPosts.add(post5);
//        allPosts.add(post6);
//        allPosts.add(post7);
//        allPosts.add(post8);
//        allPosts.add(post9);
        int index = 1;
        print("***********************************\n");
        for (Post i:allPosts){
            print(index++ +" "+ String.valueOf(i));
        }
    }}
