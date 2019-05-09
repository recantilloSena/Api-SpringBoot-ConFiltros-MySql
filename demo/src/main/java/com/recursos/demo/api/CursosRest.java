/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.recursos.demo.api;

import com.recursos.demo.modelo.Cursos;
import com.recursos.demo.repository.CursosRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Ricardo
 */
@RestController
public class CursosRest {
    
    
    @Autowired
    private CursosRepository cursosRepository;
    
    @RequestMapping (value="/rest/cursos/list", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE  )
    public List<Cursos> findAll(){
        return cursosRepository.findAll();
    }
    
    
    @RequestMapping (value="/rest/cursos/ordenados", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE  )
    public List<Cursos> findAllSort(){
        return cursosRepository.findByOrderByNombreCurso();
    }
    
}
