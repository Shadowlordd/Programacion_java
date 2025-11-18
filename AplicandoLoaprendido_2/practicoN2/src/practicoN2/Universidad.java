package practicoN2;

import java.util.Objects;
import java.util.Arrays;
import java.util.Comparator;

public class Universidad {
    private ListaEnlazada<MiembroUniversidad> miembros;

    public Universidad() { this.miembros = new ListaEnlazada<>(); }

    public void agregarMiembro(MiembroUniversidad m) {
        Objects.requireNonNull(m, "miembro no puede ser null");
        miembros.add(m);
    }

    public void listarMiembros() {
        for (MiembroUniversidad m : miembros) System.out.println(m.obtenerInformacionCompleta());
    }

    public ListaEnlazada<MiembroUniversidad> buscarPorRol(String rol) {
        Objects.requireNonNull(rol, "rol no puede ser null");
        ListaEnlazada<MiembroUniversidad> res = new ListaEnlazada<>();
        for (MiembroUniversidad m : miembros) {
            String r = m.obtenerRol();
            if (r != null && r.equalsIgnoreCase(rol)) res.add(m);
        }
        return res;
    }

    // Contar estudiantes por carrera - recursivo sobre nodos
    private static int contarEstudiantesRecursivoNodo(ListaEnlazada.Nodo<MiembroUniversidad> nodo, String carrera) {
        if (nodo == null) return 0;
        int cuenta = 0;
        MiembroUniversidad m = nodo.dato;
        if (m instanceof Estudiante) {
            Estudiante e = (Estudiante) m;
            if (e.getCarrera() != null && e.getCarrera().equalsIgnoreCase(carrera)) cuenta = 1;
        }
        return cuenta + contarEstudiantesRecursivoNodo(nodo.siguiente, carrera);
    }

    public int contarEstudiantesRecursivoPorCarrera(String carrera) {
        Objects.requireNonNull(carrera, "carrera no puede ser null");
        return contarEstudiantesRecursivoNodo(miembros.getHeadNode(), carrera);
    }

    public int contarEstudiantesIterativoPorCarrera(String carrera) {
        Objects.requireNonNull(carrera, "carrera no puede ser null");
        int cnt = 0;
        for (MiembroUniversidad m : miembros) {
            if (m instanceof Estudiante) {
                Estudiante e = (Estudiante) m;
                if (e.getCarrera() != null && e.getCarrera().equalsIgnoreCase(carrera)) cnt++;
            }
        }
        return cnt;
    }

    // Buscar estudiante por documento - recursivo
    private static Estudiante buscarEstudianteRecursivoNodo(ListaEnlazada.Nodo<MiembroUniversidad> nodo, String documento) {
        if (nodo == null) return null;
        MiembroUniversidad m = nodo.dato;
        if (m instanceof Estudiante) {
            Estudiante e = (Estudiante) m;
            if (documento.equals(e.getDocumento())) return e;
        }
        return buscarEstudianteRecursivoNodo(nodo.siguiente, documento);
    }

    public Estudiante buscarEstudianteRecursivo(String documento) {
        Objects.requireNonNull(documento, "documento no puede ser null");
        return buscarEstudianteRecursivoNodo(miembros.getHeadNode(), documento);
    }

    public Estudiante buscarEstudianteIterativo(String documento) {
        Objects.requireNonNull(documento, "documento no puede ser null");
        for (MiembroUniversidad m : miembros) {
            if (m instanceof Estudiante) {
                Estudiante e = (Estudiante) m;
                if (documento.equals(e.getDocumento())) return e;
            }
        }
        return null;
    }

    // Búsqueda binaria sencilla: convertir lista de Estudiantes  ordenar, buscar y devolver Estudiante o null.
    public Estudiante busquedaBinariaEstudiantesPorApellido(String apellido) {
        Objects.requireNonNull(apellido, "apellido no puede ser null");
        // Extraer estudiantes de la lista
        Object[] all = miembros.toArray();
        // Filtrar y construir array de Estudiante
        Estudiante[] estudiantes = Arrays.stream(all)
                .filter(obj -> obj instanceof Estudiante)
                .map(obj -> (Estudiante) obj)
                .toArray(Estudiante[]::new);

        if (estudiantes.length == 0) return null;

        Arrays.sort(estudiantes, new Comparator<Estudiante>() {
            @Override
            public int compare(Estudiante a, Estudiante b) {
                if (a == null && b == null) return 0;
                if (a == null) return 1;
                if (b == null) return -1;
                return a.getApellido().compareToIgnoreCase(b.getApellido());
            }
        });

        int izquierda = 0, derecha = estudiantes.length - 1;
        while (izquierda <= derecha) {
            int medio = (izquierda + derecha) >>> 1;
            Estudiante mid = estudiantes[medio];
            if (mid == null) return null;
            int cmp = mid.getApellido().compareToIgnoreCase(apellido);
            if (cmp == 0) return mid;
            if (cmp < 0) izquierda = medio + 1;
            else derecha = medio - 1;
        }
        return null;
    }
}