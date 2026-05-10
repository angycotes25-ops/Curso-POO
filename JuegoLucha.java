import java.util.Random;
import java.util.Scanner;

public class JuegoLucha {

    // Clase principal de personaje
    static class Personaje {

        String nombre;
        int vida = 100;

        public Personaje(String nombre) {
            this.nombre = nombre;
        }

        public void atacar(Personaje enemigo) {

            Random r = new Random();

            int dano = r.nextInt(20) + 10;

            enemigo.vida = enemigo.vida - dano;

            if (enemigo.vida < 0) {
                enemigo.vida = 0;
            }

            System.out.println(nombre + " hizo " + dano + " de daño");
        }

        public boolean vivo() {

            if (vida > 0) {
                return true;
            } else {
                return false;
            }
        }
    }

    // Clase Guerrero
    static class Guerrero extends Personaje {

        public Guerrero(String nombre) {
            super(nombre);
        }

        public void atacar(Personaje enemigo) {

            Random r = new Random();

            int dano = r.nextInt(15) + 20;

            enemigo.vida = enemigo.vida - dano;

            if (enemigo.vida < 0) {
                enemigo.vida = 0;
            }

            System.out.println("Guerrero " + nombre + " atacó con espada e hizo " + dano);
        }
    }

    // Clase Mago
    static class Mago extends Personaje {

        public Mago(String nombre) {
            super(nombre);
        }

        public void atacar(Personaje enemigo) {

            Random r = new Random();

            int dano = r.nextInt(25) + 5;

            enemigo.vida = enemigo.vida - dano;

            if (enemigo.vida < 0) {
                enemigo.vida = 0;
            }

            System.out.println("Mago " + nombre + " lanzó hechizo e hizo " + dano);
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("===== JUEGO DE LUCHA =====");

        // Jugador 1
        System.out.print("Nombre jugador 1: ");
        String nombre1 = sc.nextLine();

        System.out.println("1. Guerrero");
        System.out.println("2. Mago");
        System.out.print("Seleccione tipo: ");
        int tipo1 = sc.nextInt();
        sc.nextLine();

        // Jugador 2
        System.out.print("Nombre jugador 2: ");
        String nombre2 = sc.nextLine();

        System.out.println("1. Guerrero");
        System.out.println("2. Mago");
        System.out.print("Seleccione tipo: ");
        int tipo2 = sc.nextInt();

        Personaje jugador1;
        Personaje jugador2;

        // Crear personaje jugador 1
        if (tipo1 == 1) {
            jugador1 = new Guerrero(nombre1);
        } else {
            jugador1 = new Mago(nombre1);
        }

        // Crear personaje jugador 2
        if (tipo2 == 1) {
            jugador2 = new Guerrero(nombre2);
        } else {
            jugador2 = new Mago(nombre2);
        }

        System.out.println("\nINICIA LA PELEA");

        // Pelea
        while (jugador1.vivo() && jugador2.vivo()) {

            System.out.println("\nTurno de " + jugador1.nombre);
            jugador1.atacar(jugador2);

            System.out.println("Vida de " + jugador2.nombre + ": " + jugador2.vida);

            if (jugador2.vivo()) {

                System.out.println("\nTurno de " + jugador2.nombre);
                jugador2.atacar(jugador1);

                System.out.println("Vida de " + jugador1.nombre + ": " + jugador1.vida);
            }
        }

        // Ganador
        System.out.println("\n===== RESULTADO =====");

        if (jugador1.vivo()) {
            System.out.println("Ganó " + jugador1.nombre);
        } else {
            System.out.println("Ganó " + jugador2.nombre);
        }

        sc.close();
    }
}