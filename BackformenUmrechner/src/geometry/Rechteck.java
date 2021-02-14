package geometry;

public class Rechteck {
    // Variablen
    private double seiteA;
    private double seiteB;
    private double hoehe;
    
    // Konstruktoren
    public Rechteck(double a, double b, double h) {
	seiteA = a;
	seiteB = b;
	hoehe = h;
    }
    
    public Rechteck(double a, double b) {
	this(a, b, 4);
    }
    
    // Getter und Setter
    public double getSeiteA() {
        return seiteA;
    }

    public void setSeiteA(double seiteA) {
        this.seiteA = seiteA;
    }

    public double getSeiteB() {
        return seiteB;
    }

    public void setSeiteB(double seiteB) {
        this.seiteB = seiteB;
    }

    public double getHoehe() {
        return hoehe;
    }

    public void setHoehe(double hoehe) {
        this.hoehe = hoehe;
    }
    
    // Eigene Methoden
    public double getFlaeche() {
	double f = seiteA * seiteB;
	return f;
    }
    
    public double getVolumen() {
	double v = getFlaeche() * hoehe;
	return v;
    }
}
