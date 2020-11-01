package project.manageData;

import project.models.guest.GuestCreateAccount;
import project.models.guest.GuestList;

import java.io.*;

public class ManageGuestFile {
    private String fileName;
    private String fileDirectoryName;
    private GuestList guestList;
    private GuestCreateAccount guestAccount;

    public ManageGuestFile(String fileDirectoryName, String fileName) {
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
            GuestCreateAccount guest = new GuestCreateAccount(data[0].trim(), data[1].trim(),data[2].trim(),data[3].trim());
            guestList.addGuest(guest);
        }
        bufferedReader.close();
    }
    public GuestList getGuestList() {
        try {
            guestList = new GuestList();
            readFileData();
        } catch (FileNotFoundException e) {
            System.err.println(fileName + " not found.");
        } catch (IOException e){
            System.err.println(fileName + " has error.");
        }
        return guestList;
    }
    public void setNewPassword(GuestCreateAccount guest) {
        String filePath = fileDirectoryName + File.separator + fileName;
        File file = new File(filePath);
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(file);
            BufferedWriter writer = new BufferedWriter(fileWriter);
            String account = guest.getName() + "," + guest.getUsername() + "," + guest.getPassword() + "," + guest.getConfirmPassword();
            writer.append(account);
            writer.newLine();
            writer.close();
        }
        catch (IOException e) {
            System.err.println("Cannot write " + filePath);
        }
    }

    public void setGuestList(GuestList guestList) {
        String filePath = fileDirectoryName + File.separator + fileName;
        File file = new File(filePath);
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(file);
            BufferedWriter writer = new BufferedWriter(fileWriter);
            for (GuestCreateAccount guest : guestList.getGuestList()) {
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
