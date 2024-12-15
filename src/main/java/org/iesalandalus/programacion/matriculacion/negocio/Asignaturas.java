package org.iesalandalus.programacion.matriculacion.negocio;

import org.iesalandalus.programacion.matriculacion.dominio.Asignatura;

import javax.naming.OperationNotSupportedException;
import java.util.Arrays;

public class Asignaturas {

    private int capacidad;
    private int tamanio;
    private Asignatura[] coleccionAsignaturas;

    public Asignaturas(int capacidad) {
        if (capacidad <= 0) {
            throw new IllegalArgumentException("ERROR: La capacidad debe ser mayor que cero.");
        }
        this.capacidad = capacidad;
        this.tamanio = 0;
        this.coleccionAsignaturas = new Asignatura[capacidad];
    }

    public Asignatura[] get() {
        return copiaProfundaAsignaturas();
    }

    private Asignatura[] copiaProfundaAsignaturas() {
        Asignatura[] copia = new Asignatura[tamanio];
        for (int i = 0; i < tamanio; i++) {
            copia[i] = new Asignatura(coleccionAsignaturas[i]);
        }
        return copia;
    }

    public void insertar(Asignatura asignatura) throws OperationNotSupportedException {
        if (asignatura == null) {
            throw new NullPointerException("ERROR: No se puede insertar una asignatura nula.");
        }
        if (tamanio >= capacidad) {
            throw new OperationNotSupportedException("ERROR: No se aceptan más asignaturas.");
        }
        if (buscar(asignatura) != null) {
            throw new OperationNotSupportedException("ERROR: Ya existe una asignatura con ese código.");
        }
        coleccionAsignaturas[tamanio] = new Asignatura(asignatura);
        tamanio++;
    }

    public Asignatura buscar(Asignatura asignatura) {
        if (asignatura == null) {
            return null;
        }
        for (int i = 0; i < tamanio; i++) {
            if (coleccionAsignaturas[i].equals(asignatura)) {
                return new Asignatura(coleccionAsignaturas[i]);
            }
        }
        return null;
    }

    public void borrar(Asignatura asignatura) throws OperationNotSupportedException {
        if (asignatura == null) {
            throw new NullPointerException("ERROR: No se puede borrar una asignatura nula.");
        }
        int indice = buscarIndice(asignatura);
        if (indice == -1) {
            throw new OperationNotSupportedException("ERROR: No existe ninguna asignatura como la indicada.");
        }
        desplazarIzquierda(indice);
        tamanio--;
    }

    private int buscarIndice(Asignatura asignatura) {
        for (int i = 0; i < tamanio; i++) {
            if (coleccionAsignaturas[i].equals(asignatura)) {
                return i;
            }
        }
        return -1;
    }

    private void desplazarIzquierda(int indice) {
        for (int i = indice; i < tamanio - 1; i++) {
            coleccionAsignaturas[i] = coleccionAsignaturas[i + 1];
        }
        coleccionAsignaturas[tamanio - 1] = null;
    }

    public int getTamano() {
        return tamanio;
    }

    public int getCapacidad() {
        return capacidad;
    }

    @Override
    public String toString() {
        return "Asignaturas{" + "capacidad=" + capacidad + ", tamaño=" + tamanio + ", coleccionAsignaturas=" + Arrays.toString(copiaProfundaAsignaturas()) + '}';
    }
}
