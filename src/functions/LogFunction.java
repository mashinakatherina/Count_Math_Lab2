package functions;

public class LogFunction implements Function {
    @Override
    public double getY(double x) {
        return Math.log(x);
    }
}
