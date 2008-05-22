package player;

import java.rmi.Naming;

import common.Gaming;

import game.Game;

public class Test {

	/**
	 * @param args
	 */
	public static  String urlPlaneGame = Game.URL_BASE + "/PlaneGame";
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
			/*System.out.println(Test.urlPlaneGame);
			for(String s:Naming.list("rmi://localhost:10002/"))
				System.out.println(s);*/
			
			Gaming game = (Gaming)Naming.lookup(Test.urlPlaneGame);
			game.start();
			game.stop();
		} catch(Exception e){
			System.out.println("Wystapil blad na kliencie!!!");
			System.out.println(e.getMessage());
			e.printStackTrace();				
		}
	}

}
