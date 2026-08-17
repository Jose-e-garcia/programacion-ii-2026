public class Gato extends Mascota{
    public Gato(String nombre,
                String color,
                int edadMeses,
                String raza,
                double pesoLibras){
        super(nombre, color, edadMeses, raza, pesoLibras);
    }

@override
    public void emitirSonido(){
        System.out.println("¡Miau!");

    }
}
