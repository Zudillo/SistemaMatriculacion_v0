package org.iesalandalus.programacion.matriculacion;

import org.iesalandalus.programacion.matriculacion.dominio.*;
import org.iesalandalus.programacion.matriculacion.negocio.Alumnos;
import org.iesalandalus.programacion.matriculacion.negocio.Asignaturas;
import org.iesalandalus.programacion.matriculacion.negocio.CiclosFormativos;
import org.iesalandalus.programacion.matriculacion.negocio.Matriculas;
import org.iesalandalus.programacion.matriculacion.vista.Consola;
import org.iesalandalus.programacion.matriculacion.vista.Opcion;

public class MainApp {
    public static final int CAPACIDAD = 3; // Capacidad máxima de las colecciones
    private static final Alumnos alumnos = new Alumnos(CAPACIDAD);
    private static final Asignaturas asignaturas = new Asignaturas(CAPACIDAD);
    private static final CiclosFormativos ciclosFormativos = new CiclosFormativos(CAPACIDAD);
    private static final Matriculas matriculas = new Matriculas(CAPACIDAD);

    private static void ejecutarOpcion(Opcion opcion) {
        switch (opcion) {
            case INSERTAR_ALUMNO -> insertarAlumno();
            case BUSCAR_ALUMNO -> buscarAlumno();
            case BORRAR_ALUMNO -> borrarAlumno();
            case MOSTRAR_ALUMNOS -> mostrarAlumnos();
            case INSERTAR_ASIGNATURA -> insertarAsignatura();
            case BUSCAR_ASIGNATURA -> buscarAsignatura();
            case BORRAR_ASIGNATURA -> borrarAsignatura();
            case MOSTRAR_ASIGNATURAS -> mostrarAsignaturas();
            case INSERTAR_CICLO_FORMATIVO -> insertarCicloFormativo();
            case BUSCAR_CICLO_FORMATIVO -> buscarCicloFormativo();
            case BORRAR_CICLO_FORMATIVO -> borrarCicloFormativo();
            case MOSTRAR_CICLOS_FORMATIVOS -> mostrarCiclosFormativos();
            case INSERTAR_MATRICULA -> insertarMatricula();
            case BUSCAR_MATRICULA -> buscarMatricula();
            case ANULAR_MATRICULA -> anularMatricula();
            case MOSTRAR_MATRICULAS -> mostrarMatriculas();
            case MOSTRAR_MATRICULAS_ALUMNO -> mostrarMatriculasPorAlumno();
            case MOSTRAR_MATRICULAS_CICLO_FORMATIVO -> mostrarMatriculasPorCicloFormativo();
            case MOSTRAR_MATRICULAS_CURSO_ACADEMICO -> mostrarMatriculasPorCursoAcademico();
            case SALIR -> System.out.println("Adiós.");
            default -> System.out.println("Opción no válida.");
        }
    }

    private static void insertarAlumno() {
        try {
            Alumno alumno = Consola.leerAlumno();
            alumnos.insertar(alumno);
            System.out.println("Datos introducidos correctamente.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void buscarAlumno() {
        try {
            Alumno alumno = Consola.getAlumnoPorDni();
            Alumno encontrado = alumnos.buscar(alumno);
            System.out.println((encontrado != null) ? encontrado : "No se encontró el alumno.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void borrarAlumno() {
        try {
            Alumno alumno = Consola.getAlumnoPorDni();
            alumnos.borrar(alumno);
            System.out.println("Alumno borrado correctamente.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void mostrarAlumnos() {
        Alumno[] coleccion = alumnos.get();
        if (coleccion.length == 0) {
            System.out.println("No hay alumnos registrados.");
        } else {
            for (Alumno alumno : coleccion) {
                if (alumno != null) System.out.println(alumno);
            }
        }
    }

    private static void insertarAsignatura() {
        try {
            CicloFormativo ciclo = Consola.getCicloFormativoPorCodigo();
            Asignatura asignatura = Consola.leerAsignatura(ciclo);
            asignaturas.insertar(asignatura);
            System.out.println("Asignatura introducida correctamente.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void buscarAsignatura() {
        try {
            Asignatura asignatura = Consola.getAsignaturaPorCodigo();
            Asignatura encontrada = asignaturas.buscar(asignatura);
            System.out.println((encontrada != null) ? encontrada : "Asignatura no encotrada.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void borrarAsignatura() {
        try {
            Asignatura asignatura = Consola.getAsignaturaPorCodigo();
            asignaturas.borrar(asignatura);
            System.out.println("Asignatura borrada.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void mostrarAsignaturas() {
        Asignatura[] coleccion = asignaturas.get();
        if (coleccion.length == 0) {
            System.out.println("No hay asignaturas registradas.");
        } else {
            for (Asignatura asignatura : coleccion) {
                if (asignatura != null) System.out.println(asignatura);
            }
        }
    }

    private static void insertarCicloFormativo() {
        try {
            CicloFormativo ciclo = Consola.leerCicloFormativo();
            ciclosFormativos.insertar(ciclo);
            System.out.println("Ciclo formativo introducido correctamente.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void buscarCicloFormativo() {
        try {
            CicloFormativo ciclo = Consola.getCicloFormativoPorCodigo();
            CicloFormativo encontrado = ciclosFormativos.buscar(ciclo);
            System.out.println((encontrado != null) ? encontrado : "No se encontró el ciclo formativo.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void borrarCicloFormativo() {
        try {
            CicloFormativo ciclo = Consola.getCicloFormativoPorCodigo();
            ciclosFormativos.borrar(ciclo);
            System.out.println("Ciclo formativo borrado correctamente.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void mostrarCiclosFormativos() {
        CicloFormativo[] coleccion = ciclosFormativos.get();
        if (coleccion.length == 0) {
            System.out.println("No hay ciclos formativos registrados.");
        } else {
            for (CicloFormativo ciclo : coleccion) {
                if (ciclo != null) System.out.println(ciclo);
            }
        }
    }

    private static void insertarMatricula() {
        try {
            Alumno alumno = Consola.getAlumnoPorDni();
            Matricula matricula = Consola.leerMatricula(alumno, asignaturas.get());
            matriculas.insertar(matricula);
            System.out.println("Matrícula instroducida correctamente.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void buscarMatricula() {
        try {
            Matricula matricula = Consola.getMatriculaPorIdentificador();
            Matricula encontrada = matriculas.buscar(matricula);
            System.out.println((encontrada != null) ? encontrada : "Matrícula no encontrada.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void anularMatricula() {
        try {
            mostrarMatriculas();
            Matricula matricula = Consola.getMatriculaPorIdentificador();
            matriculas.borrar(matricula);
            System.out.println("Matrícula anulada.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void mostrarMatriculas() {
        Matricula[] coleccion = matriculas.get();
        if (coleccion.length == 0) {
            System.out.println("No hay matrículas registradas.");
        } else {
            for (Matricula matricula : coleccion) {
                if (matricula != null) System.out.println(matricula);
            }
        }
    }

    private static void mostrarMatriculasPorAlumno() {
        try {
            Alumno alumno = Consola.getAlumnoPorDni();
            Matricula[] matriculasAlumno = matriculas.get(alumno);
            if (matriculasAlumno.length == 0) {
                System.out.println("El alumno no tiene matrículas registradas.");
            } else {
                for (Matricula matricula : matriculasAlumno) {
                    if (matricula != null) System.out.println(matricula);
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void mostrarMatriculasPorCicloFormativo() {
        try {
            CicloFormativo ciclo = Consola.getCicloFormativoPorCodigo();
            Matricula[] matriculasCiclo = matriculas.get(ciclo);
            if (matriculasCiclo.length == 0) {
                System.out.println("El ciclo formativo no tiene matrículas registradas.");
            } else {
                for (Matricula matricula : matriculasCiclo) {
                    if (matricula != null) System.out.println(matricula);
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void mostrarMatriculasPorCursoAcademico() {
        System.out.print("Introduce el curso académico: ");
        String cursoAcademico = Consola.leerCurso().toString();
        Matricula[] matriculasCurso = matriculas.get(cursoAcademico);
        if (matriculasCurso.length == 0) {
            System.out.println("No hay matrículas para este curso académico.");
        } else {
            for (Matricula matricula : matriculasCurso) {
                if (matricula != null) System.out.println(matricula);
            }
        }
    }

    public static void main(String[] args) {
        Opcion opcion;
        do {
            opcion = Consola.elegirOpcion();
            ejecutarOpcion(opcion);
        } while (opcion != Opcion.SALIR);
    }
}
