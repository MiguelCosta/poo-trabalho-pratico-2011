package Importer;

import aerogest.AerogestSistema;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Possui todos os métodos necessários para gerir os ficheiros
 * 
 * @author Fábio Costa, Miguel Costa, Sofia Vieira
 */
public class SaveLoadDB {

    public static final String DefualtObjectFileName = "aeroguest.obj";

    public static void saveDB(AerogestSistema as, String filename) {
        try {
            FileOutputStream fich = new FileOutputStream(filename);
            ObjectOutputStream ficheiro = new ObjectOutputStream(fich);

            ficheiro.writeObject(as);
            ficheiro.close();
            fich.close();
        } catch (Exception ex) {
            System.out.println("ERRO (save DB): " + ex.getMessage());
        }
    }

    public static AerogestSistema loadDB(String filename) {
        try {
            FileInputStream fich = new FileInputStream(filename);
            ObjectInputStream ficheiro = new ObjectInputStream(fich);

            AerogestSistema as = (AerogestSistema) ficheiro.readObject();

            ficheiro.close();
            fich.close();
            return as;
        } catch (IOException ex) {
            System.out.println("ERRO (load DB): " + ex.getMessage());
            return null;
        } catch (ClassNotFoundException ex) {
            System.out.println("ERRO (load DB): " + ex.getMessage());
            return null;
        } catch (ClassFormatError ex) {
            System.out.println("ERRO (load DB): " + ex.getMessage());
            return null;
        } 
    }

    public static void showDBInFile(AerogestSistema as, String filename) {
        try {
            FileWriter fich = new FileWriter(filename);
            BufferedWriter ficheiro = new BufferedWriter(fich);

            ficheiro.write(as.toString()); //TODO ainda nao implementado
        } catch (Exception ex) {
            System.out.println("ERRO (save File DB): " + ex.getMessage());
        }
    }
}
