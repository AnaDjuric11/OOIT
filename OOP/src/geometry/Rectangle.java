package geometry;

public class Rectangle extends Shape{
	
	// Obelezja
	
	private Point upperleft;
	private int width;
	private int height;
	
	// Konstruktori
	
	public Rectangle () {
		
	} 
	
	public Rectangle (Point upperleft, int width, int height) {
		this.upperleft = upperleft;
		this.width = width;
		this.height = height;
	}
	
	public Rectangle (Point upperleft, int width, int height, boolean selected) {
		this.upperleft = upperleft;
		this.width = width;
		this.height = height;
		this.selected = selected;
	}
	
	// Metode
	
	public int circumference () {
		return 2*(width + height);
	}
	
	public int area() {
		return width * height;
	}
	
	public boolean contains(int x, int y) {
		return upperleft.getX() < x && (upperleft.getX() + width > x) && upperleft.getY() < y && (upperleft.getY() + width > y);
	}
	
	public boolean contains (Point p) {
		return this.contains(p.getX(), p.getY());
	}
	
	@Override
	public String toString() {
		return "upper left point: " + upperleft + ", width: " + width + ", height: " + height;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Rectangle) {
			Rectangle temp = (Rectangle) obj;
			if(upperleft.equals(temp.getUpperleft()) && width == temp.getWidth() 
					&& height == temp.getHeight()) {
				return true;
			}
		}return false;
	}
	
	// Getters & Setters

	public Point getUpperleft() {
		return upperleft;
	}

	public void setUpperleft(Point upperleft) {
		this.upperleft = upperleft;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
	
}
