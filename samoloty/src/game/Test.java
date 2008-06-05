package game;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			PlaneGame gra = new PlaneGame("Piotr");
			System.out.println("Gra utworzona poprawnie! ");
			do{
				System.out.println("Liczba graczy : "+ gra.getPlayerCount());
				System.out.println("Gra "+(gra.isStopped()?"zatrzymana":"rozpoczeta"));
				System.out.println("Gra "+(gra.isWaitForPlayers()?"czeka na graczy":"nie czeka na graczy"));
				Thread.sleep(1000);
			}while(true);
		} catch (Exception e) {
			System.out.println("Wystapil blad na serwerze!!!");
			e.printStackTrace();
		}
	}

}
