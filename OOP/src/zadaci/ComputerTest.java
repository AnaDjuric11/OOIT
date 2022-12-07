package zadaci;

public class ComputerTest {

	public static void main(String[] args) {
		Computer racunar = new Computer(8,"Windows",true);
		racunar.onOff();
		System.out.println(racunar);
		System.out.println(racunar.isPowerOn());
	}

}
