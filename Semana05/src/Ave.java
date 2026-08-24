public class Ave extends Mascota{
    private String tipo;

    public Ave (
            String nombre,
            String color,
            int edadMeses,
            String tipo,
            double pesokg) {

        super(color, edadMeses, tipo, pesokg);
    }

    //Getters
    public String getTipo(){
        return tipo;
    }

    //Setters
    public void setTipo(String tipo){
        this.tipo = tipo;
    }

    public void emitirSonido(){
        System.out.println("¡Pio pio!");
    }
}
