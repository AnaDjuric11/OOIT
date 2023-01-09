package geometry;

public class Circle extends Shape{
	
	// Obelezja
	
	private Point center;
	private int r;
	
	// Konstruktori
	
	public Circle() { 
		
	}
	
	public Circle (Point center) {
		this.center = center;
	}
	
	public Circle (Point center, int r) {
		this.center = center;
		this.r = r;
	}
	
	public Circle (Point center, int r, boolean selected) {
		this.center = center;
		this.r = r;
		this.selected = selected;
	}
	
	// Metode
	
	public double circumference() {
		return 2 * r * Math.PI;
	}
	
	public double area() {
		return r * r * Math.PI;
	}
	
	public boolean contains (int x, int y) {
		return center.distance(x, y) <= r;
	}
	
	public boolean contains (Point p) {
		return center.distance(p.getX(), p.getY()) <= r;
	}
	
	@Override
	public String toString() {
		return "Center: " + center + ", radius: " + r;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Circle) {
			Circle temp = (Circle) obj;
			if (center.equals(temp.getCenter()) && r == temp.getR()) {
				return true;
			}
		}return false;
	}
	
	// Getters & Setters

	public Point getCenter() {
		return center;
	}

	public void setCenter(Point center) {
		this.center = center;
	}

	public int getR() {
		return r;
	}

	public void setR(int r) {
		this.r = r;
	}	

}
