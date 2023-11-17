package Models;

public class Recorder {
    private int Id;
    private String Name;

    //Construtores
    public Recorder(int id, String name) {
        Id = id;
        Name = name;
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

    
}
