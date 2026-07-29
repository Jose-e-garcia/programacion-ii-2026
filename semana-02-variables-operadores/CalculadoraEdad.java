//Se le dice a java que se utilizará Scanner para leer los datos que ingrese el usuario
import java.util.Scanner;

public class CalculadoraEdad {
    public static void main(String[] args){

        //Se crea un scanner para leer lo que ingrese el usuario en pantalla
        Scanner entrada = new Scanner(System.in);

        //Primero se solicitan los datos de la persona y datos para cálculo
        // Cada dato que se solicita es guardado en la variable según su tipo (string o int)

        System.out.println("Por favor, ingrese nombre y apellido: ");
        String nombreYapellido = entrada.nextLine();

        System.out.println("Ingrese el año de nacimiento: ");
        int anioNacimiento = entrada.nextInt();

        System.out.println("Ingrese el año actual");
        int anioActual =entrada.nextInt();

        // Acá es donde se hace el cálculo por medio de resta de años
        // Se crean las variables que servirán para dicho cálculo
        // En el caso de el valor booleano, valida si es o no alguien mayor de edad

        int edadAproximada = anioActual-anioNacimiento;
        int EdadenMeses = edadAproximada*12;
        boolean esMayordeEdad = edadAproximada>=18;


        // Se muestra al usuario el resultado en pantalla

        System.out.println("---- RESULTADO ----");
        System.out.println("Nombre: " + nombreYapellido);
        System.out.println("Edad aproximada: " + edadAproximada + " años");
        System.out.println("Edad aproximada en meses: " + EdadenMeses + " meses");
        System.out.println("Es mayor de edad (True / False): " + esMayordeEdad);

        // JOSE ERNESTO GARCIA 9941-10-13121
    }
}
