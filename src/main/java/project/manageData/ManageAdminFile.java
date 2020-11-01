package project.manageData;

import project.models.admin.AdminCreateAccount;
import project.models.admin.AdminList;

import java.io.*;

public class ManageAdminFile {
    private String fileName;
    private String fileDirectoryName;
    private AdminList adminList;
    private AdminCreateAccount adminAccount;

    public ManageAdminFile(String fileDirectoryName, String fileName) {
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
            AdminCreateAccount admin = new AdminCreateAccount(data[0].trim(), data[1].trim(),data[2].trim());
            adminList.addAdmin(admin);
        }
        bufferedReader.close();
    }
    public AdminList getAdminsList() {
        try {
            adminList = new AdminList();
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
            String account = admin.getUsername() + "," + admin.getPassword() + "," + admin.getConfirmPassword();
            writer.append(account);
            writer.newLine();
            writer.close();
        }
        catch (IOException e) {
            System.err.println("Cannot write " + filePath);
        }
    }
    public void setAdminList(AdminList adminList) {
        String filePath = fileDirectoryName + File.separator + fileName;
        File file = new File(filePath);
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(file);
            BufferedWriter writer = new BufferedWriter(fileWriter);
            for (AdminCreateAccount admin : adminList.getAdmins()) {
                String line = admin.getUsername() + "," + admin.getPassword() + "," + admin.getConfirmPassword();
                writer.append(line);
                writer.newLine();
            }
            writer.close();
        } catch (IOException e) {
            System.err.println("Can not write " + filePath);
        }
    }
}
