package practicoN2;

import java.util.Objects;

public class Profesor extends Persona implements MiembroUniversidad {
    private ListaEnlazada<Materia> materiasAsignadas;

    public Profesor(String nombre, String apellido, int edad, String documento) {
        super(nombre, apellido, edad, documento);
        this.materiasAsignadas = new ListaEnlazada<>();
    }

    public ListaEnlazada<Materia> getMateriasAsignadas() { return materiasAsignadas; }

    public void asignarMateria(Materia m) {
        Objects.requireNonNull(m, "Materia no puede ser null");
        materiasAsignadas.add(m);
    }

    public boolean quitarMateria(Materia m) { return materiasAsignadas.remove(m); }

    @Override
    public String obtenerRol() { return "Profesor"; }

    @Override
    public String obtenerInformacionCompleta() {
        StringBuilder sb = new StringBuilder();
        sb.append(toString()).append("\n  Materias asignadas:");
        if (materiasAsignadas.isEmpty()) sb.append(" Ninguna");
        else for (Materia m : materiasAsignadas) sb.append("\n   - ").append(m);
        return sb.toString();
    }
}