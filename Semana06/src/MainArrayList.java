
import java.security.MessageDigest;
import java.util.ArrayList;
public class MainArrayList {

    public static void main (String[] args){

        ArrayList<String> estudiantes = new ArrayList<>();

        estudiantes.add("Ana");
        estudiantes.add("Benito");
        estudiantes.add("Daniel");
        estudiantes.add("Ana");
        estudiantes.add("David");


        for (String estudiante : estudiantes){
            System.out.println(estudiante);
        }
System.out.println(estudiantes);
    }
}
