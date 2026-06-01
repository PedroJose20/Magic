package modelo;

public class MazosColores {
    private int idMazo;
    private String coloresIds;
    private String faccion;
    private String nombreMazo;

    public MazosColores(int idMazo, String coloresIds, String faccion, String nombreMazo) {
        this.idMazo = idMazo;
        this.coloresIds = coloresIds;
        this.faccion = faccion;
        this.nombreMazo = nombreMazo;
    }

    public int getIdMazo() {
        return idMazo;
    }

    public void setIdMazo(int idMazo) {
        this.idMazo = idMazo;
    }

    public String getColoresIds() {
        return coloresIds;
    }

    public void setColoresIds(String coloresIds) {
        this.coloresIds = coloresIds;
    }

    public String getFaccion() {
        return faccion;
    }

    public void setFaccion(String faccion) {
        this.faccion = faccion;
    }

    public String getNombreMazo() {
        return nombreMazo;
    }

    public void setNombreMazo(String nombreMazo) {
        this.nombreMazo = nombreMazo;
    }

    @Override
    public String toString() {
        return String.format("%-10s %5d || %-13s %-18s || %-13s %-12s || %-10s %-15s%n",
                "ID Mazo:", idMazo,
                "Nombre:", nombreMazo,
                "IDs Colores:", coloresIds,
                "Facción:", faccion);
    }

}