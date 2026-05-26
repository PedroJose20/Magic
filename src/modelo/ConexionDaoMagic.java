package modelo;

import java.sql.*;
import java.util.ArrayList;

public class ConexionDaoMagic {
    private static final String URL = "jdbc:mysql://localhost:3306/instituto";
    private static final String USUARIO = "root";
    private static final String CONTRASENNA = "1234";

    private static Connection conectarseABDD() throws SQLException {
        return DriverManager.getConnection(URL, USUARIO, CONTRASENNA);
    }

    public ArrayList<Mazos> selectMagic(){
        ArrayList<Mazos> mazos = new ArrayList<Mazos>();
        try (Connection conn = conectarseABDD()){
            String sql = "SELECT idmazos, nombre, formato FROM magic.mazos order by nombre;";
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
}
