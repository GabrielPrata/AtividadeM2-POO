package Models;

import java.util.Date;

import Enums.Gender;

abstract class Item {
    private int Id;
    private String Name;
    private Date DateSystemInput;
    private Date PublicationDate;
    private Gender Gender;

    
    //Construtores
    public Item(int id, String name, Date dateSystemInput, Date publicationDate, Gender gender) {
        Id = id;
        Name = name;
        DateSystemInput = dateSystemInput;
        PublicationDate = publicationDate;
        Gender = gender;
    }

    //Getters and Setters
    public int getId() {
        return Id;
    }
    public void setId(int id) {
        Id = id;
    }
    public String getName() {
        return Name;
    }
    public void setName(String name) {
        Name = name;
    }
    public Date getDateSystemInput() {
        return DateSystemInput;
    }
    public void setDateSystemInput(Date dateSystemInput) {
        DateSystemInput = dateSystemInput;
    }
    public Date getPublicationDate() {
        return PublicationDate;
    }
    public void setPublicationDate(Date publicationDate) {
        PublicationDate = publicationDate;
    }

    public Gender getGender() {
        return Gender;
    }

    public void setGender(Gender gender) {
        Gender = gender;
    }

}
