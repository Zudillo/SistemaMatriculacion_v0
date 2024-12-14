package org.iesalandalus.programacion.matriculacion.dominio;

import java.time.LocalDate;

public class Alumno {

    private String ER_TELEFONO;
    private String ER_CORREO;
    private String ER_DNI;
    public String FORMATO_FECHA = "dd/MM/YYYY";
    private String ER_NIA;
    private int MIN_EDAD_ALUMNADO;
    private String nombre;
    private String telefono;
    private String correo;
    private String dni;
    private LocalDate fechaNacimiento;
    private String nia;

    private formateaNombre (String nombre) {

    }

    public String getER_TELEFONO() {
        return ER_TELEFONO;
    }

    public void setER_TELEFONO(String ER_TELEFONO) {
        this.ER_TELEFONO = ER_TELEFONO;
    }

    public String getER_CORREO() {
        return ER_CORREO;
    }

    public void setER_CORREO(String ER_CORREO) {
        this.ER_CORREO = ER_CORREO;
    }

    public String getER_DNI() {
        return ER_DNI;
    }

    public void setER_DNI(String ER_DNI) {
        this.ER_DNI = ER_DNI;
    }

    public String getFORMATO_FECHA() {
        return FORMATO_FECHA;
    }

    public void setFORMATO_FECHA(String FORMATO_FECHA) {
        this.FORMATO_FECHA = FORMATO_FECHA;
    }

    public String getER_NIA() {
        return ER_NIA;
    }

    public void setER_NIA(String ER_NIA) {
        this.ER_NIA = ER_NIA;
    }

    public int getMIN_EDAD_ALUMNADO() {
        return MIN_EDAD_ALUMNADO;
    }

    public void setMIN_EDAD_ALUMNADO(int MIN_EDAD_ALUMNADO) {
        this.MIN_EDAD_ALUMNADO = MIN_EDAD_ALUMNADO;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getNia() {
        return nia;
    }

    public void setNia(String nia) {
        this.nia = nia;
    }
}