package project.manageData;

import project.models.AdminAccount;
import project.models.GuestAccount;

import java.io.*;

public class ManageGuestFile extends ManageStaffFile {
    private GuestAccount guestList;

    public ManageGuestFile(String fileDirectoryName, String fileName) {
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
            GuestAccount guest = new GuestAccount(data[0].trim(), data[1].trim(),data[2].trim(),data[3].trim());
            guestList.addAccount(guest);
        }
        bufferedReader.close();
    }
    public GuestAccount getGuestList() {
        try {
            guestList = new GuestAccount();
            readFileData();
        } catch (FileNotFoundException e) {
            System.err.println(super.getFileName() + " not found.");
        } catch (IOException e){
            System.err.println(super.getFileName() + " has error.");
        }
        return guestList;
    }

    public void setGuestList(GuestAccount guests) {
        String filePath = super.getFileDirectoryName() + File.separator + super.getFileName();
        File file = new File(filePath);
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(file);
            BufferedWriter writer = new BufferedWriter(fileWriter);
            for (GuestAccount guest : guests.getGuests()) {
                String line = guest.getName() + "," + guest.getUsername() + "," + guest.getPassword() + "," + guest.getConfirmPassword();
                writer.append(line);
                writer.newLine();
            }
            writer.close();
        } catch (IOException e) {
            System.err.println("Can not write " + filePath);
        }
    }
}
