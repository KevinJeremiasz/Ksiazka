package ksiazka;

import java.util.Scanner;

public class Kontakt {
    String numer[] = new String[3];
    Boolean zyje;
    //tu są zmienne
    private String imie, nazwisko, miejscowosc;

    //konstruktor, sprawdza czy dana osoba jest w bazie
    Kontakt(String imie, String nazwisko, String miejscowosc, String numer, Boolean zyje) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.miejscowosc = miejscowosc;
        this.numer[0] = numer;
        this.numer[1] = numer;
        this.numer[2] = numer;
        this.zyje = zyje;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public String getMiejscowosc() {
        return miejscowosc;
    }

    public void setMiejscowosc(String miejscowosc) {
        this.miejscowosc = miejscowosc;
    }

    public String[] getNumer() {
        return numer;
    }

    public void setNumer(String[] numer) {
        this.numer = numer;
    }

    public Boolean getZyje() {
        return zyje;
    }

    public void setZyje(Boolean zyje) {
        this.zyje = zyje;
    }

    //funkcje

    //dodawanie nowego kontaktu do bazy
    void dodawanie() { // dodawanie
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj imie: ");
        setImie(scanner.nextLine());
        System.out.println("Podaj nazwisko: ");
        setNazwisko( scanner.nextLine());
        System.out.println("Podaj miejscowosc: ");
        setMiejscowosc( scanner.nextLine());
        for (int i = 0; i < 3; i++) {
            System.out.println("podaj numer telefonu ");
            numer[i] = scanner.nextLine();
        }
        setZyje(true);
        System.out.println("Pomyslnie dodano nowa osobe!");
    }

    //Usuwanie kontaktu
    void usuwanie() {
        setZyje(false);
        System.out.println("kontakt zostal usuniety");
    }

    //Edytownie
    void edytowanie() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("|Co chcesz edytowac?         |");
        System.out.println("|1. Imie                     |");
        System.out.println("|2. Nazwisko                 |");
        System.out.println("|3. Miejscowosc              |");
        System.out.println("|4. Numer prywatny           |");
        System.out.println("|5. Numer domowy             |");
        System.out.println("|6. Numer sluzbowy           |");
        System.out.println("|7. Anuluj edytowanie kontaku|");
        int menu = scanner.nextInt();
        scanner.nextLine();    //debuger
        System.out.print("");
        String podmiana = scanner.nextLine();  //podmienia na cos innego
        switch (menu) {
            case 1: {
                imie = podmiana;
            }
            break;
            case 2: {
                nazwisko = podmiana;
            }
            break;
            case 3: {
                miejscowosc = podmiana;
            }
            break;
            case 4: {
                numer[0] = podmiana;
            }
            break;
            case 5: {
                numer[1] = podmiana;
            }
            break;
            case 6: {
                numer[2] = podmiana;
            }
            break;
            default: { //anty debil
                System.out.println("Edytowanie kontaktu zosatlo anulowane "); //gdy ktos wpisze cokolwiek powyzej 6 zosatnie anulowane
            }
            break;
        }
    }

    //Wyszukiwanie
    Boolean wyszukiwanie(String szukana) {
        if (imie.equals(szukana)) {
            return true;
        } else if (nazwisko.equals(szukana)) {
            return true;
        } else if (miejscowosc.equals(szukana)) {
            return true;
        } else if (numer[0].equals(szukana)) {
            return true;
        } else if (numer[1].equals(szukana)) {
            return true;
        } else if (numer[2].equals(szukana)) {  //eguals zamiast ==
            return true;
        } else
            return false;
    }

    //Wyswietlanie całej bazy
    void wyswietlanieBazy() {
        System.out.println(imie + " " + nazwisko);
    }

    //wyswietlanie kontkatu
    void wyswietlanieKontaktu() {
        System.out.println("Imie : " + imie);
        System.out.println("Nazwisko : " + nazwisko);
        System.out.println("Miejscowosc : " + miejscowosc);
        for (int i = 0; i < 3; i++) {
            System.out.println((i + 1) + "Numer : " + numer[i]);
        }
    }

}