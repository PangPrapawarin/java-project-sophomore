package project.manageData;

import project.models.Condo;

import java.io.*;

public class ManageNewGuestInfoFile extends ManageStaffFile {
    private Condo guestInfoList;

    public ManageNewGuestInfoFile(String fileDirectoryName, String fileName) {
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
            Condo guestInfo = new Condo(data[0].trim(),data[1].trim(),data[2].trim(),data[3].trim(),data[4].trim(),data[5].trim());
            guestInfoList.addGuestInfo(guestInfo);
        }
        bufferedReader.close();
    }
    public Condo getGuestInfoList() {
        try {
            guestInfoList = new Condo();
            readFileData();
        } catch (FileNotFoundException e) {
            System.err.println(super.getFileName() + " not found.");
        } catch (IOException e){
            System.err.println(super.getFileName() + " has error.");
        }
        return guestInfoList;
    }
    public void setGuestInfoList(Condo guestsInfo) {
        String filePath = super.getFileDirectoryName() + File.separator + super.getFileName();
        File file = new File(filePath);
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(file);
            BufferedWriter writer = new BufferedWriter(fileWriter);
            for (Condo guestInfo : guestsInfo.getGuestInfoList()) {
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
