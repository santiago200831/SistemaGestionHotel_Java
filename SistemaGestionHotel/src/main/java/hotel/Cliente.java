package hotel;

import java.util.ArrayList;
import java.util.List;

/**
 * Representa a un cliente que puede solicitar habitaciones.
 */
public class Cliente extends Persona {
    private String documento;
    private String direccion;
    private final List<Reserva> reservas;

    /**
     * Registra un cliente con los datos personales heredados de Persona.
     */
    public Cliente(int idPersona, String nombre, String telefono, String correo,
                   String documento, String direccion) {
        super(idPersona, nombre, telefono, correo);
        this.documento = documento;
        this.direccion = direccion;
        this.reservas = new ArrayList<>();
    }

    /** Solicita una reserva para una habitación y un periodo. */
    public Reserva solicitarReserva(int idReserva, Habitacion habitacion,
                                    java.time.LocalDate entrada, java.time.LocalDate salida) {
        Reserva reserva = new Reserva(idReserva, this, habitacion, entrada, salida);
        if (reserva.crearReserva()) {
            reservas.add(reserva);
            return reserva;
        }
        return null;
    }

    /** Devuelve las reservas realizadas por el cliente. */
    public List<Reserva> consultarReservas() {
        return new ArrayList<>(reservas);
    }

    public String getDocumento() { return documento; }
    public String getDireccion() { return direccion; }
}
