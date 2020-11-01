package project.manageData;

import project.models.guest.GuestInfoList;
import project.models.guest.NewGuestInfo;

import java.io.*;

public class ManageNewGuestInfoFile {
    private String fileName;
    private String fileDirectoryName;
    private NewGuestInfo newGuestInfo;
    private GuestInfoList guestInfoList;

    public ManageNewGuestInfoFile(String fileDirectoryName, String fileName) {
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
            NewGuestInfo guestInfo = new NewGuestInfo(data[0].trim(),data[1].trim(),data[2].trim(),data[3].trim(),data[4].trim(),data[5].trim());
            guestInfoList.addGuestInfo(guestInfo);
        }
        bufferedReader.close();
    }
    public GuestInfoList getGuestInfoList() {
        try {
            guestInfoList = new GuestInfoList();
            readFileData();
        } catch (FileNotFoundException e) {
            System.err.println(fileName + " not found.");
        } catch (IOException e){
            System.err.println(fileName + " has error.");
        }
        return guestInfoList;
    }

    public void setGuestInfoList(GuestInfoList guestInfoList) {
        String filePath = fileDirectoryName + File.separator + fileName;
        File file = new File(filePath);
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(file);
            BufferedWriter writer = new BufferedWriter(fileWriter);
            for (NewGuestInfo guestInfo : guestInfoList.getGuestInfoList()) {
                String line = guestInfo.getRoomNumber() + "," + guestInfo.getFloorNumber() + "," + guestInfo.getBuildingNumber() + "," + guestInfo.getRoomType() + "," + guestInfo.getName() + "," + guestInfo.getPeople();
                writer.append(line);
                writer.newLine();
            }
            writer.close();
        } catch (IOException e) {
            System.err.println("Can not write " + filePath);
        }
    }
}
