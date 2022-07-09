package PROYECTO;


import javax.microedition.lcdui.Alert;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.Gauge;
import javax.microedition.lcdui.Image;
import javax.microedition.lcdui.ImageItem;
import javax.microedition.lcdui.StringItem;
import javax.microedition.lcdui.TextField;
import javax.microedition.lcdui.Ticker;
import javax.microedition.midlet.*;

/**
 * @author ALDAIR GONZALEZ LEYVA
 */
public class PROYECTO extends MIDlet implements CommandListener{
    public Display pantalla;
    public Form frmIng, frmOut, frmMag;
    public TextField txtBand1, txtBand2, txtMulti, txtTole;
    public Ticker Banner;
    Image img;
    ImageItem imgItem;
    Gauge gauge;
    public StringItem strInfo;
    Command btCalcu, btSalir, btFicha;
    
    public PROYECTO(){
        pantalla = Display.getDisplay(this);
        frmMag = new Form("CALCULADORA DE RESISTENCIA");
        try{
            img = Image.createImage("RESISTENCIA.png");
        }
        catch(Exception e){
            e.getMessage();
        }
        imgItem = new ImageItem("¡¡BIENVENIDO!!", img, ImageItem.LAYOUT_CENTER | ImageItem.LAYOUT_NEWLINE_BEFORE | ImageItem.LAYOUT_NEWLINE_AFTER, null);
  
        frmMag.append(imgItem);
        frmIng = new Form("FICHA DE RESISTENCIA");
        txtBand1 = new TextField("Color banda 1","",10, TextField.ANY);
        txtBand2 = new TextField("Color banda 2","",10, TextField.ANY);
        txtMulti = new TextField("Color de Multiplicador","",10, TextField.ANY);
        txtTole = new TextField("Color de tolerancia","",10, TextField.ANY);
        Banner= new Ticker ("ESCRIBE EN MAYÚSCULA LOS COLORES");
        btCalcu = new Command("CALCULA", Command.OK,1); 
        btFicha = new Command("FICHA", Command.OK,3);
        btSalir = new Command("Salir", Command.EXIT,2); 
        strInfo = new StringItem("","");
        frmOut = new Form("EXPLICACION");
        frmOut.append(strInfo);
        frmOut.addCommand(btSalir);
        frmOut.setCommandListener(this);
        frmIng.append(txtBand1);
        frmIng.append(txtBand2);
        frmIng.append(txtMulti);
        frmIng.append(txtTole);
        frmIng.setTicker(Banner);   
        frmIng.addCommand(btCalcu);
        frmIng.addCommand(btSalir);
        frmIng.addCommand(btFicha);
        frmIng.setCommandListener(this);
        
        
       
        
      
        
    }

    public void startApp() {
        pantalla.setCurrent (frmMag);
        try{
            Thread.sleep(3000);
            pantalla.setCurrent(frmIng);
        }
        catch(InterruptedException ex){
            ex.printStackTrace();
        }
     
    }
    
    public void pauseApp() {
    }
    
    public void destroyApp(boolean unconditional) {
    }

    public void commandAction(Command c, Displayable d) {
       int calcu=0;
       String banda1 = txtBand1.getString();
       String n1="";
       String banda2 = txtBand2.getString();
       String n2="";
       String banda3 = txtMulti.getString();
       int n3=0;
       String banda4 = txtTole.getString();
       String n4="";
       
      
          if("NEGRO".equals(banda1)){
            n1="0";
            }
            if("CAFE".equals(banda1)){
            n1="1";
            }
            if("ROJO".equals(banda1)){
            n1="2";
            }
            if("NARANJA".equals(banda1)){
            n1="3";
            }
            if("AMARILLO".equals(banda1)){
            n1="4";
            }
            if("VERDE".equals(banda1)){
            n1="5";
            }
            if("AZUL".equals(banda1)){
            n1="6";
            }
            if("VIOLETA".equals(banda1)){
            n1="7";
            }
            if("GRIS".equals(banda1)){
            n1="8";
            }
            if("BLANCO".equals(banda1)){
            n1="9";
            }
           
           
            
            if("NEGRO".equals(banda2)){
            n2="0";
            }
            if("CAFE".equals(banda2)){
            n2="1";
            }
            if("ROJO".equals(banda2)){
            n2="2";
            }
            if("NARANJA".equals(banda2)){
            n2="3";
            }
            if("AMARILLO".equals(banda2)){
            n2="4";
            }
            if("VERDE".equals(banda2)){
            n2="5";
            }
            if("AZUL".equals(banda2)){
            n2="6";
            }
            if("VIOLETA".equals(banda2)){
            n2="7";
            }
            if("GRIS".equals(banda2)){
            n2="8";
            }
            if("BLANCO".equals(banda2)){
            n2="9";
            }
            
            
            
            if("NEGRO".equals(banda3)){
            n3=1;
            }
            if("CAFE".equals(banda3)){
            n3=10;
            }
            if("ROJO".equals(banda3)){
            n3=100;
            }
            if("NARANJA".equals(banda3)){
            n3=1000;
            }
            if("AMARILLO".equals(banda3)){
            n3=10000;
            }
            if("VERDE".equals(banda3)){
            n3=100000;
            }
            if("AZUL".equals(banda3)){
            n3=1000000;
            }
            if("VIOLETA".equals(banda3)){
            n3=10000000;
            }
            if("GRIS".equals(banda3)){
            n3=100000000;
            }
            if("BLANCO".equals(banda3)){
            n3=1000000000;
            }
            
            
            
            if("ROJO".equals(banda4)){
            n4="2% de Tolerancia";
            }
            if("DORADO".equals(banda4)){
            n4="5% de Tolerancia";
            }
            if("PLATA".equals(banda4)){
            n4="10% de Tolerancia";
            }
            
            
            
            
            String CS=n1+n2;
            int newConce = Integer.parseInt(CS);
            int total= newConce*n3;
        
            String resul="";
          
       
       
       if(c==btCalcu){
          
            if(total<1000){
            resul=total+"Ω con "+n4;
            pantalla.setCurrent (new Alert(resul));           
            }
            if(total>=1000 && total<=999999){
            total=total/1000; 
            resul=total+"KΩ con "+n4;            
            pantalla.setCurrent (new Alert(resul));
            }
            if(total>=1000000){
            total=total/1000000;    
            resul=total+"MΩ con "+n4;
            pantalla.setCurrent (new Alert(resul));           
            }
             strInfo.setText("\nValor total: "+resul+"\n\nBanda 1: "+n1+"\nBanda 2: "+n2+"\nMultiplicador: "+
                  n3+"\nTolerancia: "+n4+"\n\nSe concatena el valor de las dos bandas ("+newConce+") y el numero dado se le multiplica por el multiplicador("+n3+") y se añade la tolerancia ("+n4+").");
           }
        if(c==btFicha){
                    
         
                pantalla.setCurrent (frmOut);
            }      
                          
       else 
           if(c==btSalir) {
               destroyApp(false);
           
       }
       throw new UnsupportedOperationException("Not supported yet.");
    }
}