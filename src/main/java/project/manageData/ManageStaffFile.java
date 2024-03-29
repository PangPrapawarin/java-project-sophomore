package project.manageData;

import project.models.AdminAccount;
import project.models.AdminList;
import project.models.StaffAccount;
import project.models.StaffList;

import java.io.*;

public class ManageStaffFile {
    private String fileName;
    private String fileDirectoryName;
    private AdminList staffList;

    public ManageStaffFile(String fileDirectoryName, String fileName) {
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
            AdminAccount staff = new StaffAccount(data[0].trim(), data[1].trim(),data[2].trim(),data[3].trim(),data[4].trim(),data[5].trim()); //polymorphism
            staffList.addAccount(staff); //polymorphism
        }
        bufferedReader.close();
    }

    public AdminList getList() {
        try {
            staffList = new StaffList(); //polymorphism
            readFileData();
        } catch (FileNotFoundException e) {
            System.err.println(fileName + " not found.");
        } catch (IOException e){
            System.err.println(fileName + " has error.");
        }
        return staffList;
    }
    public void setStaffs(AdminList staffs) {
        String filePath = fileDirectoryName + File.separator + fileName;
        File file = new File(filePath);
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(file);
            BufferedWriter writer = new BufferedWriter(fileWriter);
            for (AdminAccount staff : staffs.getAccountList()) {
                String line = staff.getName() + "," + staff.getUsername() + "," + staff.getPassword() + "," + staff.getConfirmPassword() + "," + staff.getWithhold() + "," + staff.getTime();
                writer.append(line);
                writer.newLine();
            }
            writer.close();
        } catch (IOException e) {
            System.err.println("Can not write " + filePath);
        }
    }
    public String getFileName() {
        return fileName;
    }

    public String getFileDirectoryName() {
        return fileDirectoryName;
    }

}
