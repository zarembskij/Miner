
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;


public class Miner_sql {
	
	private static final Insets insets = new Insets(5, 5, 5, 5);
	
	static Point[] mina = new Point[7];

	static int timeApp = 0;
	
//	Clock clock = new Clock();
	
	public static void main(String[] args) {

		SwingUtilities.invokeLater(  () -> {
			
			mina[0] = new Point(2,3);
			mina[1] = new Point(7,7);
			mina[2] = new Point(9,9);
			mina[3] = new Point(12,3);
			mina[4] = new Point(1,13);
			mina[5] = new Point(1,12);
			mina[6] = new Point(2,12);
			
			 JFrame frame = new JFrame("Miner | Jakub Zarembski");
		
			 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

			 frame.setMinimumSize(new Dimension(900, 900));
			 frame.setPreferredSize(new Dimension(900, 900));
			 frame.setSize(new Dimension(900, 900));
			 frame.setLocationRelativeTo(null);
			 frame.setResizable(true);
			 frame.revalidate();
			  
			    
			 GridBagLayout gBlayout = new GridBagLayout();
			 gBlayout.preferredLayoutSize(frame);
			 frame.setLayout(gBlayout);
			
			for(int i = 0; i < 15; i++) {

				for(int j = 0; j < 15; j++) {
					JBombButton btn = new JBombButton(" ", i, j);
					btn.setFont(new Font("Arial", Font.BOLD, 15));
					addComponent(frame, btn, i, j, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH);
					btn.addMouseListener(new MouseAdapter() {
					    public void mouseClicked(MouseEvent e) {
					    	
					    	if (e.getButton() == 3)
					    	{
					    		btn.setText("M");
					    		btn.setForeground(Color.RED);
					    	}
					    	else
					    	{
/////////////////////					    		
					    		if(btn.getText() == " ") {
					    			
					    			int licznik = 0;
					    			
					    			for (int k=0; k<mina.length; k++)
					    			{
					    				
					    				if (mina[k].getX() == (btn.getbX()) && mina[k].getY() == (btn.getbY()))
					    						{
					    							btn.setText("B");
					    							btn.setBackground(Color.RED);
					    							btn.setForeground(Color.WHITE);
					    							break;
					    						
					    						}

					    				if (
					    						(((btn.getbX()) == mina[k].getX()-1) ||
					    						((btn.getbX()) == mina[k].getX()) ||
					    						((btn.getbX()) == mina[k].getX()+1)) &&
					    						(((btn.getbY()) == mina[k].getY()-1) ||
					    						((btn.getbY()) == mina[k].getY()) ||
					    						((btn.getbY()) == mina[k].getY()+1))
					    						)
					    				{
					    					licznik++;
					    					
					    				}
					    					
					    				btn.setText(String.valueOf(licznik));
//					    				System.out.println(btn.getX()+ " " + btn.getY());
					    				
//					    				System.out.println(btn.getbX()+ " " + btn.getbY());
					    			}
					    		}	
					    		
					    		
	//////////////////////////				    		
					    	}
					    }
			       
					    }
					    );
					    
							
							
							
							
		
				}
			}
			frame.setVisible(true);
		
		});
		


	}
	



private static void addComponent(Container container, Component component, int gridx, int gridy,
	      int gridwidth, int gridheight, int anchor, int fill) {
	    GridBagConstraints gbc = new GridBagConstraints(gridx, gridy, gridwidth, gridheight, 1, 1,
	        anchor, fill, insets, 10, 10);
	    container.add(component, gbc);
	 }

}


class JBombButton extends JButton
{

	private static final long serialVersionUID = 5886070466107757364L;
	int bx;
	int by;
	String txt;
	
	public JBombButton(String txt, int x, int y)
	{
		super(txt);
		this.bx = x;
		this.by = y;
	}
	
	public void setbX(int x)
	{
		this.bx = x;
	}
	
	public void setbY(int y)
	{
		this.by = y;
	}
	
	public int getbX()
	{
		return bx;
	}
	
	public int getbY()
	{
		return by;
	}
	

}
/*
class Clock extends Thread {
		{
	
		}
		while (true)
		{
			Timer t = new Timer(100, e->{Miner.timeApp++;});
		}
	
}

*/
/*
{
	
	
	System.out.println(e.getSource() + " " + timeApp);
	

*/




