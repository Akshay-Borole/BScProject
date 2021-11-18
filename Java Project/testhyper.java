package StudentProfile;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.font.TextAttribute;
import java.util.Map;

@SuppressWarnings("serial")
class hyperlink extends JFrame  
{
	JLabel myLink;
	@SuppressWarnings({ "unchecked", "rawtypes" })
	hyperlink()
	{
		myLink=new JLabel("Click here to view fee records");
		myLink.setForeground(Color.blue);
		myLink.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		Font font = myLink.getFont();
		Map attributes = font.getAttributes();
		attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
		myLink.setFont(font.deriveFont(attributes));
		myLink.addMouseListener(new MouseAdapter() 
		{
		    @Override
		    public void mouseClicked(MouseEvent me) 
		    {
		        // the user clicks on the label
		    	if(me.getSource()==myLink)
				{
					dispose();
					new fees();
					
				}
		    	
		    }
		 
		   
		});
		
		
		add(myLink);
		setSize(500,750);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		/*
		//code for underlined font
		Font font = label.getFont();
		Map attributes = font.getAttributes();
		attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
		fees.setFont(font.deriveFont(attributes));
		*/
	}
}
public class testhyper 
{
	public static void main(String[] args) 
	{
		new hyperlink();
	}

}
