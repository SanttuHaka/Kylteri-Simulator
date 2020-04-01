
package Kayttoliittyma;

import java.awt.Color;
import java.util.Random;

public class Saavutus {
    
    int x,y, nro;
    int leveys = 46, korkeus = 46;
    boolean hover = false, unlocked = false;
    
    Random rand = new Random();
    
    float red = rand.nextFloat();
    float green = rand.nextFloat();
    float blue = rand.nextFloat();
    
    String nimi, teksti;
    Color vari;
    
    public Saavutus(int x, int y, int nro) {
        this.x = x;
        this.y = y;
        this.nro = nro;
        this.vari = new Color(red, green, blue);
    }
    
    public int getNro(){
        return nro;
    }
    
    public Color getVari(){
        return vari;
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

    public boolean isHover() {
        return hover;
    }

    public void setHover(boolean hover) {
        this.hover = hover;
    }

    public boolean isUnlocked() {
        return unlocked;
    }

    public void setUnlocked(boolean unlocked) {
        this.unlocked = unlocked;
    }

    public String getNimi() {
        return nimi;
    }

    public void setNimi(String nimi) {
        this.nimi = nimi;
    }

    public String getTeksti() {
        return teksti;
    }

    public void setTeksti(String teksti) {
        this.teksti = teksti;
    }
    
    
}
