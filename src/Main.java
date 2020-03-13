import functions.*;

import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        System.out.println(Commands.getHelp());
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("> ");
            String s = scanner.next();
            Commands.doCommand(s);
        }
    }
}
