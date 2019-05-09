/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.recursos.demo.api;

import com.recursos.demo.modelo.Aprendices;
import com.recursos.demo.repository.AprendicesRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Ricardo
 */
@RestController
public class AprendicesRest {
    
    @Autowired
    private AprendicesRepository aprendicesRepository;
    
    @RequestMapping (value="/rest/aprendices/list", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE  )
    public List<Aprendices> findAll(){
        return aprendicesRepository.findAll();
    }
    
    
    @RequestMapping (value="/rest/aprendices/new", method=RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE  )
    public Aprendices nuevoAprendiz(@RequestBody Aprendices aprendices ){
        return aprendicesRepository.save(aprendices);
    }
    
    
     @RequestMapping (value="/rest/aprendices/filtrar/{id}/{jornada}/{idCurso}/{documento}", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE  )
    public List<Aprendices> filter(@PathVariable("id") Integer id,@PathVariable("jornada") String jornada,@PathVariable("idCurso") Integer idCurso, @PathVariable("documento") String documento  ){
        
    
        
        return aprendicesRepository.filtrarAprendiz(id, jornada,idCurso,documento);
    
    
    
    }
    
    
}
