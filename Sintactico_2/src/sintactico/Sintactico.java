package sintactico;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Sintactico {

    public static void main(String[] args) throws Exception {
        // TODO code application logic here
        String path1 = "C:/Users/mayim/OneDrive/Desktop/Sintactico/src/sintactico/Lexer.flex";
        String path2 = "C:/Users/mayim/OneDrive/Desktop/Sintactico/src/sintactico/LexerCup.flex";
        String[] pathS = {"-parser", "Sintax", "C:/Users/mayim/OneDrive/Desktop/Sintactico/src/sintactico/Sintax.cup"};
        generar(path1, path2, pathS);
    }
    public static void generar(String path1, String path2, String[] pathS) throws IOException, Exception{
        File archivo;
        archivo = new File(path1);
        JFlex.Main.generate(archivo);
        archivo = new File(path2);
        JFlex.Main.generate(archivo);
        java_cup.Main.main(pathS);
        
        Path pathSym = Paths.get("C:/Users/mayim/OneDrive/Desktop/Sintactico/src/sintactico/sym.java");
        if (Files.exists(pathSym)) {
            Files.delete(pathSym);
        }
        Files.move(
                Paths.get("C:/Users/mayim/OneDrive/Desktop/Sintactico/sym.java"), 
                Paths.get("C:/Users/mayim/OneDrive/Desktop/Sintactico/src/sintactico/sym.java")
        );
        Path pathSin = Paths.get("C:/Users/mayim/OneDrive/Desktop/Sintactico/src/sintactico/Sintax.java");
        if (Files.exists(pathSin)) {
            Files.delete(pathSin);
        }
        Files.move(
                Paths.get("C:/Users/mayim/OneDrive/Desktop/Sintactico/Sintax.java"), 
                Paths.get("C:/Users/mayim/OneDrive/Desktop/Sintactico/src/sintactico/Sintax.java")
        );
    }
}