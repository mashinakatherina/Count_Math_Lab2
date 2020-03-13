import functions.Function;

public class Algorithm {

    private static final double EPSILON = 1e-9;

    public static double[] calculate(Function function, double lowLimit, double upLimit, double accuracy) {
        int amountOfDivisions = 2;
        double error = 2;
        double step = (upLimit - lowLimit)/amountOfDivisions;

        double lowValue = function.getY(lowLimit);
        if (!Double.isFinite(lowValue))
            lowValue = function.getY(lowLimit + EPSILON);

        double upValue = function.getY(upLimit);
        if (!Double.isFinite(lowValue))
            upValue = function.getY(upLimit - EPSILON);

        double value = 4 * function.getY(lowLimit + step);
        if (!Double.isFinite(value))
            value = 4 *(function.getY((lowLimit + step + EPSILON)) + function.getY(lowLimit + step - EPSILON))/2;

        double previousValue = (step / 3)*(lowValue + value + upValue);
        double currentValue = 0;

        while (error > accuracy && amountOfDivisions < 1000000000) {

            amountOfDivisions *= 2;
            step = (upLimit - lowLimit)/amountOfDivisions;
            currentValue = (step / 3)*(calculateSum(function,amountOfDivisions, step, lowLimit));
            error = (Math.abs(currentValue - previousValue)/15);
            previousValue = currentValue;
        }

        return new double[]{ currentValue, amountOfDivisions, error};
    }

    private static double calculateSum(Function function, double stepCounter,  double step, double lowLimit){
        double result = 0;

        double currentValue;
        for (int i = 0; i < stepCounter; i+=2){

            double tmp = 0;

            currentValue = function.getY(lowLimit + step*(i-1));
            if (!Double.isFinite(currentValue))
                if (i==0)
                    currentValue = function.getY(lowLimit + EPSILON);
                else
                    currentValue = (function.getY(lowLimit + step*(i-1) + EPSILON) + function.getY(lowLimit + step*(i-1) - EPSILON))/2;
            tmp += currentValue;


            currentValue = function.getY(lowLimit + step*i);
            if (!Double.isFinite(currentValue))
                currentValue = (function.getY(lowLimit + step*i + EPSILON) + function.getY(lowLimit + step*i - EPSILON))/2;
            tmp += 4 * currentValue;


            currentValue = function.getY(lowLimit + step*(i+1));
            if (!Double.isFinite(currentValue))
                if (i==stepCounter)
                    currentValue = function.getY(lowLimit + EPSILON);
                else
                    currentValue = (function.getY(lowLimit + step*(i+1) + EPSILON) + function.getY(lowLimit + step*(i+1) - EPSILON))/2;
            tmp += currentValue;

            result += tmp;
        }
        return result;
    }

}
