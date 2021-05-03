/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cst.modelTables;

import com.cst.modelo.HistorialMedico;
import com.cst.vista.GestionConsultorio;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Ordenador
 */
public class ModelTableHistorialMedico extends AbstractTableModel {
        //Arreglo con el nombre de las columnas
     public String[] m_colNames = {"CODIGO", "HISTORIA CLINICA P", "CODIGO DEL MEDICO", "PADECIMIENTO", "MEDICAMENTOS", "INDICACIONES"};

    public List<HistorialMedico> historial;

    private ComunicacionVistaModelosTablas comunicacionPersona;
    private GestionConsultorio gestionConsultorios;
    public ModelTableHistorialMedico(List<HistorialMedico> historialMedico,GestionConsultorio gestionConsultorio) {
        this.historial = historialMedico;
        this.gestionConsultorios = gestionConsultorio;
    }

    @Override
    public int getRowCount() {
        return historial.size();
    }

    @Override
    public int getColumnCount() {
       return m_colNames.length;
    }
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        HistorialMedico hm = historial.get(rowIndex);
        switch (columnIndex){
            case 0:
                return hm.getCodigo_historial_medico();
            case 1:
                return hm.getHistoria_clinica_paciente();
            case 2:
                return hm.getCodigo_medico();
            case 3:
                return hm.getPadecimiento();
            case 4:
                return hm.getMedicaciones();
            case 5:
                return hm.getInstrucciones();
        }
        return new String();
    }
     @Override
     public String getColumnName(int column){
    return m_colNames[column];
}

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        gestionConsultorios.clickHistorialMedico(historial.get(rowIndex));
        return super.isCellEditable(rowIndex, columnIndex); 
    }

    public List<HistorialMedico> getHistorial() {
        return historial;
    }

    public void setHistorial(List<HistorialMedico> historial) {
        this.historial = historial;
    }
     
}

