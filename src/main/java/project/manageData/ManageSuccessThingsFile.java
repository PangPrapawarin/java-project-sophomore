package project.manageData;

import project.models.things.CreateThings;
import project.models.things.SuccessMailAndOtherList;

import java.io.*;

public class ManageSuccessThingsFile {
    private String fileName;
    private String fileDirectoryName;
    private CreateThings createThings;
    private SuccessMailAndOtherList successMailAndOtherList;

    public ManageSuccessThingsFile(String fileDirectoryName, String fileName) {
        this.fileName = fileName;
        this.fileDirectoryName = fileDirectoryName;
        checkFileData();
    }

    public void checkFileData(){
        File file = new File(fileDirectoryName);
        if (!file.exists()) {
            file.mkdirs();
        }
        String filePath = fileDirectoryName + File.separator + fileName;
        file = new File(filePath);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                System.err.println("Failed to create " + filePath);
            }
        }
    }
    public void readFileData() throws IOException {
        String filePath = fileDirectoryName + File.separator + fileName;
        File file = new File(filePath);
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line = "";

        while((line = bufferedReader.readLine()) != null){
            String[] data = line.split(",");
            CreateThings thing = new CreateThings(data[0].trim(), data[1].trim(),data[2].trim(),data[3].trim(),data[4].trim(),data[5].trim(),data[6].trim(),data[7].trim(),data[8].trim(),data[9].trim(),data[10].trim());
            successMailAndOtherList.addMailAndOther(thing);
        }
        bufferedReader.close();
    }
    public SuccessMailAndOtherList getSuccessMailAndOtherList() {
        try {
            successMailAndOtherList = new SuccessMailAndOtherList();
            readFileData();
        } catch (FileNotFoundException e) {
            System.err.println(fileName + " not found.");
        } catch (IOException e){
            System.err.println(fileName + " has error.");
        }
        return successMailAndOtherList;
    }

    public void setSuccessMailAndOtherList(SuccessMailAndOtherList thingsList) {
        String filePath = fileDirectoryName + File.separator + fileName;
        File file = new File(filePath);
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(file);
            BufferedWriter writer = new BufferedWriter(fileWriter);
            for (CreateThings things : thingsList.getSuccessMailAndOther()) {
                String line = things.getType() + "," + things.getFrom() + "," + things.getNameSender() + "," + things.getNameReceiver() + "," + things.getRoomNumber() + "," + things.getDate() + "," + things.getStaffName() + "," + things.getSize() + "," + things.getService() + "," + things.getTrackingNumber() + "," + things.getImportant();
                writer.append(line);
                writer.newLine();
            }
            writer.close();
        } catch (IOException e) {
            System.err.println("Can not write " + filePath);
        }
    }
}
