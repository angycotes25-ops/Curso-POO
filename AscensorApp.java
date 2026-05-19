import java.util.Scanner;

public class AscensorApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Ascensor ascensor = new Ascensor();

        System.out.println("====== SISTEMA DE ASCENSOR ======");

        // PERSONA 1
        System.out.print("\nPiso actual de la Persona 1: ");
        int piso1 = sc.nextInt();

        System.out.print("Destino de la Persona 1: ");
        int destino1 = sc.nextInt();

        Persona persona1 = new Persona("Persona 1", piso1, destino1);

        // PERSONA 2
        System.out.print("\nPiso actual de la Persona 2: ");
        int piso2 = sc.nextInt();

        System.out.print("Destino de la Persona 2: ");
        int destino2 = sc.nextInt();

        Persona persona2 = new Persona("Persona 2", piso2, destino2);

        // PERSONA 1 LLAMA EL ASCENSOR
        System.out.println("\n" + persona1.nombre + " llamó el ascensor en el piso " + persona1.pisoActual);

        ascensor.mover(persona1.pisoActual);

        System.out.println("\nAscensor detenido en piso " + ascensor.pisoActual);

        ascensor.puerta.abrir();

        System.out.println(persona1.nombre + " entró al ascensor");

        ascensor.puerta.cerrar();

        ascensor.boton.presionar();

        System.out.println(persona1.nombre + " seleccionó el piso " + persona1.destino);

        // ASCENSOR EMPIEZA A SUBIR
        while(ascensor.pisoActual < persona1.destino){

            ascensor.subirUno();

            // PERSONA 2 PIDE EL ASCENSOR
            if(ascensor.pisoActual == persona2.pisoActual){

                System.out.println("\n" + persona2.nombre + " solicitó el ascensor");

                ascensor.puerta.abrir();

                System.out.println(persona2.nombre + " entró al ascensor");

                ascensor.puerta.cerrar();

                ascensor.boton.presionar();

                System.out.println(persona2.nombre + " seleccionó el piso " + persona2.destino);
            }
        }

        // PERSONA 1 BAJA
        if(ascensor.pisoActual == persona1.destino){

            System.out.println("\nAscensor llegó al piso " + persona1.destino);

            ascensor.puerta.abrir();

            System.out.println(persona1.nombre + " salió del ascensor");

            ascensor.puerta.cerrar();
        }

        // LLEVAR PERSONA 2
        ascensor.mover(persona2.destino);

        System.out.println("\nAscensor llegó al piso " + persona2.destino);

        ascensor.puerta.abrir();

        System.out.println(persona2.nombre + " salió del ascensor");

        ascensor.puerta.cerrar();

        sc.close();
    }
}

class Ascensor {

    int pisoActual;
    String estado;

    // COMPOSICION
    Puerta puerta = new Puerta();
    Motor motor = new Motor();

    // AGREGACION
    Sensor sensor = new Sensor();

    // HERENCIA
    BotonAscensor boton = new BotonAscensor();

    public Ascensor(){

        pisoActual = 1;
        estado = "Detenido";
    }

    public void mover(int destino){

        if(destino > pisoActual){

            while(pisoActual < destino){

                subirUno();
            }

        }else if(destino < pisoActual){

            while(pisoActual > destino){

                bajarUno();
            }
        }

        estado = "Detenido";
    }

    public void subirUno(){

        estado = "Subiendo";

        motor.encender();

        pisoActual++;

        System.out.println("Ascensor subiendo al piso " + pisoActual);

        pausa();
    }

    public void bajarUno(){

        estado = "Bajando";

        motor.encender();

        pisoActual--;

        System.out.println("Ascensor bajando al piso " + pisoActual);

        pausa();
    }

    public void pausa(){

        try{

            Thread.sleep(1000);

        }catch(Exception e){

            System.out.println("Error");
        }
    }
}

class Persona {

    String nombre;
    int pisoActual;
    int destino;

    public Persona(String nombre, int pisoActual, int destino){

        this.nombre = nombre;
        this.pisoActual = pisoActual;
        this.destino = destino;
    }
}

class Puerta {

    boolean abierta;

    public void abrir(){

        abierta = true;

        System.out.println("Puertas abiertas");
    }

    public void cerrar(){

        abierta = false;

        System.out.println("Puertas cerradas");
    }
}

class Motor {

    boolean encendido;

    public void encender(){

        encendido = true;
    }

    public void apagar(){

        encendido = false;
    }
}

class Sensor {

    boolean detectar;

    public boolean detectarPersona(){

        return detectar;
    }
}

class Boton {

    boolean activo;

    public void presionar(){

        activo = true;

        System.out.println("Botón presionado");
    }
}

// HERENCIA
class BotonAscensor extends Boton {

}