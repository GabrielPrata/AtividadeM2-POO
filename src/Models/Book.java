package Models;

import java.time.LocalDate;

public class Book extends Item {
    private int Pages;
    private Author Author;
    private PublishingCompany PublishedBy;


    //Construtores
    public Book(int pages, Author author, PublishingCompany publishedBy, int id, String name, LocalDate dateSystemInput, LocalDate publicationDate) {
        super(id, name, dateSystemInput, publicationDate);
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
