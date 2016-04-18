/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thermostat;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Dustin
 */
public class Thermostat {
    static ArrayList<Sensor> List= new ArrayList();

    public static void main(String[] args) throws InterruptedException {
        DrawBackground background=new DrawBackground();
        JFrame application=new JFrame();
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        application.add(background);
        application.setSize(800, 600);        
        application.setVisible(true);
        application.setFocusable(true);
        
        while(true){
        for (Sensor sense:List){
            HandleSensor(sense);
        }
        Thread.sleep(1000);
        }
    }
    static void HandleSensor(Sensor sense){
        // collect data
        // update sensor
        // database stuff
    }
    static void AddSensor(){List.add(new Sensor());}
    static void DeleteSensor(int del){List.remove(del);
    }
    static void DataForDraw(){
    }
}
    class Sensor{
        int id;
        int THigh;
        int TLow;
        int Temp;
        boolean ACMode;
        boolean TempOutOfBounds;
        Sensor(){}
    }
    class DrawBackground extends JPanel{
    int page=0;
DrawBackground(){this.addMouseListener(new MouseListener() {

    @Override
    public void mouseClicked(MouseEvent e) {
        
        
        }

    @Override
    public void mousePressed(MouseEvent e) {
        int x1=e.getX();int y1=e.getY();
        ProcessClick(x1,y1);
        repaint();
        }

    @Override
    public void mouseReleased(MouseEvent e) {
        }

    @Override
    public void mouseEntered(MouseEvent e) {
        }

    @Override
    public void mouseExited(MouseEvent e) {
        }
});}

void ProcessClick(int x1, int y1){
    if(y1>getHeight()/4){
    if(page==0){ProcessZero(x1,y1);}
    
    }
    else ProcessMenu(x1);
}
public void paintComponent(Graphics g){
    super.paintComponent(g);
    
    if(page==0){PageZero(g);}
    else if(page==1){PageOne(g);}
    else if(page==2){PageTwo(g);}
    else if(page==3){PageThree(g);}
    else if(page==4){PageFour(g);}
    else PageZero(g);
    drawMenu(g);
}
public void drawMenu(Graphics g){
    int height=getHeight()/4;
    int width=getWidth()/4;
    g.setColor(Color.red);
    g.fillRect(0, 0, width, height);
    g.setColor(Color.ORANGE);
    g.fillRect(width,0,width,height);
    g.setColor(Color.blue);
    g.fillRect(width*2, 0, width, height);
    g.setColor(Color.GREEN);
    g.fillRect(width*3, 0, width, height);
    g.setColor(Color.BLACK);
    g.drawRect(0, 0, width, height);
    g.drawRect(width,0,width,height);
    g.drawRect(width*2, 0, width, height);
    g.drawRect(width*3, 0, width, height);
    Font currentFont = g.getFont();
    Font newFont = currentFont.deriveFont(currentFont.getSize() * 1.8F);
    g.setFont(newFont);
    g.drawString("Page Zero", width/4, height*11/20);
    g.drawString("Page One", width+width/4, height*11/20);
    g.drawString("Page Two", 2*width+width/4, height*11/20);
    g.drawString("Page Three", 3*width+width/4, height*11/20);

}
public void ProcessMenu(int x){
    if(x<getWidth()/4){page=0;}
    else if(x<getWidth()/2){page=1;}
    else if(x<getWidth()*3/4){page=2;}
    else page=3;

}
public void ProcessZero(int x1, int y1){
    if(x1>getWidth()/4 && x1<getWidth()*3/4){page=1;}
}
public void PageZero(Graphics g){
    g.setColor(Color.black);
    g.fillRect(0, getHeight()/4, getWidth(), getHeight()*3/4);
    g.setColor(Color.blue);
    g.fillRect(getWidth()/4, getHeight()/4+getHeight()*3/16, getWidth()/2, getHeight()*3/8);

}
public void PageOne(Graphics g){
    g.setColor(Color.blue);
    g.fillRect(0, getHeight()/4, getWidth(), getHeight()*3/4);
    g.setColor(Color.black);
    g.fillRect(getWidth()/4, getHeight()/4+getHeight()*3/16, getWidth()/2, getHeight()*3/8);
}
public void PageTwo(Graphics g){
    g.setColor(Color.red);
    g.fillRect(0, getHeight()/4, getWidth(), getHeight()*3/4);
    g.setColor(Color.orange);
    g.fillRect(getWidth()/4, getHeight()/4+getHeight()*3/16, getWidth()/2, getHeight()*3/8);
}
public void PageThree(Graphics g){
    g.setColor(Color.GREEN);
    g.fillRect(0, getHeight()/4, getWidth(), getHeight()*3/4);
    g.setColor(Color.white);
    g.fillRect(getWidth()/4, getHeight()/4+getHeight()*3/16, getWidth()/2, getHeight()*3/8);
}
public void PageFour(Graphics g){}
 
}

