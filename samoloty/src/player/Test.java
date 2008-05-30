package player;

import game.Game;

import java.rmi.Naming;

import common.Gaming;
import common.Piloting;
import common.Playing;

public class Test {

	/**
	 * @param args
	 */
	public static String urlPlaneGame = Game.URL_BASE + "/PlaneGame";

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			/*
			 * System.out.println(Test.urlPlaneGame); for(String
			 * s:Naming.list("rmi://localhost:10002/")) System.out.println(s);
			 */

			Gaming game = (Gaming) Naming.lookup(Test.urlPlaneGame);
			game.start();
			game.stop();

			game.join("Piotr");

			Playing piotr = (Playing) Naming.lookup(Game.URL_BASE + "/Piotr");

			Piloting latam = (Piloting) Naming.lookup(Game.URL_BASE + "/"
					+ piotr.getNick() + "/plane");

			latam.move();

		} catch (Exception e) {
			System.out.println("Wystapil blad na kliencie!!!");
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}

}
