package project.models.things;

import java.util.ArrayList;

public class SuccessMailAndOtherList {
    public ArrayList<CreateThings> successList;

    public SuccessMailAndOtherList() {
        successList  = new ArrayList<>();
    }
    public ArrayList<CreateThings> getSuccessMailAndOther() {
        return successList;
    }
    public void addMailAndOther(CreateThings thingsToAdd) {
        successList.add(thingsToAdd);
    }
}
