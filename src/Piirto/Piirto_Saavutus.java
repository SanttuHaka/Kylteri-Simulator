
package Piirto;

import Kayttoliittyma.Gui;
import Kayttoliittyma.KL;
import Toiminnot.Main;
import java.awt.Color;
import java.awt.Font;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JLabel;

public class Piirto_Saavutus extends JLabel {
    
    Gui gui = new Gui();
    KL kl = new KL();
    
    int tekstiLeveys;
    
    @Override
    protected void paintComponent(Graphics g){
                
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            
        //Jos saavutusosio on klikattu auki
            if(Gui.nSaavutukset.isActive()){
                
                g.setColor(Color.BLACK);
                g.fillRect(1024, 41, gui.leveys/5, gui.korkeus - 41);
                
                for(int i= 0; i<Main.saavutusMaara; i++){
                    
                    g.setFont(new Font("BookMan", Font.BOLD, 40));
                    
                    if(!Gui.saavutus[i].isUnlocked()){
                        //Tehdään kyssärilaatikko jos saavutusta ei ole saavutettu
                        g.setColor(Color.BLACK);
                        g.fillRect(Gui.saavutus[i].getX(), Gui.saavutus[i].getY(), Gui.saavutus[i].getLeveys(), Gui.saavutus[i].getKorkeus());
                        g.setColor(Color.RED);
                        String s = "?";
                        tekstiLeveys = g.getFontMetrics().stringWidth(s);
                        g.drawString(s, Gui.saavutus[i].getX() + (Gui.saavutus[i].getLeveys()/2) - (tekstiLeveys/2), Gui.saavutus[i].getY() + Gui.saavutus[i].getKorkeus() - 9);
                        g.setColor(Color.lightGray);
                        g.drawRect(Gui.saavutus[i].getX(), Gui.saavutus[i].getY(), Gui.saavutus[i].getLeveys() - 1, Gui.saavutus[i].getKorkeus() - 1);
                    } else {
                        g.setColor(Gui.saavutus[i].getVari());
                        g.fillRect(Gui.saavutus[i].getX(), Gui.saavutus[i].getY(), Gui.saavutus[i].getLeveys(), Gui.saavutus[i].getKorkeus());
                        g.setColor(Color.WHITE);
                        String s = "" + Gui.saavutus[i].getNro();
                        tekstiLeveys = g.getFontMetrics().stringWidth(s);
                        g.drawString(s, Gui.saavutus[i].getX() + (Gui.saavutus[i].getLeveys()/2) - (tekstiLeveys/2), Gui.saavutus[i].getY() + Gui.saavutus[i].getKorkeus() - 9);
                        g.setColor(Color.lightGray);
                        g.drawRect(Gui.saavutus[i].getX(), Gui.saavutus[i].getY(), Gui.saavutus[i].getLeveys() - 1, Gui.saavutus[i].getKorkeus() - 1);
                    }
                    
                    //Jos hiiri on saavutusikonin päällä
                    if(Gui.saavutus[i].isHover()){
                        g.setColor(Color.WHITE);
                        g.drawRect(Gui.saavutus[i].getX(), Gui.saavutus[i].getY(), Gui.saavutus[i].getLeveys() - 1, Gui.saavutus[i].getKorkeus() - 1);
                        
                        //Saavutustekstien muotoilu
                        g.setFont(new Font("BookMan", Font.PLAIN, 15));
                        
                        String s;
                        
                        //Saavutuksen nimi
                        s = Gui.saavutus[i].getNimi();

                        tekstiLeveys = g.getFontMetrics().stringWidth(s);
                        g.drawString(s, (int)((gui.leveys - (gui.leveys/5)) + (gui.leveys/10) - (tekstiLeveys/2)), 590);
                        
                        //Saavutuksen selittävä teksti
                        if(!Gui.saavutus[i].isUnlocked()){
                            s = "?";
                        } else {
                            s = Gui.saavutus[i].getTeksti();
                        }
                        tekstiLeveys = g.getFontMetrics().stringWidth(s);
                        g.drawString(s, (int)((gui.leveys - (gui.leveys/5)) + (gui.leveys/10) - (tekstiLeveys/2)), 645);
                        
                        //Näiden välillä oleva pieni viiva
                        g.setColor(new Color(255,255,255,75));
                        g.drawLine((int)(gui.leveys - (gui.leveys/5)) + (gui.leveys/10) - (tekstiLeveys/4), 610, (int)(gui.leveys - (gui.leveys/5)) + (gui.leveys/10) + (tekstiLeveys/4), 610);
                    }
                }
                
                g.setColor(new Color(255,255,255,75));
                g.drawLine((gui.leveys - (gui.leveys/5)) + 1, 550, gui.leveys, 550);
            }
            
            for(int i = 0; i<Gui.saavutusSlider.length; i++){
                if(Gui.saavutusSlider[i].isNakyyko()){
                    g.setColor(Gui.saavutus[i].getVari());
                    g.fillRect((Gui.saavutusSlider[i].getX() + 5), Gui.saavutusSlider[i].getY()+5, 40, 40);
                    g.setColor(Color.WHITE);
                    g.setFont(new Font("BookMan", Font.BOLD, 34));
                    String s = "" + Gui.saavutus[i].getNro();
                    tekstiLeveys = g.getFontMetrics().stringWidth(s);
                    g.drawString(s, Gui.saavutusSlider[i].getX() + 25 - (tekstiLeveys/2), Gui.saavutusSlider[i].getY()+39);
                    g.drawRect(Gui.saavutusSlider[i].getX(), Gui.saavutusSlider[i].getY(), Gui.saavutusSlider[i].getLeveys(), Gui.saavutusSlider[i].getKorkeus());
                    g.setFont(new Font("BookMan", Font.PLAIN, 10));
                    g.drawString(Gui.saavutusSlider[i].getTeksti(), Gui.saavutusSlider[i].getX() + 60, Gui.saavutusSlider[i].getY() + 30);
                }
            }
            
            
            repaint();
        }
    
}
