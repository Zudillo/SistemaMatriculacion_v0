package org.iesalandalus.programacion.matriculacion.negocio;

import org.iesalandalus.programacion.matriculacion.dominio.Alumno;
import org.iesalandalus.programacion.matriculacion.dominio.CicloFormativo;
import org.iesalandalus.programacion.matriculacion.dominio.Matricula;

import javax.naming.OperationNotSupportedException;
import java.util.Arrays;

public class Matriculas {

    private int capacidad;
    private int tamanio;
    private Matricula[] coleccionMatriculas;

    public Matriculas(int capacidad) {
        if (capacidad <= 0) {
            throw new IllegalArgumentException("ERROR: La capacidad debe ser mayor que cero.");
        }
        this.capacidad = capacidad;
        this.tamanio = 0;
        this.coleccionMatriculas = new Matricula[capacidad];
    }

    public Matricula[] get() {
        return copiaProfundaMatriculas();
    }

    private Matricula[] copiaProfundaMatriculas() {
        Matricula[] copia = new Matricula[tamanio];
        for (int i = 0; i < tamanio; i++) {
            copia[i] = new Matricula(coleccionMatriculas[i]);
        }
        return copia;
    }

    public void insertar(Matricula matricula) throws OperationNotSupportedException {
        if (matricula == null) {
            throw new NullPointerException("ERROR: No se puede insertar una matrícula nula.");
        }
        if (tamanio >= capacidad) {
            throw new OperationNotSupportedException("ERROR: No se aceptan más matrículas.");
        }
        if (buscar(matricula) != null) {
            throw new OperationNotSupportedException("ERROR: Ya existe una matrícula con ese identificador.");
        }
        coleccionMatriculas[tamanio] = new Matricula(matricula);
        tamanio++;
    }

    public Matricula buscar(Matricula matricula) {
        if (matricula == null) {
            return null;
        }
        for (int i = 0; i < tamanio; i++) {
            if (coleccionMatriculas[i].equals(matricula)) {
                return new Matricula(coleccionMatriculas[i]);
            }
        }
        return null;
    }

    public void borrar(Matricula matricula) throws OperationNotSupportedException {
        if (matricula == null) {
            throw new NullPointerException("ERROR: No se puede borrar una matrícula nula.");
        }
        int indice = buscarIndice(matricula);
        if (indice == -1) {
            throw new OperationNotSupportedException("ERROR: No existe ninguna matrícula como la indicada.");
        }
        desplazarIzquierda(indice);
        tamanio--;
    }

    private int buscarIndice(Matricula matricula) {
        for (int i = 0; i < tamanio; i++) {
            if (coleccionMatriculas[i].equals(matricula)) {
                return i;
            }
        }
        return -1;
    }

    private void desplazarIzquierda(int indice) {
        for (int i = indice; i < tamanio - 1; i++) {
            coleccionMatriculas[i] = coleccionMatriculas[i + 1];
        }
        coleccionMatriculas[tamanio - 1] = null;
    }

    public Matricula[] get(Alumno alumno) {
        return Arrays.stream(coleccionMatriculas)
                .filter(m -> m != null && m.getAlumno().equals(alumno))
                .toArray(Matricula[]::new);
    }

    public Matricula[] get(String cursoAcademico) {
        return Arrays.stream(coleccionMatriculas)
                .filter(m -> m != null && m.getCursoAcademico().equals(cursoAcademico))
                .toArray(Matricula[]::new);
    }

    public Matricula[] get(CicloFormativo cicloFormativo) {
        return Arrays.stream(coleccionMatriculas)
                .filter(m -> m != null && Arrays.stream(m.getColeccionAsignaturas())
                        .anyMatch(a -> a.getCicloFormativo().equals(cicloFormativo)))
                .toArray(Matricula[]::new);
    }

    public int getTamano() {
        return tamanio;
    }

    public int getCapacidad() {
        return capacidad;
    }

    @Override
    public String toString() {
        return "Matriculas{" + "capacidad=" + capacidad + ", tamaño=" + tamanio + ", coleccionMatriculas=" + Arrays.toString(copiaProfundaMatriculas()) + '}';
    }
}
