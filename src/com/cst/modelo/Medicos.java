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
public class Medicos {
    
    private int idmedico, anios_contrato;
    private String cedula, nombre, apellido, codigo, direccion, especialidad;
    private Date fecha_registro;

    public Medicos() {
    }

    public int getIdmedico() {
        return idmedico;
    }

    public void setIdmedico(int idmedico) {
        this.idmedico = idmedico;
    }

    public int getAnios_contrato() {
        return anios_contrato;
    }

    public void setAnios_contrato(int anios_contrato) {
        this.anios_contrato = anios_contrato;
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

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public Date getFecha_registro() {
        return fecha_registro;
    }

    public void setFecha_registro(Date fecha_registro) {
        this.fecha_registro = fecha_registro;
    }

    @Override
    public String toString() {
        return "Medicos{" + "idmedico=" + idmedico + ", anios_contrato=" + anios_contrato + ", cedula=" + cedula + ", nombre=" + nombre + ", apellido=" + apellido + ", codigo=" + codigo + ", direccion=" + direccion + ", especialidad=" + especialidad + ", fecha_registro=" + fecha_registro + '}';
    }
    
    
}
