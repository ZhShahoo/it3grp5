package rest;

import java.util.ArrayList;
import java.util.List;

public class PatientDAO {
    private List<Patient> patient = new ArrayList<>();
    private static PatientDAO instance = new PatientDAO();


    public static PatientDAO getInstance(){
        return instance;
    }


    public List<Patient> getPatienter() {
        return patient;
    }

}
