
package Piirto;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JLabel;
import Kayttoliittyma.Gui;
import Kayttoliittyma.KL;

//PÄÄMENU NAPIT
public class Piirto_Napit extends JLabel{
    
    Gui gui = new Gui();
    KL kl = new KL();
    
    int tekstiLeveys;
    
    @Override
    protected void paintComponent(Graphics g){
                
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        //Työnappi
        if(Gui.nKlikkeri.isActive()){
            g.drawImage(kl.tyo1, Gui.nKlikkeri.getX() + 15, Gui.nKlikkeri.getY() + 15, Gui.nKlikkeri.getLeveys() - 30, Gui.nKlikkeri.getKorkeus() - 30, null);
        } else {
            g.drawImage(kl.tyo1, Gui.nKlikkeri.getX(), Gui.nKlikkeri.getY(), Gui.nKlikkeri.getLeveys(), Gui.nKlikkeri.getKorkeus(), null);
        }
    
        //Ylänappien tekstimuotoilu
        g.setFont(new Font("Arial", Font.BOLD, 15));
        
        
        //PÄIVITYKSET

        g.setColor(Color.BLACK);
        g.fillRect(Gui.nPaivitykset.getX(), Gui.nPaivitykset.getY(), Gui.nPaivitykset.getLeveys(), Gui.nPaivitykset.getKorkeus());
        
        //Asetetaan napin väri erilaiseksi jos kyseinen menu on aktiivisena
        if(Gui.nPaivitykset.isActive()){
            g.setColor(new Color(0,149,20));
            g.fillRect(Gui.nPaivitykset.getX(), Gui.nPaivitykset.getY(), Gui.nPaivitykset.getLeveys(), Gui.nPaivitykset.getKorkeus());
        }
        
        if(Gui.nPaivitykset.isHover()){
            g.setColor(new Color(84, 84, 84, 150));
            g.fillRect(Gui.nPaivitykset.getX(), Gui.nPaivitykset.getY(), Gui.nPaivitykset.getLeveys(), Gui.nPaivitykset.getKorkeus());
        } else {
            g.setColor(Color.WHITE);
        }
        
        //Kirjoitetaan teksti
        g.setColor(Color.WHITE);
        tekstiLeveys = g.getFontMetrics().stringWidth("Sijoitukset");
        g.drawString("Sijoitukset", gui.leveys - 256 + (tekstiLeveys/3), 25);

        
        //SAAVUTUKSET
        
        //Asetetaan napin väri erilaiseksi jos kyseinen menu on aktiivisena
        g.setColor(Color.BLACK);
        g.fillRect(Gui.nSaavutukset.getX(), Gui.nSaavutukset.getY(), Gui.nSaavutukset.getLeveys(), Gui.nSaavutukset.getKorkeus());
        
        if(Gui.nSaavutukset.isActive()){
            g.setColor(Color.RED);
            g.fillRect(Gui.nSaavutukset.getX(), Gui.nSaavutukset.getY(), Gui.nSaavutukset.getLeveys(), Gui.nSaavutukset.getKorkeus());
        }
        
        if(Gui.nSaavutukset.isHover()){
            g.setColor(new Color(84, 84, 84, 150));
            g.fillRect(Gui.nSaavutukset.getX(), Gui.nSaavutukset.getY(), Gui.nSaavutukset.getLeveys(), Gui.nSaavutukset.getKorkeus());
        } else {
            g.setColor(Color.WHITE);
        }
        
        //Luodaan napin teksti
        g.setColor(Color.WHITE);
        tekstiLeveys = g.getFontMetrics().stringWidth("Saavutukset");
        g.drawString("Saavutukset", gui.leveys - 128 + (tekstiLeveys/4), 25);
        
        
        //Tallennus
        
        if(Gui.nTallenna.isHover()){
            g.setColor(new Color(84, 84, 84, 150));
            g.fillRect(Gui.nTallenna.getX(), Gui.nTallenna.getY(), Gui.nTallenna.getLeveys(), Gui.nTallenna.getKorkeus());
        } else {
            g.setColor(Color.WHITE);
        }
        
        //Luodaan napin teksti
        g.setColor(Color.WHITE);
        tekstiLeveys = g.getFontMetrics().stringWidth("Tallenna");
        g.drawString("Tallenna", (Gui.nTallenna.getLeveys())/2 - (tekstiLeveys/2), 25);
        
        //Lataa

        if(Gui.nLataa.isHover()){
            g.setColor(new Color(84, 84, 84, 150));
            g.fillRect(Gui.nLataa.getX(), Gui.nLataa.getY(), Gui.nLataa.getLeveys(), Gui.nLataa.getKorkeus());
        } else {
            g.setColor(Color.WHITE);
        }
        
        //Luodaan napin teksti
        g.setColor(Color.WHITE);
        tekstiLeveys = g.getFontMetrics().stringWidth("Lataa");
        g.drawString("Lataa", (Gui.nLataa.getX()) + (Gui.nLataa.getLeveys()/2) - (tekstiLeveys/2), 25);
        
        
        repaint();
        
    }

}
