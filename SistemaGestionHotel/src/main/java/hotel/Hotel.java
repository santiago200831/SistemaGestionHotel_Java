package hotel;

import java.util.ArrayList;
import java.util.List;

/**
 * Administra las habitaciones y permite consultar su disponibilidad.
 */
public class Hotel {
    private int idHotel;
    private String nombre;
    private String direccion;
    private final List<Habitacion> habitaciones;
    private final List<Reserva> reservas;

    public Hotel(int idHotel, String nombre, String direccion) {
        this.idHotel = idHotel;
        this.nombre = nombre;
        this.direccion = direccion;
        this.habitaciones = new ArrayList<>();
        this.reservas = new ArrayList<>();
    }

    /** Agrega una habitación al hotel si su número no está registrado. */
    public boolean agregarHabitacion(Habitacion habitacion) {
        if (habitacion == null || buscarHabitacion(habitacion.getNumero()) != null) {
            return false;
        }
        habitaciones.add(habitacion);
        return true;
    }

    /** Busca una habitación por su número. */
    public Habitacion buscarHabitacion(int numero) {
        for (Habitacion habitacion : habitaciones) {
            if (habitacion.getNumero() == numero) {
                return habitacion;
            }
        }
        return null;
    }

    /** Devuelve las habitaciones disponibles. */
    public List<Habitacion> consultarDisponibilidad() {
        List<Habitacion> disponibles = new ArrayList<>();
        for (Habitacion habitacion : habitaciones) {
            if (habitacion.isDisponible()) {
                disponibles.add(habitacion);
            }
        }
        return disponibles;
    }

    /** Guarda una reserva creada correctamente. */
    public boolean registrarReserva(Reserva reserva) {
        if (reserva == null || !"Confirmada".equals(reserva.getEstado())) {
            return false;
        }
        reservas.add(reserva);
        return true;
    }

    public List<Reserva> consultarReservas() {
        return new ArrayList<>(reservas);
    }

    public int getIdHotel() { return idHotel; }
    public String getNombre() { return nombre; }
    public String getDireccion() { return direccion; }
    public List<Habitacion> getHabitaciones() { return new ArrayList<>(habitaciones); }
}
