package practicoN2;

public class Materia {
    private String nombre;
    private double nota;
    private Profesor profesor;

    public Materia(String nombre, double nota, Profesor profesor) {
        setNombre(nombre);
        setNota(nota);
        this.profesor = profesor;
    }

    public String getNombre() { return nombre; }

    public void setNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) throw new IllegalArgumentException("nombre materia inválido");
        this.nombre = nombre.trim();
    }

    public double getNota() { return nota; }

    public void setNota(double nota) {
        if (nota < 0.0 || nota > 10.0) throw new IllegalArgumentException("nota fuera de rango");
        this.nota = nota;
    }

    public Profesor getProfesor() { return profesor; }

    public void setProfesor(Profesor profesor) { this.profesor = profesor; }

    @Override
    public String toString() {
        String profNombre = profesor != null ? profesor.getNombre() + " " + profesor.getApellido() : "Sin profesor";
        return nombre + " (Nota: " + String.format("%.2f", nota) + ", Profesor: " + profNombre + ")";
    }
}