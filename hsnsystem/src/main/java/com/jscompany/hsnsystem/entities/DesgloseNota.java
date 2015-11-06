/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jscompany.hsnsystem.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Joao Sanga
 */
@Entity
@Table(name = "desglose_nota", catalog = "redColegioDB", schema = "COLEGIOS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DesgloseNota.findAll", query = "SELECT d FROM DesgloseNota d")})
public class DesgloseNota implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Long id;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "nota", precision = 8, scale = 8)
    private Float nota;
    @Column(name = "tipo_nota")
    private Integer tipoNota;
    @JoinColumn(name = "id_detalle_materia", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private DetalleMateria idDetalleMateria;

    public DesgloseNota() {
    }

    public DesgloseNota(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Float getNota() {
        return nota;
    }

    public void setNota(Float nota) {
        this.nota = nota;
    }

    public Integer getTipoNota() {
        return tipoNota;
    }

    public void setTipoNota(Integer tipoNota) {
        this.tipoNota = tipoNota;
    }

    public DetalleMateria getIdDetalleMateria() {
        return idDetalleMateria;
    }

    public void setIdDetalleMateria(DetalleMateria idDetalleMateria) {
        this.idDetalleMateria = idDetalleMateria;
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
        if (!(object instanceof DesgloseNota)) {
            return false;
        }
        DesgloseNota other = (DesgloseNota) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.jscompany.hsnsystem.entities.DesgloseNota[ id=" + id + " ]";
    }
    
}
