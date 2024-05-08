package com.example.babycarev1;

import java.util.Date;

public class Usuario {

    protected String nombre;
    protected String apellidos;
    protected String dni;
    protected Date fechaDeNacimiento;
    protected String telefono;
    protected String sexo;
    protected String nombreUsuario;
    protected String contrasena;
    protected String correoElectronico;
    protected String nacionalidad;
    protected String direccion;

    public Usuario(String nombre, String apellidos, String dni, String telefono, String sexo, String nombreUsuario, String contrasena, String correoElectronico, String nacionalidad, String direccion) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dni = dni;
        this.telefono = telefono;
        this.sexo = sexo;
        this.nombreUsuario = nombreUsuario;
        this.contrasena = contrasena;
        this.correoElectronico = correoElectronico;
        this.nacionalidad = nacionalidad;
        this.direccion = direccion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}
