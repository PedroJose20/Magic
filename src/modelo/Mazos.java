package modelo;

public class Mazos {
    private int idmazos;
    private String nombre;
    private String formato;

    public Mazos(int idmazos, String nombre, String formato) {
        this.idmazos = idmazos;
        this.nombre = nombre;
        this.formato = formato;
    }

    public Mazos(String nombre, String formato) {
        this.nombre = nombre;
        this.formato = formato;
    }

    public int getIdmazos() {
        return idmazos;
    }

    public void setIdmazos(int idmazos) {
        this.idmazos = idmazos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFormato() {
        return formato;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }

    @Override
    public String toString() {
        return String.format("%-10s %5d || %-9s %-15s || %-10s %-12s%n",
                "ID Mazo:", idmazos,
                "Nombre:", nombre,
                "Formato:", formato);
    }

}