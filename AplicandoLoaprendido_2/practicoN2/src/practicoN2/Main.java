package practicoN2;

public class Main {
    public static void main(String[] args) {
        Universidad uni = new Universidad();

        Profesor prof1 = new Profesor("María", "López", 45, "P900");
        Profesor prof2 = new Profesor("Juan", "García", 50, "P901");

        Materia m1 = new Materia("POO", 8.5, prof1);
        Materia m2 = new Materia("Algoritmos", 7.0, prof2);
        Materia m3 = new Materia("Estructuras", 9.0, prof1);

        ListaEnlazada<Materia> materiasLuis = new ListaEnlazada<>();
        materiasLuis.add(m1); materiasLuis.add(m2);
        Estudiante e1 = new Estudiante("Luis", "Pérez", 21, "DNI123", "Ingenieria", 0.0, materiasLuis);

        ListaEnlazada<Materia> materiasAna = new ListaEnlazada<>();
        materiasAna.add(m2); materiasAna.add(m3);
        Estudiante e2 = new Estudiante("Ana", "Gómez", 20, "DNI456", "Medicina", 0.0, materiasAna);

        uni.agregarMiembro(prof1);
        uni.agregarMiembro(prof2);
        uni.agregarMiembro(e1);
        uni.agregarMiembro(e2);

        System.out.println("Listado de miembros:");
        uni.listarMiembros();

        System.out.println("\nContar estudiantes en Ingenieria (iterativo): " +
                uni.contarEstudiantesIterativoPorCarrera("Ingenieria"));

        System.out.println("Contar estudiantes en Medicina (recursivo): " +
                uni.contarEstudiantesRecursivoPorCarrera("Medicina"));

        System.out.println("\nPromedio recursivo de Luis: " +
                Estudiante.promedioFinalRecursivo(e1.getMaterias()));

        System.out.println("\nBúsqueda binaria por apellido 'Gómez':");
        Estudiante encontrado = uni.busquedaBinariaEstudiantesPorApellido("Gómez");
        System.out.println(encontrado != null ? encontrado.obtenerInformacionCompleta() : "No encontrado");
    }
}