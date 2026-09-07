public class Excepciones {

    public static void main(String[] args) {
        System.out.println("Inicio");

        try {
            int edad = Integer.parseInt("hola");
            int resultado = edad / 0;

        } catch (NumberFormatException e) {
            System.out.println("Error al ingresar");

        } catch (ArithmeticException e) {
            System.out.println("Division entre 0");

        } catch (Exception e) {
            System.out.println("Error genérico");
        }

        System.out.println("Fin");
    }
}