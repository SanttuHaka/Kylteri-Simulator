
package Kayttoliittyma;

import java.awt.image.BufferedImage;
import Toiminnot.Main;
import java.awt.Color;
import java.util.Random;

public class Paivitys {
    
    Gui gui = new Gui();
    
    // Tehdään random taustavärit päivityksille
    Random rand = new Random();

    float blue = rand.nextFloat();
    
    // Päivityksen attribuutit
    public int x;
    public int y;
    
    // Sijainti leveys
    public int leveys = gui.leveys / 5;
    public int korkeus = 150;
    
    public String nimi;
    public BufferedImage kuva;
    
    public int maara;
    public int hinta;
    public Color vari;
    
    //päivitysten vaikutus eps:iin
    public static double eka=0.1,toka = 1,kolmas = 8,neljas = 47,viides = 260;
    
    
    public Paivitys(String nimi, int hinta){
        
        // Päivityksen attribuutit
        this.x = gui.leveys - gui.leveys/5;
        this.nimi = nimi;
        this.maara = 0;
        this.hinta = hinta;
        this.vari = new Color(0, 0.1f, blue);
    }
    
    //Asettaa y-koordinaatin kutsuttaessa päivitykselle
    public static int setYKoord(int index){
        return 40 + index * 150;
    }
    
    //Klikkipäivityksen hinta
    public static void epsPaivitys(int index){

        
        switch(index){
        // 1. PÄIVITYKSEN VAIKUTUS
        case 0:
            Main.eps +=eka;
            break;
        // 2. PÄIVITYKSEN VAIKUTUS
        case 1:
            Main.eps +=toka;
            break;
        // 3. PÄIVITYKSEN VAIKUTUS
        case 2:
            Main.eps +=kolmas;
            break;
        // 4. PÄIVITYKSEN VAIKUTUS
        case 3:
            Main.eps +=neljas;
            break;
        case 4:
            Main.eps +=viides;
            break;
        }
    }
    
    //Getterit ja setterit
    
    public Color getVari() {
        return vari;
    }
    
    public Gui getGui() {
        return gui;
    }

    public void setGui(Gui gui) {
        this.gui = gui;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getLeveys() {
        return leveys;
    }

    public void setLeveys(int leveys) {
        this.leveys = leveys;
    }

    public int getKorkeus() {
        return korkeus;
    }

    public void setKorkeus(int korkeus) {
        this.korkeus = korkeus;
    }

    public String getNimi() {
        return nimi;
    }

    public void setNimi(String nimi) {
        this.nimi = nimi;
    }

    public BufferedImage getKuva() {
        return kuva;
    }

    public void setKuva(BufferedImage kuva) {
        this.kuva = kuva;
    }

    public int getMaara() {
        return maara;
    }

    public void setMaara(int maara) {
        this.maara = maara;
    }

    public int getHinta() {
        return hinta;
    }

    public void setHinta(int hinta) {
        this.hinta = hinta;
    }
    
    
}
