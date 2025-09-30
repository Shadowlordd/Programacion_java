package proyect_facu;

public class Materia {
    private String nombre;
    private String codigo;
    private int creditos;
    private double calificacion;

    public Materia(String nombre, String codigo, int creditos, double calificacion) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.creditos = creditos;
        setCalificacion(calificacion);
    }

    public String getNombre() { return nombre; }
    public String getCodigo() { return codigo; }
    public int getCreditos() { return creditos; }
    public double getCalificacion() { return calificacion; }

    public void setCalificacion(double calificacion) {
        if (calificacion >= 0 && calificacion <= 10) {
            this.calificacion = calificacion;
        } else {
            throw new IllegalArgumentException("La calificación debe estar entre 0 y 10.");
        }
    }
}

