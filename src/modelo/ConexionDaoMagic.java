package modelo;

import java.sql.*;
import java.util.ArrayList;

public class ConexionDaoMagic {
    private static final String URL = "jdbc:mysql://localhost:3306/magic";
    private static final String USUARIO = "root";
    private static final String CONTRASENNA = "1234";

    private static Connection conectarseABDD() throws SQLException {
        return DriverManager.getConnection(URL, USUARIO, CONTRASENNA);
    }

    // SELECT MAZOS
    public ArrayList<Mazos> selectMazos() {
        ArrayList<Mazos> mazos = new ArrayList<>();
        try (Connection conn = conectarseABDD()) {
            String sql = "SELECT idmazos, nombre, formato FROM mazos ORDER BY idmazos ASC;";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                int idmazos = rs.getInt("idmazos");
                String nombre = rs.getString("nombre");
                String formato = rs.getString("formato");
                mazos.add(new Mazos(idmazos, nombre, formato));
            }
        } catch (SQLException ex) {
            System.out.println("Error al conectar a la base de datos: " + ex.getMessage());
        }
        return mazos;
    }

    // SELECT COLORES
    public ArrayList<Colores> selectColores() {
        ArrayList<Colores> colores = new ArrayList<>();
        try (Connection conn = conectarseABDD()) {
            String sql = "SELECT idcolor, nombre FROM colores ORDER BY idcolor;";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                int idcolor = rs.getInt("idcolor");
                String nombre = rs.getString("nombre");
                colores.add(new Colores(idcolor, nombre));
            }
        } catch (SQLException ex) {
            System.out.println("Error al conectar a la base de datos: " + ex.getMessage());
        }
        return colores;
    }

    // SELECT MAZOS_COLORES
    public ArrayList<MazosColores> selectMazosColores() {
        ArrayList<MazosColores> lista = new ArrayList<>();
        try (Connection conn = conectarseABDD()) {
            String sql = "SELECT mc.id_mazo, mc.colores_ids, mc.faccion, m.nombre FROM mazos_colores mc JOIN mazos m ON mc.id_mazo = m.idmazos ORDER BY mc.id_mazo;";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                int idMazo = rs.getInt("id_mazo");
                String coloresIds = rs.getString("colores_ids");
                String faccion = rs.getString("faccion");
                String nombreMazo = rs.getString("nombre");
                lista.add(new MazosColores(idMazo, coloresIds, faccion, nombreMazo));
            }
        } catch (SQLException ex) {
            System.out.println("Error al conectar a la base de datos: " + ex.getMessage());
        }
        return lista;
    }

    // INSERT MAZO
    public int insertarMazo(Mazos mazo) {
        int resultado = 0;
        try (Connection conn = conectarseABDD()) {
            String query = "INSERT INTO mazos (nombre, formato) VALUES (?, ?);";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, mazo.getNombre());
            stmt.setString(2, mazo.getFormato());
            resultado = stmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Error al insertar mazo: " + ex.getMessage());
        }
        return resultado;
    }

    // INSERT COLOR
    public int insertarColor(String nombre) {
        int resultado = 0;
        try (Connection conn = conectarseABDD()) {
            String query = "INSERT INTO colores (nombre) VALUES (?);";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, nombre);
            resultado = stmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Error al insertar color: " + ex.getMessage());
        }
        return resultado;
    }

    // INSERT MAZO_COLORS
    public int insertarMazosColores(int idMazo, String coloresIds) {
        int resultado = 0;
        try (Connection conn = conectarseABDD()) {
            String query = "INSERT INTO mazos_colores (id_mazo, colores_ids) VALUES (?, ?);";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, idMazo);
            stmt.setString(2, coloresIds);
            resultado = stmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Error al insertar relación mazo-colores: " + ex.getMessage());
        }
        return resultado;
    }

    // DELETE MAZO
    public int eliminarMazo(int idmazos) {
        int resultado = 0;
        try (Connection conn = conectarseABDD()) {
            String q1 = "DELETE FROM mazos_colores WHERE id_mazo = ?;";
            PreparedStatement stmt1 = conn.prepareStatement(q1);
            stmt1.setInt(1, idmazos);
            stmt1.executeUpdate();

            String q2 = "DELETE FROM mazos WHERE idmazos = ?;";
            PreparedStatement stmt2 = conn.prepareStatement(q2);
            stmt2.setInt(1, idmazos);
            resultado = stmt2.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Error al eliminar mazo: " + ex.getMessage());
        }
        return resultado;
    }

    // UPDATE MAZO
    public int actualizarMazo(int idmazos, String dato, int opcion) {
        int resultado = 0;
        try (Connection conn = conectarseABDD()) {
            String query;
            PreparedStatement stmt;
            switch (opcion) {
                case 1:
                    query = "UPDATE mazos SET nombre = ? WHERE idmazos = ?;";
                    stmt = conn.prepareStatement(query);
                    stmt.setString(1, dato);
                    stmt.setInt(2, idmazos);
                    resultado = stmt.executeUpdate();
                    break;
                case 2:
                    query = "UPDATE mazos SET formato = ? WHERE idmazos = ?;";
                    stmt = conn.prepareStatement(query);
                    stmt.setString(1, dato);
                    stmt.setInt(2, idmazos);
                    resultado = stmt.executeUpdate();
                    break;
                case 3:
                    query = "UPDATE mazos_colores SET colores_ids = ? WHERE id_mazo = ?;";
                    stmt = conn.prepareStatement(query);
                    stmt.setString(1, dato);
                    stmt.setInt(2, idmazos);
                    resultado = stmt.executeUpdate();
                    break;
            }
        } catch (SQLException ex) {
            System.out.println("Error al actualizar mazo: " + ex.getMessage());
        }
        return resultado;
    }
}