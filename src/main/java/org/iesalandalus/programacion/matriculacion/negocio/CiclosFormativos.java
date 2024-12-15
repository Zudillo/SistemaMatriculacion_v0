package org.iesalandalus.programacion.matriculacion.negocio;

import org.iesalandalus.programacion.matriculacion.dominio.CicloFormativo;

import javax.naming.OperationNotSupportedException;
import java.util.Arrays;

public class CiclosFormativos {

    private int capacidad;
    private int tamanio;
    private CicloFormativo[] coleccionCiclosFormativos;

    public CiclosFormativos(int capacidad) {
        if (capacidad <= 0) {
            throw new IllegalArgumentException("ERROR: La capacidad debe ser mayor que cero.");
        }
        this.capacidad = capacidad;
        this.tamanio = 0;
        this.coleccionCiclosFormativos = new CicloFormativo[capacidad];
    }

    public CicloFormativo[] get() {
        return copiaProfundaCiclosFormativos();
    }

    private CicloFormativo[] copiaProfundaCiclosFormativos() {
        CicloFormativo[] copia = new CicloFormativo[tamanio];
        for (int i = 0; i < tamanio; i++) {
            copia[i] = new CicloFormativo(coleccionCiclosFormativos[i]);
        }
        return copia;
    }

    public void insertar(CicloFormativo cicloFormativo) throws OperationNotSupportedException {
        if (cicloFormativo == null) {
            throw new NullPointerException("ERROR: No se puede insertar un ciclo formativo nulo.");
        }
        if (tamanio >= capacidad) {
            throw new OperationNotSupportedException("ERROR: No se aceptan más ciclos formativos.");
        }
        if (buscar(cicloFormativo) != null) {
            throw new OperationNotSupportedException("ERROR: Ya existe un ciclo formativo con ese código.");
        }
        coleccionCiclosFormativos[tamanio] = new CicloFormativo(cicloFormativo);
        tamanio++;
    }

    public CicloFormativo buscar(CicloFormativo cicloFormativo) {
        if (cicloFormativo == null) {
            return null;
        }
        for (int i = 0; i < tamanio; i++) {
            if (coleccionCiclosFormativos[i].equals(cicloFormativo)) {
                return new CicloFormativo(coleccionCiclosFormativos[i]);
            }
        }
        return null;
    }

    public void borrar(CicloFormativo cicloFormativo) throws OperationNotSupportedException {
        if (cicloFormativo == null) {
            throw new NullPointerException("ERROR: No se puede borrar un ciclo formativo nulo.");
        }
        int indice = buscarIndice(cicloFormativo);
        if (indice == -1) {
            throw new OperationNotSupportedException("ERROR: No existe ningún ciclo formativo como el indicado.");
        }
        desplazarIzquierda(indice);
        tamanio--;
    }

    private int buscarIndice(CicloFormativo cicloFormativo) {
        for (int i = 0; i < tamanio; i++) {
            if (coleccionCiclosFormativos[i].equals(cicloFormativo)) {
                return i;
            }
        }
        return -1;
    }

    private void desplazarIzquierda(int indice) {
        for (int i = indice; i < tamanio - 1; i++) {
            coleccionCiclosFormativos[i] = coleccionCiclosFormativos[i + 1];
        }
        coleccionCiclosFormativos[tamanio - 1] = null;
    }

    public int getTamano() {
        return tamanio;
    }

    public int getCapacidad() {
        return capacidad;
    }

    @Override
    public String toString() {
        return "CiclosFormativos{" + "capacidad=" + capacidad + ", tamaño=" + tamanio + ", coleccionCiclosFormativos=" + Arrays.toString(copiaProfundaCiclosFormativos()) + '}';
    }
}
