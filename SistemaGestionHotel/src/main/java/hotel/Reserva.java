package hotel;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * Representa la reserva de una habitación por parte de un cliente.
 */
public class Reserva {
    private int idReserva;
    private Cliente cliente;
    private Habitacion habitacion;
    private LocalDate fechaEntrada;
    private LocalDate fechaSalida;
    private String estado;

    public Reserva(int idReserva, Cliente cliente, Habitacion habitacion,
                   LocalDate fechaEntrada, LocalDate fechaSalida) {
        this.idReserva = idReserva;
        this.cliente = cliente;
        this.habitacion = habitacion;
        this.fechaEntrada = fechaEntrada;
        this.fechaSalida = fechaSalida;
        this.estado = "Pendiente";
    }

    /**
     * Registra la reserva si los datos son válidos y la habitación está disponible.
     * @return true si se pudo crear; false en caso contrario
     */
    public boolean crearReserva() {
        if (cliente == null || habitacion == null || fechaEntrada == null || fechaSalida == null) {
            return false;
        }
        if (!fechaSalida.isAfter(fechaEntrada) || !habitacion.isDisponible()) {
            return false;
        }
        habitacion.cambiarDisponibilidad(false);
        estado = "Confirmada";
        return true;
    }

    /** Cancela una reserva confirmada y libera la habitación. */
    public boolean cancelarReserva() {
        if (!"Confirmada".equals(estado)) {
            return false;
        }
        estado = "Cancelada";
        habitacion.cambiarDisponibilidad(true);
        return true;
    }

    /** Calcula el costo total de la estadía según las noches reservadas. */
    public double calcularTotal() {
        long noches = ChronoUnit.DAYS.between(fechaEntrada, fechaSalida);
        return noches * habitacion.consultarPrecio();
    }

    public int getIdReserva() { return idReserva; }
    public Cliente getCliente() { return cliente; }
    public Habitacion getHabitacion() { return habitacion; }
    public LocalDate getFechaEntrada() { return fechaEntrada; }
    public LocalDate getFechaSalida() { return fechaSalida; }
    public String getEstado() { return estado; }
}
