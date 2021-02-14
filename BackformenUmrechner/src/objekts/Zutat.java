package objekts;

public class Zutat {
    private String name;
    private double anzahl;
    private String einheit;
    
    public Zutat(String _name, double _anzahl, String _einheit) {
	name = _name;
	anzahl = _anzahl;
	einheit = _einheit;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAnzahl() {
        return anzahl;
    }

    public void setAnzahl(double d) {
        this.anzahl = d;
    }

    public String getEinheit() {
        return einheit;
    }

    public void setEinheit(String einheit) {
        this.einheit = einheit;
    }
}
