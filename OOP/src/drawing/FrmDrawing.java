package drawing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import geometry.Line;
import geometry.Point;
import geometry.Rectangle;
import geometry.Shape;
import geometry.Circle;
import geometry.Donut;

import javax.swing.ButtonGroup;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class FrmDrawing extends JFrame {

	private JPanel contentPane;
	private PnlDrawing pnlDrawing;
	private int brojac = 0;
	private boolean selected;
	private Point startPoint, endPoint, upperLeft;
	private Color outlineColor, innerColor;
	private ArrayList<Shape> selectedShapes = new ArrayList<Shape>();
	private final ButtonGroup buttonGroup = new ButtonGroup();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmDrawing frame = new FrmDrawing();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public FrmDrawing() {
		setTitle("Djuric Ana IM11/2019");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 778, 461);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(184, 219, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		pnlDrawing = new PnlDrawing();
		pnlDrawing.setBackground(new Color(255, 255, 255));
		pnlDrawing.setBounds(10, 82, 744, 331);
		pnlDrawing.setBorder(new LineBorder(new Color(126, 189, 245), 2));
		contentPane.setLayout(null);
		JPanel toolbar = new JPanel();
		toolbar.setBackground(new Color(184, 219, 250));
		toolbar.setBounds(10, 10, 744, 61);
		contentPane.add(toolbar);
		
		contentPane.add(pnlDrawing, BorderLayout.CENTER);
		toolbar.setLayout(null);
		JToggleButton tglbtnSelect = new JToggleButton("Select");
		tglbtnSelect.setFont(new Font("Tahoma", Font.BOLD, 11));
		tglbtnSelect.setForeground(new Color(255, 255, 255));
		tglbtnSelect.setBackground(new Color(126, 189, 245));
		buttonGroup.add(tglbtnSelect);
		tglbtnSelect.setBounds(155, 5, 100, 23);
		toolbar.add(tglbtnSelect);
		
		JToggleButton tglbtnDelete = new JToggleButton("Delete");
		tglbtnDelete.setFont(new Font("Tahoma", Font.BOLD, 11));
		tglbtnDelete.setForeground(new Color(255, 255, 255));
		tglbtnDelete.setBackground(new Color(126, 189, 245));
		tglbtnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(pnlDrawing.getShapes().isEmpty()) {
					JOptionPane.showMessageDialog(null, "The field is empty!", "ERROR", JOptionPane.ERROR_MESSAGE);
				}else if(selectedShapes.size() == 0) {
					JOptionPane.showMessageDialog(null, "No shapes are currently selected. Please select a shape before proceeding with this operation.", "ERROR", JOptionPane.ERROR_MESSAGE);
				}else{
					int selectedOption = JOptionPane.showConfirmDialog(null, "You have selected shapes to be deleted. Are you sure you want to proceed?", "Warning message", JOptionPane.YES_NO_OPTION);
					if (selectedOption == JOptionPane.YES_OPTION) {
						pnlDrawing.getShapes().removeAll(selectedShapes);
						selectedShapes.clear();
						repaint();
					}
				}
			}
		});
		JToggleButton tglbtnModify = new JToggleButton("Modify");
		tglbtnModify.setFont(new Font("Tahoma", Font.BOLD, 11));
		tglbtnModify.setForeground(new Color(255, 255, 255));
		tglbtnModify.setBackground(new Color(126, 189, 245));
		tglbtnModify.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tglbtnModify.isSelected()) {
					if(pnlDrawing.getShapes().isEmpty()) {
						JOptionPane.showMessageDialog(null, "The field is empty! To perform this operation, please create a shape first.", "ERROR", JOptionPane.ERROR_MESSAGE);
					}else if(selectedShapes.isEmpty()) {
						JOptionPane.showMessageDialog(null, "To modify an object, please select it first.", "ERROR", JOptionPane.ERROR_MESSAGE);
					}else if(selectedShapes.size()>1) {
						JOptionPane.showMessageDialog(null, "It is not possible to modify multiple objects at once. Please select one object to modify.", "ERROR", JOptionPane.ERROR_MESSAGE);
					}else {
					for(Shape s : pnlDrawing.getShapes()) {
						if(s instanceof Point) {
							if(s.isSelected()) {
								Point temp = (Point) s;
								Point p = new Point();
								
								DlgPoint point = new DlgPoint();
								point.getTxtX().setText(Integer.toString(temp.getX()));
								point.getTxtY().setText(Integer.toString(temp.getY()));
								point.setVisible(true);
								
								if(point.isCommited()) {
									p = point.getP();
									p.setSelected(false);
									pnlDrawing.getShapes().remove(s);
									pnlDrawing.getShapes().add(p);
									//pnlDrawing.getShapes().set(pnlDrawing.getShapes().indexOf(temp), p);
									repaint();
									selectedShapes.clear();
								}
							}
						}else if(s instanceof Line) {
							if(s.isSelected()) {
								Line temp = (Line) s;
								Line l = new Line();
								
								DlgLine line = new DlgLine();
								line.getTxtStartX().setText(Integer.toString(temp.getStartPoint().getX()));
								line.getTxtStartY().setText(Integer.toString(temp.getStartPoint().getY()));
								line.getTxtEndX().setText(Integer.toString(temp.getEndPoint().getX()));
								line.getTxtEndY().setText(Integer.toString(temp.getEndPoint().getY()));
								line.setVisible(true);
								
								if(line.isCommited()) {
									l = line.getLine();
									l.setSelected(false);
									pnlDrawing.getShapes().remove(s);
									pnlDrawing.getShapes().add(l);
									//pnlDrawing.getShapes().set(pnlDrawing.getShapes().indexOf(temp), l);
									repaint();
									selectedShapes.clear();
								}
							}
						}else if(s instanceof Rectangle) {
							if(s.isSelected()) {
								Rectangle temp = (Rectangle) s;
								Rectangle r = new Rectangle();
								
								DlgRectangle rect = new DlgRectangle();
								rect.getTxtUpperX().setText(Integer.toString(temp.getUpperLeft().getX()));
								rect.getTxtUpperY().setText(Integer.toString(temp.getUpperLeft().getY()));
								rect.getTxtWidth().setText(Integer.toString(temp.getWidth()));
								rect.getTxtHeight().setText(Integer.toString(temp.getHeight()));
								rect.setVisible(true);
								
								if(rect.isCommited()) {
									r = rect.getRectangle();
									r.setSelected(false);
									pnlDrawing.getShapes().remove(s);
									pnlDrawing.getShapes().add(r);
									//pnlDrawing.getShapes().set(pnlDrawing.getShapes().indexOf(temp), r);
									repaint();
									selectedShapes.clear();
								}
							}
						}else if(s instanceof Circle && (s instanceof Donut)==false) {
							if(s.isSelected()) {
								Circle temp = (Circle) s;
								Circle c = new Circle();
								
								DlgCircle circle = new DlgCircle();
								circle.getTxtXCenter().setText(Integer.toString(temp.getCenter().getX()));
								circle.getTxtYCenter().setText(Integer.toString(temp.getCenter().getY()));
								circle.getTxtRadius().setText(Integer.toString(temp.getRadius()));
								circle.setVisible(true);
								
								if(circle.isCommited()) {
									c = circle.getCircle();
									c.setSelected(false);
									pnlDrawing.getShapes().remove(s);
									pnlDrawing.getShapes().add(c);
									//pnlDrawing.getShapes().set(pnlDrawing.getShapes().indexOf(temp), c);
									repaint();
									selectedShapes.clear();
								}
							}
						}else if(s instanceof Donut) {
							if(s.isSelected()) {
							Donut temp = (Donut) s;
							Donut d = new Donut();
							
							DlgDonut donut = new DlgDonut();
							donut.getTxtX().setText(Integer.toString(temp.getCenter().getX()));
							donut.getTxtY().setText(Integer.toString(temp.getCenter().getY()));
							donut.getTxtOuterRadius().setText(Integer.toString(temp.getRadius()));
							donut.getTxtInnerRadius().setText(Integer.toString(temp.getInnerRadius()));
							donut.setVisible(true);
							
							if(donut.isCommited()) {
								d = donut.getDonut();
								d.setSelected(false);
								pnlDrawing.getShapes().remove(s);
								pnlDrawing.getShapes().add(d);
								//pnlDrawing.getShapes().set(pnlDrawing.getShapes().indexOf(temp), d);
								repaint();
								selectedShapes.clear();
								}
							}
						}
					}
				}
			}
		}
		});
		buttonGroup.add(tglbtnModify);
		tglbtnModify.setBounds(313, 5, 100, 23);
		toolbar.add(tglbtnModify);
		
		
		buttonGroup.add(tglbtnDelete);
		tglbtnDelete.setBounds(476, 5, 100, 23);
		toolbar.add(tglbtnDelete);
		
		JToggleButton tglbtnPoint = new JToggleButton("Point");
		tglbtnPoint.setFont(new Font("Tahoma", Font.BOLD, 11));
		tglbtnPoint.setForeground(new Color(255, 255, 255));
		tglbtnPoint.setBackground(new Color(126, 189, 245));
		buttonGroup.add(tglbtnPoint);
		tglbtnPoint.setBounds(0, 38, 100, 23);
		toolbar.add(tglbtnPoint);
		
		JToggleButton tglbtnLine = new JToggleButton("Line");
		tglbtnLine.setFont(new Font("Tahoma", Font.BOLD, 11));
		tglbtnLine.setForeground(new Color(255, 255, 255));
		tglbtnLine.setBackground(new Color(126, 189, 245));
		buttonGroup.add(tglbtnLine);
		tglbtnLine.setBounds(155, 38, 100, 23);
		toolbar.add(tglbtnLine);
		
		JToggleButton tglbtnRectangle = new JToggleButton("Rectangle");
		tglbtnRectangle.setFont(new Font("Tahoma", Font.BOLD, 11));
		tglbtnRectangle.setForeground(new Color(255, 255, 255));
		tglbtnRectangle.setBackground(new Color(126, 189, 245));
		buttonGroup.add(tglbtnRectangle);
		tglbtnRectangle.setBounds(313, 38, 100, 23);
		toolbar.add(tglbtnRectangle);
		
		JToggleButton tglbtnCircle = new JToggleButton("Circle");
		tglbtnCircle.setFont(new Font("Tahoma", Font.BOLD, 11));
		tglbtnCircle.setForeground(new Color(255, 255, 255));
		tglbtnCircle.setBackground(new Color(126, 189, 245));
		buttonGroup.add(tglbtnCircle);
		tglbtnCircle.setBounds(476, 38, 100, 23);
		toolbar.add(tglbtnCircle);
		
		JToggleButton tglbtnDonut = new JToggleButton("Donut");
		tglbtnDonut.setFont(new Font("Tahoma", Font.BOLD, 11));
		tglbtnDonut.setForeground(new Color(255, 255, 255));
		tglbtnDonut.setBackground(new Color(126, 189, 245));
		buttonGroup.add(tglbtnDonut);
		tglbtnDonut.setBounds(644, 38, 100, 23);
		toolbar.add(tglbtnDonut);
		
		pnlDrawing.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(tglbtnSelect.isSelected()) {
					for(Shape s : pnlDrawing.getShapes()) {
						if(s.contains(e.getX(), e.getY())) {
							if(s instanceof Point) {
								if(!s.isSelected()) {
									s.setSelected(true);
									selectedShapes.add(s);
									repaint();
								}else {
									s.setSelected(false);
									selectedShapes.remove(s);
									repaint();
								}
							}else if (s instanceof Line) {
								if(!s.isSelected()) {
									s.setSelected(true);
									selectedShapes.add(s);
									repaint();
								}else {
									s.setSelected(false);
									selectedShapes.remove(s);
									repaint();
								}
							}else if (s instanceof Rectangle) {
								if(!s.isSelected()) {
									s.setSelected(true);
									selectedShapes.add(s);
									repaint();
								}else {
									s.setSelected(false);
									selectedShapes.remove(s);
									repaint();
								}
							}else if(s instanceof Circle) {
								if(s.getClass() != Circle.class) {
									if(!s.isSelected()) {   //donut
										s.setSelected(true);
										selectedShapes.add(s);
										repaint();
									} else {
										s.setSelected(false);
										selectedShapes.remove(s);
										repaint();
									}
								}else {
									if(!s.isSelected()) {
										s.setSelected(true); //circle
										selectedShapes.add(s);
										repaint();
									}else {
										s.setSelected(false);
										selectedShapes.remove(s);
										repaint();
									}
								}
							}
						}
					}
				}else if(tglbtnPoint.isSelected()) {
					Point p = new Point(e.getX(),e.getY());
					pnlDrawing.getShapes().add(p);
					repaint();
				}else if(tglbtnLine.isSelected()){
					brojac++;
					if(brojac == 1) {
						startPoint = new Point(e.getX(),e.getY());
						pnlDrawing.getShapes().add(startPoint);
						repaint();
					}else if(brojac == 2){
						endPoint = new Point(e.getX(),e.getY());
						pnlDrawing.getShapes().remove(startPoint);
						Line l = new Line(startPoint, endPoint);
						pnlDrawing.getShapes().add(l);
						repaint();
						brojac = 0;
					}
				}else if(tglbtnRectangle.isSelected()) {
					upperLeft = new Point(e.getX(),e.getY());
					DlgRectangle rect = new DlgRectangle();
					rect.getTxtUpperX().setText(Integer.toString(upperLeft.getX()));
					rect.getTxtUpperX().setEditable(false);
					rect.getTxtUpperY().setText(Integer.toString(upperLeft.getY()));
					rect.getTxtUpperY().setEditable(false);
					rect.setVisible(true);
					repaint();
					
					if(rect.isCommited()) {
						int width = Integer.parseInt(rect.getTxtWidth().getText());
						int height = Integer.parseInt(rect.getTxtHeight().getText());
						outlineColor = rect.getOutlineColor();
						innerColor = rect.getInnerColor();
						Rectangle r = new Rectangle(upperLeft, width, height, outlineColor, innerColor);
						pnlDrawing.getShapes().add(r);
						repaint();
					}		
				}else if(tglbtnCircle.isSelected()) {
					Point center = new Point (e.getX(), e.getY());
					DlgCircle circle = new DlgCircle();
					circle.getTxtXCenter().setText(Integer.toString(center.getX()));
					circle.getTxtXCenter().setEditable(false);
					circle.getTxtYCenter().setText(Integer.toString(center.getY()));
					circle.getTxtYCenter().setEditable(false);
					circle.setVisible(true);
					repaint();
					
					if(circle.isCommited()) {
						int radius = Integer.parseInt(circle.getTxtRadius().getText());
						outlineColor = circle.getOutlineColor();
						innerColor = circle.getInnerColor();
						Circle c = new Circle(center, radius, outlineColor, innerColor);
						pnlDrawing.getShapes().add(c);
						repaint();
					}
				}else if(tglbtnDonut.isSelected()) {
					Point center = new Point(e.getX(), e.getY());
					DlgDonut donut = new DlgDonut();
					donut.getTxtX().setText(Integer.toString(center.getX()));
					donut.getTxtX().setEditable(false);
					donut.getTxtY().setText(Integer.toString(center.getY()));
					donut.getTxtY().setEditable(false);
					donut.setVisible(true);
					repaint();
					
					if(donut.isCommited()) {
						int outerRadius = Integer.parseInt(donut.getTxtOuterRadius().getText());
						int innerRadius = Integer.parseInt(donut.getTxtInnerRadius().getText());
						outlineColor = donut.getOutlineColor();
						innerColor = donut.getInnerColor();
						Donut d = new Donut(center, outerRadius, innerRadius, outlineColor, innerColor);
						pnlDrawing.getShapes().add(d);
						repaint();
					}
				}
			}
		});
		
	}

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}
}
