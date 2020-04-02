package core.Utility.FileOperation;

import java.io.*;
import java.util.*;

public class FileOperation {

    public static File lastFileModified(String dir, Long time) {
        File choice = null;
        while (Objects.isNull(choice)) {
            File fl = new File(dir);
            File[] files = fl.listFiles(new FileFilter() {
                public boolean accept(File file) {
                    return file.isFile();
                }
            });
            for (File file : files) {

                String name = file.getName();
                String extension = name.substring(name.lastIndexOf("."));
                if (file.lastModified() > time && extension.equals(".pdf")) {
                    choice = file;
                }
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return choice;
    }

}
