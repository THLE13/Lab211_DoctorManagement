
package controller;


import common.DoctorCRUD;
import common.Library;
import view.Menu;


public class DoctorManagement extends Menu<String> {

    static String[] mc = {"Add a doctor", "Update a doctor", "Remove a doctor", "Search doctor(s)", "Exit"};

    protected Library library;
    protected DoctorCRUD doctorCrud;

    public DoctorManagement() {
        super("===== DOCTOR MANAGEMENT =====", mc);
        library = new Library();
        doctorCrud = new DoctorCRUD();
    }

    @Override
    public void execute(int n) {
        
        switch (n) {
            case 1:
                doctorCrud.create();
                break;
            case 2:
                String codeUpdate = library.getString("Input code of doctor to update: ");
                doctorCrud.update(codeUpdate);
                break;
            case 3:
                String codeDelete = library.getString("Input code of doctor to delete: ");
                doctorCrud.detele(codeDelete);
                break;
            case 4:
                String specializationSearch = library.getString("Input name of doctor to search: ");
                if(doctorCrud.search(specializationSearch).isEmpty()) {
                    System.out.println("Not found!");
                } else {
                    doctorCrud.display(doctorCrud.search(specializationSearch));
                }
                break;
            case 5:
                System.exit(0);
            default:
                System.out.println("Your choice invalid! Pls input another choice");
        }
    }
}
