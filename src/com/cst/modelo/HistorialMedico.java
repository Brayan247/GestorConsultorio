/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cst.modelo;

import java.util.Date;

/**
 *
 * @author Ordenador
 */
public class HistorialMedico {
    
    private int idhistorialmedico;
    private String codigo_historial_medico, historia_clinica_paciente, codigo_medico,
            padecimiento, medicaciones, instrucciones;
    private Date fecha;

    public HistorialMedico() {
    }

    public int getIdhistorialmedico() {
        return idhistorialmedico;
    }

    public void setIdhistorialmedico(int idhistorialmedico) {
        this.idhistorialmedico = idhistorialmedico;
    }

    public String getCodigo_historial_medico() {
        return codigo_historial_medico;
    }

    public void setCodigo_historial_medico(String codigo_historial_medico) {
        this.codigo_historial_medico = codigo_historial_medico;
    }

    public String getHistoria_clinica_paciente() {
        return historia_clinica_paciente;
    }

    public void setHistoria_clinica_paciente(String historia_clinica_paciente) {
        this.historia_clinica_paciente = historia_clinica_paciente;
    }

    public String getCodigo_medico() {
        return codigo_medico;
    }

    public void setCodigo_medico(String codigo_medico) {
        this.codigo_medico = codigo_medico;
    }

    public String getPadecimiento() {
        return padecimiento;
    }

    public void setPadecimiento(String padecimiento) {
        this.padecimiento = padecimiento;
    }

    public String getMedicaciones() {
        return medicaciones;
    }

    public void setMedicaciones(String medicaciones) {
        this.medicaciones = medicaciones;
    }

    public String getInstrucciones() {
        return instrucciones;
    }

    public void setInstrucciones(String instrucciones) {
        this.instrucciones = instrucciones;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "HistorialMedico{" + "idhistorialmedico=" + idhistorialmedico + ", codigo_historial_medico=" + codigo_historial_medico + ", historia_clinica_paciente=" + historia_clinica_paciente + ", codigo_medico=" + codigo_medico + ", padecimiento=" + padecimiento + ", medicaciones=" + medicaciones + ", instrucciones=" + instrucciones + ", fecha=" + fecha + '}';
    }
    
    
}
