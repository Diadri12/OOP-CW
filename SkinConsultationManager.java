package SkinConsultationCenter;

public interface SkinConsultationManager {
    public void addDoc();

    public void addDoc(Doctor doctor);

    public void deleteDoc();

    public void deleteDoc(Doctor doctor);

    public void addConsultation(Consultation consultation);

    public void removeConsultation(Consultation consultation);

    public void printDocList();

    public void printConsultationList();

    public void SaveInFile();

}
