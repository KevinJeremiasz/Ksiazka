package Ksiazka2;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Pliczki {
    String obecnaLokacja;
    String nazwa;
    File file;
    Path lokacjaPliku;

    Pliczki() throws IOException {
        obecnaLokacja = new File(".").getCanonicalPath();
        System.out.println(obecnaLokacja);
    }

    void plikNieWybrany() {
        if (file != null) {
            System.out.println("Ta baza jest teraz otwarta : " + nazwa);
        } else {
            System.out.println("Plik nie zostal wybrany");
        }
    }

    void otworzPlik() {
        Scanner scan = new Scanner(System.in);
        nazwa = scan.nextLine();
        try{
            file = new File(obecnaLokacja, "\\" + "Pliki" + "\\" + nazwa + ".txt");
            if(!file.exists()){
                File plik=file;
                plik.createNewFile();
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        System.out.println(file);
    }

    void zapisDoPliku(String[] temp) {
        try {
            PrintWriter writer = new PrintWriter(new FileWriter(file, true));
            for (int i = 0; i < 6; i++) {
                writer.println(temp[i]);
            }
            writer.close();
            System.out.println("Zapisano");
        } catch (IOException EX) {
            System.out.println(EX.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    void wyswietlOsobe(int id) {
        String[] tab = new String[6];
        Scanner wpliku = null;
        int licznik = 0;
        int numer = id - 1;
        try {
            wpliku = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while (wpliku.hasNextLine()) {

            if (licznik / 6 == numer) {
                tab[licznik % 6] = wpliku.nextLine();
                System.out.println(tab[licznik % 6]);
            } else {
                wpliku.nextLine();

            }
            licznik++;
        }

    }
    void wyswietlOsobeMenu() {
        String[] tab = new String[2];
        Scanner wpliku = null;
        int licznik = 0;
        int id = 1;
        try {
            wpliku = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while (wpliku.hasNextLine()) {
            if (licznik == 0) {
                tab[licznik] = wpliku.nextLine();
                licznik++;

            } else if (licznik == 1) {
                tab[licznik] = wpliku.nextLine();
                System.out.println(id + ". " + tab[0] + " " + tab[1]);
                licznik++;
                id++;
            } else if (licznik == 5) {
                licznik = 0;
                wpliku.nextLine();
            } else {
                licznik++;
                wpliku.nextLine();
            }

        }
    }
    void usunOsobeZBazy(int id){
        Scanner wpliku = null;
        PrintWriter writer=null;
        int licznik = 0;
        int numer = id - 1;
        try {
            writer = new PrintWriter(new FileWriter(file));
            wpliku = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException ex){
            ex.printStackTrace();
        }catch (Exception ex){
            ex.printStackTrace();
        }
        while (wpliku.hasNextLine()) {

            if (licznik / 6 == numer) {
                for (int i=0;i<6;i++){
                    writer.print("");
                }
                break;
            } else {
                wpliku.nextLine();
                licznik++;

            }

        }
    }
}
