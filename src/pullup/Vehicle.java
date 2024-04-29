package pullup;


public class Vehicle {
	protected String nombre;
    protected String casco;
    protected String matricula;
    protected boolean isMaleteroAbierto;
    protected String maletero;

    public void start() {
    }

    public boolean isTrunkOpen() {
        return isMaleteroAbierto;
    }
}
