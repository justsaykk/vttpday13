package day13workshop.day13wrkshop.services;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
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
            Contact contact = new Contact();
            Path filePath = new File(this.dataDir, fileId).toPath();
            Charset cs = Charset.forName("utf-8");
            List<String> stringVal = Files.readAllLines(filePath, cs);

            // stringVal.get(0) is the fileId. Not useful in our case
            contact.setName(stringVal.get(1));
            contact.setEmail(stringVal.get(2));
            contact.setPhone(stringVal.get(3));

            // Pass the contact object back to the contact controller for further processing
            return contact;

        } catch (Exception e) {
            System.err.printf("Error: %s", e);
            e.printStackTrace();
            return null;
        }

    }
}
