import functions.*;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputReader {
    public static Function functionChooser(){
        Function result = null;

        Scanner scanner = new Scanner(System.in);
        System.out.print(">>> ");
        String number = scanner.next();

        switch (number){
            case "1":{
                result = new LinearFunction();
                break;
            }
            case "2":{
                result = new HyperbolicFunction();
                break;
            }
            case "3":{
                result = new ParabolicFunction();
                break;
            }
            case "4":{
                result = new RadicalFunction();
                break;
            }
            case "5":{
                result = new SinFunction();
                break;
            }
            case "6":{
                result = new ExpFunction();
                break;
            }
            default:{
                System.out.println("Please try again");
                functionChooser();
            }
        }
        return result;
    }

    public static double input(){
        double result = 0;
        Scanner scanner = new Scanner(System.in);
        boolean checkinput = true;
        while (checkinput) {
            System.out.print(">>> ");
            String s = scanner.next();
            try {
                result = Double.parseDouble(s);
                checkinput = false;
            }
            catch (NumberFormatException | InputMismatchException e) {
                System.out.println("Please try again");
            }
        }
        return result;
    }
}
