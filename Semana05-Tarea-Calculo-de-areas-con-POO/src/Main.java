public class Main {

    public static void main(String[] args) {

        Circulo circulo = new Circulo("Círculo", 5);
        Rectangulo rectangulo = new Rectangulo("Rectángulo", 8, 5);
        Triangulo triangulo = new Triangulo("Triángulo", 10, 5);

        Figura[] figuras = {circulo, rectangulo, triangulo};

        for (Figura figura : figuras) {

            figura.mostrarInformacion();
            System.out.printf("Área: %.2f%n", figura.calcularArea());

        }

    }

}