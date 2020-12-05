package project.models;

import java.util.ArrayList;

public class ThingList {
    private ArrayList<Thing> things, selectThings;

    public ThingList() {
        things = new ArrayList<>();
        selectThings = new ArrayList<>();
    }
    public void addThing(Thing thing) {
        things.add(thing);
    }
    public void removeThing(Thing thing) {
        things.remove(thing);
    }
    public ArrayList<Thing> getThings() {
        return things;
    }
    public ArrayList<Thing> showGuestThings(String name) {
        for (Thing thing : things) {
            if (thing.getNameReceiver().toLowerCase().equals(name.toLowerCase())) {
                return selectThings;
            }
        }
        return null;
    }

    public void addThingGuest(String name) {
        for (Thing thing : things) {
            if (thing.getNameReceiver().toLowerCase().equals(name.toLowerCase())) {
                selectThings.add(thing);
            }
        }
    }
}
