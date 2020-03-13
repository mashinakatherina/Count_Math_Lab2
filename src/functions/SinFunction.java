package functions;

public class SinFunction  implements Function {

    @Override
    public double getY(double x) {
        return Math.sin(x) / x;
    }

}
