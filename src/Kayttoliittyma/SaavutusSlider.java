
package Kayttoliittyma;

import java.util.Timer;
import java.util.TimerTask;

//Kun saavutetaan saavutus, vasempaan alanurkkaan pompahtaa ilmoitusruutu
public class SaavutusSlider {
    
    Gui gui = new Gui();
    
    int x = 0, y, leveys = 200, korkeus = 50;
    String teksti;
    boolean nakyyko = false;
    
    public SaavutusSlider(Saavutus saavutus){
        
        this.y = gui.korkeus;
        this.teksti = saavutus.getTeksti();
    }
    
    public static void slideIn(SaavutusSlider saavutusSlider){
        Timer time = new Timer();
        time.scheduleAtFixedRate(new TimerTask() {
            int temp = 0;
            
            public void run() {
                
                if(temp<80){
                    saavutusSlider.y -=1;
                    temp++;
                }else{
                    
                    slideOut(saavutusSlider);
                    try {
                        time.cancel();
                    } catch (Exception e) {
                        
                        e.printStackTrace();
                    }
                }
            }
        }, 0, 30);
    }
    
    public static void slideOut(SaavutusSlider saavutusSlider){
        Timer time = new Timer();
        time.scheduleAtFixedRate(new TimerTask() {
            int temp = 80;
            
            public void run() {
                
                if(temp>0){
                    saavutusSlider.y +=1;
                    temp--;
                }else{
                    
                    saavutusSlider.setNakyyko(false);
                    try {
                        time.cancel();
                    } catch (Exception e) {
                        
                        e.printStackTrace();
                    }
                }
            }
        //kesto kuinka kauan ruutu näkyy 
        }, 3000, 30);
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

    public String getTeksti() {
        return teksti;
    }

    public void setTeksti(String teksti) {
        this.teksti = teksti;
    }

    public boolean isNakyyko() {
        return nakyyko;
    }

    public void setNakyyko(boolean nakyyko) {
        this.nakyyko = nakyyko;
    }
    
    
}
