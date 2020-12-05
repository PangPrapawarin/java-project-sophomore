package project.manageData;

import project.models.AdminAccount;
import project.models.AdminList;
import project.models.GuestAccount;
import project.models.GuestList;

import java.io.*;

public class ManageGuestFile extends ManageStaffFile {
    private AdminList guestList;

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
            AdminAccount guest = new GuestAccount(data[0].trim(), data[1].trim(),data[2].trim(),data[3].trim()); //polymorphism
            guestList.addAccount(guest); //polymorphism
        }
        bufferedReader.close();
    }
    @Override
    public AdminList getList() {
        try {
            guestList = new GuestList(); //polymorphism
            readFileData();
        } catch (FileNotFoundException e) {
            System.err.println(super.getFileName() + " not found.");
        } catch (IOException e){
            System.err.println(super.getFileName() + " has error.");
        }
        return guestList;
    }

    public void setGuestList(AdminList guests) {
        String filePath = super.getFileDirectoryName() + File.separator + super.getFileName();
        File file = new File(filePath);
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(file);
            BufferedWriter writer = new BufferedWriter(fileWriter);
            for (AdminAccount guest : guests.getAccountList()) {
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
