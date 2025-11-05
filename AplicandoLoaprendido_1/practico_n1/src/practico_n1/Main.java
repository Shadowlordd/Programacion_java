package practico_n1;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println(" Inicio del programa");

        // Crear profesor
        Profesor prof = new Profesor("Laura", "Gómez", 45, "12345678", "Matemáticas", 20);

        // Crear materias
        Materia algebra = new Materia("Álgebra", 9.0, prof);
        Materia analisis = new Materia("Análisis", 8.5, prof);
        prof.asignarMateria(algebra);
        prof.asignarMateria(analisis);

        // Crear estudiantes
        Estudiante est1 = new Estudiante("Carlos", "Pérez", 20, "87654321", "Ingeniería", 0.0,
                Arrays.asList(algebra, analisis));
        Estudiante est2 = new Estudiante("Ana", "Zamora", 22, "99887766", "Ingeniería", 0.0,
                Arrays.asList(algebra));
        Estudiante est3 = new Estudiante("Luis", "Alonso", 21, "11223344", "Medicina", 0.0,
                Arrays.asList(analisis));

        // Calcular promedio recursivo e iterativo
        Materia[] materiasArray = est1.getMaterias().toArray(new Materia[0]);
        double promedioRec = Estudiante.promedioFinalRecursivo(materiasArray);
        double promedioIter = est1.calcularPromedioIterativo();
        System.out.println(" Promedio recursivo de Carlos: " + promedioRec);
        System.out.println(" Promedio iterativo de Carlos: " + promedioIter);

        // Crear personal
        Personal admin = new Personal("Marta", "López", 38, "44556677", "Administración", "Secretaria",
                LocalDate.of(2015, 3, 1));

        // Crear universidad y agregar miembros
        Universidad uni = new Universidad();
        uni.agregarMiembro(prof);
        uni.agregarMiembro(est1);
        uni.agregarMiembro(est2);
        uni.agregarMiembro(est3);
        uni.agregarMiembro(admin);

        // Mostrar todos los miembros
        System.out.println("\n Miembros de la universidad:");
        uni.listarMiembros();

        // Buscar por rol
        System.out.println("\n Estudiantes:");
        List<MiembroUniversidad> estudiantes = uni.buscarPorRol("Estudiante");
        estudiantes.forEach(e -> System.out.println(e.obtenerInformacionCompleta()));

        // Contar estudiantes por carrera (recursivo e iterativo)
        Estudiante[] estArray = { est1, est2, est3 };
        int ingRec = Universidad.contarEstudiantesRecursivo(estArray, "Ingeniería", 0);
        int ingIter = Universidad.contarEstudiantesIterativo(estArray, "Ingeniería");
        System.out.println("\n Ingeniería (recursivo): " + ingRec);
        System.out.println(" Ingeniería (iterativo): " + ingIter);

        // Buscar estudiante por documento
        Estudiante encontradoRec = Universidad.buscarEstudianteRecursivo(estArray, "99887766", 0);
        Estudiante encontradoIter = Universidad.buscarEstudianteIterativo(estArray, "99887766");
        System.out.println("\n Estudiante encontrado (recursivo): " + encontradoRec);
        System.out.println(" Estudiante encontrado (iterativo): " + encontradoIter);

        // Ordenar estudiantes por apellido
        System.out.println("\n Estudiantes ordenados por apellido:");
        Universidad.ordenarEstudiantesPorApellido(estArray);
        for (Estudiante e : estArray) {
            System.out.println(e.getApellido() + " - " + e.getNombre());
        }

        // Búsqueda binaria por apellido
        String apellidoBuscado = "Zamora";
        int indice = Universidad.busquedaBinariaEstudiantes(estArray, apellidoBuscado);
        System.out.println("\n Búsqueda binaria de '" + apellidoBuscado + "':");
        if (indice != -1) {
            System.out.println("Encontrado: " + estArray[indice]);
        } else {
            System.out.println(" No se encontró el estudiante con apellido " + apellidoBuscado);
        }

        System.out.println(" Fin del programa");
    }
}
