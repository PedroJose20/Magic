package modelo;

public class Colores {
    private int idcolor;
    private String nombre;

    // Constructores
    public Colores() {}

    public Colores(int idcolor, String nombre) {
        this.idcolor = idcolor;
        this.nombre = nombre;
    }

    // Getters y Setters
    public int getIdcolor() { return idcolor; }
    public void setIdcolor(int idcolor) { this.idcolor = idcolor; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
}
