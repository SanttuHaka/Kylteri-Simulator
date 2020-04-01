/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Piirto;

import Kayttoliittyma.Gui;
import Kayttoliittyma.KL;
import Toiminnot.Main;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JLabel;

/**
 *
 * @author Santtu
 */
public class Piirto_Sijoitukset extends JLabel {
    
    Gui gui = new Gui();
    KL kl = new KL();


    @Override
    protected void paintComponent(Graphics g){
                
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        //Jokaisen sijoituksen ilmestymisalueen rajat
        int x = 0;
        int y = 0;
        //Kuinka paljon kuva siirtyy x-akselilla
        int kerroin = 1;
        //Kuinka monta yhteen riviin
        int rivissa;

        for (int i = 0; i < 5; i++) {
            rivissa = 4;
            switch (i) {
                //mehu
                case 0:
                    x = 450;
                    y = 450;
                    kerroin = 30;
                    rivissa = 4;
                    break;
                //parkkipirkko
                case 1:
                    x = 900;
                    y = 410;
                    rivissa = 4;
                    break;
                //mainostaulu
                case 2:
                    kerroin = 45;
                    x = 900;
                    y = 125;
                    break;
                //timo
                case 3:
                    x = 950;
                    y = 500;
                    rivissa = 8;
                    kerroin = 50;
                    break;
                    
                //ventures
                case 4:
                    x = 300;
                    y = 25;
                    rivissa = 2;
                    kerroin = 60;
                    
                    break;
                default:
                    break;
            }
            //tallennetaan x:n alkuarvo temppiin
            int tmp = x;
            for(int j = 0; j<Gui.paivitys[i].getMaara(); j++){

                //Vain rivissa kuvaa samaan riviin
                if(j%rivissa == 0 && j != 0){
                    x = tmp;
                    y = y + kerroin;
                }
                //Piirretään kuva
                g.drawImage(kl.sijoitukset[i], x, y, null);
                
                //siirretään seuraavaa kuvaa, ettei mene päällekkäin
                x = x - 2 * kerroin;
                
                
                //__________________PELIN VOITTAMINEN; 1 000 000 € kerääminen________________________________________
                if(Gui.saavutus[7].isUnlocked()){
                    g.drawImage(kl.sakke, 0, 0, null);
                }

                
            }
        }
    }
}
