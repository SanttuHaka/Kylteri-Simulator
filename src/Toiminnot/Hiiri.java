
package Toiminnot;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import Kayttoliittyma.Gui;
import Kayttoliittyma.Nappi;
import Kayttoliittyma.Paivitys;

//Hiiren toiminnot eri tilanteissa
// TÄÄLLÄ MYÖS HINTA- JA TEHOKERTOIMET
public class Hiiri implements MouseListener, MouseMotionListener, MouseWheelListener{
    
    Gui gui = new Gui();
    HiiriCollision hc = new HiiriCollision();

    @Override
    public void mouseClicked(MouseEvent e) {
    }
    
    //Kun hiirtä painetaan
    @Override
    public void mousePressed(MouseEvent e) {
        
        //Jos painetaan päivitykset-nappia
        if(hc.sisalla(e.getX(), e.getY(), Gui.nPaivitykset)){
            Nappi.setActive(Gui.nPaivitykset);
        }
        
        //Jos painetaan saavutukset-nappia
        if(hc.sisalla(e.getX(), e.getY(), Gui.nSaavutukset)){
            Nappi.setActive(Gui.nSaavutukset);
        }
        
        
        //Työnappi aktiviteetti
        if(hc.sisalla(e.getX(), e.getY(), Gui.nKlikkeri)){
            Gui.nKlikkeri.setActive(true);
            Main.euroja += Main.epk;
            Main.klikkiLuku ++;
        }
        
        //Päivitysnappula aktiviteetti
        if(Gui.nPaivitykset.isActive()){
            for(int i = 0; i<Gui.paivitys.length; i++){
                //Jos kursori on napin päällä
                if(hc.sisalla(e.getX(), e.getY(), Gui.paivNappi[i])){
                
                    //Jos on tarpeeksi rahnaa päivitykseen
                    if(Main.euroja >= Gui.paivitys[i].getHinta()){
                    
                        //Vähennetään päivityksen hinta
                        Main.euroja -= Gui.paivitys[i].getHinta();
                    
                        //Kasvatetaan päivityksen määrää
                        int maara = Gui.paivitys[i].getMaara();
                        Gui.paivitys[i].setMaara(maara +=1);
                    
                        //Kasvatetaan seuraavan päivityksen hintaa
                        int hinta = Gui.paivitys[i].getHinta();
                        
                    
                        // ----------TÄSSÄ PÄIVITYKSEN HINTAKERROIN
                        if(Gui.paivitys[i].getMaara() < 50){
                            if(Gui.paivitys[i] == Gui.paivitys[0]){
                                Gui.paivitys[0].setHinta(hinta += hinta/5);
                            } else {
                            Gui.paivitys[i].setHinta(hinta += hinta/4);
                            }
                        } else {
                            Gui.paivitys[i].setHinta(hinta += hinta/2);
                        }
                        Paivitys.epsPaivitys(i);
                    }
                }
            }
        }
        
        //Klikkerin päivitys
        if(hc.sisalla(e.getX(), e.getY(), Gui.paivKlikkeri)){
            if(Main.euroja >= Main.paivKlikkeriHinta){
                Main.euroja -= Main.paivKlikkeriHinta;
                
                // --- KLIKKERIHINTAKERROIN
                Main.paivKlikkeriHinta *=1.3;
                
                // --- KLIKKERITEHOKERROIN
                Main.epk = Main.epk + 0.2;
            }
        }
        
        //Pelin tallennus
        if(hc.sisalla(e.getX(), e.getY(), Gui.nTallenna)){
            Data.tallennaData();
        }
        
        //Pelin lataus
        if(hc.sisalla(e.getX(), e.getY(), Gui.nLataa)){
            Data.lataaData();
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
        //Työnappi
        if(Gui.nKlikkeri.isActive()){
            Gui.nKlikkeri.setActive(false);
        }
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void mouseDragged(MouseEvent e) {
    }
    
    //Kun hiiri liikkuu päällä
    @Override
    public void mouseMoved(MouseEvent e) {
        
        //Tsekkaa onko hiiri päivitykset-nappulan päällä
        if(hc.sisalla(e.getX(), e.getY(), Gui.nPaivitykset)) {
            Gui.nPaivitykset.setHover(true);
        } else {
            Gui.nPaivitykset.setHover(false);
        }
        
        //Tsekkaa onko hiiri saavutukset-nappulan päällä
        if(hc.sisalla(e.getX(), e.getY(), Gui.nSaavutukset)) {
            Gui.nSaavutukset.setHover(true);
        } else {
            Gui.nSaavutukset.setHover(false);
        }
        
        
        //Paivitysnappulat
        for(int i = 0; i<Gui.paivNappi.length; i++){
            if(hc.sisalla(e.getX(), e.getY(), Gui.paivNappi[i])) {
            Gui.paivNappi[i].setHover(true);
            } else {
            Gui.paivNappi[i].setHover(false);
            }
        }
        
        //Klikkeripäivitysnappi
        if(hc.sisalla(e.getX(), e.getY(), Gui.paivKlikkeri)) {
            Gui.paivKlikkeri.setHover(true);
        } else {
            Gui.paivKlikkeri.setHover(false);
        }
        
        //Tallennusnappi
        if(hc.sisalla(e.getX(), e.getY(), Gui.nTallenna)) {
            Gui.nTallenna.setHover(true);
        } else {
            Gui.nTallenna.setHover(false);
        }
        
        //Latausnappi
        if(hc.sisalla(e.getX(), e.getY(), Gui.nLataa)) {
            Gui.nLataa.setHover(true);
        } else {
            Gui.nLataa.setHover(false);
        }
        
        
        //////////////////////////
        //SAAVUTUKSET
        //////////////////////////
        
        for(int i = 0; i<Main.saavutusMaara; i++){
            if(hc.sisalla(e.getX(),e.getY(), Gui.saavutus[i])){
                
                Gui.saavutus[i].setHover(true);
                
            }else{
                Gui.saavutus[i].setHover(false);
            }
        }
        
    }
    
    //Kun skrollataan hiirellä
    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {
        
        if(Gui.nPaivitykset.isActive()){
            
            if(e.getX() > (gui.leveys - (gui.leveys/5))){
                
                //Alaspäin skrollaus
                if(e.getWheelRotation() == 1) {
                    Gui.oikeaKorkeus -=10;
                    
                    if(Gui.oikeaKorkeus >= -(Gui.maxKorkeus - 700)){
                        for(int i = 0; i<Gui.paivitys.length; i++){
                            int y1 = Gui.paivitys[i].getY() - 10;
                            int y2 = Gui.paivNappi[i].getY() - 10;
                            
                            Gui.paivitys[i].setY(y1);
                            Gui.paivNappi[i].setY(y2);
                        }
                    }else{
                        Gui.oikeaKorkeus = -(Gui.maxKorkeus - 700);
                    }
                }
                
                //Ylöspäin skrollaus
                if(e.getWheelRotation() == -1) {
                    Gui.oikeaKorkeus +=10;
                    
                    if(Gui.oikeaKorkeus <= 0){
                        for(int i = 0; i<Gui.paivitys.length; i++){
                            int y1 = Gui.paivitys[i].getY() + 10;
                            int y2 = Gui.paivNappi[i].getY() + 10;
                            
                            Gui.paivitys[i].setY(y1);
                            Gui.paivNappi[i].setY(y2);
                        }
                    }else{
                        Gui.oikeaKorkeus = 0;
                    }
                }
            }
        }
        
    }
    
}
