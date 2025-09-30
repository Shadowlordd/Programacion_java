package proyect_facu;

public class App {
    public static void main(String[] args) {
        // Crear carrera
        Carrera informatica = new Carrera("Informática");

        // Crear estudiantes
        Estudiante e1 = new Estudiante("Lucía", "Gómez", 20, "Informática");
        Estudiante e2 = new Estudiante("Tomás", "Pérez", 22, "Informática");

        // Crear materias
        Materia m1 = new Materia("Programación", "INF101", 4, 9.0);
        Materia m2 = new Materia("Bases de Datos", "INF202", 3, 8.5);
        Materia m3 = new Materia("Matemática", "MAT100", 5, 7.8);

        // Asignar materias
        e1.agregarMateria(m1);
        e1.agregarMateria(m2);

        e2.agregarMateria(m2);
        e2.agregarMateria(m3);

        // Agregar estudiantes a carrera
        informatica.agregarEstudiante(e1);
        informatica.agregarEstudiante(e2);

        // Mostrar promedio de cada estudiante
        for (Estudiante e : informatica.getEstudiantes()) {
            System.out.println("Estudiante: " + e.getNombre() + " | Promedio: " + e.calcularPromedio());
        }

        // Listar todos los estudiantes de la carrera
        System.out.println("\nEstudiantes en la carrera de Informática:");
        informatica.listarEstudiantes();
    }
}
