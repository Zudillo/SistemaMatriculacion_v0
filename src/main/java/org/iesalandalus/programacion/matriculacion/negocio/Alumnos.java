package org.iesalandalus.programacion.matriculacion.negocio;

import org.iesalandalus.programacion.matriculacion.dominio.Alumno;

import javax.naming.OperationNotSupportedException;
import java.util.Arrays;

public class Alumnos {

    private int capacidad;
    private int tamanio;
    private Alumno[] coleccionAlumnos;

    public Alumnos(int capacidad) {
        if (capacidad <= 0) {
            throw new IllegalArgumentException("ERROR: La capacidad debe ser mayor que cero.");
        }
        this.capacidad = capacidad;
        this.tamanio = 0;
        this.coleccionAlumnos = new Alumno[capacidad];
    }

    public Alumno[] get() {
        return copiaProfundaAlumnos();
    }

    private Alumno[] copiaProfundaAlumnos() {
        Alumno[] copia = new Alumno[tamanio];
        for (int i = 0; i < tamanio; i++) {
            copia[i] = new Alumno(coleccionAlumnos[i]);
        }
        return copia;
    }

    public void insertar(Alumno alumno) throws OperationNotSupportedException {
        if (alumno == null) {
            throw new NullPointerException("ERROR: No se puede insertar un alumno nulo.");
        }
        if (tamanio >= capacidad) {
            throw new OperationNotSupportedException("ERROR: No se aceptan más alumnos.");
        }
        if (buscar(alumno) != null) {
            throw new OperationNotSupportedException("ERROR: Ya existe un alumno con ese dni.");
        }
        coleccionAlumnos[tamanio] = new Alumno(alumno);
        tamanio++;
    }

    public Alumno buscar(Alumno alumno) {
        if (alumno == null) {
            return null;
        }
        for (int i = 0; i < tamanio; i++) {
            if (coleccionAlumnos[i].equals(alumno)) {
                return new Alumno(coleccionAlumnos[i]);
            }
        }
        return null;
    }

    public void borrar(Alumno alumno) throws OperationNotSupportedException {
        if (alumno == null) {
            throw new NullPointerException("ERROR: No se puede borrar un alumno nulo.");
        }
        int indice = buscarIndice(alumno);
        if (indice == -1) {
            throw new OperationNotSupportedException("ERROR: No existe ningún alumno como el indicado.");
        }
        desplazarIzquierda(indice);
        tamanio--;
    }

    private int buscarIndice(Alumno alumno) {
        for (int i = 0; i < tamanio; i++) {
            if (coleccionAlumnos[i].equals(alumno)) {
                return i;
            }
        }
        return -1;
    }

    private void desplazarIzquierda(int indice) {
        for (int i = indice; i < tamanio - 1; i++) {
            coleccionAlumnos[i] = coleccionAlumnos[i + 1];
        }
        coleccionAlumnos[tamanio - 1] = null;
    }

    public int getTamano() {
        return tamanio;
    }

    public int getCapacidad() {
        return capacidad;
    }

    @Override
    public String toString() {
        return "Alumnos{" + "capacidad=" + capacidad + ", tamaño=" + tamanio + ", coleccionAlumnos=" + Arrays.toString(copiaProfundaAlumnos()) + '}';
    }
}