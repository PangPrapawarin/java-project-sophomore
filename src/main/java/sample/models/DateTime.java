package sample.models;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTime {
    private String time;
    private LocalDateTime localDateTime = LocalDateTime.now();
    private DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/mm/yyyy hh:mm:ss");

    public void addTime() {
        this.time = dateTimeFormatter.format(localDateTime);
    }

    public String getTime() {
        return time;
    }
}
