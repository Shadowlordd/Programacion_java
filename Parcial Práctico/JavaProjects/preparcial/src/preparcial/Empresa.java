package preparcial;

public class Empresa {
    public void mostrarInformacion(Empleado empleado) {
        System.out.println(empleado.mostrarDatos());
    }

    // Ordena por sueldo de forma descendente (mayor a menor)
    public void ordenarPorSueldo(Empleado[] empleados) {
        for (int i = 0; i < empleados.length - 1; i++) {
            for (int j = 0; j < empleados.length - 1 - i; j++) {
                if (empleados[j].getSueldo() < empleados[j + 1].getSueldo()) {
                    Empleado aux = empleados[j];
                    empleados[j] = empleados[j + 1];
                    empleados[j + 1] = aux;
                }
            }
        }
    }

    // Búsqueda lineal por nombre. Devuelve el Empleado encontrado o null y muestra mensaje si no existe.
    public Empleado buscarPorNombre(Empleado[] empleados, String nombreBuscado) {
        if (empleados == null || nombreBuscado == null) {
            System.out.println("Parámetros inválidos para la búsqueda.");
            return null;
        }
        for (Empleado emp : empleados) {
            if (emp != null && emp.getNombre().equalsIgnoreCase(nombreBuscado)) {
                return emp;
            }
        }
        System.out.println("Empleado no encontrado: " + nombreBuscado);
        return null;
    }
}