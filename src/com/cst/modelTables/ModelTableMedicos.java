/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cst.modelTables;

import com.cst.modelo.Medicos;
import com.cst.vista.GestionConsultorio;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Ordenador
 */
public class ModelTableMedicos extends AbstractTableModel {
        //Arreglo con el nombre de las columnas
     public String[] m_colNames = {"CEDULA", "NOMBRE", "APELLIDO", "CODIGO", "DIRECCION", "AÑOS DE CONTRATO", "ESPECIALIDAD"};

    public List<Medicos> medicos;

    private ComunicacionVistaModelosTablas comunicacionPersona;
    private GestionConsultorio gestionConsultorios;
    public ModelTableMedicos(List<Medicos> medico,GestionConsultorio gestionConsultorio) {
        this.medicos = medico;
        this.gestionConsultorios = gestionConsultorio;
    }

    @Override
    public int getRowCount() {
        return medicos.size();
    }

    @Override
    public int getColumnCount() {
       return m_colNames.length;
    }
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Medicos m = medicos.get(rowIndex);
        switch (columnIndex){
            case 0:
                return m.getCedula();
            case 1:
                return m.getNombre();
            case 2:
                return m.getApellido();
            case 3:
                return m.getCodigo();
            case 4:
                return m.getDireccion();
            case 5:
                return m.getAnios_contrato();
            case 6:
                return m.getEspecialidad();
        }
        return new String();
    }
     @Override
     public String getColumnName(int column){
    return m_colNames[column];
}

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        gestionConsultorios.clickMedicos(medicos.get(rowIndex));
        return super.isCellEditable(rowIndex, columnIndex); 
    }

    public List<Medicos> getMedicos() {
        return medicos;
    }

    public void setMedicos(List<Medicos> medicos) {
        this.medicos = medicos;
    }
         
}

