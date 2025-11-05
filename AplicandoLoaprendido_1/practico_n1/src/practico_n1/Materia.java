package practico_n1;

public class Materia {
    private String nombre;
    private double nota;
    private Profesor profesor;

    public Materia(String nombre, double nota, Profesor profesor) {
        this.nombre = nombre;
        this.nota = nota;
        this.profesor = profesor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    @Override
    public String toString() {
        String profNombre = profesor != null ? profesor.getNombre() + " " + profesor.getApellido() : "Sin profesor";
        return nombre + " (Nota: " + nota + ", Profesor: " + profNombre + ")";
    }
}