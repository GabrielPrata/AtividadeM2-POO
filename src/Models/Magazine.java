package Models;

import java.time.LocalDate;

public class Magazine extends Item {
    private int Pages;
    private int Edition;
    private PublishingCompany PublishedBy;


    //Construtores
    public Magazine(int pages, int edition, PublishingCompany publishedBy, int id, String name, LocalDate dateSystemInput, LocalDate publicationDate) {
        super(id, name, dateSystemInput, publicationDate);
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
