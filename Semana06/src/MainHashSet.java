import java.util.HashSet;

public class MainHashSet {

    public static void main(String[] args){
        HashSet<String> correos = new HashSet<>();

        correos.add("dalvarez@miumg.edu.gt");
        correos.add("jvaldez@miumg.edu.gt");
        correos.add("dalvarez@miumg.edu.gt");

        for (String correo: correos){

                System.out.println(correo);
        }
    }
}
