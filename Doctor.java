package SkinConsultationCenter;

import java.util.ArrayList;

public class Doctor extends Person  {
     String medLicNum;
     String specialization;

     static ArrayList <Doctor> doctors = new ArrayList<Doctor>();

    public Doctor(String name, String surname, String dateOfBirth, String mobileNum, String medLicNum, String specialization) {
        super(name, surname, dateOfBirth, mobileNum);
        this.name = name;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
        this.mobileNum = mobileNum;
        this.medLicNum = medLicNum;
        this.specialization = specialization;
    }


    public String getMedLicNum() {

        return this.medLicNum;
    }

    public void setMedLicNum(String medLicNum) {

        this.medLicNum = medLicNum;
    }

    public String getSpecialization() {

        return this.specialization;
    }

    public void setSpecialization(String specialization) {

        this.specialization = specialization;
    }

    @Override
    public String toString()
    {
        super.toString();
        return "Doctor{" +
                "medLicNum='" + medLicNum + '\'' +
                ", specialization='" + specialization + '\'' +
                '}';
    }
}
