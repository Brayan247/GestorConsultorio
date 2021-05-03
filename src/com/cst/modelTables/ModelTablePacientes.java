/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cst.modelTables;

import com.cst.modelo.Pacientes;
import com.cst.vista.GestionConsultorio;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Ordenador
 */
public class ModelTablePacientes extends AbstractTableModel {
        //Arreglo con el nombre de las columnas
     public String[] m_colNames = {"HISTORIA CLINICA", "CEDULA", "NOMBRE", "APELLIDO", "FECHA NACIMIENTO", "RESIDENCIA", "EDAD", "GENERO", "ESTADO CIVIL"};

    public List<Pacientes> pacientes;

    private ComunicacionVistaModelosTablas comunicacionPersona;
    private GestionConsultorio gestionConsultorios;
    public ModelTablePacientes(List<Pacientes> pacientes,GestionConsultorio gestionConsultorio) {
        this.pacientes = pacientes;
        this.gestionConsultorios = gestionConsultorio;
    }

    @Override
    public int getRowCount() {
        return pacientes.size();
    }

    @Override
    public int getColumnCount() {
       return m_colNames.length;
    }
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Pacientes p = pacientes.get(rowIndex);
        switch (columnIndex){
            case 0:
                return p.getHistoriaclinica();
            case 1:
                return p.getCedula();
            case 2:
                return p.getNombre();
            case 3:
                return p.getApellido();
            case 4:
                return p.getFecha_nacimiento();
            case 5:
                return p.getResidencia();
            case 6:
                return p.getEdad();
            case 7:
                if(p.getGenero() == 1){
                    return "Masculino";
                }else{
                    return "Femenino";
                }
            case 8:
                return p.getEstado_civil();
            case 9:
                return p.getFecha_registro();
        }
        return new String();
    }
     @Override
     public String getColumnName(int column){
    return m_colNames[column];
}

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        gestionConsultorios.clickPacientes(pacientes.get(rowIndex));
        return super.isCellEditable(rowIndex, columnIndex); 
    }
     

    public List<Pacientes> getPacientes() {
        return pacientes;
    }

    public void setPacientes(List<Pacientes> pacientes) {
        this.pacientes = pacientes;
    }

     
}

