package modelo;

public class Mazos {
    private int idmazos;
    private String nombre;
    private String formato;

    // Constructores
    public Mazos() {}

    public Mazos(int idmazos, String nombre, String formato) {
        this.idmazos = idmazos;
        this.nombre = nombre;
        this.formato = formato;
    }

    // Getters y Setters
    public int getIdmazos() { return idmazos; }
    public void setIdmazos(int idmazos) { this.idmazos = idmazos; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getFormato() { return formato; }
    public void setFormato(String formato) { this.formato = formato; }
}
