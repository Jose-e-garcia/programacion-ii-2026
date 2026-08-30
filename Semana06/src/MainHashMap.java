
import java.awt.*;
import java.util.HashMap;
public class MainHashMap {

    public static void main(String[] args){

        HashMap< String, Double> preciosMascota = new HashMap<>();

        preciosMascota.put("PET-001", 150.00);
        preciosMascota.put("PET-002", 380.00);
        preciosMascota.put("PET-003", 450.00);

        String codigoMascota = "PET-001";

        if(preciosMascota.containsKey(codigoMascota)){
            System.out.println(preciosMascota.get(codigoMascota));
        }

        System.out.println(preciosMascota.get("PET-005"));
    }
}
