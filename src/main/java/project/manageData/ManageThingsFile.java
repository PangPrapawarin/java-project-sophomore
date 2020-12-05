package project.manageData;

import project.models.Thing;
import project.models.ThingList;

import java.io.*;

public class ManageThingsFile extends ManageStaffFile {
    private ThingList thingsList;

    public ManageThingsFile(String fileDirectoryName, String fileName) {
        super(fileDirectoryName, fileName);
        super.checkFileData();
    }

    @Override
    public void readFileData() throws IOException {
        String filePath = super.getFileDirectoryName() + File.separator + super.getFileName();
        File file = new File(filePath);
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line = "";

        while((line = bufferedReader.readLine()) != null){
            String[] data = line.split(",");
            Thing th = new Thing(data[0].trim(),data[1].trim(),data[2].trim(),data[3].trim(),data[4].trim(),data[5].trim(),data[6].trim(),data[7].trim(),data[8].trim(),data[9].trim(),data[10].trim());
            thingsList.addThing(th);
        }
        bufferedReader.close();
    }
    public ThingList getThingsList() {
        try {
            thingsList = new ThingList();
            readFileData();
        } catch (FileNotFoundException e) {
            System.err.println(super.getFileName() + " not found.");
        } catch (IOException e){
            System.err.println(super.getFileName() + " has error.");
        }
        return thingsList;
    }

    public void setThingsList(ThingList things) {
        String filePath = super.getFileDirectoryName() + File.separator + super.getFileName();
        File file = new File(filePath);
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(file);
            BufferedWriter writer = new BufferedWriter(fileWriter);
            for (Thing th : thingsList.getThings()) {
                String line = th.getType() + "," + th.getFrom() + "," + th.getNameSender() + "," + th.getNameReceiver() + "," + th.getRoomNumber() + "," + th.getDate() + "," + th.getStaffName() + "," + th.getSize() + "," + th.getService() + "," + th.getTrackingNumber() + "," + th.getImportant();
                writer.append(line);
                writer.newLine();
            }
            writer.close();
        } catch (IOException e) {
            System.err.println("Can not write " + filePath);
        }
    }
}
