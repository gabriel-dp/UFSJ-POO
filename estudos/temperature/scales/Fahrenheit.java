package scales;

public class Fahrenheit extends Temperature {
    public Fahrenheit(double degrees) {
        super(degrees);
    }

    public double convertoToC() {
        double celsius = (this.getDegrees() - 32) / 1.8;
        return celsius;
    }

    public double convertoToF() {
        return this.getDegrees();
    }

    public double convertoToK() {
        double kelvin = this.getDegrees().convertoToC() + 273.15;
        return kelvin;
    }
}
