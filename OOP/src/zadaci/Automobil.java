package zadaci;

public class Automobil {
	
	// Obelezja
	
	private String marka;
	private int brzina;
	private boolean ukljucen;
	
	// Kontruktori
	
	public Automobil (boolean ukljucen) {
		this.ukljucen = ukljucen;
	}
	
	public Automobil (boolean ukljucen, int brzina) {
		this.ukljucen = ukljucen;
		if (brzina <= 6) {
			this.brzina = brzina;
		}
	}
	

	public int getBrzina() {
		return brzina;
	}

	public boolean isUkljucen() {
		return ukljucen;
	}
	
	public void promeniBrzinu (int brzina) {
		if (brzina>this.brzina) {
		if (this.brzina == brzina - 1) {
			this.brzina = brzina;
		}else {
			System.out.println("Nedozvoljen prenos");
		}
	}else {
		this.brzina = brzina;
	}

	}
	
	
	

}
