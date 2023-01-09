package zadaci;

public class Pokemon {
	
	private static int brojPokemona;
	private String ime;
	private String tip;
	private int redniBroj;
	public static final char generacija = 'X';
	
	public Pokemon(String ime, String tip) {
		this.ime = ime;
		if(tip == "elektricni" || tip == "vatreni" || tip == "vodeni" || tip == "zemljani") {
			this.tip = tip;
		}
		this.brojPokemona++;
		this.redniBroj=this.brojPokemona;
	}
	
	@Override
	public String toString() {
		return ime + " je pokemon " + generacija + " generacije, on je " + tip + 
				" tip i u ovom programu kreiran je kao  " + redniBroj + " od trenutno postojecih "
				+ brojPokemona + " Pokemona.";
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Pokemon) {
			Pokemon temp = (Pokemon)obj;
			if(this.ime.equals(temp.getIme()) && this.tip.equals(temp.getTip())) {
				if(this.redniBroj == temp.getRedniBroj()) {
					System.out.println("Poredjenje sa samim sobom");
				}
				return true;
			}else if(this.getTip().equals(temp.getTip())) {
				System.out.println("Srodni pokemoni");
			}
		}return false;
	}

	public static int getBrojPokemona() {
		return brojPokemona;
	}

	
	public String getIme() {
		return ime;
	}


	public String getTip() {
		return tip;
	}


	public int getRedniBroj() {
		return redniBroj;
	}


	public static char getGeneracija() {
		return generacija;
	}
	
	

}
