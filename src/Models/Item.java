package Models;

import java.time.LocalDate;

abstract class Item {
    private int Id;
    private String Name;
    private LocalDate DateSystemInput;
    private LocalDate PublicationDate;

    
    //Construtores
    public Item(int id, String name, LocalDate dateSystemInput, LocalDate publicationDate) {
        Id = id;
        Name = name;
        DateSystemInput = dateSystemInput;
        PublicationDate = publicationDate;
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
    public LocalDate getDateSystemInput() {
        return DateSystemInput;
    }
    public void setDateSystemInput(LocalDate dateSystemInput) {
        DateSystemInput = dateSystemInput;
    }
    public LocalDate getPublicationDate() {
        return PublicationDate;
    }
    public void setPublicationDate(LocalDate publicationDate) {
        PublicationDate = publicationDate;
    }
}
