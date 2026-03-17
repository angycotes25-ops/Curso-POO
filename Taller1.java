public class Taller1 {

    public static void main(String[] args) {

        System.out.println("TALLER 1\n");

        // ================================
        // Ejercicio Práctico 1: Modelado de una Clase Simple
        // ================================
        System.out.println("Ejercicio Práctico 1: Cuenta Bancaria\n");

        CuentaBancaria cuenta1 = new CuentaBancaria(102030, "Juan Perez", 500000);

        System.out.println("Saldo inicial: $" + cuenta1.consultarSaldo());

        cuenta1.depositar(200000);
        System.out.println("Saldo actual: $" + cuenta1.consultarSaldo());

        cuenta1.retirar(150000);
        System.out.println("Saldo actual: $" + cuenta1.consultarSaldo());


        // ================================
        // Ejercicio Práctico 2: Modelado de una Clase Compleja
        // ================================
        System.out.println("\nEjercicio Práctico 2: Gestión de Libros\n");

        Libro libro1 = new Libro("Cien años de soledad", "Gabriel Garcia Marquez", "12345", 417);
        libro1.prestar();
        libro1.prestar();

        libro1.devolver();

        if (libro1.estaDisponible()) {
            System.out.println("El libro está disponible.");
        } else {
            System.out.println("El libro no está disponible.");
        }


        // ================================
        // Ejercicio Práctico 3: Manejo de Inventario
        // ================================
        System.out.println("\nEjercicio Práctico 3: Inventario\n");

        Producto producto1 = new Producto("Laptop", 101, 10, 2500000);
        producto1.anadirStock(5);
        producto1.reducirStock(3);

        System.out.println("Valor del inventario de Laptop: $" + producto1.calcularValorInventario());


        // ================================
        // Ejercicio Práctico 4: Gestión de Perfumes
        // ================================
        System.out.println("\nEjercicio Práctico 4: Perfumes\n");

        Perfume perfume1 = new Perfume("Scandal", "Jean Paul Gaultier", 100, 450000);

        perfume1.aplicarPerfume(5);
        System.out.println("Cantidad restante: " + perfume1.consultarCantidadRestante() + " ml");

        perfume1.ajustarPrecio(420000);


        // ================================
        // Proyecto Final: Sistema de Reservas de Hotel
        // ================================
        System.out.println("\nProyecto Final: Reservas de Hotel\n");

        ReservaHotel reserva1 = new ReservaHotel("Laura Martinez", "10/05/2026", "15/05/2026", 204);
        ReservaHotel reserva2 = new ReservaHotel("Carlos Gomez", "12/05/2026", "18/05/2026", 305);

        reserva1.nuevaReserva();
        reserva2.nuevaReserva();

        reserva1.consultarReserva();
        reserva2.consultarReserva();

        reserva1.cancelarReserva();
        reserva1.consultarReserva();
    }


    // ================================
    // Clase CuentaBancaria
    // ================================
    static class CuentaBancaria {

        private double saldo;

        public CuentaBancaria(int numeroCuenta, String titular, double saldoInicial) {
            this.saldo = saldoInicial;
        }

        public void depositar(double cantidad) {
            saldo = saldo + cantidad;
            System.out.println("Se depositaron $" + cantidad);
        }

        public void retirar(double cantidad) {
            if (cantidad <= saldo) {
                saldo = saldo - cantidad;
                System.out.println("Se retiraron $" + cantidad);
            } else {
                System.out.println("No hay saldo suficiente.");
            }
        }

        public double consultarSaldo() {
            return saldo;
        }
    }


    // ================================
    // Clase Libro
    // ================================
    static class Libro {

        private String titulo;
        private boolean disponible;

        public Libro(String titulo, String autor, String ISBN, int numeroPaginas) {
            this.titulo = titulo;
            this.disponible = true;
        }

        public void prestar() {
            if (disponible) {
                disponible = false;
                System.out.println("El libro \"" + titulo + "\" ha sido prestado.");
            } else {
                System.out.println("El libro \"" + titulo + "\" no está disponible.");
            }
        }

        public void devolver() {
            disponible = true;
            System.out.println("El libro \"" + titulo + "\" ha sido devuelto.");
        }

        public boolean estaDisponible() {
            return disponible;
        }
    }


    // ================================
    // Clase Producto
    // ================================
    static class Producto {

        private String nombre;
        private int cantidadStock;
        private double precio;

        public Producto(String nombre, int codigo, int cantidadStock, double precio) {
            this.nombre = nombre;
            this.cantidadStock = cantidadStock;
            this.precio = precio;
        }

        public void anadirStock(int cantidad) {
            cantidadStock = cantidadStock + cantidad;
            System.out.println("Se añadieron " + cantidad + " unidades de " + nombre);
        }

        public void reducirStock(int cantidad) {
            if (cantidad <= cantidadStock) {
                cantidadStock = cantidadStock - cantidad;
                System.out.println("Se redujeron " + cantidad + " unidades de " + nombre);
            } else {
                System.out.println("No hay suficiente stock de " + nombre);
            }
        }

        public double calcularValorInventario() {
            return cantidadStock * precio;
        }
    }


    // ================================
    // Clase Perfume
    // ================================
    static class Perfume {

        private String nombre;
        private double capacidad;
        private double precio;

        public Perfume(String nombre, String marca, double capacidad, double precio) {
            this.nombre = nombre;
            this.capacidad = capacidad;
            this.precio = precio;
        }

        public void aplicarPerfume(double cantidad) {
            if (cantidad <= capacidad) {
                capacidad = capacidad - cantidad;
                System.out.println("Se aplicaron " + cantidad + " ml de " + nombre);
            } else {
                System.out.println("No queda suficiente perfume.");
            }
        }

        public double consultarCantidadRestante() {
            return capacidad;
        }

        public void ajustarPrecio(double nuevoPrecio) {
            precio = nuevoPrecio;
            System.out.println("El nuevo precio del perfume es $" + precio);
        }
    }


    // ================================
    // Clase ReservaHotel
    // ================================
    static class ReservaHotel {

        private String nombreCliente;
        private String fechaEntrada;
        private String fechaSalida;
        private int numeroHabitacion;
        private boolean reservaActiva;

        public ReservaHotel(String nombreCliente, String fechaEntrada, String fechaSalida, int numeroHabitacion) {
            this.nombreCliente = nombreCliente;
            this.fechaEntrada = fechaEntrada;
            this.fechaSalida = fechaSalida;
            this.numeroHabitacion = numeroHabitacion;
            this.reservaActiva = false;
        }

        public void nuevaReserva() {
            if (!reservaActiva) {
                reservaActiva = true;
                System.out.println("Reserva creada para " + nombreCliente);
            } else {
                System.out.println("Ya existe una reserva activa.");
            }
        }

        public void cancelarReserva() {
            if (reservaActiva) {
                reservaActiva = false;
                System.out.println("La reserva de " + nombreCliente + " ha sido cancelada.");
            } else {
                System.out.println("No hay reserva activa para cancelar.");
            }
        }

        public void consultarReserva() {
            if (reservaActiva) {
                System.out.println("Cliente: " + nombreCliente);
                System.out.println("Habitación: " + numeroHabitacion);
                System.out.println("Fecha de entrada: " + fechaEntrada);
                System.out.println("Fecha de salida: " + fechaSalida);
            } else {
                System.out.println("No hay reserva activa.");
            }
        }
    }
}
