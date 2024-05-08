package com.example.babycarev1;

public class Cuidador {

    private String nombre, apellidos, telefono, fechaNacimiento, sexo, experiencia, disponibilidad, puntuacion, resenias;



    private int idCuidador;
    public Cuidador(int idCuidador, String nombre, String apellidos, String telefono, String fechaNacimiento, String sexo, String experiencia, String disponibilidad, String puntuacion, String resenias) {
        this.idCuidador = idCuidador;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.fechaNacimiento = fechaNacimiento;
        this.sexo = sexo;
        this.experiencia = experiencia;
        this.disponibilidad = disponibilidad;
        this.puntuacion = puntuacion;
        this.resenias = resenias;
    }

    public int getIdCuidador() { return idCuidador; }

    public void setIdCuidador(int idCuidador) { this.idCuidador = idCuidador; }

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

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(String experiencia) {
        this.experiencia = experiencia;
    }

    public String getDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(String disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    public String getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(String puntuacion) {
        this.puntuacion = puntuacion;
    }

    public String getResenias() {
        return resenias;
    }

    public void setResenias(String resenias) {
        this.resenias = resenias;
    }
}
