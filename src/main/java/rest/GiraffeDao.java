package rest;

import java.util.ArrayList;
import java.util.List;

public class GiraffeDao {
    private List<Patient> giraffes = new ArrayList<>();
    private static GiraffeDao instance = new GiraffeDao();

    private GiraffeDao(){
        Patient melman = new Patient();
        Patient marius = new Patient();
        melman.setName("melman");
        marius.setName("marius");
        giraffes.add(melman);
        giraffes.add(marius);
    }

    public static  GiraffeDao getInstance(){
        return instance;
    }


    public List<Patient> getGiraffes() {
        return giraffes;
    }
}
