package Ksiazka2;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    Pliczki baza = null;

    Menu() {
        System.out.println("Witamy w Ksiazce Telefonicznej 2.0 ");
    }

    void menu() {
        Boolean runMenu = true;
        Scanner scan = new Scanner(System.in);
        wyswietlOsobe();
        do {
            wyswietlOsobe();
            pokarzOpcjeMenu();
            odstep();
            switch (insertInt()) {
                case 1: {
                    try {
                        baza.zapisDoPliku(dodajOsobe());
                    } catch (Exception ex) {
                        System.out.println(ex.fillInStackTrace());
                    }
                    break;
                }
                case 2: {
                    usunOsobeZBazy();
                    break;
                }
                case 3: {

                    break;
                }
                case 4: {
                    odstep();
                    System.out.println("Wybierz numer osoby");
                    calaOsoba();
                    break;
                }
                case 5: {
                    plikMenu();
                    break;
                }
                case 6: {
                    wyswietlOsobe();
                    break;
                }

                default: {
                    runMenu = false;
                }
            }
        } while (runMenu);
    }

    int insertInt() {
        Scanner scan = new Scanner(System.in);
        int retNumber;
        try {
            retNumber = scan.nextInt();
            return retNumber;
        } catch (InputMismatchException ex) {
            insertInt();
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Program napotkal blad");
        }
        return 0;
    }

    String[] dodajOsobe() {
        Scanner scan = new Scanner(System.in);
        String[] temp = new String[6];
        System.out.println("Podaj imie");
        temp[0] = scan.nextLine();
        System.out.println("Podaj nazwisko");
        temp[1] = scan.nextLine();
        System.out.println("Podaj miasto");
        temp[2] = scan.nextLine();
        for (int i = 3; i < 6; i++) {
            System.out.println("Podaj numer" + (i - 2));
            temp[i] = scan.nextLine();
        }
        return temp;
    }

    void edytujOsobe() {
        System.out.println("Wybierz osobe do edycjo : ");
        baza.wyswietlOsobe(insertInt());
        System.out.println("Wybierz co chcesz edytować : ");
        System.out.println("1 Imie      : 2 Nazwisko  ");
        System.out.println("3 Miasto    : 4 Telefon 1 ");
        System.out.println("5 Telefon 2 : 6 Telefon 3 ");
    }

    void plikMenu() {
        try {
            baza = new Pliczki();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println("1 otwórz");
        switch (insertInt()) {
            case 1: {//Otwórz
                System.out.println("Otworz plik");
                baza.otworzPlik();
                break;
            }
            case 2: {//stwórz

                break;
            }
        }
    }

    void calaOsoba() {
        baza.wyswietlOsobe(insertInt());
    }

    void wyswietlOsobe() {
        try {
            odstep();
            baza.wyswietlOsobeMenu();
            odstep();
        } catch (NullPointerException ex) {
            System.out.println("Baza nie została otwarta ");
            plikMenu();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }

    void pokarzOpcjeMenu() {
        System.out.println("1. Dodaj osobe");
        System.out.println("2. Usun");
        System.out.println("3. edytuj");
        System.out.println("4. Wyswietl osobe");
        System.out.println("5. Ustawienia Pliku");
    }

    void odstep() {
        for (int i = 0; i < 20; i++) {
            System.out.print("-");
        }
        System.out.println(" ");
    }
    void usunOsobeZBazy(){
        baza.usunOsobeZBazy(insertInt());
        System.out.println("Kontaktowi mówimi naura");
    }
}

