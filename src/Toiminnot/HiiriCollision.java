
package Toiminnot;

//Tässä luokassa luodaan tapahtumat, kun kursori koskettaa jotain.

import Kayttoliittyma.Nappi;
import Kayttoliittyma.Saavutus;

public class HiiriCollision {
        
        int hiiriX, hiiriY, x, y, leveys, korkeus;
        
        //Konstruktori joka saa arvot, mikäli kursori on objektin sisäpuolella ja palauttaa totuusarvon.
        public boolean sisalla(int hiiriX, int hiiriY, Nappi np) {
            
            this.hiiriX = hiiriX;
            this.hiiriY = hiiriY;
            this.x = np.getX();
            this.y = np.getY();
            this.leveys = np.getLeveys();
            this.korkeus = np.getKorkeus();
            
            if(this.hiiriX >= this.x && this.hiiriX <= this.x + this.leveys && this.hiiriY > this.y && this.hiiriY <= this.y + this.korkeus){
                return true;
            } else {
            return false;
            }
        }
        
        //Onko kursori saavutusikonien päällä
        public boolean sisalla(int hiiriX, int hiiriY, Saavutus saa) {
            
            this.hiiriX = hiiriX;
            this.hiiriY = hiiriY;
            this.x = saa.getX();
            this.y = saa.getY();
            this.leveys = saa.getLeveys();
            this.korkeus = saa.getKorkeus();
            
            if(this.hiiriX >= this.x && this.hiiriX <= this.x + this.leveys && this.hiiriY > this.y && this.hiiriY <= this.y + this.korkeus){
                return true;
            } else {
            return false;
            }
        }
}
