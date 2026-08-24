public class EnvioInternacional extends Envio {

    private String paisDestino;

    public EnvioInternacional(
            String codigo,
            String destinatario,
            double pesoKg,
            String paisDestino) {

        super(codigo, destinatario, pesoKg);
        this.paisDestino = paisDestino;
    }

    public String getPaisDestino() {
        return paisDestino;
    }

    @Override
    public double calcularCostoFinal() {
        return calcularCostoBase()
                + 75
                + (calcularCostoBase() * 0.12);
    }

}