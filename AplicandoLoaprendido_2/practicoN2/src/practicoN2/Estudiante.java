package practicoN2;

import java.util.Objects;

public class Estudiante extends Persona implements MiembroUniversidad {
    private String carrera;
    private double promedio; // se mantiene consistente con las materias
    private ListaEnlazada<Materia> materias;

    public Estudiante(String nombre, String apellido, int edad, String documento,
                      String carrera, double promedio, ListaEnlazada<Materia> materias) {
        super(nombre, apellido, edad, documento);
        setCarrera(carrera);
        setPromedio(promedio);
        this.materias = (materias == null) ? new ListaEnlazada<>() : materias;
        if (!this.materias.isEmpty()) this.promedio = calcularPromedioIterativo();
    }

    public String getCarrera() { return carrera; }

    public void setCarrera(String carrera) {
        if (carrera == null || carrera.trim().isEmpty()) throw new IllegalArgumentException("carrera inválida");
        this.carrera = carrera.trim();
    }

    public double getPromedio() { return promedio; }

    public void setPromedio(double promedio) {
        if (promedio < 0.0 || promedio > 10.0) throw new IllegalArgumentException("promedio fuera de rango");
        this.promedio = promedio;
    }

    public ListaEnlazada<Materia> getMaterias() { return materias; }

    public void setMaterias(ListaEnlazada<Materia> materias) {
        this.materias = (materias == null) ? new ListaEnlazada<>() : materias;
        this.promedio = calcularPromedioIterativo();
    }

    public void agregarMateria(Materia m) {
        Objects.requireNonNull(m, "Materia no puede ser null");
        materias.add(m);
        promedio = calcularPromedioIterativo();
    }

    public boolean eliminarMateria(Materia m) {
        if (m == null) return false;
        boolean removed = materias.remove(m);
        if (removed) promedio = calcularPromedioIterativo();
        return removed;
    }

    @Override
    public String obtenerRol() { return "Estudiante"; }

    @Override
    public String obtenerInformacionCompleta() {
        StringBuilder sb = new StringBuilder();
        sb.append(toString()).append("\n  Materias:");
        if (materias.isEmpty()) sb.append(" Ninguna");
        else for (Materia m : materias) sb.append("\n   - ").append(m == null ? "null" : m.toString());
        return sb.toString();
    }

    @Override
    public String toString() {
        return super.toString() + ", Carrera: " + carrera + ", Promedio: " + String.format("%.2f", promedio);
    }

    // Recursivo acumulador: suma de notas y contador a partir de un nodo
    public static double calcularPromedioRecursivo(ListaEnlazada.Nodo<Materia> actual, int contador, double suma) {
        if (actual == null) return contador == 0 ? 0.0 : suma / contador;
        Materia materia = actual.dato;
        double nota = (materia == null) ? 0.0 : materia.getNota();
        return calcularPromedioRecursivo(actual.siguiente, contador + (materia == null ? 0 : 1), suma + nota);
    }

    public static double promedioFinalRecursivo(ListaEnlazada<Materia> lista) {
        if (lista == null || lista.isEmpty()) return 0.0;
        return calcularPromedioRecursivo(lista.getHeadNode(), 0, 0.0);
    }

    public double calcularPromedioIterativo() {
        if (materias == null || materias.isEmpty()) return 0.0;
        double suma = 0.0;
        int cnt = 0;
        for (Materia m : materias) {
            if (m != null) {
                suma += m.getNota();
                cnt++;
            }
        }
        return cnt == 0 ? 0.0 : suma / cnt;
    }
}