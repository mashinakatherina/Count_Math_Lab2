package functions;

public class ParabolicFunction implements Function {

    @Override
    public double getY(double x) {
        return Math.pow(x, 2);
    }

}
