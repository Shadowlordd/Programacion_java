package practico_n1;

import java.util.List;

public class Estudiante extends Persona implements MiembroUniversidad {
    private String carrera;
    private double promedio;
    private List<Materia> materias;

    public Estudiante(String nombre, String apellido, int edad, String documento,
                      String carrera, double promedio, List<Materia> materias) {
        super(nombre, apellido, edad, documento);
        this.carrera = carrera;
        this.promedio = promedio;
        this.materias = materias;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public double getPromedio() {
        return promedio;
    }

    public void setPromedio(double promedio) {
        this.promedio = promedio;
    }

    public List<Materia> getMaterias() {
        return materias;
    }

    public void setMaterias(List<Materia> materias) {
        this.materias = materias;
    }

    @Override
    public String obtenerRol() {
        return "Estudiante";
    }

    @Override
    public String obtenerInformacionCompleta() {
        StringBuilder sb = new StringBuilder();
        sb.append(toString()).append("\n  Materias:");
        if (materias != null) {
            for (Materia m : materias) {
                sb.append("\n   - ").append(m);
            }
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        return super.toString() + ", Carrera: " + carrera + ", Promedio: " + promedio;
    }

    // Recursivo: suma de notas; dividir por cantidad fuera si es necesario
    public static double calcularPromedioRecursivo(Materia[] materias, int indice) {
        if (materias == null || materias.length == 0) return 0;
        if (indice >= materias.length) return 0;
        if (indice == materias.length - 1) {
            return materias[indice].getNota();
        }
        return materias[indice].getNota() + calcularPromedioRecursivo(materias, indice + 1);
    }

    // Conveniencia: devuelve el promedio final usando la función recursiva
    public static double promedioFinalRecursivo(Materia[] materias) {
        if (materias == null || materias.length == 0) return 0;
        double suma = calcularPromedioRecursivo(materias, 0);
        return suma / materias.length;
    }

    // Iterativo sobre la lista de materias (instancia)
    public double calcularPromedioIterativo() {
        if (materias == null || materias.isEmpty()) return 0;
        double suma = 0;
        for (Materia m : materias) {
            suma += m.getNota();
        }
        return suma / materias.size();
    }
}