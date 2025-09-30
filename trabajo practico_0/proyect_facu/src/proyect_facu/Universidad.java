package proyect_facu;

import java.util.ArrayList;
import java.util.List;

public class Universidad {
    private String nombre;
    private String direccion;
    private List<Estudiante> estudiantes = new ArrayList<>();

    public Universidad(String nombre, String direccion) {
        this.nombre = nombre;
        this.direccion = direccion;
    }

    public void agregarEstudiante(Estudiante e) {
        estudiantes.add(e);
    }

    public List<Estudiante> getEstudiantes() {
        return estudiantes;
    }
    
    public String getNombre() {
    return nombre;
}

}
