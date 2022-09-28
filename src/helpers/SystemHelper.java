package helpers;

import java.util.Scanner;

public class SystemHelper {

    public static void print(String message){
        System.out.print(message);
    }
public static void println(String message){
        System.out.println(message);
    }

    public static Scanner input(){
        return new Scanner(System.in);
    }

    //main menu
    public static int mainMenu(){
        int choice;
            println("\n*********************** Game Space ***********************");
            println("1.Add player");
            println("2.Statistics");
            println("0.Quit");
            print("Select choice : ");
            choice = input().nextInt();
            return choice;
    }
    public static int statisticMenu(){
        int choice;
            println("1.Total Of Day");
            println("2.Total Of month");
            println("0.Quit");
            print("Select choice : ");
            choice = input().nextInt();
            return choice;
    }

}
