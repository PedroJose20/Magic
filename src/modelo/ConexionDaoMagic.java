package modelo;

import java.sql.*;

public class ConexionDaoMagic {
    private static final String URL = "jdbc:mysql://localhost:3306/instituto";
    private static final String USUARIO = "root";
    private static final String CONTRASENNA = "1234";

    private static Connection conectarseABDD() throws SQLException {
        return DriverManager.getConnection(URL, USUARIO, CONTRASENNA);
    }
}
