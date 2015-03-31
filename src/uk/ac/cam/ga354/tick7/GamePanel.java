package uk.ac.cam.ga354.tick7;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

import uk.ac.cam.acr31.life.World;


public class GamePanel extends JPanel {
private int zoom = 10; //Number of pixels used to represent a cell
private int width = 1; //Width of game board in pixels
private int height = 1;//Height of game board in pixels
private World current = null;

public Dimension getPreferredSize() {
return new Dimension(width, height);
}

protected void setZoom(int a){
	zoom = a;
	return;
}
protected void paintComponent(Graphics g) {
if (current == null) return;
g.setColor(java.awt.Color.WHITE);
g.fillRect(0, 0, width, height);
current.draw(g, width, height);
if (zoom > 4) {
	   g.setColor(java.awt.Color.LIGHT_GRAY);
	   for(int x = 0; x<width; x += zoom){
	      g.drawLine(x,0,x,height);
	   }
	    for (int y=0; y<height; y += zoom){
	      g.drawLine(0,y,width,y);
	    }
	  }
	 }

private void computeSize() {
if (current == null)  return;
int newWidth = current.getWidth() * zoom;
int newHeight = current.getHeight() * zoom;
if (newWidth != width || newHeight != height) {
 width = newWidth;
 height = newHeight;
 revalidate(); //trigger the GamePanel to re-layout its components
}
}

public void display(World w) {
current = w;
computeSize();
repaint();
}
}