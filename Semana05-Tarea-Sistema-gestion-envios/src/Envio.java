public class Envio {

    private String codigo;
    private String destinatario;
    private double pesoKg;

    public Envio(
            String codigo,
            String destinatario,
            double pesoKg) {

        this.codigo = codigo;
        this.destinatario = destinatario;
        this.pesoKg = pesoKg;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getDestinatario() {
        return destinatario;
    }

    public double getPesoKg() {
        return pesoKg;
    }

    public double calcularCostoBase() {
        return pesoKg * 10;
    }

    public double calcularCostoFinal() {
        return calcularCostoBase();
    }

    public void mostrarResumen() {
        System.out.println("Código: " + codigo);
        System.out.println("Destinatario: " + destinatario);
        System.out.println("Costo final: Q" + calcularCostoFinal());
    }

    public void mostrarResumen(boolean desglose) {
        mostrarResumen();
    }

}

