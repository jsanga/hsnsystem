/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jscompany.hsnsystem.entities;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Joao Sanga
 */
@Entity
@Table(name = "matricula", catalog = "redColegioDB", schema = "COLEGIOS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Matricula.findAll", query = "SELECT m FROM Matricula m")})
public class Matricula implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "id_colegio")
    private BigInteger idColegio;
    @Column(name = "id_curso")
    private BigInteger idCurso;
    @Column(name = "id_periodo_lectivo")
    private BigInteger idPeriodoLectivo;
    @Column(name = "id_estudiante")
    private BigInteger idEstudiante;

    public Matricula() {
    }

    public Matricula(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigInteger getIdColegio() {
        return idColegio;
    }

    public void setIdColegio(BigInteger idColegio) {
        this.idColegio = idColegio;
    }

    public BigInteger getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(BigInteger idCurso) {
        this.idCurso = idCurso;
    }

    public BigInteger getIdPeriodoLectivo() {
        return idPeriodoLectivo;
    }

    public void setIdPeriodoLectivo(BigInteger idPeriodoLectivo) {
        this.idPeriodoLectivo = idPeriodoLectivo;
    }

    public BigInteger getIdEstudiante() {
        return idEstudiante;
    }

    public void setIdEstudiante(BigInteger idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Matricula)) {
            return false;
        }
        Matricula other = (Matricula) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.jscompany.hsnsystem.entities.Matricula[ id=" + id + " ]";
    }
    
}
