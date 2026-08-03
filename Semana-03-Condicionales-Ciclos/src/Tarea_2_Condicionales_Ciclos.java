import java.util.Scanner;
public class Tarea_2_Condicionales_Ciclos {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion = 0;

        //Personalización obligatoria, datos de estudiante
        System.out.println("Estudiante: José Ernesto García");
        System.out.println("Carnet: 9941-10-13121");
        System.out.println("Semana 3 - Condiciones y Ciclos");

        System.out.println("\n ==== DESAFÍOS LÓGICOS ==== \n");
        //Ciclo do while que controla el Menú principal
        do {
            System.out.println("1. Generar una secuencia");
            System.out.println("2. Realizar un conteo reresivo");
            System.out.println("3. Analizar números");
            System.out.println("4. Dibujar una pirámide");
            System.out.println("5. Validar palabra secreta");
            System.out.println("6. Salir");
            System.out.println("Seleccione una opción: ");

            opcion = scanner.nextInt();

            //Esta es la estructura switch para las opciones del menú
            switch (opcion) {

                //generar una secuencia
                case 1:
                    System.out.println("\n GENERAR SECUENCIA ");
                    System.out.println("ingrese numero inicial: ");
                    int numInicio = scanner.nextInt();

                    System.out.println("ingrese numero final: ");
                    int numFinal = scanner.nextInt();

                    System.out.println("ingrese incremento: ");
                    int incremento = scanner.nextInt();

                    // if / else para la Validación
                    if (incremento <= 0) {
                        System.out.println("Error: el incremento debe ser mayor que cero");
                    } else if (numFinal <= numInicio) {
                        System.out.println("Error: el numero final debe ser mayor que el inicial");
                    } else {
                        System.out.print("resultado: ");

                        // Ciclo for para procesar la secuencia
                        for (int i = numInicio; i <= numFinal; i += incremento) {
                            System.out.print(i + " ");
                        }
                        System.out.println();
                    }
                    break;

                //Opción para realizar un conteo regresivo
                case 2:
                    System.out.println("\n CONTEO REGRESIVO ");
                    System.out.println("ingrese el numero inicial entre 10 y 50: ");
                    int numConteo = scanner.nextInt();

                    //ciclo while para pedir el numero de nuevo si es que no cumple con el rango
                    while (numConteo < 10 || numConteo > 50) {
                        System.out.println("numero fuera de rango. Debe estar entre 10 y 50");
                        System.out.print("ingrese el numero inicial nuevamente: ");
                        numConteo = scanner.nextInt();
                    }

                    System.out.print("Resultado: ");
                    //ciclo while para el conteo regresivo
                    while (numConteo >= 0) {
                        System.out.print(numConteo + " ");
                        numConteo--;
                    }
                    System.out.println("\n ¡ Despegue !");
                    break;

                case 3:
                    System.out.println("\nANALIZAR NUMEROS");
                    int positivos = 0;
                    int negativos = 0;
                    int sumaValida = 0;
                    int ignorados = 0;

                    // Este es el iclo while para lectura de numeros indefinida
                    while (true) {
                        System.out.print("ingrese un numero: ");
                        int num = scanner.nextInt();

                        if (num == 0) {
                            break;
                        }

                        if (num % 5 == 0) {
                            System.out.println("El numero " + num + " fue ignorado");
                            ignorados++;
                            continue;
                        }

                        if (num > 0) {
                            positivos++;
                        } else {
                            negativos++;
                        }
                        sumaValida += num;
                    }

                    System.out.println("\nResultado: ");
                    System.out.println("positivos: " + positivos);
                    System.out.println("negativos: " + negativos);
                    System.out.println("suma valida:" + sumaValida);
                    System.out.println("numeros ignorados:" + ignorados);
                    break;

                case 4:
                    System.out.println("\n DIBUJAR PIRÁMIDE ");
                    System.out.println("\n ingrese la altura. Debe ser entre 3 y 10: ");
                    int altura = scanner.nextInt();

                    //Validación de la altua con ciclo while
                    while (altura < 3 || altura > 10) {
                        System.out.println("Altura invalida. debe estar entre 3 y 10");
                        System.out.print("ingrese la altura nuevamente");
                        altura = scanner.nextInt();
                    }

                    System.out.println("Resultado: ");
                    //Se utiliza ciclo for anidado para dibujar la pirámide
                    for (int i = 1; i <= altura; i++) {
                        //ciclo interno 1: imprime espacios en blanco
                        for (int j = 1; j <= altura - i; j++) {
                            System.out.print(" ");
                        }
                        //ciclo interno 2: imprimir asteriscos
                        for (int k = 1; k <= (2 * i -1); k++){
                            System.out.print("*");
                        }
                        //saltar la linea por cada nivel de la piramide
                        System.out.println();
                    }
                    break;

                case 5:
                    System.out.println("\n VALIDAR PALABRA SECRETA ");
                    //Se limpia el buffer del Scanner antes de leer las líneas de texto
                    scanner.nextLine();

                    String intento = "";
                    String palabraObjetivo = "Guatemala";

                    //Se utiliza ciclo do-while para solicitar la palabra hasta que sea correcta
                    do {
                        System.out.print("ingrese la palabra secreta: ");
                        intento = scanner.nextLine();

                        //eliminar espacios en extremos
                        if (intento.trim().equalsIgnoreCase(palabraObjetivo)) {
                            System.out.println("palabra correcta");
                            break;
                        } else {
                            System.out.println("palabra incorrecta. intente de nuevo \n");
                        }
                    } while (true);
                    break;

                //salir del programa
                case 6:
                    System.out.println("\n PROGRAMA FINALIZADO CORRECTAMENTE ");
                    break;

                //validar opción no existente en el menu
                default:
                    System.out.println("\nopcion no valida. Intente de nuevo");
                    break;

            }

            System.out.println(); //espacio para separar repeticiones del menu

        } while (opcion != 6);

        scanner.close();

    }
}