package day13workshop.day13wrkshop.services;

import java.io.File;

import org.springframework.stereotype.Service;

@Service
public class DatabaseService {
    private File dataDir = new File("someFile");

    public File getDataDir() {
        return dataDir;
    };

    public void setDataDir(File file) {
        this.dataDir = file;
    };

    
}
