package practico_n1;

import java.util.ArrayList;
import java.util.List;

public class Universidad {
    private List<MiembroUniversidad> miembros;

    public Universidad() {
        miembros = new ArrayList<>();
    }

    public void agregarMiembro(MiembroUniversidad miembro) {
        miembros.add(miembro);
    }

    public void listarMiembros() {
        for (MiembroUniversidad m : miembros) {
            System.out.println(m.obtenerInformacionCompleta());
        }
    }

    public List<MiembroUniversidad> buscarPorRol(String rol) {
        List<MiembroUniversidad> resultado = new ArrayList<>();
        for (MiembroUniversidad m : miembros) {
            if (m.obtenerRol().equalsIgnoreCase(rol)) {
                resultado.add(m);
            }
        }
        return resultado;
    }

    // Contar estudiantes por carrera (recursivo)
    public static int contarEstudiantesRecursivo(Estudiante[] estudiantes, String carrera, int indice) {
        if (estudiantes == null || indice >= estudiantes.length) return 0;
        int cuenta = 0;
        if (estudiantes[indice] != null && estudiantes[indice].getCarrera() != null &&
            estudiantes[indice].getCarrera().equalsIgnoreCase(carrera)) {
            cuenta = 1;
        }
        return cuenta + contarEstudiantesRecursivo(estudiantes, carrera, indice + 1);
    }

    // Contar estudiantes por carrera (iterativo)
    public static int contarEstudiantesIterativo(Estudiante[] estudiantes, String carrera) {
        if (estudiantes == null) return 0;
        int contador = 0;
        for (Estudiante e : estudiantes) {
            if (e != null && e.getCarrera() != null && e.getCarrera().equalsIgnoreCase(carrera)) {
                contador++;
            }
        }
        return contador;
    }

    // Buscar estudiante por documento (recursivo)
    public static Estudiante buscarEstudianteRecursivo(Estudiante[] estudiantes, String documento, int indice) {
        if (estudiantes == null || indice >= estudiantes.length) return null;
        if (estudiantes[indice] != null && estudiantes[indice].getDocumento().equals(documento)) {
            return estudiantes[indice];
        }
        return buscarEstudianteRecursivo(estudiantes, documento, indice + 1);
    }

    // Buscar estudiante por documento (iterativo)
    public static Estudiante buscarEstudianteIterativo(Estudiante[] estudiantes, String documento) {
        if (estudiantes == null) return null;
        for (Estudiante e : estudiantes) {
            if (e != null && e.getDocumento().equals(documento)) return e;
        }
        return null;
    }

    // Ordenar (Selection Sort) por apellido
    public static void ordenarEstudiantesPorApellido(Estudiante[] estudiantes) {
        if (estudiantes == null) return;
        int n = estudiantes.length;
        for (int i = 0; i < n - 1; i++) {
            int indiceMinimo = i;
            for (int j = i + 1; j < n; j++) {
                if (estudiantes[j] != null && estudiantes[indiceMinimo] != null &&
                    estudiantes[j].getApellido().compareToIgnoreCase(estudiantes[indiceMinimo].getApellido()) < 0) {
                    indiceMinimo = j;
                }
            }
            if (indiceMinimo != i) {
                Estudiante temp = estudiantes[i];
                estudiantes[i] = estudiantes[indiceMinimo];
                estudiantes[indiceMinimo] = temp;
            }
        }
    }

    // Búsqueda binaria por apellido (devuelve índice o -1)
    public static int busquedaBinariaEstudiantes(Estudiante[] estudiantes, String apellido) {
        if (estudiantes == null || apellido == null) return -1;
        ordenarEstudiantesPorApellido(estudiantes); // aseguramos orden
        int izquierda = 0;
        int derecha = estudiantes.length - 1;
        while (izquierda <= derecha) {
            int medio = (izquierda + derecha) / 2;
            if (estudiantes[medio] == null) {
                // si hay nulls, ajustamos búsqueda linealmente alrededor (defensivo)
                int l = medio - 1;
                int r = medio + 1;
                boolean encontrado = false;
                while (l >= izquierda || r <= derecha) {
                    if (l >= izquierda && estudiantes[l] != null) {
                        if (estudiantes[l].getApellido().equalsIgnoreCase(apellido)) return l;
                        if (estudiantes[l].getApellido().compareToIgnoreCase(apellido) < 0) {
                            izquierda = medio + 1;
                            encontrado = true;
                            break;
                        }
                        l--;
                    }
                    if (r <= derecha && estudiantes[r] != null) {
                        if (estudiantes[r].getApellido().equalsIgnoreCase(apellido)) return r;
                        if (estudiantes[r].getApellido().compareToIgnoreCase(apellido) > 0) {
                            derecha = medio - 1;
                            encontrado = true;
                            break;
                        }
                        r++;
                    }
                    if (encontrado) break;
                    if (l < izquierda && r > derecha) break;
                }
                // si no lo manejamos, retornamos -1
                return -1;
            }
            int cmp = estudiantes[medio].getApellido().compareToIgnoreCase(apellido);
            if (cmp == 0) return medio;
            else if (cmp < 0) izquierda = medio + 1;
            else derecha = medio - 1;
        }
        return -1;
    }
}
