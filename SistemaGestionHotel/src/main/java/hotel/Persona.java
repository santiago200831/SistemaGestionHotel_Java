package hotel;

/**
 * Clase base para las personas registradas en el sistema del hotel.
 */
public class Persona {
    protected int idPersona;
    protected String nombre;
    protected String telefono;
    protected String correo;

    /**
     * Crea una persona con sus datos básicos.
     * @param idPersona identificador de la persona
     * @param nombre nombre completo
     * @param telefono número de contacto
     * @param correo correo electrónico
     */
    public Persona(int idPersona, String nombre, String telefono, String correo) {
        this.idPersona = idPersona;
        this.nombre = nombre;
        this.telefono = telefono;
        this.correo = correo;
    }

    /** Actualiza los datos de contacto de la persona. */
    public void actualizarDatos(String nombre, String telefono, String correo) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.correo = correo;
    }

    public int getIdPersona() { return idPersona; }
    public String getNombre() { return nombre; }
    public String getTelefono() { return telefono; }
    public String getCorreo() { return correo; }
}
