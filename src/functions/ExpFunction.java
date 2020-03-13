package functions;

public class ExpFunction implements Function {
    @Override
    public double getY(double x) {
        return Math.exp(x);
    }
}
