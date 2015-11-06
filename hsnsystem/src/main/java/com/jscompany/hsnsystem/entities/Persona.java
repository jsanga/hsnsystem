/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jscompany.hsnsystem.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Joao Sanga
 */
@Entity
@Table(name = "persona", catalog = "redColegioDB", schema = "USUARIOS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Persona.findAll", query = "SELECT p FROM Persona p")})
public class Persona implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Long id;
    @Size(max = 10)
    @Column(name = "cedula", length = 10)
    private String cedula;
    @Size(max = 100)
    @Column(name = "nombres", length = 100)
    private String nombres;
    @Size(max = 100)
    @Column(name = "apellidos", length = 100)
    private String apellidos;
    @Size(max = 150)
    @Column(name = "direccion", length = 150)
    private String direccion;
    @Column(name = "fecha_entrada")
    @Temporal(TemporalType.DATE)
    private Date fechaEntrada;
    @Column(name = "fecha_salida")
    @Temporal(TemporalType.DATE)
    private Date fechaSalida;
    @OneToMany(mappedBy = "idPersona", fetch = FetchType.LAZY)
    private Collection<Profesor> profesorCollection;
    @OneToMany(mappedBy = "idPersona", fetch = FetchType.LAZY)
    private Collection<Estudiante> estudianteCollection;
    @OneToMany(mappedBy = "idPersona", fetch = FetchType.LAZY)
    private Collection<PersonaEmail> personaEmailCollection;
    @OneToMany(mappedBy = "idPersona", fetch = FetchType.LAZY)
    private Collection<PersonaTelefono> personaTelefonoCollection;
    @OneToMany(mappedBy = "idPersona", fetch = FetchType.LAZY)
    private Collection<Rol> rolCollection;
    @JoinColumn(name = "id_loguin", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Loguin idLoguin;

    public Persona() {
    }

    public Persona(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Date getFechaEntrada() {
        return fechaEntrada;
    }

    public void setFechaEntrada(Date fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    public Date getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    @XmlTransient
    public Collection<Profesor> getProfesorCollection() {
        return profesorCollection;
    }

    public void setProfesorCollection(Collection<Profesor> profesorCollection) {
        this.profesorCollection = profesorCollection;
    }

    @XmlTransient
    public Collection<Estudiante> getEstudianteCollection() {
        return estudianteCollection;
    }

    public void setEstudianteCollection(Collection<Estudiante> estudianteCollection) {
        this.estudianteCollection = estudianteCollection;
    }

    @XmlTransient
    public Collection<PersonaEmail> getPersonaEmailCollection() {
        return personaEmailCollection;
    }

    public void setPersonaEmailCollection(Collection<PersonaEmail> personaEmailCollection) {
        this.personaEmailCollection = personaEmailCollection;
    }

    @XmlTransient
    public Collection<PersonaTelefono> getPersonaTelefonoCollection() {
        return personaTelefonoCollection;
    }

    public void setPersonaTelefonoCollection(Collection<PersonaTelefono> personaTelefonoCollection) {
        this.personaTelefonoCollection = personaTelefonoCollection;
    }

    @XmlTransient
    public Collection<Rol> getRolCollection() {
        return rolCollection;
    }

    public void setRolCollection(Collection<Rol> rolCollection) {
        this.rolCollection = rolCollection;
    }

    public Loguin getIdLoguin() {
        return idLoguin;
    }

    public void setIdLoguin(Loguin idLoguin) {
        this.idLoguin = idLoguin;
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
        if (!(object instanceof Persona)) {
            return false;
        }
        Persona other = (Persona) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.jscompany.hsnsystem.entities.Persona[ id=" + id + " ]";
    }
    
}
