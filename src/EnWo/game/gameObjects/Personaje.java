/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EnWo.game.gameObjects;

import EnWo.game.Gui;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JLabel;

public class Personaje {

    private static final int WITH = 60;
    private static final int HEIGHT = 90;
    int x = 0;
    int xa = 0;
    int xb = 0;
    int y = 500;
    int ya = 500;
    int m = 0;
    public static long timeBetween = 1000000000L / 2;
    public static long lastTime = 0;

    private ArrayList<PlayerShoot> disparos;
    public boolean disparar;
    private boolean desplazar;
    private JLabel label;
    private JLabel label2;
    private Gui game;
    public boolean bajar;
    public boolean retroceder;
    public boolean recargar;
    public boolean iniciado;

    public Personaje(Gui game) {
        this.game = game;
        desplazar = false;
        bajar = false;
        retroceder = false;
        iniciado = false;
        disparar = false;
        recargar = true;

    }

    public boolean isDesplazar() {
        return desplazar;
    }

    public void setDesplazar(boolean desplazar) {
        this.desplazar = desplazar;
    }

    public void move() {
        if (iniciado == false) {
            label.setLocation(10, 500);
            label2.setLocation(10, 500);
            label.setVisible(true);
            label2.setVisible(false);
          
        } 
        if (disparos == null) {
            disparos = new ArrayList<>();
        }
        if (System.nanoTime() - lastTime >= timeBetween * 4) {

            recargar = true;
            lastTime = System.nanoTime();
        }
        if (disparar) {
            if (recargar) {
                disparos.add(new PlayerShoot(getGame(), label.getX(), label.getY(), getGame().CrearDisparos(), getGame().Damage));

                disparar = false;
                recargar = false;
            } else {
                disparar = false;
            }

        }
        for (int i = 0; i < disparos.size(); i++) {
            disparos.get(i).move();
            if (disparos.get(i).x >= 600) {
                disparos.remove(i);
            }

        }
        label.setLocation(label.getX() + xb, label.getY());
        label2.setLocation(label2.getX() + xb, label2.getY());
        x = x + xb;
    }

    public void keyReleased(KeyEvent e) {
        xb = 0;
    }

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
              iniciado=true;
            xb = -10;
        }

        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
              iniciado=true;
            xb = 10;
        }
        if (e.getKeyCode() == KeyEvent.VK_UP) {

        }

        if (e.getKeyCode() == KeyEvent.VK_DOWN) {

        }

    }

    public void paint(Graphics2D g) {
        g.fillRect(x + 60, y, WITH, HEIGHT);
    }

    public ArrayList<PlayerShoot> getDisparos() {
        return disparos;
    }

    public void setDisparos(ArrayList<PlayerShoot> disparos) {
        this.disparos = disparos;
    }

    public JLabel getlabel() {
        return label;
    }

    public void setlabel(JLabel label) {
        this.label = label;
    }

    public Rectangle getBounds() {
        return new Rectangle(x + 60, y, WITH, HEIGHT);
    }

    public JLabel getLabel2() {
        return label2;
    }

    public void setLabel2(JLabel label2) {
        this.label2 = label2;
    }

    public Gui getGame() {
        return game;
    }

    public void setGame(Gui game) {
        this.game = game;
    }

}
