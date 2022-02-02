package ksiazka;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int aktualnie = 0;  //aktualnie ile osob jest w bazie
        //tworzenie tablicy
        Kontakt tab[] = new Kontakt[10];
        //tworzenie obiektow konstrukotrem
        for (int i = 0; i < tab.length; i++) {
            tab[i] = new Kontakt("", "", "", "", false);
        }
        //Program glowny
        int menu;
        do {

            System.out.println(" ");
            System.out.println("|1. Wyswietl kontakt|");
            System.out.println("|2. Dodaj kontakt   |");
            System.out.println("|3. Usun kontakt    |");  //glowne menu
            System.out.println("|4. Edytuj          |");
            System.out.println("|5. Wyszukaj        |");
            System.out.println("|6. Wyjscie         |");
            menu = scanner.nextInt();
            switch (menu) {
                case 1: {
                    if (aktualnie > 0) {
                        System.out.println("Wybierz kontakt");
                        int kontakt = scanner.nextInt();
                        if (tab[kontakt - 1].zyje == true)
                            tab[kontakt - 1].wyswietlanieKontaktu();
                        else {
                            System.out.println("ten kontakt nie istnieje");
                        }
                    } else {
                        System.out.println("Brak kontaktu do wyswietlenia ");
                    }
                }
                break;
                case 2: {
                    if(aktualnie==tab.length){
                        System.out.println("Baza jest przepelniona ");
                    }else{
                        for(int i=0;i<tab.length;i++){
                            if(tab[i].zyje==true){

                            }else{
                                tab[i].dodawanie();
                                aktualnie++;
                                break;
                            }
                        }
                    }
                }
                break;
                case 3: {
                    System.out.println("Wybierz kontakt ktory chcesz usunac ");
                    int kontakt = scanner.nextInt();
                    if (tab[kontakt - 1].zyje == true) {
                        tab[kontakt - 1].usuwanie();
                    } else {
                        System.out.println("kontakt nie istnieje");
                    }
                }
                break;
                case 4: {
                    System.out.println("Wybierz kontakt ktory chcesz edytowac ");
                    int kontakt = scanner.nextInt();
                    if (tab[kontakt - 1].zyje == true) {
                        tab[kontakt - 1].edytowanie();
                        System.out.println("kontakt zostal zedytowany!");
                    } else {
                        System.out.println("kontakt nie istnieje");
                    }
                }
                break;
                case 5: {
                    int wynik = 0;
                    scanner.nextLine();
                    System.out.println(" ");
                    String szukana = scanner.nextLine();
                    for (int i = 0; i < tab.length; i++) {
                        if (tab[i].wyszukiwanie(szukana)) {
                            tab[i].wyswietlanieBazy();
                            wynik++;
                        }
                    }
                    if (wynik == 0) {
                        System.out.println("Brak wyniku wyszukiwania");
                    }
                }
                break;
                default: {
                    System.out.println("Wyjscie ");
                }
                break;
            }
        } while (menu > 0 && menu < 6);


    }
}

