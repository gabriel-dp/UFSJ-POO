package scales;

public class Celsius extends Temperature {
    public Celsius(double degrees) {
        super(degrees);
    }

    public double convertoToC() {
        return this.getDegrees();
    }

    public double convertoToF() {
        double fahrenheit = this.getDegrees() * 1.8 + 32;
        return fahrenheit;
    }

    public double convertoToK() {
        double kelvin = this.getDegrees() + 273.15;
        return kelvin;
    }
}
