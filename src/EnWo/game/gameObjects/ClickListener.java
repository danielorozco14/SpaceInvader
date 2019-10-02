/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EnWo.game.gameObjects;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *
 * @author CARLOS
 */
public class ClickListener extends MouseAdapter {

    private Personaje raqueta;

    public ClickListener(Personaje raqueta) {
        this.raqueta = raqueta;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON1) {
            raqueta.xa = e.getX();
            raqueta.ya = e.getY();
            raqueta.m = e.getY() - raqueta.y / e.getX() - raqueta.x;
            if (raqueta.ya > raqueta.y) {
                raqueta.bajar = true;
            } else {
                raqueta.bajar = false;
            }
            if (raqueta.xa < raqueta.x) {
                raqueta.retroceder = true;
            } else {
                raqueta.retroceder = false;
            }
            raqueta.iniciado = true;
            raqueta.setDesplazar(true);

        }
        if (e.getButton() == MouseEvent.BUTTON3) {
            raqueta.disparar = true;

        }

    }
}
