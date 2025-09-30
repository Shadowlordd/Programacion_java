package proyect_facu;

import java.util.ArrayList;
import java.util.List;

public class Carrera {
    private String nombre;
    private List<Estudiante> estudiantes = new ArrayList<>();

    public Carrera(String nombre) {
        this.nombre = nombre;
    }

    public void agregarEstudiante(Estudiante e) {
        estudiantes.add(e);
    }

    public void listarEstudiantes() {
        for (Estudiante e : estudiantes) {
            System.out.println(e.getNombre() + " " + e.getApellido());
        }
    }

    public Estudiante buscarEstudiante(String nombre) {
        for (Estudiante e : estudiantes) {
            if (e.getNombre().equalsIgnoreCase(nombre)) {
                return e;
            }
        }
        return null; // Este return debe estar dentro de buscarEstudiante
    }

    public List<Estudiante> getEstudiantes() {
        return estudiantes;
    }
}
