import java.sql.ResultSet;
import java.sql.SQLException;

import singleton.ConexionSingleton;

public class Main {
    public static void main(String args[]) {

        try {
            // Creación de objeto Singleton: PANTALLA 1
            ConexionSingleton conexionSingleton1 = ConexionSingleton.getInstance("jdbc:mysql://localhost:3306/ine",
                    "ine_user", "ine.1234");

            // Tabla ciudadano
            System.out.println("--TABLA DE CIUDADANOS--");
            // Inserciones
            conexionSingleton1.getConexion().ejecutar("insert into ciudadano values('JAIME GUERRA')");
            conexionSingleton1.getConexion().ejecutar("insert into ciudadano values('JORDAN CHAVEZ')");
            conexionSingleton1.getConexion().ejecutar("insert into ciudadano values('XIMENA MENDOZA')");
            conexionSingleton1.getConexion().ejecutar("insert into ciudadano values('GABRIEL OLIVAS')");
            // Consulta posterior a las inserciones
            ResultSet rs1 = conexionSingleton1.getConexion().query("select * from ciudadano");
            while (rs1.next()) {
                System.out.println(rs1.getString("nombre"));
            }
            System.out.println();
            // Actualización
            conexionSingleton1.getConexion().ejecutar("update ciudadano set nombre = 'VICENTE GONZALEZ' where nombre = 'GABRIEL OLIVAS'");
            // Eliminación
            conexionSingleton1.getConexion().ejecutar("delete from ciudadano where nombre = 'JAIME GUERRA'");
            // Consulta posterior a la actualización y eliminación
            System.out.println("--TABLA DESPUÉS DE ACTUALIZACIÓN Y ELIMINACIÓN--");
            rs1 = conexionSingleton1.getConexion().query("select * from ciudadano");
            while (rs1.next()) {
                System.out.println(rs1.getString("nombre"));
            }
            System.out.println();

            // Creación de objeto Singleton: PANTALLA 2
            ConexionSingleton conexionSingleton2 = ConexionSingleton.getInstance("jdbc:mysql://localhost:3306/ine",
                    "ine_user", "ine.1234");

            // Tabla entidad
            System.out.println("--TABLA DE ENTIDADES--");
            // Inserciones
            conexionSingleton2.getConexion().ejecutar("insert into entidad values('CHIHUAHUA')");
            conexionSingleton2.getConexion().ejecutar("insert into entidad values('CHIAPAS')");
            conexionSingleton2.getConexion().ejecutar("insert into entidad values('DURANGO')");
            conexionSingleton2.getConexion().ejecutar("insert into entidad values('SONORA')");
            // Consulta posterior a las inserciones
            ResultSet rs2 = conexionSingleton2.getConexion().query("select * from entidad");
            while (rs2.next()) {
                System.out.println(rs2.getString("estado"));
            }
            System.out.println();
            // Actualización
            conexionSingleton2.getConexion().ejecutar("update entidad set estado = 'SINALOA' where estado = 'SONORA'");
            // Eliminación
            conexionSingleton2.getConexion().ejecutar("delete from entidad where estado = 'CHIAPAS'");
            // Consultar posterior a la actualización y eliminación
            System.out.println("--TABLA DESPUÉS DE ACTUALIZACIÓN Y ELIMINACIÓN--");
            rs2 = conexionSingleton2.getConexion().query("select * from entidad");
            while (rs2.next()) {
                System.out.println(rs2.getString("estado"));
            }
            System.out.println();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}