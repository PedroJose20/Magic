package modelo;

public class MazosColores {
    private int idMazo;
    private int idColor;
    private String faccion;

    // Constructores
    public MazosColores() {}

    public MazosColores(int idMazo, int idColor, String faccion) {
        this.idMazo = idMazo;
        this.idColor = idColor;
        this.faccion = faccion;
    }

    // Getters y Setters
    public int getIdMazo() { return idMazo; }
    public void setIdMazo(int idMazo) { this.idMazo = idMazo; }

    public int getIdColor() { return idColor; }
    public void setIdColor(int idColor) { this.idColor = idColor; }

    public String getFaccion() { return faccion; }
    public void setFaccion(String faccion) { this.faccion = faccion; }
}
