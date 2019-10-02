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

public class PlayerShoot {

    private static final int DIAMETER = 55;
    public int x = 1000;
    int y = 0;
    int xa = -1;
    int ya = 1;
    private Gui game;
    public JLabel label;
    private int Damage;

    public int flag;

    public PlayerShoot(Gui game, int y, int x, JLabel label, int dano) {

        this.game = game;
        this.y = y;
        this.label = label;
        this.Damage = dano;
        this.x = x;

    }

    public void move() {
        x = x - 1;
        label.setLocation( y - 100,x);
        if (collision()) {
            game.jefe.vida -= Damage;
            game.jefe.golpeado = true;
            label.setVisible(false);
            if (game.jefe.vida <= 0) {
                game.Victory();
                    
            }
        } else {
            game.jefe.golpeado = false;
        }

    }

    private boolean collision() {
        return game.jefe.getBounds().intersects(getBounds());
    }

    public void paint(Graphics2D g) {
        g.fillOval(x, y, DIAMETER, DIAMETER);
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, DIAMETER, DIAMETER);
    }

}
