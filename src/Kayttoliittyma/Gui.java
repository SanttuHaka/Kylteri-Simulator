package Kayttoliittyma;

import Toiminnot.Main;
import Toiminnot.Hiiri;
import Piirto.Piirto_Paivitys;
import Piirto.Piirto_Napit;
import Piirto.Piirto_Main;
import Piirto.Piirto_Saavutus;
import Piirto.Piirto_Sijoitukset;
import Toiminnot.Data;

import javax.swing.JFrame;

//Käyttöliittymän luonti
public class Gui {
    
    JFrame jf;
    
    Piirto_Main p;
    Piirto_Napit pn;
    Piirto_Paivitys pp;
    Piirto_Saavutus sa;
    Piirto_Sijoitukset ps;
    
    KL kl = new KL();
    
    //Peliruudun koko
    public final int leveys = 1280;
    public final int korkeus = 720;
    
    public static int maxKorkeus, oikeaKorkeus = 0;
    
    public static Nappi nPaivitykset, nSaavutukset;
    public static Nappi paivKlikkeri, nKlikkeri;
    public static Nappi nTallenna, nLataa;
    
    public static Saavutus saavutus[] = new Saavutus[Main.saavutusMaara];
    public static SaavutusSlider saavutusSlider[] = new SaavutusSlider[Main.saavutusMaara];
    public static Nappi paivNappi[] = new Nappi[Main.paivMaara];
    public static Paivitys paivitys[] = new Paivitys[Main.paivMaara];
    
    public void luoGui(){
        
        //----------------------------------------------------------------------
        
        //Nappuloiden määrittely (Sijainti x, Sijainti y, Napin leveys, Napin korkeus)
        nPaivitykset = new Nappi(leveys- 256, 0, 128, 40);
        nSaavutukset = new Nappi(leveys - 128, 0, 128, 40);
        
        //Klikkerinapit
        nKlikkeri = new Nappi(53, 250, 150, 150);
        paivKlikkeri = new Nappi(53, 500, 150, 50);
        
        //Valikon tallennus & lataus
        nTallenna = new Nappi(0, 0, 128, 40);
        nLataa = new Nappi(128, 0, 128, 40);
        
        //----------------------------------------------------------------------
        
        
        //Päivitysvalikko aktiiviseksi alussa
        nPaivitykset.active = true;
        
        //Paivitysnappuloiden määrittely
        for(int i = 0; i<paivitys.length; i++){
            paivNappi[i] = new Nappi();
            paivNappi[i].y = 40 + (i*150);
            paivNappi[i].x = leveys - (leveys/5);
            paivNappi[i].leveys = leveys/5;
            paivNappi[i].korkeus = 150;
        }
        
        //Paivitysten määrittely (Nimi, Järjestys, Päivityksen hinta)
        paivitys[0] = new Paivitys("Mehukoju", 15);
        paivitys[1] = new Paivitys("Parkkipirkko", 100);
        paivitys[2] = new Paivitys("Mainostaulu", 1100);
        paivitys[3] = new Paivitys("Daatta Consulting", 12000);
        paivitys[4] = new Paivitys("Assari Ventures", 130000);
        
        //Antaa päivityksille y-koordinaatit
        for(int i = 0; i<paivitys.length; i++){
            paivitys[i].setY(Paivitys.setYKoord(i));
        }
        
        maxKorkeus = (40 + (paivitys.length * 150));
        
        
        int temp = 0;
        int yEri = 0;
        int xEri = 0;
        
        //Saavutusten asettelu, max 4 per rivi
        for(int i = 0; i<saavutus.length; i++){
            saavutus[i] = new Saavutus((leveys - (leveys/5)) + 6 + xEri, 46 + yEri, (i+1));
            
            temp++;
            
            if(temp % 5 == 0){
                temp = 0;
                yEri += 52;
            }
            
            xEri = temp * 46 + temp * 4;
        }
        
        Data.setSaavutusNimi();
        Data.setSaavutusTeksti();
        
        for(int i = 0; i<saavutusSlider.length; i++){
            saavutusSlider[i] = new SaavutusSlider(saavutus[i]);
        }
        
        
        //Ruudun luonti
        jf = new JFrame("KylteriSim");
        jf.setSize(leveys,korkeus);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setLocationRelativeTo(null);
        jf.addMouseWheelListener(new Hiiri());
        jf.setResizable(false);
        
        
        //Sijoituskuvien piirto
        ps = new Piirto_Sijoitukset();
        ps.setSize(leveys,korkeus);
        ps.setVisible(true);
        ps.requestFocus();
        ps.addMouseListener(new Hiiri());
        ps.addMouseMotionListener(new Hiiri());
        
        jf.add(ps);
        
        //Päivitys-osion luonti
        pp = new Piirto_Paivitys();
        pp.setSize(leveys,korkeus);
        pp.setVisible(true);
        pp.requestFocus();
        pp.addMouseListener(new Hiiri());
        pp.addMouseMotionListener(new Hiiri());
        
        jf.add(pp);
        
        //Saavutus-osion luonti
        sa = new Piirto_Saavutus();
        sa.setSize(leveys,korkeus);
        sa.setVisible(true);
        sa.requestFocus();
        sa.addMouseListener(new Hiiri());
        sa.addMouseMotionListener(new Hiiri());
        
        jf.add(sa);
        
        //Nappuloiden luonti
        pn = new Piirto_Napit();
        pn.setSize(leveys,korkeus);
        pn.setVisible(true);
        pn.requestFocus();
        pn.addMouseListener(new Hiiri());
        pn.addMouseMotionListener(new Hiiri());
        
        jf.add(pn);
        
        //Hiiren tilan luonti
        p = new Piirto_Main();
        p.setSize(leveys,korkeus);
        p.setVisible(true);
        p.requestFocus();
        p.addMouseListener(new Hiiri());
        p.addMouseMotionListener(new Hiiri());
        
        jf.add(p);
        
        jf.setVisible(true);
    }
}
