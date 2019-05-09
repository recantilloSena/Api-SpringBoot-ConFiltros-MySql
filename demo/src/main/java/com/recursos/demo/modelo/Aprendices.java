/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.recursos.demo.modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Ricardo
 */
@Entity
@Table(name = "aprendices")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Aprendices.findAll", query = "SELECT a FROM Aprendices a")
    , @NamedQuery(name = "Aprendices.findByIdAprendices", query = "SELECT a FROM Aprendices a WHERE a.idAprendices = :idAprendices")
    , @NamedQuery(name = "Aprendices.findByApellido1", query = "SELECT a FROM Aprendices a WHERE a.apellido1 = :apellido1")
    , @NamedQuery(name = "Aprendices.findByApellido2", query = "SELECT a FROM Aprendices a WHERE a.apellido2 = :apellido2")
    , @NamedQuery(name = "Aprendices.findByNombres", query = "SELECT a FROM Aprendices a WHERE a.nombres = :nombres")
    , @NamedQuery(name = "Aprendices.findByDocumento", query = "SELECT a FROM Aprendices a WHERE a.documento = :documento")
    , @NamedQuery(name = "Aprendices.findByJornada", query = "SELECT a FROM Aprendices a WHERE a.fkCurso.idCurso = :idCurso")})
public class Aprendices implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_aprendices")
    private Integer idAprendices;
    @Size(max = 45)
    @Column(name = "apellido1")
    private String apellido1;
    @Size(max = 45)
    @Column(name = "apellido2")
    private String apellido2;
    @Size(max = 45)
    @Column(name = "nombres")
    private String nombres;
    @Size(max = 45)
    @Column(name = "documento")
    private String documento;
    @Size(max = 5)
    @Column(name = "jornada")
    private String jornada;
    @JoinColumn(name = "fk_curso", referencedColumnName = "id_curso")
    @ManyToOne
    private Cursos fkCurso;

    public Aprendices() {
    }

    public Aprendices(Integer idAprendices) {
        this.idAprendices = idAprendices;
    }

    public Integer getIdAprendices() {
        return idAprendices;
    }

    public void setIdAprendices(Integer idAprendices) {
        this.idAprendices = idAprendices;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getJornada() {
        return jornada;
    }

    public void setJornada(String jornada) {
        this.jornada = jornada;
    }

    public Cursos getFkCurso() {
        return fkCurso;
    }

    public void setFkCurso(Cursos fkCurso) {
        this.fkCurso = fkCurso;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAprendices != null ? idAprendices.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Aprendices)) {
            return false;
        }
        Aprendices other = (Aprendices) object;
        if ((this.idAprendices == null && other.idAprendices != null) || (this.idAprendices != null && !this.idAprendices.equals(other.idAprendices))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.recursos.demo.modelo.Aprendices[ idAprendices=" + idAprendices + " ]";
    }
    
}
