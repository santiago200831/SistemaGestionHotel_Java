package hotel;

/**
 * Representa al empleado que atiende las operaciones del hotel.
 */
public class Empleado extends Persona {
    private int codigoEmpleado;
    private String cargo;

    public Empleado(int idPersona, String nombre, String telefono, String correo,
                    int codigoEmpleado, String cargo) {
        super(idPersona, nombre, telefono, correo);
        this.codigoEmpleado = codigoEmpleado;
        this.cargo = cargo;
    }

    /** Simula el ingreso al sistema con una validación básica de datos. */
    public boolean iniciarSesion(String usuario, String clave) {
        return usuario != null && !usuario.isBlank()
                && clave != null && !clave.isBlank();
    }

    /** Permite cancelar una reserva existente. */
    public boolean gestionarReserva(Reserva reserva) {
        return reserva != null && reserva.cancelarReserva();
    }

    public int getCodigoEmpleado() { return codigoEmpleado; }
    public String getCargo() { return cargo; }
}
