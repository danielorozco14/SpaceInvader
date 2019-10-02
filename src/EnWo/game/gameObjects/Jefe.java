/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EnWo.game.gameObjects;

import EnWo.game.Gui;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import javax.swing.JLabel;

public class Jefe {

    private static final int DIAMETER = 170;
    public int x = 8000;
    public int vida;
    int y = -70;
    int xa = -1;
    int ya = 1;
    boolean mov=false;
    private Gui game;
    public JLabel label;
    public JLabel label2;
    public boolean golpeado;
    public static long timeBetweenDucks = 1000000000L / 2;
    public static long lastDuckTime = 0;
    public static long timeBetweenDucks2 = 1000000000L / 2;
    public static long lastDuckTime2 = 0;

    public Jefe(Gui game, JLabel label, int x, JLabel label2, int vida) {
        this.vida = vida;
        this.game = game;
        this.x = 10;
        this.label = label;
        this.label2 = label2;
        golpeado = false;
    }

    public void move() {

        label.setLocation(y, x);
        label2.setLocation(y, x);
        label2.setVisible(golpeado);
       if(mov==false){
           mov=true;
           y=0;
       }
        
       if (y > 900) {
            ya = -1;
        }
       if (y <= 0) {
            ya = 1;
           
        }
        y = y + ya;

    }

    private boolean collision() {
        return game.Character.getBounds().intersects(getBounds());
    }

    public void paint(Graphics2D g) {
        g.fillOval(x + 90, y + 120, DIAMETER, DIAMETER);
    }

    public Rectangle getBounds() {
        return new Rectangle(x + 90, y + 120, DIAMETER, DIAMETER);
    }

}
