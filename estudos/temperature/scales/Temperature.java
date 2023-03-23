package scales;

public abstract class Temperature {
    private double degrees;

    public Temperature(double degrees) {
        this.degrees = degrees;
    }

    public double getDegrees() {
        return this.degrees;
    }

    public abstract double convertoToC();

    public abstract double convertoToF();

    public abstract double convertoToK();
}
