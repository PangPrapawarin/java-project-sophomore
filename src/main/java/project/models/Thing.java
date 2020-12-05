package project.models;

import java.util.ArrayList;

public class Thing {
    private String date;
    private String type;
    private String from;
    private String nameSender;
    private String nameReceiver;
    private String roomNumber;
    private String staffName;
    private String size;
    private String service;
    private String trackingNumber;
    private String important;

    public Thing(String type, String from, String nameSender, String nameReceiver, String roomNumber, String date, String staffName, String size, String service, String trackingNumber, String important) {
        this.type = type;
        this.from = from;
        this.nameSender = nameSender;
        this.nameReceiver = nameReceiver;
        this.roomNumber = roomNumber;
        this.date = date;
        this.staffName = staffName;
        this.size = size;
        this.service = service;
        this.trackingNumber = trackingNumber;
        this.important = important;
    }

    public String getType() {
        return type;
    }

    public String getService() {
        return service;
    }

    public String getTrackingNumber() {
        return trackingNumber;
    }

    public String getImportant() {
        return important;
    }

    public String getFrom() {
        return from;
    }

    public String getNameSender() {
        return nameSender;
    }

    public String getNameReceiver() {
        return nameReceiver;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public String getDate() {
        return date;
    }

    public String getStaffName() {
        return staffName;
    }

    public String getSize() {
        return size;
    }

    public void setDate(String time) {
        date = time;
    }
}
