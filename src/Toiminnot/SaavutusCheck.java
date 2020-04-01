
package Toiminnot;

import Kayttoliittyma.Gui;
import Kayttoliittyma.Paivitys;
import Kayttoliittyma.Saavutus;
import Kayttoliittyma.SaavutusSlider;

import java.util.Timer;
import java.util.TimerTask;

//Luodaan saavutukset ja metodit sille onko ne saavutettu
public class SaavutusCheck {
    
    Timer time;
    
    public SaavutusCheck(){
        
        time = new Timer();
        time.schedule(new TimerTask() {
            
            public void run() {
                
                //Saavutus 1
                //100 klikkausta
                if(!Gui.saavutus[0].isUnlocked()){
                    if(Main.klikkiLuku >= 100){
                        unlock(Gui.saavutus[0], Gui.saavutusSlider[0]);
                        Main.epk = Main.epk * 2;
                    }
                }
                
                //Saavutus 2
                //1000 klikkausta
                if(!Gui.saavutus[1].isUnlocked()){
                    if(Main.klikkiLuku >= 1000){
                        unlock(Gui.saavutus[1], Gui.saavutusSlider[1]);
                        Main.epk = Main.epk * 2;
                    }
                }
                
                //Saavutus 3
                //10 mehukojua
                if(!Gui.saavutus[2].isUnlocked()){
                    if(Gui.paivitys[0].maara >= 10){
                        unlock(Gui.saavutus[2], Gui.saavutusSlider[2]);
                        Main.eps = Main.eps + 10 * Paivitys.eka;
                        Paivitys.eka = Paivitys.eka * 2;
                    }
                }
                
                //Saavutus 4
                //15 pirkkoo = tuplataan pirkkojen ja mehujen tuotanto
                if(!Gui.saavutus[3].isUnlocked()){
                    if(Gui.paivitys[1].maara >= 15){
                        unlock(Gui.saavutus[3], Gui.saavutusSlider[3]);
                        Main.eps = Main.eps+(15*Paivitys.toka) + Paivitys.eka*Gui.paivitys[0].maara;                         
                        Paivitys.toka = Paivitys.toka * 2;
                        Paivitys.eka = Paivitys.eka * 2;
                    }
                }
                
                //Saavutus 5
                //Ensimmäinen timo (data konsultti on timo) = korotetaan kaikkea vähän, koska timo on jumala
                if(!Gui.saavutus[4].isUnlocked()){
                    if(Gui.paivitys[3].maara >= 1){
                        unlock(Gui.saavutus[4], Gui.saavutusSlider[4]);
                        Main.eps = Main.eps + Gui.paivitys[1].maara * Paivitys.toka + Gui.paivitys[0].maara*Paivitys.eka + Gui.paivitys[2].maara*Paivitys.kolmas;
                        Paivitys.eka = Paivitys.eka * 2;
                        Paivitys.toka = Paivitys.toka * 2;
                        Paivitys.kolmas = Paivitys.kolmas * 2;
                        Main.epk = Main.epk *2;
                    }
                }
                
                //Saavutus 6
                //50 päivitystä : parannetaan klikkauksia klik = 0.5*eps
                if(!Gui.saavutus[5].isUnlocked()){
                    int summa = 0;
                    for (Paivitys alkio : Gui.paivitys) {
                        summa = summa + alkio.maara;
                    }
                    if(summa >= 50){
                        unlock(Gui.saavutus[5], Gui.saavutusSlider[5]);
                        Main.epk = Main.epk + Main.eps*0.5;
                    }
                }
                
                //Saavutus 7
                //Kaikki päivitykset ostettu <= kerran : Kaikki jatkossa ostetut tuotteet tuplasti parempia
                if(!Gui.saavutus[6].isUnlocked()){
                    boolean onks = true;
                    for (Paivitys alkio : Gui.paivitys) {
                        if(alkio.maara == 0){
                            onks = false;
                        }
                    }                   
                    if(onks){
                        unlock(Gui.saavutus[6], Gui.saavutusSlider[6]);
                        Paivitys.eka = Paivitys.eka * 2;
                        Paivitys.toka = Paivitys.toka * 2;
                        Paivitys.kolmas = Paivitys.kolmas * 2;
                        Paivitys.neljas = Paivitys.neljas * 2;
                        Paivitys.viides = Paivitys.viides * 2;                        
                    }
                }
                
                //Saavutus 8
                //Riittävä määrä massia, voittaa pelin : sakari esiin?
                if(!Gui.saavutus[7].isUnlocked()){
                    
                    if(Main.euroja >= 1000000){
                        unlock(Gui.saavutus[7], Gui.saavutusSlider[7]);
                        //Tähän sakari
                    }
                }
            }
        }, 1000, 1000);
    }
    
    //Metodi saavutuksen unlockaamiseen ja sen asettamiseksi näkyville
    public static void unlock(Saavutus saavutus, SaavutusSlider slider){
        saavutus.setUnlocked(true);
        slider.setNakyyko(true);
        SaavutusSlider.slideIn(slider);
    }
    
}
