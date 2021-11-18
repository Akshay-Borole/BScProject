
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

class front extends JFrame implements ActionListener
{
	JPanel p1,p2,p3,p4;
	JRadioButton par,tea,stu;
	JButton click,clicktoLogin,tclicktoLogin;
	front()
	{
		ImageIcon img = new ImageIcon("/home/dkale/Java Project/images/Logo.png");
		JLabel image = new JLabel(img);
		p1=new JPanel();p3=new JPanel();
		p2=new JPanel();p4=new JPanel();
		
		click=new JButton("Click to Register");
		click.setFont(new Font("Verdana", Font.BOLD, 14));
		click.setPreferredSize(new Dimension(250,35));
		
		clicktoLogin=new JButton("Student/Parent,click to login");
		clicktoLogin.setFont(new Font("Verdana", Font.BOLD, 14));
		clicktoLogin.setPreferredSize(new Dimension(300,35));

		tclicktoLogin=new JButton("Teacher,click to Login");
		tclicktoLogin.setFont(new Font("Verdana", Font.BOLD, 14));
		tclicktoLogin.setPreferredSize(new Dimension(250,35));

		par=new JRadioButton("Parent");
		par.setFont(new Font("Verdana", Font.BOLD, 16));
		
		tea=new JRadioButton("Teacher");
		tea.setFont(new Font("Verdana", Font.BOLD, 16));
		
		stu=new JRadioButton("Student");
		stu.setFont(new Font("Verdana", Font.BOLD, 16));
		
		
		ButtonGroup bg=new ButtonGroup();
		bg.add(par);bg.add(tea);bg.add(stu);
		
		p1.setLayout(new FlowLayout(FlowLayout.CENTER));
		p1.add(image);//this
		
		p2.setLayout(new GridLayout(6,1,0,10));
		p2.add(tea);p2.add(stu);p2.add(par);p2.add(click);p2.add(clicktoLogin);p2.add(tclicktoLogin); //this
		
		p3.setLayout(new GridLayout(2,1));
		p3.add(p1);p3.add(p2);
		
		p4.setLayout(new FlowLayout(FlowLayout.CENTER));
		p4.add(p3);
		
		click.addActionListener(this);
		clicktoLogin.addActionListener(this);
		tclicktoLogin.addActionListener(this);
		add(p4);
		setSize(450,500);
		setVisible(true);
		setTitle("Welcome!");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void actionPerformed(ActionEvent ae)
	{
		if(stu.isSelected() && ae.getSource()==click)
			new register();
		if(tea.isSelected() && ae.getSource()==click)
			new register2();
		if(par.isSelected() && ae.getSource()==click)
			new register3();
		if(ae.getSource()==clicktoLogin)
			 new log();
		if(ae.getSource()==tclicktoLogin)
			 new tlog();
	} 
}

public class frontPage 
{
	public static void main(String[] args) 
	{
		new front();
	}

}
