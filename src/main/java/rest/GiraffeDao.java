package rest;

import java.util.ArrayList;
import java.util.List;

public class GiraffeDao {
    private List<Patient> giraffes = new ArrayList<>();
    private static GiraffeDao instance = new GiraffeDao();


    public static  GiraffeDao getInstance(){
        return instance;
    }


    public List<Patient> getGiraffes() {
        return giraffes;
    }

}
