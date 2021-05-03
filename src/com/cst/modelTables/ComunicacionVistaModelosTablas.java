/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cst.modelTables;

import com.cst.modelo.Pacientes;
import com.cst.modelo.Medicos;
import com.cst.modelo.HistorialMedico;
import com.cst.modelo.ExamenesMedicos;

public interface ComunicacionVistaModelosTablas {
    void clickPacientes(Pacientes p);
    void clickMedicos(Medicos p);
    void clickHistorialMedico(HistorialMedico p);
    void clickExamenesMedicos(ExamenesMedicos p);
}
