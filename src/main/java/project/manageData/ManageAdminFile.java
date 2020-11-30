package project.manageData;

import project.models.AdminAccount;
import project.models.GuestAccount;

import java.io.*;

public class ManageAdminFile extends ManageStaffFile {
    private AdminAccount adminList;

    public ManageAdminFile(String fileDirectoryName, String fileName) {
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
            AdminAccount admin = new AdminAccount(data[0].trim(), data[1].trim(),data[2].trim());
            adminList.addAccount(admin);
        }
        bufferedReader.close();
    }
    public AdminAccount getAdminsList() {
        try {
            adminList = new AdminAccount();
            readFileData();
        } catch (FileNotFoundException e) {
            System.err.println(super.getFileName() + " not found.");
        } catch (IOException e){
            System.err.println(super.getFileName() + " has error.");
        }
        return adminList;
    }
    public void setAdminList(AdminAccount adminList) {
        String filePath = super.getFileDirectoryName() + File.separator + super.getFileName();
        File file = new File(filePath);
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(file);
            BufferedWriter writer = new BufferedWriter(fileWriter);
            for (AdminAccount admin : adminList.getAdmins()) {
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
