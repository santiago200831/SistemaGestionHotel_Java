package hotel;

import java.time.LocalDate;

/**
 * Programa principal: muestra un ejemplo básico de uso del sistema.
 */
public class Main {
    public static void main(String[] args) {
        Hotel hotel = new Hotel(1, "Hotel Buen Descanso", "Medellín, Antioquia");

        Habitacion habitacion1 = new Habitacion(101, "Sencilla", 120000);
        Habitacion habitacion2 = new Habitacion(102, "Doble", 180000);
        hotel.agregarHabitacion(habitacion1);
        hotel.agregarHabitacion(habitacion2);

        Cliente cliente = new Cliente(
                1, "Laura Gómez", "3001234567", "laura@email.com",
                "100200300", "Medellín"
        );

        System.out.println("=== SISTEMA DE GESTIÓN DE HOTEL ===");
        System.out.println("Hotel: " + hotel.getNombre());
        System.out.println("Habitaciones disponibles: " + hotel.consultarDisponibilidad().size());

        Reserva reserva = cliente.solicitarReserva(
                1, habitacion1,
                LocalDate.of(2026, 11, 10),
                LocalDate.of(2026, 11, 13)
        );

        if (reserva != null && hotel.registrarReserva(reserva)) {
            System.out.println("Reserva creada correctamente.");
            System.out.println("Cliente: " + cliente.getNombre());
            System.out.println("Habitación: " + reserva.getHabitacion().getNumero());
            System.out.println("Estado: " + reserva.getEstado());
            System.out.println("Total por la estadía: $" + reserva.calcularTotal());
        } else {
            System.out.println("No fue posible crear la reserva.");
        }

        System.out.println("Habitaciones disponibles después de reservar: "
                + hotel.consultarDisponibilidad().size());

        Empleado empleado = new Empleado(
                2, "Carlos Pérez", "3015555555", "carlos@hotel.com",
                10, "Recepcionista"
        );
        if (empleado.gestionarReserva(reserva)) {
            System.out.println("La reserva fue cancelada por recepción.");
        }
        System.out.println("Habitaciones disponibles al final: "
                + hotel.consultarDisponibilidad().size());
    }
}
