package day13workshop.day13wrkshop.services;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

import org.springframework.stereotype.Service;

import day13workshop.day13wrkshop.models.Contact;

@Service
public class DatabaseService {
    private File dataDir = new File("someFile");

    public File getDataDir() {
        return dataDir;
    };

    public void setDataDir(File file) {
        this.dataDir = file;
    };

    public Boolean save(Contact contact) {
        File f = new File(this.dataDir, contact.getId());
        // write it like this so that we don't need to close it later
        try (OutputStream out = new FileOutputStream(f);) {
            PrintWriter pw = new PrintWriter(out);
            pw.println(contact.getId());
            pw.println(contact.getName());
            pw.println(contact.getEmail());
            pw.println(contact.getPhone());
            pw.flush();

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public Contact read(String fileId) {

        try {
            File f = new File(this.dataDir, fileId);
            Contact contact = new Contact();
            Scanner myScanner = new Scanner(f);

            while (myScanner.hasNextLine()) {
                System.out.println(myScanner.nextLine());
            }
            myScanner.close();

            return contact;

        } catch (Exception e) {
            System.err.printf("Error: %s", e);
            e.printStackTrace();
            return null;
        }

    }
}
