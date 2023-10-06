package common;

import java.util.ArrayList;
import java.util.List;
import model.Doctor;

public class DoctorCRUD extends ArrayList<Doctor> {

    Library library = new Library();

    public void create() {
        String code = library.getString("Input code of doctor: ");
        String name = library.getString("Input name of doctor: ");
        String specialization = library.getString("Input specialization of doctor: ");
        int availability = library.getInt("Input availability of doctor: ");
        this.add(new Doctor(code, name, specialization, availability));
    }

    public void detele(String doctorCode) {
        try {
            for (Doctor doctor : this) {
                if (doctor.getCode().equalsIgnoreCase(doctorCode)) {
                    this.remove(doctor);
                } else {
                    System.out.println("Candidate Id not found to remove");
                }
            }
        } catch (Exception e) {
        }

    }

    public void update(String doctorCode) {
        for (Doctor doctor : this) {
            if (doctor.getCode().equalsIgnoreCase(doctorCode)) {
                String name = library.getString("Input name of doctor to update: ");
                doctor.setName(name);
                String specialization = library.getString("Input specialization of doctor to update: ");
                doctor.setSpecialization(specialization);
                int availability = library.getInt("Input availability of doctor to update: ");
                doctor.setAvailability(availability);
                
            }
        }
    }

    public List<Doctor> search(String specialization) {
        List<Doctor> result = new ArrayList<>();
        for (Doctor doctor : this) {
            if (doctor.getSpecialization().contains(specialization)) {
                result.add(doctor);
            }
        }
        return result;
    }

    public void display() {
        System.out.format("%8s%16s%16s%16s", "Code", "Name", "Specialization", "Availability");
        for (Doctor doctor : this) {
            System.out.format("%8s%16s%16s%16d", doctor.getCode(), doctor.getName(), doctor.getSpecialization(), doctor.getAvailability());
        }
    }
    
    public void display(List<Doctor> list) {
        System.out.format("%8s%16s%16s%16s\n", "Code", "Name", "Specialization", "Availability");
        for (Doctor doctor : list) {
            System.out.format("%8s%16s%10s%16d\n", doctor.getCode(), doctor.getName(), doctor.getSpecialization(), doctor.getAvailability());
        }
    }

}
