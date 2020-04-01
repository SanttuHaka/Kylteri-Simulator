
package Kayttoliittyma;

//Tällä luokalla luodaan nappuloita käyttöliittymään.
public class Nappi {
    
    public int x;
    public int y;
    public int leveys;
    public int korkeus;
    
    public boolean hover = false;
    public boolean active = false;
    
    public Nappi(int x, int y, int leveys, int korkeus) {
        
        this.x = x;
        this.y = y;
        this.leveys = leveys;
        this.korkeus = korkeus;

    }
    
    public Nappi(){
        
    }
    
    //Metodi napin asettamiseksi aktiiviseksi
    public static void setActive(Nappi np){
        
        Gui.nPaivitykset.active = false;
        Gui.nSaavutukset.active = false;
        
        np.active = true;
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

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
    
    
}
