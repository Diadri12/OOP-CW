package SkinConsultationCenter;

public class Patient extends Person {
    int patientID;


    Patient(String name, String surname, String dateOfBirth, String mobileNum, int patientID) {
        super(name, surname, dateOfBirth, mobileNum);
    }

    public int getPatientID() {

        return this.patientID;
    }

    public void setPatientID(int patientID) {

        this.patientID = patientID;
    }
}
