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
public class ExamenesMedicos {
    
   private int idExamenesMedicos, genero;
   private String tipo, instrucciones,  historia_clinica_paciente,cedula, nombre, apellido, codigo_medico;
   private Date fecha_designacion, fecha_expiracion, fecha_nacimiento;

    public ExamenesMedicos() {
    }

    public int getIdExamenesMedicos() {
        return idExamenesMedicos;
    }

    public void setIdExamenesMedicos(int idExamenesMedicos) {
        this.idExamenesMedicos = idExamenesMedicos;
    }

    public int getGenero() {
        return genero;
    }

    public void setGenero(int genero) {
        this.genero = genero;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getInstrucciones() {
        return instrucciones;
    }

    public void setInstrucciones(String instrucciones) {
        this.instrucciones = instrucciones;
    }

    public String getHistoria_clinica_paciente() {
        return historia_clinica_paciente;
    }

    public void setHistoria_clinica_paciente(String historia_clinica_paciente) {
        this.historia_clinica_paciente = historia_clinica_paciente;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCodigo_medico() {
        return codigo_medico;
    }

    public void setCodigo_medico(String codigo_medico) {
        this.codigo_medico = codigo_medico;
    }

    public Date getFecha_designacion() {
        return fecha_designacion;
    }

    public void setFecha_designacion(Date fecha_designacion) {
        this.fecha_designacion = fecha_designacion;
    }

    public Date getFecha_expiracion() {
        return fecha_expiracion;
    }

    public void setFecha_expiracion(Date fecha_expiracion) {
        this.fecha_expiracion = fecha_expiracion;
    }

    public Date getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(Date fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }
    

    @Override
    public String toString() {
        return "ExamenesMedicos{" + "idExamenesMedicos=" + idExamenesMedicos + ", genero=" + genero + ", tipo=" + tipo + ", instrucciones=" + instrucciones + ", historia_clinica_paciente=" + historia_clinica_paciente + ", cedula=" + cedula + ", nombre=" + nombre + ", apellido=" + apellido + ", codigo_medico=" + codigo_medico + ", fecha_designacion=" + fecha_designacion + ", fecha_expiracion=" + fecha_expiracion + '}';
    }

    

    
   
   
}
