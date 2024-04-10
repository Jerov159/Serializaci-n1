package Domain;

import java.io.Serializable;

public class Patient implements Serializable {
    private String name;
    private String lastname;
    private int age;
    private String genre;
    private String address;
    private String phone;
    private String id;

    public Patient(String id, String namePatient, String lastnamePatient, short age, String genre, String address, String phone) {

    }


    public String getId() {
        return id;
    }

    public void setId(int id) {
        this.age = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getId(int id) {
        return id;
    }
}

