import java.io.File;

import org.apache.commons.io.FileUtils;
import org.apache.pdfbox.*;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.StringBuffer;

public class PdfReader {

    public static int readDoc(String fileAddress) throws IOException {

        File file = new File(fileAddress);

        PDDocument document = Loader.loadPDF(file);


        PDFTextStripper pdfStripper = new PDFTextStripper();

        String text = pdfStripper.getText(document);

        int citationsRemoved = 0;
        for (int i = 0;i < text.length(); i++){
            if(text.charAt(i) == '('){
                citationsRemoved++;
                text = removeCitation(text,i);


            }
        }
        document.close();
        File newDoc = new File(System.getProperty("user.dir"),"EditedFile.txt");
        FileUtils.writeStringToFile(newDoc,text,"ISO-8859-1" );

        return citationsRemoved;

    }

    private static String removeCitation(String s,int i){
        char j = '1';
        int lettersLong = 0;
        StringBuilder sb = new StringBuilder(s);

        while (j != ')'){
            lettersLong++;
            j = s.charAt(i);
            i++;
        }


        i -= lettersLong;
        StringBuilder edited = sb.delete(i,i+lettersLong + 1);
        return edited.toString();
    }

}
