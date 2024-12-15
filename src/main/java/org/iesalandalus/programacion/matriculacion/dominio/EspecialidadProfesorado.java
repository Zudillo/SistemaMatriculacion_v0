package org.iesalandalus.programacion.matriculacion.dominio;

public enum EspecialidadProfesorado {

    INFORMATICA("Informática"),
    SISTEMAS("Sistemas y Aplicaciones Informáticas"),
    FOL("Formación y Orientación Laboral");

    private final String cadenaAMostrar;

    EspecialidadProfesorado(String cadenaAMostrar) {
        this.cadenaAMostrar = cadenaAMostrar;
    }

    public String imprimir() {
        return this.ordinal() + ".-" + this.cadenaAMostrar;
    }

    @Override
    public String toString() {
        return cadenaAMostrar;
    }
}
