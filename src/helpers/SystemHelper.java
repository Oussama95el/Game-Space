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
            println("*********************** Game Space ***********************");
            println("1.Add player");
            println("2.Statistics");
            println("0.Quit");
            print("Select choice : ");
            choice = input().nextInt();
            return choice;
    }

}
