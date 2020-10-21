package sample.models;

public class Mails {
    private String nameReceiver;
    private String surnameReceiver;
    private String roomNumber;
    private String nameSender;
    private String surnameSender;
    private String size;
    private Object photo;
    private String date;

    public String getNameReceiver() {
        return nameReceiver;
    }
    public void setNameReceiver(String nameReceiver) {
        this.nameReceiver = nameReceiver;
    }
    public String getRoomNumber() {
        return roomNumber;
    }
    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }
    public String getNameSender() {
        return nameSender;
    }
    public void setNameSender(String nameSender) {
        this.nameSender = nameSender;
    }
    public String getSize() {
        return size;
    }
    public Object getPhoto() {
        return photo;
    }
    public void setPhoto(Object photo) {
        this.photo = photo;
    }
}
