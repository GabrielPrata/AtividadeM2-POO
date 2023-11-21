package Models;

import java.util.Date;

import Enums.Gender;

public class Magazine extends Item {
    private int Pages;
    private int Edition;
    private PublishingCompany PublishedBy;


    //Construtores
    public Magazine(int pages, int edition, PublishingCompany publishedBy, int id, String name, Date dateSystemInput, Date publicationDate, Gender gender) {
        super(id, name, dateSystemInput, publicationDate, gender);
        Pages = pages;
        Edition = edition;
        PublishedBy = publishedBy;
    }

    //Getters and Setters
    public int getPages() {
        return Pages;
    }


    public void setPages(int pages) {
        Pages = pages;
    }


    public int getEdition() {
        return Edition;
    }


    public void setEdition(int edition) {
        Edition = edition;
    }

    public PublishingCompany getPublishedBy() {
        return PublishedBy;
    }

    public void setPublishedBy(PublishingCompany publishedBy) {
        PublishedBy = publishedBy;
    }

}
