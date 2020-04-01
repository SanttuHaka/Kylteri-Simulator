
package Toiminnot;

import java.util.Timer;
import java.util.TimerTask;

//Tämä luokka on rahamäärän päivitystä varten
public class Laskuri {
    
    Timer laske;

    public Laskuri() {
        
        laske = new Timer();
        laske.scheduleAtFixedRate(new TimerTask() {
            
            
            @Override
            public void run() {
                //Tässä määrätään timerin avulla, että rahan kertyminen/päivitys tapahtuu kerran sekunnin sadasosassa
                Main.euroja += Main.eps/100;
                
            }
        }, 0, 10);
    }
    
}
