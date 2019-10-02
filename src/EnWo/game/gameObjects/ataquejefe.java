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

public class ataquejefe {

    private static final int DIAMETER = 55;
    public int x = 1000;
    int y = 0;
    int xa = -1;
    int ya = 1;
    private Gui game;
    public JLabel label;
    public JLabel golpe;
    public int flag;
    public static long timeBetweenDucks = 1000000000L / 2;
    public static long lastDuckTime = 0;
    public static long timeBetweenDucks2 = 1000000000L / 2;
    public static long lastDuckTime2 = 0;

    public ataquejefe(Gui game, int y, JLabel label, JLabel golpe) {

        this.game = game;
        this.y = y;
        this.label = label;
        this.golpe = golpe;
    }

    public void move() {

        if (x + xa > game.getWidth() - DIAMETER) {
            xa = -1;
        }
        if (y + ya < 0) {
            ya = 1;
        }
        if (y + ya > game.getHeight() - DIAMETER) {
            ya = -1;
        }
//			
        if (collision()) {
            golpe.setLocation(x + xa - 30, y + ya - 50);
            flag = 2;

        }
        if (collision() == false) {
            if (flag == 2) {
                game.vida -= 1;
                System.out.println(game.vida);
                flag = 0;
                if (game.vida <= 0) {
                    game.gameOver();
                   
                }
            }

        }

        label.setLocation(x + xa - 30, y + ya - 50);

        x = x + xa;
        y = y + ya;
    }

    private boolean collision() {
        return game.Character.getBounds().intersects(getBounds());
    }

    public void paint(Graphics2D g) {
        g.fillOval(x, y, DIAMETER, DIAMETER);
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, DIAMETER, DIAMETER);
    }

}
