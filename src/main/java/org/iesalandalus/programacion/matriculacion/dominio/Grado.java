package org.iesalandalus.programacion.matriculacion.dominio;

public enum Grado {

    GDCFGB("Grado D Ciclo Formativo de Grado Básico"),
    GDCFGM("Grado D Ciclo Formativo de Grado Medio"),
    GDCFGS("Grado D Ciclo Formativo de Grado Superior"),
    ;

    private final String cadenaAMostrar;

    Grado(String cadenaAMostrar) {
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