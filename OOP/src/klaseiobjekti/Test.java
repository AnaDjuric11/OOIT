package klaseiobjekti;

public class Test {

	public static void main(String[] args) {
		Zaposleni radnik = new Zaposleni ("Ana","Djuric","Menadzer", 30000.00, "ir118");
		System.out.println(radnik.toString());
		radnik.ispisPodataka();
		System.out.println("Dodatne informacije o radniku: ");
		System.out.println("Datum zaposlenja: " + radnik.getDatumZaposlenja());
		System.out.println("ID radnika je: " + radnik.getIDRadnika());
		System.out.println("Fakultet i smijer radnika je: " + radnik.getFakultet());
		
	}

}
