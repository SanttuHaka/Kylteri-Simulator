
package Toiminnot;

import Kayttoliittyma.Gui;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Scanner;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

//Datan käsittely (Tallennus ja lataus)
public class Data {
    
    File kansio = new File("datat");
    File tiedosto = new File("datat/tallennus.txt");
    StringBuilder sb = new StringBuilder();
    
    public static void tallennaData(){
        
        Data data = new Data();
        
        //Luodaan kansiot ja tiedostot
        if(!data.kansio.exists()){
            data.kansio.mkdirs();
        }
        
        if(!data.tiedosto.exists()){
            try{
                data.tiedosto.createNewFile();
                
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        
        //Datan tallennus
        data.sb.append(Main.euroja);
        data.sb.append("\n");
        data.sb.append(Main.eps);
        data.sb.append("\n");
        data.sb.append(Main.epk);
        data.sb.append("\n");
        data.sb.append(Main.paivKlikkeriHinta);
        data.sb.append("\n");
        
        for(int i = 0; i<Gui.paivitys.length; i++){
            data.sb.append(Gui.paivitys[i].getMaara());
            data.sb.append("\n");
            data.sb.append(Gui.paivitys[i].getHinta());
            data.sb.append("\n");
        }
        
        //Tallennetaan Klikkausten määrä
        data.sb.append(Main.klikkiLuku);
        data.sb.append("\n");
        
        //Tallennetaan saavutukset
        for(int i = 0; i<Main.saavutusMaara; i++){
            if(Gui.saavutus[i].isUnlocked()){
                //Jos on unlockattu niin tallennetaan luku 1
                data.sb.append("1");
                data.sb.append("\n");
            }else{
                //Jos ei oo unlockattu niin tallennetaan luku 0
                data.sb.append("0");
                data.sb.append("\n");
            }
        }
        
        try {
            OutputStream stream = new FileOutputStream(data.tiedosto);
            String s = data.sb.toString();
            
            stream.write(s.getBytes());
            stream.close();

            System.out.println("Tiedosto tallennettu.");
            JOptionPane.showMessageDialog(null, "Peli tallennettu!", "Tallennus", JOptionPane.INFORMATION_MESSAGE);
            
        } catch (IOException e) {
            
            e.printStackTrace();
        }
    }
    
    //Datan lataus
    public static void lataaData(){
        
        JFileChooser valitsin = new JFileChooser();
        
        int temp = valitsin.showOpenDialog(null);
        if(temp == JFileChooser.APPROVE_OPTION){
            String s = valitsin.getSelectedFile().getAbsolutePath();
            if(s.endsWith("tallennus.txt")){
                
                File tiedosto = new File(s);
                try {
                    Scanner sc = new Scanner(tiedosto);
                    
                    //Ladataan tekstistä data
                    Main.euroja = Double.parseDouble(sc.nextLine());
                    Main.eps = Double.parseDouble(sc.nextLine());
                    Main.epk = Double.parseDouble(sc.nextLine());
                    Main.paivKlikkeriHinta = Integer.parseInt(sc.nextLine());
                    
                    //Päivitykset
                    for(int i = 0; i<Gui.paivitys.length; i++){
                        Gui.paivitys[i].setMaara(Integer.parseInt(sc.nextLine()));
                        Gui.paivitys[i].setHinta(Integer.parseInt(sc.nextLine()));
                    }
                    
                    //Klikkausten määrä
                    Main.klikkiLuku = Integer.parseInt(sc.nextLine());
                    
                    //Saavutukset
                    for(int i = 0; i<Main.saavutusMaara; i++){
                        if(sc.nextLine().equals("1")){
                            Gui.saavutus[i].setUnlocked(true);
                        }else{
                            Gui.saavutus[i].setUnlocked(false);
                        }
                    }
                    
                } catch (FileNotFoundException e) {
                    
                    e.printStackTrace();
                    
                }
            }else{
                System.out.println("Tallennustiedoston lukeminen ei onnistunut!");
            }
        }
        
    }
    
    //Poistetaan tallennustiedosto
    public static void poistaData(){
        Data data = new Data();
        int kysy = JOptionPane.showConfirmDialog(null, "Haluatko varmasti poistaa tallennuksesi?", "Poista", JOptionPane.YES_NO_OPTION);
        if(kysy == 0){
            if(!data.kansio.exists()){
                System.out.println("Tiedostoa ei olemassa.");
                JOptionPane.showMessageDialog(null, "Tallennustiedostoa ei olemassa.", "Poisto", JOptionPane.INFORMATION_MESSAGE);
            } else {
                data.tiedosto.delete();
                JOptionPane.showMessageDialog(null, "Tallennus poistettu.", "Poisto", JOptionPane.INFORMATION_MESSAGE);
                System.out.println("Tallennus.txt poistettu.");
            }
        }
    }
    
    public static void latausAlussa(){
        


        File tallennus = new File("datat/tallennus.txt");
        if(tallennus.exists()){
            
            try {
                Scanner sc = new Scanner(tallennus);
                    
                //Ladataan tekstistä data
                Main.euroja = Double.parseDouble(sc.nextLine());
                Main.eps = Double.parseDouble(sc.nextLine());
                Main.epk = Double.parseDouble(sc.nextLine());
                Main.paivKlikkeriHinta = Integer.parseInt(sc.nextLine());
                    
                //Päivitykset
                for(int i = 0; i<Gui.paivitys.length; i++){
                    Gui.paivitys[i].setMaara(Integer.parseInt(sc.nextLine()));
                    Gui.paivitys[i].setHinta(Integer.parseInt(sc.nextLine()));
                }
                    
                //Klikkausten määrä
                Main.klikkiLuku = Integer.parseInt(sc.nextLine());
                    
                //Saavutukset
                for(int i = 0; i<Main.saavutusMaara; i++){
                    if(sc.nextLine().equals("1")){
                        Gui.saavutus[i].setUnlocked(true);
                    }else{
                        Gui.saavutus[i].setUnlocked(false);
                    }
                }
                    
            } catch (FileNotFoundException e) {
                    
                e.printStackTrace();
                    
            }
        }
    }
    
    //Luetaan saavutuksien tekstit
    public static void setSaavutusTeksti(){
        File saaTeksti = new File("datat/saaTeksti.txt");
        if(saaTeksti != null){
            try{
                Scanner sc = new Scanner(saaTeksti);
                for(int i = 0; i<Main.saavutusMaara; i++){
                    Gui.saavutus[i].setTeksti(sc.nextLine());
                }
            }catch (FileNotFoundException e) {
                System.out.println("Saavutustiedostoa ei pystytty lukemaan!");
                e.printStackTrace();
            }
        }
    }
    
    //Luetaan saavutuksien nimet
    public static void setSaavutusNimi(){
        File saaNimi = new File("datat/saaNimi.txt");
        if(saaNimi != null){
            try{
                Scanner sc = new Scanner(saaNimi);
                for(int i = 0; i<Main.saavutusMaara; i++){
                    Gui.saavutus[i].setNimi(sc.nextLine());
                }
            }catch (FileNotFoundException e) {
                System.out.println("Nimitiedostoa ei pystytty lukemaan!");
                e.printStackTrace();
            }
        }
    }
    
}
