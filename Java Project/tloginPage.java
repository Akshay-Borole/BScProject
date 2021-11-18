
import java.awt.*;
import java.awt.Color;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

class tlog extends JFrame implements ActionListener 
{
	JLabel user,pass;
	JTextField tu;
	JPasswordField jp;
	JButton log,res;
	JPanel p1,p2,p3,p4,p5,p6,p7,p8;
	int rows;
	PreparedStatement ps=null,ps1=null,ps2=null;
	ResultSet rs=null,rs1=null,rs2=null,rs3=null;
	Connection conn=null;
	Statement stmt=null,stmt1=null,stmt2=null,stmt3=null;
	tlog() 
	{
		user=new JLabel("Enter ID");
		user.setFont(new Font("Verdana", Font.BOLD, 18));
		
		res=new JButton("Click to register");
		res.setFont(new Font("Arial", Font.ITALIC, 14));
		res.setForeground(Color.blue);
		
		tu=new JTextField();
		tu.setPreferredSize(new Dimension(150,35));
		pass=new JLabel("Password");
		pass.setFont(new Font("Verdana", Font.BOLD, 18));
		
		jp=new JPasswordField();
		jp.setPreferredSize(new Dimension(150,35));
		
		log=new JButton("Login");
		log.setPreferredSize(new Dimension(150,35));
		log.setFont(new Font("Verdana", Font.BOLD, 16));
		
		p1=new JPanel();p3=new JPanel();p5=new JPanel();
		p2=new JPanel();p4=new JPanel();p6=new JPanel();
		p7=new JPanel();p8=new JPanel();
		ImageIcon img = new ImageIcon("/home/dkale/Java Project/images/Logo.png");
		JLabel image = new JLabel(img);
		
		p1.setLayout(new FlowLayout(FlowLayout.CENTER));
		p1.add(image);
		
		
		p2.setLayout(new GridLayout(1,2,2,2));
		p2.add(user);p2.add(tu);
		p3.setLayout(new FlowLayout(FlowLayout.CENTER,40,40));
		p3.add(p2);
		
		p4.setLayout(new GridLayout(1,2,2,2));
		p4.add(pass);p4.add(jp);
		p5.setLayout(new FlowLayout(FlowLayout.CENTER));
		p5.add(p4);
		
		p6.setLayout(new FlowLayout(FlowLayout.CENTER));
		p6.add(log);
		
		p7.setLayout(new GridLayout(4,1,0,0));
		p7.add(p1);
		p7.add(p3);p7.add(p5);p7.add(p6);
		
		res.addActionListener(this);
		log.addActionListener(this);
		
		Color  colr  = new Color(255,165,0,5);//255,165,0
		add(p7);
		setSize(500,750);
		p1.setBackground(colr);
		p2.setBackground(colr);
		p3.setBackground(colr);
		p4.setBackground(colr);
		p5.setBackground(colr);
		p6.setBackground(colr);
		p8.setBackground(colr);
		setTitle("Teacher Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);	
	}	
	@SuppressWarnings("deprecation")	
	public void actionPerformed(ActionEvent ae)
	{
		boolean flag=true;
		String username=tu.getText();
		//int u=Integer.parseInt(username);
		String p=jp.getText();
		if(ae.getSource()==log)
		{
			try
			{
				//load driver class
				Class.forName("org.postgresql.Driver");
				//Connect to database
				conn=DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","");
				stmt=conn.createStatement();
		         	rs=stmt.executeQuery("select teacher_id from teacher");
		         	stmt1=conn.createStatement();
		         	rs1=stmt1.executeQuery("select teacher_password from teacher");
	
			     while(rs.next()&&rs1.next())
			     {
			    	 
			    	 if((username.equals(rs.getString(1))) && (p.equals(rs1.getString(1))))
			    	 {
			    		dispose();
			    		flag=true;
			    		new tdashboard();
			    	 }
				else
					flag=false;
			    	 
			     }

			     if(flag==false)
			     {
			    	 JOptionPane.showMessageDialog(null,"Invalid User(Please Enter User ID and Password correctly)");
			     }
			     
			}
			catch(Exception excp)
			{
				excp.printStackTrace();
			}
		} 
	}
}
public class tloginPage
	{
	public static void main(String args[])
	{
		new tlog();
	}
}
