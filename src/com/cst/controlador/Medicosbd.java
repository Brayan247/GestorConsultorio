/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cst.controlador;

import com.cst.conexionbd.Conexion;
import com.cst.modelo.Medicos;
import com.cst.utilidades.Utilidades;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ordenador
 */
public class Medicosbd {

    private Utilidades utilidades;

    public Medicosbd() {
        utilidades = new Utilidades();
    }

    public boolean GuardarMedicos(Medicos me) {
        boolean registrar = false;
        Statement stm = null;
        Connection con = null;
        String sql = "INSERT INTO `gestorpacientes`.`medicos` (`idmedicos`, `cedula`, `nombre`, `apellido`, `codigo`, `direccion`, `años_contrato`, `especialidad`, `fecha_registro`) VALUES ("
                + "'" + String.valueOf(me.getIdmedico()) + "',"
                + " '" + me.getCedula() + "',"
                + " '" + me.getNombre() + "',"
                + " '" + me.getApellido() + "',"
                + " '" + me.getCodigo() + "',"
                + " '" + me.getDireccion() + "',"
                + " '" + me.getAnios_contrato() + "',"
                + " '" + me.getEspecialidad() + "',"
                + " '" + utilidades.devolverFecha(me.getFecha_registro()) + "');";
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

    public boolean EditarMedicos(Medicos me) {
        boolean editar = false;
        Statement stm = null;
        Connection con = null;
        String sql = "UPDATE `gestorpacientes`.`medicos` SET "
                + "`direccion` = '" + me.getDireccion() + "',"
                + " `años_contrato` = '" + me.getAnios_contrato() + "'"
                + " WHERE (`idmedicos` = '" + String.valueOf(me.getIdmedico()) + "');";
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

    public boolean EliminarMedicos(Medicos me) {
        boolean eliminar = false;
        Statement stm = null;
        Connection con = null;
        String sql = "DELETE FROM `gestorpacientes`.`medicos` WHERE (`idmedicos` = '" + String.valueOf(me.getIdmedico()) + "');";
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

    public List<Medicos> ObtenerMedicos() {
        Connection co = null;
        Statement stm = null;
        //Sentencia de JDBC para obtener valores de la base de datos.
        ResultSet rs = null;
        String sql = "select * from gestorpacientes.medicos;";
        List<Medicos> ListaMedicos = new ArrayList<Medicos>();
        try {
            co = new Conexion().ConexionMysql();
            stm = co.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                Medicos c = new Medicos();
                c.setIdmedico(rs.getInt(1));
                c.setCedula(rs.getString(2));
                c.setNombre(rs.getString(3));
                c.setApellido(rs.getString(4));
                c.setCodigo(rs.getString(5));
                c.setDireccion(rs.getString(6));
                c.setAnios_contrato(rs.getInt(7));
                c.setEspecialidad(rs.getString(8));
                c.setFecha_registro(rs.getDate(9));
                ListaMedicos.add(c);
            }
            stm.close();
            rs.close();
            co.close();
        } catch (SQLException e) {
            System.out.println("Error:" + e.getMessage());
        }
        return ListaMedicos;
    }
    
    public List<Medicos> getMedicosCedula(String cedula) {
        Connection co = null;
        Statement stm = null;
        //Sentencia de JDBC para obtener valores de la base de datos.
        ResultSet rs = null;
        List<Medicos> personasEncontradas = new ArrayList<>();
        String sql = "SELECT * FROM gestorpacientes.medicos where cedula like '%" + cedula + "%';";
        try {
            co = new Conexion().ConexionMysql();
            stm = co.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                Medicos c = new Medicos();
                c.setIdmedico(rs.getInt(1));
                c.setCedula(rs.getString(2));
                c.setNombre(rs.getString(3));
                c.setApellido(rs.getString(4));
                c.setCodigo(rs.getString(5));
                c.setDireccion(rs.getString(6));
                c.setAnios_contrato(rs.getInt(7));
                c.setEspecialidad(rs.getString(8));
                c.setFecha_registro(rs.getDate(9));
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

    public List<Medicos> getMedicosCodigo(String codigo) {
        Connection co = null;
        Statement stm = null;
        //Sentencia de JDBC para obtener valores de la base de datos.
        ResultSet rs = null;
        List<Medicos> personasEncontradas = new ArrayList<>();
        String sql = "SELECT * FROM gestorpacientes.medicos where codigo like '%" + codigo + "%';";
        try {
            co = new Conexion().ConexionMysql();
            stm = co.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                Medicos c = new Medicos();
                c.setIdmedico(rs.getInt(1));
                c.setCedula(rs.getString(2));
                c.setNombre(rs.getString(3));
                c.setApellido(rs.getString(4));
                c.setCodigo(rs.getString(5));
                c.setDireccion(rs.getString(6));
                c.setAnios_contrato(rs.getInt(7));
                c.setEspecialidad(rs.getString(8));
                c.setFecha_registro(rs.getDate(9));
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
     public Medicos getMedicoCodigo(String codigo) {
        Connection co = null;
        Statement stm = null;
        //Sentencia de JDBC para obtener valores de la base de datos.
        ResultSet rs = null;
        Medicos c = null;
        String sql = "SELECT * FROM gestorpacientes.medicos where codigo like '%" + codigo + "%';";
        try {
            co = new Conexion().ConexionMysql();
            stm = co.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                c = new Medicos();
                c.setIdmedico(rs.getInt(1));
                c.setCedula(rs.getString(2));
                c.setNombre(rs.getString(3));
                c.setApellido(rs.getString(4));
                c.setCodigo(rs.getString(5));
                c.setDireccion(rs.getString(6));
                c.setAnios_contrato(rs.getInt(7));
                c.setEspecialidad(rs.getString(8));
                c.setFecha_registro(rs.getDate(9));
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
