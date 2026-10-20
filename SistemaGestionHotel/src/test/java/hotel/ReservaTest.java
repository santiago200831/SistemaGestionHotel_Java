package hotel;

import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

/** Pruebas unitarias sencillas para las reservas. */
class ReservaTest {

    @Test
    void crearReservaCambiaDisponibilidad() {
        Cliente cliente = new Cliente(1, "Ana", "3000000000", "ana@email.com", "123", "Medellín");
        Habitacion habitacion = new Habitacion(101, "Sencilla", 100000);
        Reserva reserva = new Reserva(1, cliente, habitacion,
                LocalDate.of(2026, 11, 10), LocalDate.of(2026, 11, 12));

        assertTrue(reserva.crearReserva());
        assertEquals("Confirmada", reserva.getEstado());
        assertFalse(habitacion.isDisponible());
    }

    @Test
    void noPermiteReservarHabitacionOcupada() {
        Cliente cliente = new Cliente(1, "Ana", "3000000000", "ana@email.com", "123", "Medellín");
        Habitacion habitacion = new Habitacion(101, "Sencilla", 100000);
        Reserva primera = new Reserva(1, cliente, habitacion,
                LocalDate.of(2026, 11, 10), LocalDate.of(2026, 11, 12));
        Reserva segunda = new Reserva(2, cliente, habitacion,
                LocalDate.of(2026, 11, 15), LocalDate.of(2026, 11, 17));

        assertTrue(primera.crearReserva());
        assertFalse(segunda.crearReserva());
    }

    @Test
    void cancelarReservaLiberaHabitacion() {
        Cliente cliente = new Cliente(1, "Ana", "3000000000", "ana@email.com", "123", "Medellín");
        Habitacion habitacion = new Habitacion(101, "Sencilla", 100000);
        Reserva reserva = new Reserva(1, cliente, habitacion,
                LocalDate.of(2026, 11, 10), LocalDate.of(2026, 11, 12));
        reserva.crearReserva();

        assertTrue(reserva.cancelarReserva());
        assertEquals("Cancelada", reserva.getEstado());
        assertTrue(habitacion.isDisponible());
    }

    @Test
    void calculaTotalPorNoches() {
        Cliente cliente = new Cliente(1, "Ana", "3000000000", "ana@email.com", "123", "Medellín");
        Habitacion habitacion = new Habitacion(101, "Sencilla", 100000);
        Reserva reserva = new Reserva(1, cliente, habitacion,
                LocalDate.of(2026, 11, 10), LocalDate.of(2026, 11, 13));

        assertEquals(300000.0, reserva.calcularTotal());
    }
}
