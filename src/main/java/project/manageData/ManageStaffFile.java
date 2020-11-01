package project.manageData;

import project.models.staff.StaffCreateAccount;
import project.models.staff.StaffList;

import java.io.*;

public class ManageStaffFile {
    private String fileName;
    private String fileDirectoryName;
    private StaffList staffs;

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
            StaffCreateAccount staff = new StaffCreateAccount(data[0].trim(), data[1].trim(),data[2].trim(),data[3].trim(),data[4].trim(),data[5].trim());
            staffs.addStaff(staff);
        }
        bufferedReader.close();
    }
    public StaffList getStaffsList() {
        try {
            staffs = new StaffList();
            readFileData();
        } catch (FileNotFoundException e) {
            System.err.println(fileName + " not found.");
        } catch (IOException e){
            System.err.println(fileName + " has error.");
        }
        return staffs;
    }
    public String getNameStaff(String username) throws IOException {
        readFileData();
        try {
            for ( StaffCreateAccount staff : staffs.getStaffs()) {
                if (username.equals(staff.getUsername())){
                    return staff.getName();
                }
            }
        } catch (Exception e) {
            System.err.println("ไม่เจอรายชื่อนี้");
        }
        return null;
    }
    public void addStaff(StaffCreateAccount staff) {
        String filePath = fileDirectoryName + File.separator + fileName;
        File file = new File(filePath);
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(file);
            BufferedWriter writer = new BufferedWriter(fileWriter);
            String account = staff.getName() + "," + staff.getUsername() + "," + staff.getPassword() + "," + staff.getConfirmPassword() + "," + staff.getWithhold() + "," + staff.getTime();
            writer.append(account);
            writer.newLine();
            writer.close();
        }
        catch (IOException e) {
            System.err.println("Cannot write " + filePath);
        }
    }
    public void removeStaff(StaffCreateAccount staff, String removeStaff) {
        String filePath = fileDirectoryName + File.separator + fileName;
        File file = new File(filePath);
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(file);
            BufferedWriter writer = new BufferedWriter(fileWriter);
            if (staff.getName().equals(removeStaff)) {
                writer.append("");
            }
            writer.close();
        }
        catch (IOException e) {
            System.err.println("Cannot write " + filePath);
        }
    }
    public void setStaffs(StaffList staffs) {
        String filePath = fileDirectoryName + File.separator + fileName;
        File file = new File(filePath);
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(file);
            BufferedWriter writer = new BufferedWriter(fileWriter);
            for (StaffCreateAccount staff : staffs.getStaffs()) {
                String line = staff.getName() + "," + staff.getUsername() + "," + staff.getPassword() + "," + staff.getConfirmPassword() + "," + staff.getWithhold() + "," + staff.getTime();
                writer.append(line);
                writer.newLine();
            }
            writer.close();
        } catch (IOException e) {
            System.err.println("Can not write " + filePath);
        }
    }
}
