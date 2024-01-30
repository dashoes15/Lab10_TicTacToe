import java.util.Locale;
import java.util.Scanner;
public class InputHelper {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
    }


    //loops until a valid int is given
    public static int getInt(Scanner scan, String prompt) {
        boolean done = false;
        int x = 0;
        System.out.println(prompt);
        do {
            if (scan.hasNextInt()) {
                x = scan.nextInt();
                done = true;
            } else {
                System.out.println("You have entered something invalid.");
            }
            scan.nextLine(); //clears buffer
        } while (!done);
        return x;
    }


    public static int getRangedInt(Scanner scan, String prompt, int min, int max) {
        boolean done = false;
        int x = 0;
        System.out.println(prompt);
        do {
            if (scan.hasNextInt()) {
                x = scan.nextInt();
                if (x >= min && x <= max) {
                    done = true;
                } else {
                    System.out.println("Input is outside range.");
                }
            } else {
                System.out.println("You have entered something invalid.");
            }
            scan.nextLine(); //clears buffer
        } while (!done);
        return x;
    }


    public static double getDouble(Scanner scan, String prompt) {
        boolean done = false;
        double x = 0;
        System.out.println(prompt);
        do {
            if (scan.hasNextDouble()) {
                x = scan.nextDouble();
                done = true;
            } else {
                System.out.println("You have entered something invalid.");
            }
            scan.nextLine(); //clears buffer
        } while (!done);
        return x;
    }


    public static double getRangedDouble(Scanner scan, String prompt, int min, int max) {
        boolean done = false;
        double x = 0;
        System.out.println(prompt);
        do {
            if (scan.hasNextDouble()) {
                x = scan.nextDouble();
                if (x >= min && x <= max) {
                    done = true;
                } else {
                    System.out.println("Input is outside range.");
                }
            } else {
                System.out.println("You have entered something invalid.");
            }
            scan.nextLine(); //clears buffer
        } while (!done);
        return x;
    }


    public static String getRegExString(Scanner scan, String prompt, String regEx){
        boolean done = false;
        String x = "";
        do {
            System.out.println(prompt);
            x = scan.nextLine();
            if (x.matches(regEx)) {
                done = true;
            }else{
                System.out.println("Input does not match regEx pattern.");
            }
        } while (!done);
        return x;
    }


    public static String getNonZeroString(Scanner scan, String prompt){
        boolean done = false;
        String input;
        do {
            System.out.println(prompt);
            input = scan.nextLine();
            if (!(input.equals(" ") || input.equals(""))) {
                done = true;
            }else{
                System.out.println("You have entered a blank string! :o");
            }
        } while (!done);
        return input;
    }


    public static int getPositiveNonZeroInt(Scanner scan, String prompt){
        boolean done = false;
        int input = 0;
        do {
            if (scan.hasNextInt()) {
                input = scan.nextInt();
                if (input >= 0) {
                    done = true;
                }else{
                    System.out.println("The number is less than zero.");
                }
            }else{
                System.out.println("You have not entered a number.");
            }
        } while (!done);
        return input;
    }


    public static boolean getYNConfirm(Scanner in, String prompt) {
        boolean done = false;
        String YN;
        do {
            System.out.println(prompt);
            YN = in.nextLine();
            YN = YN.toUpperCase();
            if (YN.equals("N") || YN.equals("Y")) {
                done = true;
            } else {
                System.out.println("Invalid");
            }
        } while (!done);
        return YN.equals("N");
    }
    public static void prettyHeader(String msg){
        int x = msg.length();
        int l = (54-x)/2;
        int t = 0;
        for (int j = 0; j <=60; j++) {
            System.out.print("*");




        }
        System.out.println();
        for (int k = 0; k <= 60; k++) {
            if (k<3 || k>57) {
                System.out.print("*");
            }else if(k>3+l && k<58-l){




                String chara = msg.substring(t, t+1);
                t++;
                System.out.print(chara);


            }else{
                System.out.print(" ");
            }


        }
        System.out.println();
        for (int j = 0; j <=60; j++) {
            System.out.print("*");
        }
    }


}
