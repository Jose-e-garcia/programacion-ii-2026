public class EnvioNacional extends Envio {

    private String departamento;
    private double distanciaKm;

    public EnvioNacional(
            String codigo,
            String destinatario,
            double pesoKg,
            String departamento,
            double distanciaKm) {

        super(codigo, destinatario, pesoKg);
        this.departamento = departamento;
        this.distanciaKm = distanciaKm;
    }

    public String getDepartamento() {
        return departamento;
    }

    public double getDistanciaKm() {
        return distanciaKm;
    }

    @Override
    public double calcularCostoFinal() {
        return calcularCostoBase() + (distanciaKm * 0.50);
    }

}