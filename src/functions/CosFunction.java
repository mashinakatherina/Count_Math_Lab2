package functions;

public class CosFunction implements Function {
    @Override
    public double getY(double x) {
        return Math.cos(x);
    }
}
