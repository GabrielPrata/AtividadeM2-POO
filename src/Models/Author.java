package Models;

public class Author {
    private int Id;
    private String Name;


    //Constructors
    public Author(int id, String name) {
        Id = id;
        Name = name;
    }


    //Getters and Setters
    public void setId(int id) {
        Id = id;
    }

    public void setName(String name) {
        Name = name;
    }

    
    
}
