import functions.Function;

import static utilits.Utilities.colorize;

public class Commands {
    public static void doCommand(String command) {
        switch (command) {

            case "input": {
                manualInput();
                return;
            }
            case "help": {
                System.out.println(getHelp());
                return;
            }
            case "exit": {
                System.exit(0);
            }
            default: {
                System.out.println("undefined command. use help");
            }
        }
    }

    private static void manualInput() {

        System.out.println("Choose on of these functions. Type number of function you want to integrate \n" +
                "1) y = 2x + 5 \n" +
                "2) y = 1 / x \n" +
                "3) y = x^2 \n" +
                "4) y = sqrt(x) \n"+
                "5) y = sin(x) / x\n" +
                "6) y = e^x \n");
        Function function = InputReader.functionChooser();

        System.out.println("Type low limit  of the integration here");
        double lowerLimit = InputReader.input();

        System.out.println("Type up limit  of the integration here");
        double upperLimit = InputReader.input();

        System.out.println("Type wanted accuracy");
        double accuracy = InputReader.input();

        boolean isIntervalValid = true;

        if (upperLimit < lowerLimit) {
            isIntervalValid = false;
            upperLimit += lowerLimit;
            lowerLimit = upperLimit - lowerLimit;
            upperLimit -= lowerLimit;
        }

        if (upperLimit == lowerLimit){
            System.out.println(colorize("[[RED]]Limits are equal. Integral is zero.[[RESET]]"));
            return;
        }


        double result[] = Algorithm.integrate(function, lowerLimit, upperLimit, accuracy);
        if (Double.isFinite(result[0])) {
            if  (!isIntervalValid) result[0] *= -1;
            if (result[2] < accuracy)
                System.out.println(colorize(" [[BLUE]]Integral: [[RESET]]" + result[0] +
                        "\n[[BLUE]] Amount of divisions: [[RESET]]" + result[1] +
                        "\n[[BLUE]] Measurement error: [[RESET]]" + result[1 + 1]));
            else System.out.println(colorize("[[RED]]Cannot get accuracy[[RESET]]"));
        }
        else System.out.println(colorize("[[RED]]Integral is not convergence[[RESET]]"));


    }
    public static String getHelp() {
        return colorize( "To choose function type '[[BLUE]]input[[RESET]]' here," +
                "\n you choose from some functions: [[GREEN]]" +
                "\n 1) y = 2x + 5 " +
                "\n 2) y = 1 / x " +
                "\n 3) y = x^2 " +
                "\n 4) y = sqrt(x) "+
                "\n 5) y = sin(x) / x" +
                "\n 6) y = e^x "+
                "\n [[RESET]]to exit enter '[[BLUE]]exit[[RESET]]'" +
                "\n to get help use '[[BLUE]]help[[RESET]]'. All.");
    }

}
