/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cst.controlador;

import com.cst.conexionbd.Conexion;
import com.cst.modelo.ExamenesMedicos;
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
public class ExamenesMedicosbd {

    private Utilidades utilidades;

    public ExamenesMedicosbd() {
        utilidades = new Utilidades();
    }

    public boolean GuardarExamenesMedicos(ExamenesMedicos em) {
        boolean registrar = false;
        Statement stm = null;
        Connection con = null;
        String sql = "INSERT INTO `gestorpacientes`.`examenes_medicos` (`idexamenes_medicos`, `historia_clinica_paciente`, `tipo`, `instrucciones`, `cedula`, `nombre`, `apellido`, `fecha_nacimiento`, `genero`, `codigo_medico`, `fecha_designacion`, `fecha_expiracion`) VALUES "
                + "('"+String.valueOf(em.getIdExamenesMedicos())+"',"
                + " '"+em.getHistoria_clinica_paciente()+"',"
                + " '"+em.getTipo()+"',"
                + " '"+em.getInstrucciones()+"',"
                + " '"+em.getCedula()+"',"
                + " '"+em.getNombre()+"',"
                + " '"+em.getApellido()+"',"
                + " '"+utilidades.devolverFecha(em.getFecha_nacimiento())+"',"
                + " '"+em.getGenero()+"',"
                + " '"+em.getCodigo_medico()+"',"
                + " '"+utilidades.devolverFecha(em.getFecha_designacion())+"',"
                + " '"+utilidades.devolverFecha(em.getFecha_expiracion())+"');";
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

    public List<ExamenesMedicos> ObtenerExamenesMedicos() {
        Connection co = null;
        Statement stm = null;
        //Sentencia de JDBC para obtener valores de la base de datos.
        ResultSet rs = null;
        String sql = "select * from gestorpacientes.examenes_medicos;";
        List<ExamenesMedicos> ListaHistorialMedico = new ArrayList<ExamenesMedicos>();
        try {
            co = new Conexion().ConexionMysql();
            stm = co.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                ExamenesMedicos c = new ExamenesMedicos();
                c.setIdExamenesMedicos(rs.getInt(1));
                c.setHistoria_clinica_paciente(rs.getString(2));
                c.setTipo(rs.getString(3));
                c.setInstrucciones(rs.getString(4));
                c.setCedula(rs.getString(5));
                c.setNombre(rs.getString(6));
                c.setApellido(rs.getString(7));
                c.setFecha_nacimiento(rs.getDate(8));
                c.setGenero(rs.getInt(9));
                c.setCodigo_medico(rs.getString(10));
                c.setFecha_designacion(rs.getDate(11));
                c.setFecha_expiracion(rs.getDate(12));
                ListaHistorialMedico.add(c);
            }
            stm.close();
            rs.close();
            co.close();
        } catch (SQLException e) {
            System.out.println("Error:" + e.getMessage());
        }
        return ListaHistorialMedico;
    }
    
    public List<ExamenesMedicos> getObtenerExamenesMedicosTipo(String tipo) {
        Connection co = null;
        Statement stm = null;
        //Sentencia de JDBC para obtener valores de la base de datos.
        ResultSet rs = null;
        String sql = "select * from gestorpacientes.examenes_medicos where tipo like '%" + tipo + "%';;";
        List<ExamenesMedicos> ListaHistorialMedico = new ArrayList<ExamenesMedicos>();
        try {
            co = new Conexion().ConexionMysql();
            stm = co.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                ExamenesMedicos c = new ExamenesMedicos();
                c.setIdExamenesMedicos(rs.getInt(1));
                c.setHistoria_clinica_paciente(rs.getString(2));
                c.setTipo(rs.getString(3));
                c.setInstrucciones(rs.getString(4));
                c.setCedula(rs.getString(5));
                c.setNombre(rs.getString(6));
                c.setApellido(rs.getString(7));
                c.setFecha_nacimiento(rs.getDate(8));
                c.setGenero(rs.getInt(9));
                c.setCodigo_medico(rs.getString(10));
                c.setFecha_designacion(rs.getDate(11));
                c.setFecha_expiracion(rs.getDate(12));
                ListaHistorialMedico.add(c);
            }
            stm.close();
            rs.close();
            co.close();
        } catch (SQLException e) {
            System.out.println("Error:" + e.getMessage());
        }
        return ListaHistorialMedico;
    }
    
    public List<ExamenesMedicos> getObtenerExamenesMedicosHistoriaClinica(String historiaclinica) {
        Connection co = null;
        Statement stm = null;
        //Sentencia de JDBC para obtener valores de la base de datos.
        ResultSet rs = null;
        String sql = "select * from gestorpacientes.examenes_medicos where historia_clinica_paciente like '%" + historiaclinica + "%';;";
        List<ExamenesMedicos> ListaHistorialMedico = new ArrayList<ExamenesMedicos>();
        try {
            co = new Conexion().ConexionMysql();
            stm = co.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                ExamenesMedicos c = new ExamenesMedicos();
                c.setIdExamenesMedicos(rs.getInt(1));
                c.setHistoria_clinica_paciente(rs.getString(2));
                c.setTipo(rs.getString(3));
                c.setInstrucciones(rs.getString(4));
                c.setCedula(rs.getString(5));
                c.setNombre(rs.getString(6));
                c.setApellido(rs.getString(7));
                c.setFecha_nacimiento(rs.getDate(8));
                c.setGenero(rs.getInt(9));
                c.setCodigo_medico(rs.getString(10));
                c.setFecha_designacion(rs.getDate(11));
                c.setFecha_expiracion(rs.getDate(12));
                ListaHistorialMedico.add(c);
            }
            stm.close();
            rs.close();
            co.close();
        } catch (SQLException e) {
            System.out.println("Error:" + e.getMessage());
        }
        return ListaHistorialMedico;
    }
    
    public List<ExamenesMedicos> getObtenerExamenesMedicosCodigoMedico(String codigo) {
        Connection co = null;
        Statement stm = null;
        //Sentencia de JDBC para obtener valores de la base de datos.
        ResultSet rs = null;
        String sql = "select * from gestorpacientes.examenes_medicos where codigo_medico like '%" + codigo + "%';;";
        List<ExamenesMedicos> ListaHistorialMedico = new ArrayList<ExamenesMedicos>();
        try {
            co = new Conexion().ConexionMysql();
            stm = co.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                ExamenesMedicos c = new ExamenesMedicos();
                c.setIdExamenesMedicos(rs.getInt(1));
                c.setHistoria_clinica_paciente(rs.getString(2));
                c.setTipo(rs.getString(3));
                c.setInstrucciones(rs.getString(4));
                c.setCedula(rs.getString(5));
                c.setNombre(rs.getString(6));
                c.setApellido(rs.getString(7));
                c.setFecha_nacimiento(rs.getDate(8));
                c.setGenero(rs.getInt(9));
                c.setCodigo_medico(rs.getString(10));
                c.setFecha_designacion(rs.getDate(11));
                c.setFecha_expiracion(rs.getDate(12));
                ListaHistorialMedico.add(c);
            }
            stm.close();
            rs.close();
            co.close();
        } catch (SQLException e) {
            System.out.println("Error:" + e.getMessage());
        }
        return ListaHistorialMedico;
    }
    
    

}
