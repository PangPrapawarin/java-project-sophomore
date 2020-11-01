package project.models.things;

import java.util.ArrayList;

public class ThingsList {
    private ArrayList<CreateThings> things;

    public ThingsList() {
        things = new ArrayList<>();
    }
    public void addThings(CreateThings thing) {
        things.add(thing);
    }
    public void removeThings(CreateThings thing) {
        things.remove(thing);
    }
    public ArrayList<CreateThings> getThings() {
        return things;
    }
    public void setTimeThing(String type,String room, String nameSender,String nameReceiver,String time) {
        for (CreateThings thing : things) {
            if (type.equals(thing.getType())&&room.equals(thing.getRoomNumber())&&nameSender.toLowerCase().equals(thing.getNameSender().toLowerCase())&&nameReceiver.toLowerCase().equals(thing.getNameReceiver().toLowerCase())) {
                thing.setDate(type,room,nameSender,nameReceiver,time);
            }
        }
    }
}
