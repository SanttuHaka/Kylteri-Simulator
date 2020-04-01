
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

public class Piirto_Main extends JLabel{
    
    Gui valikko = new Gui();
    KL k = new KL();
    
    DecimalFormat df = new DecimalFormat("###,###,###");
    DecimalFormat df2 = new DecimalFormat("###,###,###.##");
    
    String s;
    int tekstinLeveys;
    
    @Override
    protected void paintComponent(Graphics g){
                
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        //Taustakuvan piirto
        g.drawImage(k.TKKK, valikko.leveys/5, 0, valikko.leveys - ( 2 * (valikko.leveys/5)), valikko.korkeus, null);

        //Vasen Pystyviiva
        g.setColor(Color.WHITE);
        g.drawLine(valikko.leveys/5, 0, valikko.leveys/5, valikko.korkeus);
        
        //Vasen Tausta
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, valikko.leveys/5, valikko.korkeus);
        
        //Oikea Pystyviiva
        g.setColor(Color.WHITE);
        g.drawLine(valikko.leveys-257, 0, valikko.leveys-257, valikko.korkeus);
        
        //YläviivaVasen
        g.drawLine(0, 40, 256, 40);
        
        //YläviivaOikea
        g.drawLine(valikko.leveys-256, 40, valikko.leveys, 40);
        
        //Euromäärän numerot
        g.setFont(new Font("Arial", Font.BOLD, 37));
        s = df.format(Main.euroja) + " €";
        tekstinLeveys = g.getFontMetrics().stringWidth(s);
        g.drawString(s, 128-(tekstinLeveys/2), 130);
        
        //Euro per sek numerot
        g.setFont(new Font("Arial", Font.BOLD, 15));
        s = df2.format(Main.eps) + " €/s";
        tekstinLeveys = g.getFontMetrics().stringWidth(s);
        g.drawString(s, 129-(tekstinLeveys/2), 150);
        
        repaint();
    }
    
}
