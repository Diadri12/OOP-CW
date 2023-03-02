package SkinConsultationCenter;

public class Person {
    String name;
    String surname;
    String dateOfBirth;
    String mobileNum;

    public Person(String name, String surname, String dateOfBirth, String mobileNum) {
        this.name = name;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
        this.mobileNum = mobileNum;
    }


    public String getName() {

        return this.name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public String getSurname() {

        return this.surname;
    }

    public void setSurname(String surname) {

        this.surname = surname;
    }

    public String getDateOfBirth() {

        return this.dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {

        this.dateOfBirth = dateOfBirth;
    }

    public String getMobileNum() {

        return this.mobileNum;
    }

    public void setMobileNum(String mobileNum) {

        this.mobileNum = mobileNum;
    }


    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", mobileNum=" + mobileNum +
                '}';
    }
}
