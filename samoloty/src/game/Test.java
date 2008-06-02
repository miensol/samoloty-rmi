package game;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			PlaneGame gra = new PlaneGame("Piotr");
			int i =  0;
			while(++i<100){
				Thread.sleep(1000);
				
				gra.moveAll();
			}
			System.out.println("Gra utworzona poprawnie! ");
		} catch (Exception e) {
			System.out.println("Wystapil blad na serwerze!!!");
			e.printStackTrace();

		}
	}

}
