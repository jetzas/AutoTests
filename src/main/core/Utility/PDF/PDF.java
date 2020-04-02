package core.Utility.PDF;

import java.io.*;
import org.apache.pdfbox.pdmodel.*;
import org.apache.pdfbox.text.*;

public class PDF {

    public String[] pdfReader(String fileName) {

        String lines[] = null;
        try (PDDocument document = PDDocument.load(new File(fileName))) {
            document.getClass();
            if (!document.isEncrypted()) {

                PDFTextStripperByArea stripper = new PDFTextStripperByArea();
                stripper.setSortByPosition(true);

                PDFTextStripper tStripper = new PDFTextStripper();

                String pdfFileInText = tStripper.getText(document);
                //System.out.println("Text:" + st);

                // split by whitespace
                lines = pdfFileInText.split("\\r?\\n");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }

}
