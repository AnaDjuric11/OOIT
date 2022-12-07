package zadaci;

public class TestAutomobil {

	public static void main(String[] args) {
		Automobil auto = new Automobil (true, 3);
		auto.promeniBrzinu(6);
		System.out.println(auto.getBrzina());
		auto.promeniBrzinu(1);
		System.out.println(auto.getBrzina());
	}

}
