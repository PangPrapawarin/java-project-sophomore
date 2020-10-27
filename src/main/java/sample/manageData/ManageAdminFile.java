package sample.manageData;

import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import sample.models.CreateAccounts;
import sample.models.admin.AdminCreateAccount;
import sample.models.admin.AdminList;
import sample.models.staff.StaffCreateAccount;
import sample.models.staff.StaffList;

import java.io.*;

public class ManageAdminFile {
    private String fileName;
    private String fileDirectoryName;
    private AdminList adminList;
    private AdminCreateAccount adminAccount;

    public ManageAdminFile(String fileName, String fileDirectoryName) {
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
        String line = bufferedReader.readLine();

        while(line != null){
            String[] data = line.split(",");
            AdminCreateAccount admin = new AdminCreateAccount(data[0].trim(), data[1].trim(),data[2].trim());
            adminList.addAdmin(admin);
        }
        bufferedReader.close();
    }
    public AdminList getAdminsList() {
        try {
            AdminList admin = new AdminList();
            readFileData();
        } catch (FileNotFoundException e) {
            System.err.println(fileName + " not found.");
        } catch (IOException e){
            System.err.println(fileName + " has error.");
        }
        return adminList;
    }
    public void setNewPassword(AdminCreateAccount admin) {
        String filePath = fileDirectoryName + File.separator + fileName;
        File file = new File(filePath);
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(file);
            BufferedWriter writer = new BufferedWriter(fileWriter);
            String account = admin.getUsername() + "," + admin.getPassword();
            writer.append(account);
            writer.newLine();
            writer.close();
        }
        catch (IOException e) {
            System.err.println("Cannot write " + filePath);
        }
    }
}
