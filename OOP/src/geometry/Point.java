package geometry;

public class Point extends Shape{
	
	// Obelezja
	
	private int x;
	private int y;
	
	// Konstruktori
	
	public Point() {
		
	} 
	
	public Point (int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public Point (int x, int y, boolean selected) {
		this.x = x;
		this.y = y;
		this.selected = selected;
	}
	
	// Metode
	
	public double distance (int x, int y) {
		int dx = this.x - x;
		int dy = this.y - y;
		double d = Math.sqrt(dx*dx + dy*dy);
		return d;	
	}
	
	public boolean contains (int x, int y) {
		return this.distance(x, y)<=2; //this zato sto ne postoji obiljezje nad kojim mozemo da pozovemo, pozivamo nad objektom te klase
	}
	
	@Override
	public String toString() {
		return "(" + x + "," + y + ")";
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Point) {
			Point temp = (Point) obj;
			if (x == temp.x && y == temp.y) {
				return true;
			}
		}return false;
	}
	
	// Getters & Setters
	
	public int getX() {
		return x;
	}
	
	public void setX(int X) {
		this.x = x;
	}
	
	public int getY() {
		return y;
	}
	
	public void setY(int y) {
		this.y=y;
	}

}
