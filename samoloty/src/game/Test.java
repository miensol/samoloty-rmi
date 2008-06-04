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
		} catch (Exception e) {
			System.out.println("Wystapil blad na serwerze!!!");
			e.printStackTrace();
		}
	}

}
