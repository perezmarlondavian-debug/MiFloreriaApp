package com.mifloreria.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Clase encargada de establecer la conexión con la base de datos MySQL.
 * Sigue el patrón de diseño básico para la conexión.
 */
public class Conexion {
    
    // Credenciales de la base de datos
    private static final String URL = "jdbc:mysql://localhost:3306/mi_floreria";
    private static final String USUARIO = "root";
    private static final String CLAVE = ""; 

    /**
     * Método para obtener la conexión a la base de datos.
     * @return Objeto Connection activo, o null si falla.
     */
    public Connection getConexion() {
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(URL, USUARIO, CLAVE);
            System.out.println("Conexión exitosa a la base de datos.");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error al conectar con la base de datos: " + e.getMessage());
        }
        return con;
    }
}