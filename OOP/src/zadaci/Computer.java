package zadaci;

public class Computer {
	
	// Obelezja
	
	private int ram;
	private String os;
	private boolean powerOn;

	// Konstruktori
	
	public Computer () {
		
	}
	
	public Computer (int ram, String os, boolean powerOn) {
		this.ram = ram;
		this.os = os;
		this.powerOn = powerOn;
	}
	
	// Metodi
	
	public void onOff() {
		if(powerOn) {
			powerOn = false;
		}else {
			powerOn = true;
		}
	}
	
	// Getters & Setters
	
	public int getRam() {
		return ram;
	}
	
	public void setRam(int ram) {
		boolean check = false;
		for(int i = 2; i <= 128; i=i*2) {
			if(ram == i) {
				this.ram = ram;
				check = true;
			}
			}if (!check){
				this.ram = 4;
				System.out.println("Moguce vrijednosti RAM-a su: 2, 4, 8, 16, 32, 64, 128");
		}
	}
	
	public String getOs() {
		return os;
	}
	
	public void setOs(String os) {
		boolean temp = false;
		if(os == "Linux" || os == "MacOs" || os == "Windows") {
			this.os = os;
			temp = true;
		}if (!temp) {
			this.os = "built-in";
			System.out.println("Moguci OS su: Linux, MacOs, Windows");
		}
	}
	
	public boolean isPowerOn() {
		return powerOn;
	}
	
	public void setPowerOn(boolean powerOn) {
		this.powerOn = powerOn;
	}
}
