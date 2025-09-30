package proyect_facu;

import java.util.ArrayList;
import java.util.List;

public class Estudiante {
    private String nombre;
    private String apellido;
    private int edad;
    private String carrera;
    private List<Materia> materias = new ArrayList<>();

    public Estudiante(String nombre, String apellido, int edad, String carrera) {
        setNombre(nombre);
        setApellido(apellido);
        setEdad(edad);
        this.carrera = carrera;
    }

    public void agregarMateria(Materia materia) {
        materias.add(materia);
    }

    public double calcularPromedio() {
        if (materias.isEmpty()) return 0;
        double suma = 0;
        for (Materia m : materias) {
            suma += m.getCalificacion();
        }
        return suma / materias.size();
    }

    // Getters y setters con validaciones
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) {
        if (nombre != null && !nombre.trim().isEmpty()) this.nombre = nombre;
        else throw new IllegalArgumentException("Nombre inválido.");
    }

    public String getApellido() { return apellido; }
    public void setApellido(String apellido) {
        if (apellido != null && !apellido.trim().isEmpty()) this.apellido = apellido;
        else throw new IllegalArgumentException("Apellido inválido.");
    }

    public int getEdad() { return edad; }
    public void setEdad(int edad) {
        if (edad > 16) this.edad = edad;
        else throw new IllegalArgumentException("Edad debe ser mayor a 16.");
    }

    public String getCarrera() { return carrera; }
    public List<Materia> getMaterias() { return materias; }
}
