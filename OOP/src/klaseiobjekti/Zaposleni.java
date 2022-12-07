package klaseiobjekti;

public class Zaposleni {

	//Obiljezja
	
	private String ime;
	private String prezime;
	private String radnoMesto;
	private String brojRadneKnjizice;
	private double plata;
	
	//konstruktori
	
	public Zaposleni(String ime, String prezime, String radnoMesto, double plata, String brojRadneKnjizice) {
		this.ime = ime;
		this.prezime = prezime;
		this.radnoMesto = radnoMesto;
		this.plata = plata;
		this.brojRadneKnjizice = brojRadneKnjizice;
	}
		
	//Get metode

	public String getIme() {
		return ime;
	}
	
	public String getPrezime() {
		return prezime;
	}
	
	public String getRadnoMesto () {
		return radnoMesto;
	}
	
	public double getPlata() {
		return plata;
	}
	
	public String getBrojRadneKnjizice() {
		return brojRadneKnjizice;
	}
	
	// dodatni get metodi
	
	public int getDatumZaposlenja() {
		
		String datumZaposlenja = "20" + brojRadneKnjizice.charAt(3) + brojRadneKnjizice.charAt(4);
		return Integer.parseInt(datumZaposlenja);
	}
	
	public int getIDRadnika() {
		String IDRadnika = " " + brojRadneKnjizice.charAt(2);
		return Integer.parseInt(IDRadnika);
	}

	public String getFakultet() {
		char fakultet = brojRadneKnjizice.charAt(0);
		char smer = brojRadneKnjizice.charAt(1);
		
		if(fakultet == 'i') {
			switch(smer) {
			case 'r':
				return "Projektovanje i racunarstvo";
			case 'i':
				return "Informacione tehnologije";
			default:
				return "Smer je nepoznat";
			}
			}else {
				return "Fakultet je nepoznat";
		}
	}
	//set metode
	
	public void setIme(String ime) {
		this.ime = ime;
	}
	
	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}
	
	public void setRadnoMesto (String radnoMesto) {
		this.radnoMesto = radnoMesto;
	}
	
	public void setPlata (double plata) {
		this.plata = plata;
	}
	
	public void setBrojRadneKnjizice(String brojRadneKnjizice) {
		this.brojRadneKnjizice = brojRadneKnjizice;
	}
	
	public String toString() {
		return ime + " " + prezime + " " + radnoMesto + " " + plata + " " + brojRadneKnjizice;
	}
	
	public void ispisPodataka() {
		System.out.println(ime + " " + prezime + " " + radnoMesto + " " + plata + " " + brojRadneKnjizice);
	}
	
	
	
	
}
