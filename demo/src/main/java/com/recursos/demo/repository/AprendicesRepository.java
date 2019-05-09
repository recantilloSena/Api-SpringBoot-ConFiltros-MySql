/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.recursos.demo.repository;

import com.recursos.demo.modelo.Aprendices;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author Ricardo
 */
public interface AprendicesRepository  extends JpaRepository<Aprendices, Integer>{
    
    
    List<Aprendices> findByIdAprendices (Integer idAprendices);
        
    /**
     *
     * @param idAprendices 
     * @param jornada
     * @param idCurso
     * @param documento
     * @return filtro de Aprendices
     */
    @Query("SELECT a FROM Aprendices a WHERE (a.idAprendices = :idAprendices OR :idAprendices = 0) AND (a.jornada = :jornada OR :jornada = '0' )  AND ( a.fkCurso.idCurso = :idCurso  OR :idCurso = 0  ) AND ( a.documento = :documento  OR :documento = '0'  )   ")
    List<Aprendices> filtrarAprendiz (@Param("idAprendices") Integer idAprendices, @Param("jornada") String jornada, @Param("idCurso") Integer idCurso, @Param("documento") String documento);
    
    
}
