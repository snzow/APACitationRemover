import java.util.Scanner;
import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

    runProgram();

    }

    public static void runProgram() throws IOException{
        Scanner kb = new Scanner(System.in);

        System.out.println("---------------------");
        System.out.println("Pdf apa annoying citation remover v0.01");
        System.out.println("Please enter the exact file location of the pdf:");
        String pdfAddress = kb.nextLine();
        int k = PdfReader.readDoc(pdfAddress);
        System.out.println("Process Complete, total citations removed: " + k);
        System.out.println("the edited file should be named EditedFile.txt");
        System.out.println("your original pdf is unchanged");
        System.out.println("Love you!");
        System.out.println("---------------------");
    }
}