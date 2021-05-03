package com.cst.controlador;

import com.cst.conexionbd.Conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.cst.modelo.Pacientes;
import com.cst.utilidades.Utilidades;

public class Pacientesbd {

    private Utilidades utilidades;

    public Pacientesbd() {
        utilidades = new Utilidades();
    }

    public boolean GuardarPacientes(Pacientes pa) {
        boolean registrar = false;
        Statement stm = null;
        Connection con = null;
        String sql = "INSERT INTO `gestorpacientes`.`pacientes` (`idpacientes`, `historia_clinica`, `cedula`, `nombre`, `apellido`, `fecha_nacimiento`, `residencia`, `edad`, `genero`, `estado_civil`, `fecha_registro`) VALUES ("
                + "'" + String.valueOf(pa.getIdpacientes()) + "',"
                + " '" + pa.getHistoriaclinica() + "',"
                + " '" + pa.getCedula() + "',"
                + " '" + pa.getNombre() + "',"
                + " '" + pa.getApellido() + "',"
                + " '" + utilidades.devolverFecha(pa.getFecha_nacimiento()) + "',"
                + " '" + pa.getResidencia() + "',"
                + " '" + pa.getEdad() + "',"
                + " '" + pa.getGenero() + "',"
                + " '" + pa.getEstado_civil() + "',"
                + " '" + utilidades.devolverFecha(pa.getFecha_registro()) + "');";
        try {
            Conexion conexion = new Conexion();
            con = conexion.ConexionMysql();
            stm = con.createStatement();
            stm.execute(sql);
            registrar = true;
            stm.close();
            return registrar;
        } catch (Exception e) {
            System.out.println("hubo algun error" + e.getMessage());

        }
        return false;
    }

    public boolean EditarPacientes(Pacientes pa) {
        boolean editar = false;
        Statement stm = null;
        Connection con = null;
        String sql = "UPDATE `gestorpacientes`.`pacientes` SET "
                + "`nombre` = '"+pa.getNombre()+"',"
                + " `apellido` = '"+pa.getApellido()+"',"
                + " `residencia` = '"+pa.getResidencia()+"',"
                + " `genero` = '"+pa.getGenero()+"',"
                + " `estado_civil` = '"+pa.getEstado_civil()+"' "
                + "WHERE (`idpacientes` = '"+String.valueOf(pa.getIdpacientes())+"');";
        try {
            Conexion conexion = new Conexion();
            con = conexion.ConexionMysql();
            stm = con.createStatement();
            stm.executeUpdate(sql);
            editar = true;
            stm.close();
            return editar;
        } catch (Exception e) {
            System.out.println("hubo algun error" + e.getMessage());

        }
        return false;
    }

    public boolean EliminarPacientes(Pacientes pa) {
        boolean eliminar = false;
        Statement stm = null;
        Connection con = null;
        String sql = "DELETE FROM `gestorpacientes`.`pacientes` WHERE (`idpacientes` = '" + String.valueOf(pa.getIdpacientes()) + "');";
        try {
            Conexion conexion = new Conexion();
            con = conexion.ConexionMysql();
            stm = con.createStatement();
            stm.executeUpdate(sql);
            eliminar = true;
            stm.close();
            return eliminar;
        } catch (Exception e) {
            System.out.println("hubo algun error" + e.getMessage());

        }
        return false;
    }

    public List<Pacientes> ObtenerPacientes() {
        Connection co = null;
        Statement stm = null;
        //Sentencia de JDBC para obtener valores de la base de datos.
        ResultSet rs = null;
        String sql = "select * from gestorpacientes.pacientes;";
        List<Pacientes> ListaSitiosWeb = new ArrayList<Pacientes>();
        try {
            co = new Conexion().ConexionMysql();
            stm = co.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                Pacientes c = new Pacientes();
                c.setIdpacientes(rs.getInt(1));
                c.setHistoriaclinica(rs.getString(2));
                c.setCedula(rs.getString(3));
                c.setNombre(rs.getString(4));
                c.setApellido(rs.getString(5));
                c.setFecha_nacimiento(rs.getDate(6));
                c.setResidencia(rs.getString(7));
                c.setEdad(rs.getInt(8));
                c.setGenero(rs.getInt(9));
                c.setEstado_civil(rs.getString(10));
                c.setFecha_registro(rs.getDate(11));
                ListaSitiosWeb.add(c);
            }
            stm.close();
            rs.close();
            co.close();
        } catch (SQLException e) {
            System.out.println("Error:" + e.getMessage());
        }
        return ListaSitiosWeb;
    }

    public List<Pacientes> getPacientesHistoriaClinica(String historiaclinica) {
        Connection co = null;
        Statement stm = null;
        //Sentencia de JDBC para obtener valores de la base de datos.
        ResultSet rs = null;
        List<Pacientes> personasEncontradas = new ArrayList<>();
        String sql = "SELECT * FROM gestorpacientes.pacientes where historia_clinica like '%" + historiaclinica + "%';";
        try {
            co = new Conexion().ConexionMysql();
            stm = co.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                Pacientes c = new Pacientes();
                c.setIdpacientes(rs.getInt(1));
                c.setHistoriaclinica(rs.getString(2));
                c.setCedula(rs.getString(3));
                c.setNombre(rs.getString(4));
                c.setApellido(rs.getString(5));
                c.setFecha_nacimiento(rs.getDate(6));
                c.setResidencia(rs.getString(7));
                c.setEdad(rs.getInt(8));
                c.setGenero(rs.getInt(9));
                c.setEstado_civil(rs.getString(10));
                c.setFecha_registro(rs.getDate(11));
                personasEncontradas.add(c);
            }
            stm.close();
            rs.close();
            co.close();
        } catch (SQLException e) {
            System.out.println("Error:" + e.getMessage());
        }
        return personasEncontradas;
    }
    
    public List<Pacientes> getPacientesCedula(String cedula) {
        Connection co = null;
        Statement stm = null;
        //Sentencia de JDBC para obtener valores de la base de datos.
        ResultSet rs = null;
        List<Pacientes> personasEncontradas = new ArrayList<>();
        String sql = "SELECT * FROM gestorpacientes.pacientes where cedula like '%" + cedula + "%';";
        try {
            co = new Conexion().ConexionMysql();
            stm = co.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                Pacientes c = new Pacientes();
                c.setIdpacientes(rs.getInt(1));
                c.setHistoriaclinica(rs.getString(2));
                c.setCedula(rs.getString(3));
                c.setNombre(rs.getString(4));
                c.setApellido(rs.getString(5));
                c.setFecha_nacimiento(rs.getDate(6));
                c.setResidencia(rs.getString(7));
                c.setEdad(rs.getInt(8));
                c.setGenero(rs.getInt(9));
                c.setEstado_civil(rs.getString(10));
                c.setFecha_registro(rs.getDate(11));
                personasEncontradas.add(c);
            }
            stm.close();
            rs.close();
            co.close();
        } catch (SQLException e) {
            System.out.println("Error:" + e.getMessage());
        }
        return personasEncontradas;
    }
    
     public Pacientes getPacienteHistoriaClinica(String historiaclinica) {
        Connection co = null;
        Statement stm = null;
        //Sentencia de JDBC para obtener valores de la base de datos.
        ResultSet rs = null;
        Pacientes c = null;
        String sql = "SELECT * FROM gestorpacientes.pacientes where historia_clinica like '%" + historiaclinica + "%';";
        try {
            co = new Conexion().ConexionMysql();
            stm = co.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                c = new Pacientes();
                c.setIdpacientes(rs.getInt(1));
                c.setHistoriaclinica(rs.getString(2));
                c.setCedula(rs.getString(3));
                c.setNombre(rs.getString(4));
                c.setApellido(rs.getString(5));
                c.setFecha_nacimiento(rs.getDate(6));
                c.setResidencia(rs.getString(7));
                c.setEdad(rs.getInt(8));
                c.setGenero(rs.getInt(9));
                c.setEstado_civil(rs.getString(10));
                c.setFecha_registro(rs.getDate(11));
            }
            stm.close();
            rs.close();
            co.close();
        } catch (SQLException e) {
            System.out.println("Error:" + e.getMessage());
        }
        return c;
    }
}
