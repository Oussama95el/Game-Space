package game_space;


import static helpers.SystemHelper.println;

/**
 * this class will have purpose defining each post and keep track of
 * the material like (console, monitor ...)
 */
public class Post {


    private String console;
    private String monitor;

    /**
     * Class Constructor
     *
     *
     * @param monitor Object containing monitor information
     * @param console Object containing monitor information
     */
    public Post( String monitor, String console){
        this.monitor = monitor;
        this.console = console;
    }

    // Getters
    public String getConsole(){     // get post console
        return this.console;
    }
    public String getMonitor(){     // get post consol
        return  this.monitor;
    }

//    Override toString method of String class

    public String toString(){
        return   this.console +" | " + this.monitor+"\n";
    }

    static public Post setPosts() {
        Post post1 = new Post("Asus", "Xbox");
        Post post2 = new Post("Asus", "Xbox");
        Post post3 = new Post("Asus", "Xbox");
        Post post4 = new Post("HP", "Xbox");
        Post post5 = new Post("Samsung", "PS5");
        Post post6 = new Post("Samsung", "PS5");
        Post post7 = new Post("Dell", "PS5");
        Post post8 = new Post("Dell", "PS5");
        Post post9 = new Post("Dell", "PS5");

        int choice = -1;
        do {
            println("Choose post :");
            println(String.valueOf(post1));
            println(String.valueOf(post2));
            println(String.valueOf(post3));
            println(String.valueOf(post4));
            println(String.valueOf(post5));
            println(String.valueOf(post6));
            println(String.valueOf(post7));
            println(String.valueOf(post8));
            println(String.valueOf(post9));
            println("press 0 to quit");

            switch (choice) {
                case 1:
                    return post1;
                case 2:
                    return post2;
                case 3:
                    return post3;
                case 4:
                    return post4;
                case 5:
                    return post5;
                case 6:
                    return post6;
                case 7:
                    return post7;
                case 8:
                    return post8;
                case 9:
                    return post9;
            }
        } while (true);
    }}
