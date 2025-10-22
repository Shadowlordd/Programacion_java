package preparcial;

public class Main {
    public static void main(String[] args) {
        Empleado e = new Empleado("Carlos", 50000);
        Desarrollador d = new Desarrollador("Ana", 75000, "Java");
        Gerente g = new Gerente("Luis", 98000, "Ventas");

        Empresa empresa = new Empresa();

        // Mostrar directamente
        System.out.println(e.mostrarDatos());
        System.out.println(d.mostrarDatos());
        System.out.println(g.mostrarDatos());

        // Demostración de polimorfismo usando Empresa
        empresa.mostrarInformacion(d);
        empresa.mostrarInformacion(g);

        // --- Ordenamiento por sueldo (descendente) ---
        Empleado[] lista = { e, d, g };

        System.out.println("\nAntes de ordenar:");
        for (Empleado emp : lista) {
            System.out.println(emp.mostrarDatos());
        }

        empresa.ordenarPorSueldo(lista);

        System.out.println("\nDespués de ordenar (sueldo descendente):");
        for (Empleado emp : lista) {
            System.out.println(emp.mostrarDatos());
        }

        // --- Búsqueda por nombre (línea sugerida: después del ordenamiento) ---
        // Buscar existente
        Empleado encontrado = empresa.buscarPorNombre(lista, "Ana");
        if (encontrado != null) {
            System.out.println("\nResultado búsqueda: " + encontrado.mostrarDatos());
        }

        // Buscar inexistente
        Empleado noExiste = empresa.buscarPorNombre(lista, "María");
        if (noExiste == null) {
            System.out.println("\nLa búsqueda por 'María' no devolvió resultados.");
        }
    }
}