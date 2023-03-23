package scales;

public class Kelvin extends Temperature {
    public Kelvin(double degrees) {
        super(degrees);
    }

    public double convertoToC() {
        double celsius = this.getDegrees() - 273.15;
        return celsius;
    }

    public double convertoToF() {
        double fahrenheit = this.getDegrees().convertoToC() * 1.8 + 32;
        return fahrenheit;
    }

    public double convertoToK() {
        return this.getDegrees();
    }
}
