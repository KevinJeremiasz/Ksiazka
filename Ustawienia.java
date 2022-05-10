package Ksiazka2;

public class Ustawienia {
    int iloscOsobNastronie;
    Ustawienia(){
        iloscOsobNastronie=10;
    }
    int [] domyslnie(){
        int[] temp =new int[1];
        temp[1]=this.iloscOsobNastronie;
        return temp;
    }
}
