/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EnWo.game.gameObjects;


import EnWo.game.Gui;
import javax.swing.JLabel;

public class Escenario {
	
	int x = 0;
	int y = 0;
	
	private final Gui game;
         public JLabel label;
       

	public Escenario(Gui game,int x,JLabel label) {
             
		this.game= game;
                this.x=x;
                this.label=label;
	}

	public void move() {
		x=x+1;
                label.setLocation( y,x);
                if(x==1200){
                    x=-600;
                }

	}


        
}