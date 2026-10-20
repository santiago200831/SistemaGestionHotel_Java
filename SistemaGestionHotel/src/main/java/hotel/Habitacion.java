package hotel;

/**
 * Guarda la información y disponibilidad de una habitación.
 */
public class Habitacion {
    private int numero;
    private String tipo;
    private double precio;
    private boolean disponible;

    public Habitacion(int numero, String tipo, double precio) {
        this.numero = numero;
        this.tipo = tipo;
        this.precio = precio;
        this.disponible = true;
    }

    /** Cambia el estado de disponibilidad de la habitación. */
    public void cambiarDisponibilidad(boolean disponible) {
        this.disponible = disponible;
    }

    /** Consulta el precio por noche. */
    public double consultarPrecio() {
        return precio;
    }

    public int getNumero() { return numero; }
    public String getTipo() { return tipo; }
    public boolean isDisponible() { return disponible; }
}
