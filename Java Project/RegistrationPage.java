
import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

class register extends JFrame implements ActionListener
{
	int rows;
	PreparedStatement ps=null;
	ResultSet rs=null;
	Connection conn=null;
	String sname,sbirthdate,sgender,sclass,sphno,semail,saddress;
	JLabel title,fullname,dob,gender,clas,phno,email,address;
	JTextField t_fullname,t_dob,t_clas,t_phno,t_email,t_address,t_gender;
	JPanel p0,p1,p2,p3,p4,p5,p6;
	JButton submit,backToLog,ok;
	JScrollPane jsp;
	register()
	{
		p0=new JPanel();p1=new JPanel();p3=new JPanel();p5=new JPanel();
		p2=new JPanel();p4=new JPanel();p6=new JPanel();		
		
		
		title=new JLabel("Student Registration Form");
		title.setFont(new Font("Verdana", Font.BOLD, 18));
	    
		fullname=new JLabel("Full Name");
		fullname.setFont(new Font("Verdana", Font.BOLD, 16));
		
		dob=new JLabel("Date of Birth(dd/mm/yyyy)");
		dob.setFont(new Font("Verdana", Font.BOLD, 16));
		
		gender=new JLabel("Gender");
		gender.setFont(new Font("Verdana", Font.BOLD, 16));
		
		clas=new JLabel("Class");
		clas.setFont(new Font("Verdana", Font.BOLD, 16));
		
		phno=new JLabel("Phone Number");
		phno.setFont(new Font("Verdana", Font.BOLD, 16));
		
		email=new JLabel("Email");
		email.setFont(new Font("Verdana", Font.BOLD, 16));
		
		address=new JLabel("Address");
		address.setFont(new Font("Verdana", Font.BOLD, 16));
		
		t_fullname=new JTextField();
		t_fullname.setPreferredSize(new Dimension(150,35));
		t_dob=new JTextField();
		t_dob.setPreferredSize(new Dimension(150,35));
		t_clas=new JTextField();
		t_clas.setPreferredSize(new Dimension(150,35));
		t_phno=new JTextField();
		t_phno.setPreferredSize(new Dimension(150,35));
		t_email=new JTextField();
		t_email.setPreferredSize(new Dimension(150,35));
		t_address=new JTextField();
		t_address.setPreferredSize(new Dimension(150,35));
		t_gender=new JTextField();
		t_gender.setPreferredSize(new Dimension(150,35));
		
		submit=new JButton("Submit");
		submit.setPreferredSize(new Dimension(150,35));
		backToLog=new JButton("Back to Login Page");
		backToLog.setPreferredSize(new Dimension(150,35));
		
		p0.setLayout(new FlowLayout(FlowLayout.CENTER,0,80));
		p0.add(title); //this
	    p1.setLayout(new GridLayout(1,1));
		p1.add(p0);
				
		p2.setLayout(new GridLayout(7,2,70,10));
		p2.add(fullname);p2.add(t_fullname);
		p2.add(dob);p2.add(t_dob);
		p2.add(gender);p2.add(t_gender);
		p2.add(clas);p2.add(t_clas);
		p2.add(phno);p2.add(t_phno);
		p2.add(email);p2.add(t_email);
		p2.add(address);p2.add(t_address);
		p3.setLayout(new FlowLayout(FlowLayout.CENTER));
		p3.add(p2);
		
		p4.setLayout(new FlowLayout(FlowLayout.CENTER,20,90));
		p4.add(submit);p4.add(backToLog);
		
		p5.setLayout(new GridLayout(3,1,40,0));
		p5.add(p1);
		p5.add(p3);p5.add(p4);
	
		p6.setLayout(new FlowLayout(FlowLayout.CENTER));
		p6.add(p5);
		
		jsp=new JScrollPane(p6);
		jsp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		jsp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		
		submit.addActionListener(this);
		backToLog.addActionListener(this);
		add(jsp);
		setTitle("Welcome to Student Registration Page!");
		setSize(700,650);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==submit)
		{
			sname=t_fullname.getText();
			sbirthdate=t_dob.getText();
			sgender=t_gender.getText();
			sclass=t_clas.getText();
			sphno=t_phno.getText();
			semail=t_email.getText();
			saddress=t_address.getText();
		
			try
			{
					//load driver class
					Class.forName("org.postgresql.Driver");
					//Connect to database
					conn=DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","dhanu");
					ps=conn.prepareStatement("insert into student values(default,?,?,?,?,?,?,?)",Statement.RETURN_GENERATED_KEYS);
					
					ps.setString(1,sname);
					ps.setString(2,sbirthdate);
					ps.setString(3,sgender);
					ps.setString(4,sclass);
					ps.setString(5,sphno);
					ps.setString(6,semail);
					ps.setString(7,saddress);
					rows=ps.executeUpdate();
					rs=ps.getGeneratedKeys();
					rs.next();
					if(rows>0)
					{
						
						System.out.println("Operation Successfull");
						dispose();
						new confirm();
					}
					else
						System.out.println("Failed");
			}
			catch(Exception excp)
			{
				excp.printStackTrace();
			}
			
		}
		if(ae.getSource()==backToLog)
		{
			dispose();
			new log();
		}
	} 
	
}

class RegistrationPage 
{
	public static void main(String args[])
	{
		new register();
		
	}
}

		
