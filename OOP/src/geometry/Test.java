package geometry;

public class Test {

	public static void main(String[] args) {
		
		Point p1 = new Point (3,5);
		System.out.println(p1.toString());
		Point p2 = new Point (3,6); 
		Line l1 = new Line (p1,p2);
		Line l2 = new Line (new Point(5,6), new Point(7,8));
		System.out.println(l1);
		System.out.println(l2.toString());
		Circle c = new Circle (new Point (4,7), 5);
		System.out.println(c.toString());
		System.out.println(p1.equals(p2));
		
		Point p3 = new Point();
		p3.setX(5);
		p3.setY(4);
		p3.setSelected(true);
		
		System.out.println("X koordinata tacke p3 je: " + p3.getX());
		System.out.println("Y koordinata tacke p3 je: " + p3.getY());
		System.out.println("Selected je postavljen na: " + p3.isSelected());
		
		Point p4 = new Point ();
		p4.setX(6);
		p4.setY(8);
		
		System.out.println("Udaljenost izmedju p3 i p4 je: " + 
		p3.distance(p4.getX(), p4.getY()));
		
		Line l3 = new Line();
		l3.setStartPoint(p1);
		l3.setEndPoint(p1);
		
		System.out.println(l3.getStartPoint().getX());
		
		Line l4 = new Line();
		l4.setStartPoint(new Point());
		l4.getStartPoint().setX(6);
		System.out.println(l4.getStartPoint().getX());
		
		Line l5 = new Line();
		l5.setStartPoint(new Point());
		l5.setEndPoint(new Point());
		l5.getStartPoint().setX(5);
		l5.getStartPoint().setY(4);
		l5.getEndPoint().setX(7);
		l5.getEndPoint().setY(3);
		double d = l5.getStartPoint().distance(l5.getEndPoint().getX(), 
				l5.getEndPoint().getY());
		System.out.println(d);
		
		Circle c1 = new Circle ();
		c1.setCenter(p2);
		c1.setRadius(2);
		
		System.out.println("Centar kruga je tacka sa koordinatama: ");
		System.out.println("X: " + c1.getCenter().getX());
		System.out.println("Y: " + c1.getCenter().getY());
		System.out.println("Poluprecnik kruga je: " + c.getRadius());
		
		Rectangle r1 = new Rectangle();
		r1.setWidth(5);
		r1.setHeight(3);
		
		Point point = new Point();
		Point myPoint = new Point(3,5);
		System.out.println(myPoint.getX());
		Point myOtherPoint = new Point (3,5,true);
		
		Object o1 = new Point();
		
		Point p5 = new Point(5,5);
		Point p6 = new Point (5,5);
		Line l6 = new Line(p4,p5);
		Rectangle r2 = new Rectangle (p5, 50, 50, false);
		Circle c2 = new Circle (p5, 50, true);
		
		System.out.println(p6 == p5);
		System.out.println(l6 == l6);
		System.out.println(p5.equals(p6));
		System.out.println(p5.equals(c2));
		System.out.println(l6.equals(p5));
		
		double circleArea = c.area();
		System.out.println(circleArea);
		System.out.println(c.area());
		
		Circle c3 = new Circle();
		c3.setCenter(new Point(3,5));
		
		Line l7 = new Line();
		Line l8 = new Line (p1, p2);
		Line l9 = new Line (p1, p2, true);
		Line l10 = new Line (new Point (6,7), new Point(8,9));
		
		Point p77 = new Point(3,5);
		Circle c4 = new Circle (new Point(3,5), 7);
		Donut d1 = new Donut(new Point(3,5), 7, 3);
		System.out.println(d1.area());
		System.out.println(c4.area());
		
		Point p7 = new Point (3,5);
		System.out.println(c4.equals(d1));
		System.out.println(d1.equals(c4));
		System.out.println(c4.toString());
		
		System.out.println(c4.equals(p77));
		
		
		Circle c15 = new Circle (new Point(2,5),6);
		Circle c16 = new Circle (new Point(2,5),6);
		
		System.out.println(c15.equals(c16));
		System.out.println(c15 == c16);
		System.out.println();
		System.out.println();
		

	}

}
