
package Piirto;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.text.DecimalFormat;
import javax.swing.JLabel;

import Kayttoliittyma.Gui;
import Kayttoliittyma.KL;
import Toiminnot.Main;

//Päivitysosion sisältö
public class Piirto_Paivitys extends JLabel{
    
    Gui gui = new Gui();
    int tekstiLeveys;
    DecimalFormat df = new DecimalFormat ("###,###,###");
    DecimalFormat df2 = new DecimalFormat ("###,###,###.#");
    KL kl = new KL();

    @Override
    protected void paintComponent(Graphics g){
                
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        //Piirretään päivitysnapit jos päivitysvalikko on aktiivisena
        if(Gui.nPaivitykset.isActive()){
            
            for(int i = 0; i< Gui.paivitys.length; i++){
                    

                    //Paivitysnappuloiden tausta
                    
                    g.setColor(Gui.paivitys[i].getVari());
                    g.fillRect(Gui.paivitys[i].getX(), Gui.paivitys[i].getY(), Gui.paivitys[i].getLeveys(), Gui.paivitys[i].getKorkeus());
                
                    //Paivitysnappulaviivat
                    g.setColor(new Color(255,255,255, 150));
                    //Yläviiva
                    g.drawLine((gui.leveys - gui.leveys/5) + 1, Gui.paivitys[i].getY(), gui.leveys, Gui.paivitys[i].getY());
                    //Alaviiva
                    g.drawLine((gui.leveys - gui.leveys/5) + 1, Gui.paivitys[i].getY() + 150, gui.leveys, Gui.paivitys[i].getY() + 150);
                
                    
                    //Määrä
                    g.setColor(Color.WHITE);

                    g.setFont(new Font("Arial", Font.PLAIN ,28));
                    tekstiLeveys = g.getFontMetrics().stringWidth(Integer.toString(Gui.paivitys[i].maara));
                    g.drawString(Integer.toString(Gui.paivitys[i].getMaara()), gui.leveys - 213 + (170-tekstiLeveys)/2, Gui.paivitys[i].getY() + 123);
                
                    //Nimi
                    g.setFont(new Font("Arial", Font.PLAIN, 25));
                    tekstiLeveys = g.getFontMetrics().stringWidth(Gui.paivitys[i].nimi);
                    g.drawString(Gui.paivitys[i].getNimi(), gui.leveys - 213 + (170-tekstiLeveys)/2, Gui.paivitys[i].getY() + 40);
                
                    //Hinta
                    String s = df.format(Gui.paivitys[i].hinta);
                    tekstiLeveys = g.getFontMetrics().stringWidth(s + " €");
                    g.drawString(s + " €", (int)(gui.leveys - 213 + (170-tekstiLeveys)/2), Gui.paivitys[i].getY() + 80);
                
                    //Nappi
                    g.setColor(new Color(255,255,255,75));
                    g.drawRect(Gui.paivNappi[i].getX(), Gui.paivNappi[i].getY(), Gui.paivNappi[i].getLeveys(), Gui.paivNappi[i].getKorkeus());
                
                    if(Gui.paivNappi[i].isHover()){
                        g.setColor(new Color(84,84,84,90));
                        g.fillRect(Gui.paivNappi[i].getX(), Gui.paivNappi[i].getY(), Gui.paivNappi[i].getLeveys(), Gui.paivNappi[i].getKorkeus());
                    }

                }
        }
        
        //Klikkipäivitysnappi
        g.setFont(new Font("Arial", Font.PLAIN, 25));
        g.setColor(new Color(255,255,255,75));
        g.drawRect(Gui.paivKlikkeri.getX(), Gui.paivKlikkeri.getY(), Gui.paivKlikkeri.getLeveys(), Gui.paivKlikkeri.getKorkeus());
        
        if(Gui.paivKlikkeri.isHover()){
            g.setColor(new Color(84,84,84,150));
            g.fillRect(Gui.paivKlikkeri.getX(), Gui.paivKlikkeri.getY(), Gui.paivKlikkeri.getLeveys(), Gui.paivKlikkeri.getKorkeus());
        } else {
            g.setColor(Color.WHITE);
        }
        
        // Klikkipäivitys napin tekstit
        g.setColor(Color.WHITE);
        tekstiLeveys = g.getFontMetrics().stringWidth("Opiskele");
        g.drawString("Opiskele", 53 + (150 - tekstiLeveys)/2, 532);
        
        String s = df.format(Main.paivKlikkeriHinta) + " €";
        tekstiLeveys = g.getFontMetrics().stringWidth(s);
        g.drawString(s, 53 + (150 - tekstiLeveys)/2, 480);
        
        // euroa per klik teksti
        g.setFont(new Font("Arial", Font.PLAIN, 22));
        s = df2.format(Main.epk) + " €/klik";
        tekstiLeveys = g.getFontMetrics().stringWidth(s);
        g.drawString(s, 53 + (150 - tekstiLeveys)/2, 590);
        
        repaint();
        
    }
}
