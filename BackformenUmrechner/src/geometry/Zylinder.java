package geometry;

public class Zylinder {
    // Variablen
    private double durchmesser;
    private double hoehe;
    
    // Konstruktoren
    public Zylinder(double d, double h) {
	durchmesser = d;
	hoehe = h;
    }
    
    public Zylinder(double d) {
	this(d,6);
    }
    
    // Getter und Setter
    public double getDurchmesser() {
        return durchmesser;
    }

    public void setDurchmesser(double durchmesser) {
        this.durchmesser = durchmesser;
    }

    public double getHoehe() {
        return hoehe;
    }

    public void setHoehe(double hoehe) {
        this.hoehe = hoehe;
    }
    
    // Eigene Methoden
    public double getFlaeche() {
	double f = Math.PI * ((durchmesser/2)*(durchmesser/2));
	return f;
    }
    
    public double getVolumen() {
	double v = getFlaeche() * hoehe;
	return v;
    }
}
