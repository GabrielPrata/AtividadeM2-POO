package Models;

import java.util.Date;

import Enums.Gender;

public class Disk extends Item {
    private int Duration;
    private Recorder Recorder;

    //Construtores
    public Disk(int duration, Recorder recorder, int id, String name, Date dateSystemInput, Date publicationDate, Gender gender) {
        super(id, name, dateSystemInput, publicationDate, gender);
        Duration = duration;
        Recorder = recorder;
    }

    //Getters and Setters
    public int getDuration() {
        return Duration;
    }

    public void setDuration(int duration) {
        Duration = duration;
    }

    public Recorder getRecorder() {
        return Recorder;
    }

    public void setRecorder(Recorder recorder) {
        Recorder = recorder;
    }

    
}
