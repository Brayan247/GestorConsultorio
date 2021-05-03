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
public class Pacientes {

    private int idpacientes;
    private String historiaclinica;
    private String cedula;
    private String nombre;
    private String apellido;
    private Date fecha_nacimiento;
    private String residencia;
    private int edad;
    private int genero;
    private String estado_civil;
    private Date fecha_registro;

    public Pacientes() {
    }

    public int getIdpacientes() {
        return idpacientes;
    }

    public void setIdpacientes(int idpacientes) {
        this.idpacientes = idpacientes;
    }

    public String getHistoriaclinica() {
        return historiaclinica;
    }

    public void setHistoriaclinica(String historiaclinica) {
        this.historiaclinica = historiaclinica;
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

    public Date getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(Date fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public String getResidencia() {
        return residencia;
    }

    public void setResidencia(String residencia) {
        this.residencia = residencia;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getGenero() {
        return genero;
    }

    public void setGenero(int genero) {
        this.genero = genero;
    }

    public String getEstado_civil() {
        return estado_civil;
    }

    public void setEstado_civil(String estado_civil) {
        this.estado_civil = estado_civil;
    }

    public Date getFecha_registro() {
        return fecha_registro;
    }

    public void setFecha_registro(Date fecha_registro) {
        this.fecha_registro = fecha_registro;
    }

    @Override
    public String toString() {
        return "Pacientes{" + "idpacientes=" + idpacientes + ", historiaclinica=" + historiaclinica + ", cedula=" + cedula + ", nombre=" + nombre + ", apellido=" + apellido + ", fecha_nacimiento=" + fecha_nacimiento + ", residencia=" + residencia + ", edad=" + edad + ", genero=" + genero + ", estado_civil=" + estado_civil + ", fecha_registro=" + fecha_registro + '}';
    }

    

}
