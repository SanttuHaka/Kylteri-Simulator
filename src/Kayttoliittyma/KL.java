package Kayttoliittyma;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

//Ladataan kaikki kuvat/grafiikat
public class KL {
    
    public BufferedImage TKKK;
    public BufferedImage sakke;
    public BufferedImage tyo1;
    public BufferedImage[] sijoitukset = new BufferedImage[5];
    

    public KL() {
        
        try {
            sakke = ImageIO.read(new File("kuvat/sakke.png"));
            TKKK = ImageIO.read(new File("kuvat/TKKK.jpg"));
            tyo1 = ImageIO.read(new File("kuvat/tyo.jpg"));
            
            for(int i = 0; i < sijoitukset.length; i++){
                sijoitukset[i] = ImageIO.read(new File("kuvat/sijoitus" + (i + 1) + ".png"));
            }
            

        } catch (IOException e) {
            
            e.printStackTrace();
        }
    }
}
