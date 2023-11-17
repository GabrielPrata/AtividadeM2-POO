package Models;

import java.time.LocalDate;

public class Disk extends Item {
    private int Duration;
    private Recorder Recorder;

    //Construtores
    public Disk(int duration, Recorder recorder, int id, String name, LocalDate dateSystemInput, LocalDate publicationDate) {
        super(id, name, dateSystemInput, publicationDate);
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
