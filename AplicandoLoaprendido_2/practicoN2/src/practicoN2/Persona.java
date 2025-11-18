package practicoN2;

public class Persona {
    private String nombre;
    private String apellido;
    private int edad;
    private String documento;

    public Persona(String nombre, String apellido, int edad, String documento) {
        if (nombre == null || nombre.trim().isEmpty()) throw new IllegalArgumentException("nombre inválido");
        if (apellido == null || apellido.trim().isEmpty()) throw new IllegalArgumentException("apellido inválido");
        this.nombre = nombre.trim();
        this.apellido = apellido.trim();
        this.edad = edad;
        this.documento = documento;
    }

    public String getNombre() { return nombre; }
    public String getApellido() { return apellido; }
    public int getEdad() { return edad; }
    public String getDocumento() { return documento; }

    @Override
    public String toString() {
        return nombre + " " + apellido + " (Edad: " + edad + ", Doc: " + documento + ")";
    }
}