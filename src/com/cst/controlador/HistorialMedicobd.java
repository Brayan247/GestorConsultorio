/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cst.controlador;

import com.cst.conexionbd.Conexion;
import com.cst.modelo.HistorialMedico;
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
public class HistorialMedicobd {

    private Utilidades utilidades;

    public HistorialMedicobd() {
        utilidades = new Utilidades();
    }

    public boolean GuardarHistorialMedico(HistorialMedico hm) {
        boolean registrar = false;
        Statement stm = null;
        Connection con = null;
        String sql = "INSERT INTO `gestorpacientes`.`historial_medico` (`idhisorial_medico`, `codigo_historial_medico`, `historia_clinica_paciente`, `codigo_medico`, `padecimiento`, `medicamentos`, `instrucciones`, `fecha`) VALUES ("
                + "'" + String.valueOf(hm.getIdhistorialmedico()) + "',"
                + " '" + hm.getCodigo_historial_medico() + "',"
                + " '" + hm.getHistoria_clinica_paciente() + "',"
                + " '" + hm.getCodigo_medico() + "',"
                + " '" + hm.getPadecimiento() + "',"
                + " '" + hm.getMedicaciones() + "',"
                + " '" + hm.getInstrucciones() + "',"
                + " '" + utilidades.devolverFecha(hm.getFecha()) + "');";
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

    public boolean EditarHistorialMedico(HistorialMedico hm) {
        boolean editar = false;
        Statement stm = null;
        Connection con = null;
        String sql = "UPDATE `gestorpacientes`.`historial_medico` SET `padecimiento` = '"+hm.getPadecimiento()+"',"
                + " `medicamentos` = '"+hm.getMedicaciones()+"',"
                + " `instrucciones` = '"+hm.getInstrucciones()+"' "
                + "WHERE (`idhisorial_medico` = '"+String.valueOf(hm.getIdhistorialmedico())+"');";
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

    public List<HistorialMedico> ObtenerHistorialMedico() {
        Connection co = null;
        Statement stm = null;
        //Sentencia de JDBC para obtener valores de la base de datos.
        ResultSet rs = null;
        String sql = "select * from gestorpacientes.historial_medico;";
        List<HistorialMedico> ListaHistorialMedico = new ArrayList<HistorialMedico>();
        try {
            co = new Conexion().ConexionMysql();
            stm = co.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                HistorialMedico c = new HistorialMedico();
                c.setIdhistorialmedico(rs.getInt(1));
                c.setCodigo_historial_medico(rs.getString(2));
                c.setHistoria_clinica_paciente(rs.getString(3));
                c.setCodigo_medico(rs.getString(4));
                c.setPadecimiento(rs.getString(5));
                c.setMedicaciones(rs.getString(6));
                c.setInstrucciones(rs.getString(7));
                c.setFecha(rs.getDate(8));
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

    public List<HistorialMedico> getHistorialMedicosHistoriaClinica(String historiaclinica) {
        Connection co = null;
        Statement stm = null;
        //Sentencia de JDBC para obtener valores de la base de datos.
        ResultSet rs = null;
        List<HistorialMedico> personasEncontradas = new ArrayList<>();
        String sql = "SELECT * FROM gestorpacientes.historial_medico where historia_clinica_paciente like '%" + historiaclinica + "%';";
        try {
            co = new Conexion().ConexionMysql();
            stm = co.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                HistorialMedico c = new HistorialMedico();
                c.setIdhistorialmedico(rs.getInt(1));
                c.setCodigo_historial_medico(rs.getString(2));
                c.setHistoria_clinica_paciente(rs.getString(3));
                c.setCodigo_medico(rs.getString(4));
                c.setPadecimiento(rs.getString(5));
                c.setMedicaciones(rs.getString(6));
                c.setInstrucciones(rs.getString(7));
                c.setFecha(rs.getDate(8));
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
    
    public List<HistorialMedico> getHistorialMedicosVodigoMedico(String codigomedico) {
        Connection co = null;
        Statement stm = null;
        //Sentencia de JDBC para obtener valores de la base de datos.
        ResultSet rs = null;
        List<HistorialMedico> personasEncontradas = new ArrayList<>();
        String sql = "SELECT * FROM gestorpacientes.historial_medico where codigo_medico like '%" + codigomedico + "%';";
        try {
            co = new Conexion().ConexionMysql();
            stm = co.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                HistorialMedico c = new HistorialMedico();
                c.setIdhistorialmedico(rs.getInt(1));
                c.setCodigo_historial_medico(rs.getString(2));
                c.setHistoria_clinica_paciente(rs.getString(3));
                c.setCodigo_medico(rs.getString(4));
                c.setPadecimiento(rs.getString(5));
                c.setMedicaciones(rs.getString(6));
                c.setInstrucciones(rs.getString(7));
                c.setFecha(rs.getDate(8));
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
    
    public HistorialMedico getverificacionPaciente(String Historiaclinica) {
        Connection co = null;
        Statement stm = null;
        //Sentencia de JDBC para obtener valores de la base de datos.
        ResultSet rs = null;
        HistorialMedico c = null;
        String sql = "SELECT * FROM gestorpacientes.historial_medico where historia_clinica_paciente like '%" + Historiaclinica + "%';";
        try {
            co = new Conexion().ConexionMysql();
            stm = co.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                c = new HistorialMedico();
                c.setIdhistorialmedico(rs.getInt(1));
                c.setCodigo_historial_medico(rs.getString(2));
                c.setHistoria_clinica_paciente(rs.getString(3));
                c.setCodigo_medico(rs.getString(4));
                c.setPadecimiento(rs.getString(5));
                c.setMedicaciones(rs.getString(6));
                c.setInstrucciones(rs.getString(7));
                c.setFecha(rs.getDate(8));
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
