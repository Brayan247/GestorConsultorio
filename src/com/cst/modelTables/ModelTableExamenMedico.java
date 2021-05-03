/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cst.modelTables;

import com.cst.modelo.ExamenesMedicos;
import com.cst.vista.GestionConsultorio;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Ordenador
 */
public class ModelTableExamenMedico extends AbstractTableModel {
        //Arreglo con el nombre de las columnas
     public String[] m_colNames = {"IPO", "INSTRUCCIONES", "HISTORIA CLINICA P", "CEDULA P", "NOMBRE P", "APELLIDO P", "FECHA NACIMIENTO P", "GENERO P", "CODIGO MEDICO", "FECHA DESIGNADA", "FECHA EXPIRACION"};

    public List<ExamenesMedicos> examenes;

    private ComunicacionVistaModelosTablas comunicacionPersona;
    private GestionConsultorio gestionConsultorios;
    public ModelTableExamenMedico(List<ExamenesMedicos> examenMedico,GestionConsultorio gestionConsultorio) {
        this.examenes = examenMedico;
        this.gestionConsultorios = gestionConsultorio;
    }

    @Override
    public int getRowCount() {
        return examenes.size();
    }

    @Override
    public int getColumnCount() {
       return m_colNames.length;
    }
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        ExamenesMedicos em = examenes.get(rowIndex);
        switch (columnIndex){
            case 0:
                return em.getTipo();
            case 1:
                return em.getInstrucciones();
            case 2:
                return em.getHistoria_clinica_paciente();
            case 3:
                return em.getCedula();
            case 4:
                return em.getNombre();
            case 5:
                return em.getApellido();
            case 6:
                return em.getFecha_nacimiento();
            case 7:
                if(em.getGenero() == 1){
                    return "Masculino";
                }else{
                    return "Femenino";
                }
            case 8:
                return em.getCodigo_medico();
            case 9:
                return em.getFecha_designacion();
            case 10:
                return em.getFecha_expiracion();
        }
        return new String();
    }
     @Override
     public String getColumnName(int column){
    return m_colNames[column];
}

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        gestionConsultorios.clickExamenesMedicos(examenes.get(rowIndex));
        return super.isCellEditable(rowIndex, columnIndex); 
    }

    public List<ExamenesMedicos> getExamenes() {
        return examenes;
    }

    public void setExamenes(List<ExamenesMedicos> examenes) {
        this.examenes = examenes;
    }
     


     
}

