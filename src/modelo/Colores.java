package modelo;

public class Colores {
    private int idcolor;
    private String nombre;

    public Colores(int idcolor, String nombre) {
        this.idcolor = idcolor;
        this.nombre = nombre;
    }

    public int getIdcolor() {
        return idcolor;
    }


    public void setIdcolor(int idcolor) {
        this.idcolor = idcolor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return String.format("%-10s %5d || %-9s %-15s%n",
                "ID Color:", idcolor,
                "Nombre:", nombre);
    }

}