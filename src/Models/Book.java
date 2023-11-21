package Models;

import java.util.Date;

import Enums.Gender;

public class Book extends Item {
    private int Pages;
    private Author Author;
    private PublishingCompany PublishedBy;


    //Construtores
    public Book(int pages, Author author, PublishingCompany publishedBy, int id, String name, Date dateSystemInput, Date publicationDate, Gender gender) {
        super(id, name, dateSystemInput, publicationDate, gender);
        Pages = pages;
        Author = author;
        PublishedBy = publishedBy;
    }

    //Getters and Setters
    public int getPages() {
        return Pages;
    }

    public void setPages(int pages) {
        Pages = pages;
    }

    public Author getAuthor() {
        return Author;
    }

    public void setAuthor(Author author) {
        Author = author;
    }

    public PublishingCompany getPublishedBy() {
        return PublishedBy;
    }

    public void setPublishedBy(PublishingCompany publishedBy) {
        PublishedBy = publishedBy;
    }

    
    
}
