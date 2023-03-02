package SkinConsultationCenter;

import java.io.*;
import java.util.*;

public class WestminsterSkinConsultationManager implements SkinConsultationManager {

    static ArrayList<Doctor> doctors = new ArrayList<Doctor>();
   static ArrayList<Consultation> consultations = new ArrayList<Consultation>();
   Scanner Sc = new Scanner(System.in);
   public WestminsterSkinConsultationManager() {

   }
    @Override
    public void addDoc(Doctor doctor) {
       this.doctors.add(doctor);
    }

    @Override
    public void deleteDoc(Doctor doctor) {
        this.doctors.remove(doctor);
    }

    @Override
    public void addConsultation(Consultation consultation){
        this.consultations.add(consultation);
    }

    @Override
    public void removeConsultation(Consultation consultation){
        this.consultations.remove(consultation);
    }


    @Override
    public void printConsultationList(){
        for(Consultation consultation:this.consultations){
            System.out.println(consultation);
        }
    }

    //Method to Add Doctors
    public void addDoc() {
       doctors.add(new Doctor("Saman", "Hettiarachchi","08/11/1995", "0775967845","MED1234", "Cosmetic Dermatology"));
        doctors.add(new Doctor("Lahiru", "Perera","05/12/1980", "0775967845","MED1234", "Cosmetic Dermatology"));
        doctors.add(new Doctor("Anne", "Mary","09/12/1990", "0775967845","MED1234", "Cosmetic Dermatology"));
        doctors.add(new Doctor("Harry", "Potter","08/11/1985", "0775967845","MED1234", "Cosmetic Dermatology"));
        doctors.add(new Doctor("Sammy", "Mail","12/09/1990", "0775967845","MED1234", "Cosmetic Dermatology"));

        System.out.println("Enter the first name of Doctor");
        String name = Sc.nextLine();
       System.out.println("Enter the last name of Doctor");
       String surname = Sc.nextLine();
       System.out.println("Enter the DOB of Doctor");
        String DOB = Sc.nextLine();
       System.out.println("Enter the medical license number of Doctor");
        String medLicNum = Sc.nextLine();
       System.out.println("Enter the specialization of Doctor");
        String specialization = Sc.nextLine();
       System.out.println("Enter the mobile number of Doctor");
       String mobileNum = Sc.nextLine();
       doctors.add(new Doctor(name,surname,DOB,mobileNum,medLicNum,specialization));
    }

    //Method to Delete Doctors
    public void deleteDoc() {
       System.out.println("Enter the medical license number");
       String medLicNumber = this.Sc.next();

       Doctor doctor = null;
       for(Doctor doc: this.doctors){
           if(doc.getMedLicNum().equals(medLicNumber)){
               doctor = doc;
               break;
           }
       }
       if(doctor == null){
           System.out.println("The doctor with the specified Medical License Number is not found");
       }else{
           this.doctors.remove(doctor);
           System.out.println("Name: " + doctor.getName() + " " + doctor.getSurname() + " holding license number" + doctor.getMedLicNum() + "has been removed");
           System.out.println("The Consultation center now has" + this.doctors.size() + "doctors");
       }
    }

    //Method to Print Doctors
    public void printDocList(){
      Collections.sort(doctors,new Comparator<Doctor>() {
          public int compare(Doctor o1, Doctor o2) {
            return o1.getSurname().compareTo(o2.getSurname());
          }
     });

      for(Doctor doctor: doctors){
         System.out.println("Doctor name: " + doctor.getName() + " " + doctor.getSurname());
         System.out.println("Medical license number: " + doctor.getMedLicNum());
         System.out.println("Date of Birth: " + doctor.getDateOfBirth());
         System.out.println("Specialization: " + doctor.getSpecialization());
         System.out.println("Mobile Number: " + doctor.getMobileNum());

       }
    }

    //Method to Save Information in file
    public void SaveInFile(){
        try{
            FileOutputStream writeData = new FileOutputStream("Consultations.txt");
            ObjectOutputStream writeStream = new ObjectOutputStream(writeData);

            writeStream.writeObject(doctors);
            writeStream.flush();
            writeStream.close();

        }catch (IOException e) {
            e.printStackTrace();
        }

        try{
            FileInputStream readData = new FileInputStream("Consultations.txt");
            ObjectInputStream readStream = new ObjectInputStream(readData);

            ArrayList<Doctor> doctors1 = (ArrayList<Doctor>) readStream.readObject();
            readStream.close();
            System.out.println(doctors1.toString());
        }catch (Exception e) {
            e.printStackTrace();
        }

    }


    //Console Menu
    public static void main(String[] args) {
        do {
            Scanner sc2 = new Scanner(System.in);
            WestminsterSkinConsultationManager W = new WestminsterSkinConsultationManager();
            System.out.println("Welcome to The Skin Consultation Center");
            System.out.println("Please follow the following instructions");
            System.out.println("A - Add a new doctor");
            System.out.println("D - Delete a doctor");
            System.out.println("P - Print the list of doctors");
            System.out.println("S - Save all in file");
            System.out.println("G - Display the GUI");
            System.out.println("Please select one instruction: ");
            String selection = sc2.next();
            switch (selection) {
                case "A":
                    System.out.println("Enter doctor details");
                    W.addDoc();
                    break;
                case "D":
                    System.out.println("Enter License Number");
                    W.deleteDoc();
                    break;
                case "P":
                    System.out.println("Displaying all Doctor Information");
                    W.printDocList();
                    break;
                case "S":
                    System.out.println("Saving all information in file");
                    W.SaveInFile();
                    break;
                case "G":
                    System.out.println("This is the GUI for Skin Consultation System");
                    TestGUI testGUI = new TestGUI();
                    testGUI.TestGUI();
                    break;
                default:
                    System.out.println("You have inserted a wrong character" +
                            " \n Please enter again");
            }
        }while (true) ;
    }
}
