package Toiminnot;

import Kayttoliittyma.Gui;


public class Main {
    
    //PÄÄATTRIBUUTIT
    
    //Euromäärä
    public static double euroja = 0;
    
    //Euroa per sekunti
    public static double eps = 0;
    
    // Euro per klik
    public static double epk = 1;
    
    //Päivitysten määrä
    public static int paivMaara = 5;
    
    //Klikkerin päivittämisen hinta
    public static int paivKlikkeriHinta = 10;
    
    //Saavutusten määrä
    public static int saavutusMaara = 8;
    
    //Klikkausten määrä
    public static int klikkiLuku = 0;

    public static void main(String[] args) {
        
        Gui naytto = new Gui();
        naytto.luoGui();
        
        new Laskuri();
        new SaavutusCheck();
        
        //Ladataan automaattisesti tallennetut datat
        Data.latausAlussa();
    }
    
}
