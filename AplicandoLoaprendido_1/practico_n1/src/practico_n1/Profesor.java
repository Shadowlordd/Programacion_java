package practico_n1;

import java.util.ArrayList;
import java.util.List;

public class Profesor extends Persona implements MiembroUniversidad {
    private String especialidad;
    private int añosExperiencia;
    private List<Materia> materiasAsignadas;

    public Profesor(String nombre, String apellido, int edad, String documento,
                    String especialidad, int añosExperiencia) {
        super(nombre, apellido, edad, documento);
        this.especialidad = especialidad;
        this.añosExperiencia = añosExperiencia;
        this.materiasAsignadas = new ArrayList<>();
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public int getAñosExperiencia() {
        return añosExperiencia;
    }

    public void setAñosExperiencia(int añosExperiencia) {
        this.añosExperiencia = añosExperiencia;
    }

    public List<Materia> getMateriasAsignadas() {
        return materiasAsignadas;
    }

    public void setMateriasAsignadas(List<Materia> materiasAsignadas) {
        this.materiasAsignadas = materiasAsignadas;
    }

    public void asignarMateria(Materia materia) {
        if (materia != null) {
            materiasAsignadas.add(materia);
            materia.setProfesor(this);
        }
    }

    @Override
    public String obtenerRol() {
        return "Profesor";
    }

    @Override
    public String obtenerInformacionCompleta() {
        StringBuilder sb = new StringBuilder();
        sb.append(toString()).append("\n  Materias asignadas:");
        for (Materia m : materiasAsignadas) {
            sb.append("\n   - ").append(m.getNombre());
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        return super.toString() + ", Especialidad: " + especialidad +
               ", Experiencia: " + añosExperiencia + " años";
    }
}