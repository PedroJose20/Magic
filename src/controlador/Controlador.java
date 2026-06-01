package controlador;

import modelo.*;

import java.util.List;

public class Controlador {
    ConexionDaoMagic daoMagic = new ConexionDaoMagic();

    public Controlador() {}

    public List<Mazos> obtenerMazos() {
        return daoMagic.selectMazos();
    }

    public List<Colores> obtenerColores() {
        return daoMagic.selectColores();
    }

    public List<MazosColores> obtenerMazosColores() {
        return daoMagic.selectMazosColores();
    }

    public int insertarMazo(Mazos mazo) {
        return daoMagic.insertarMazo(mazo);
    }

    public int insertarColor(String nombre) {
        return daoMagic.insertarColor(nombre);
    }

    public int insertarMazoColor(int idMazo, String coloresIds) {
        return daoMagic.insertarMazosColores(idMazo, coloresIds);
    }

    public int eliminarMazo(int idmazos) {
        return daoMagic.eliminarMazo(idmazos);
    }

    public int actualizarMazo(int idmazos, String dato, int opcion) {
        return daoMagic.actualizarMazo(idmazos, dato, opcion);
    }
}