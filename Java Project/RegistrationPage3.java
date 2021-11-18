
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

@SuppressWarnings("serial")
class register3 extends JFrame implements ActionListener
{
	String prname,padd,pnum,psid,ppass,pcpass;
	JLabel pname,ptitle,StudentID,phoneNumber,paddress,pass,cpass;
	JTextField t_pname,t_StudentID,t_phoneNumber,t_paddress;
	JButton done;
	JScrollPane jsp;
	JPasswordField t_pass,t_cpass;
	PreparedStatement ps=null;
	ResultSet rs=null;
	Connection conn=null;
	int rows,childId;
	JPanel p1,p2,p3,p4,p5,p6,p7,p8,p9,p10,p11,p12,p13,p14,p15;
	register3()
	{
		p1=new JPanel();p2=new JPanel();p3=new JPanel();p4=new JPanel();
		p5=new JPanel();p6=new JPanel();p7=new JPanel();p8=new JPanel();
		p9=new JPanel();p10=new JPanel();p11=new JPanel();p12=new JPanel();
		p13=new JPanel();p14=new JPanel();p15=new JPanel();
		
		pass=new JLabel("Enter a password");
		pass.setFont(new Font("Verdana", Font.BOLD, 16));
		cpass=new JLabel("Confirm the password");	
		cpass.setFont(new Font("Verdana", Font.BOLD, 16));	
		
		t_pass=new JPasswordField();
		t_pass.setPreferredSize(new Dimension(150,35));
		t_cpass=new JPasswordField();
		t_cpass.setPreferredSize(new Dimension(130,35));

		ptitle=new JLabel("Parent Registration Form");
		ptitle.setFont(new Font("Verdana", Font.BOLD, 18));
		
		StudentID=new JLabel("Enter Student ID");
		StudentID.setFont(new Font("Verdana", Font.BOLD, 16));
		
		phoneNumber=new JLabel("Phone Number");
		phoneNumber.setFont(new Font("Verdana", Font.BOLD, 16));
		
		pname=new JLabel("Full Name");
		pname.setFont(new Font("Verdana", Font.BOLD, 16));
		
		paddress=new JLabel("Address");
		paddress.setFont(new Font("Verdana", Font.BOLD, 16));
		
		done=new JButton("Submit");
		done.setPreferredSize(new Dimension(150,35));
		done.addActionListener(this);
	
		t_pname=new JTextField();
		t_pname.setPreferredSize(new Dimension(150,35));
		t_StudentID=new JTextField();
		t_StudentID.setPreferredSize(new Dimension(150,35));
		t_phoneNumber=new JTextField();
		t_phoneNumber.setPreferredSize(new Dimension(150,35));
		t_paddress=new JTextField();
		t_paddress.setPreferredSize(new Dimension(150,35));
		
		p1.setLayout(new FlowLayout(FlowLayout.CENTER,0,40));
		p1.add(ptitle);//this
		
		p2.setLayout(new GridLayout(1,2,0,0));
		p2.add(pname);p2.add(t_pname);
		p3.setLayout(new FlowLayout(FlowLayout.CENTER));
		p3.add(p2); //this
		
		p4.setLayout(new GridLayout(1,2,0,0));
		p4.add(phoneNumber);p4.add(t_phoneNumber);
		p5.setLayout(new FlowLayout(FlowLayout.CENTER));
		p5.add(p4);//this
		
		p6.setLayout(new GridLayout(1,2,0,0));
		p6.add(paddress);p6.add(t_paddress);
		p7.setLayout(new FlowLayout(FlowLayout.CENTER));
		p7.add(p6);//this
		
		p10.setLayout(new GridLayout(1,2,0,0));
		p10.add(StudentID);p10.add(t_StudentID);
		p11.setLayout(new FlowLayout(FlowLayout.CENTER));
		p11.add(p10);//this
		
		p8.setLayout(new FlowLayout(FlowLayout.CENTER));
		p8.add(done);//this
		
		p12.setLayout(new GridLayout(1,2,10,0));
		p12.add(pass);p12.add(t_pass);
		p13.setLayout(new FlowLayout(FlowLayout.CENTER));
		p13.add(p12);//this

		p14.setLayout(new GridLayout(1,2,10,0));
		p14.add(cpass);p14.add(t_cpass);
		p15.setLayout(new FlowLayout(FlowLayout.CENTER));
		p15.add(p14);//this
				
		p9.setLayout(new GridLayout(8,1,0,0));
		p9.add(p1);p9.add(p3);p9.add(p5);p9.add(p7);
		p9.add(p11);p9.add(p13);p9.add(p15);p9.add(p8);
        
		jsp=new JScrollPane(p9);
		jsp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		jsp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);  
		add(jsp);		
		setTitle("Welcome to Parent Registration Page!");
		setSize(600,700);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	@SuppressWarnings("deprecation")
	public void actionPerformed(ActionEvent ae)
	{
		
		prname=t_pname.getText();
		padd=t_paddress.getText();
		pnum=t_phoneNumber.getText();
		psid=t_StudentID.getText();
		childId=Integer.parseInt(psid);
		ppass=t_pass.getText();
		pcpass=t_cpass.getText();
		if(ae.getSource()==done)
		{
			try
			{
				//load driver class
				Class.forName("org.postgresql.Driver");
				//Connect to database
				conn=DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","");
				if(ppass.equals(pcpass))
				{
				ps=conn.prepareStatement("insert into parent values(?,?,?,?,?,?)");
				ps.setString(1,prname);
				ps.setString(2,pnum);
				ps.setString(3,padd);
				ps.setInt(4,childId);
				ps.setString(5,ppass);
				ps.setString(6,pcpass);
				rows=ps.executeUpdate();
				if(rows>0)
				{
					JOptionPane.showMessageDialog(null,"Registered Successfully");
					dispose();
					System.out.println("Operation Sucessful");
				}
				}
				else
					JOptionPane.showMessageDialog(null,"Please enter the correct password");
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}		
		}		
	}		
   }
public class RegistrationPage3 
{
	public static void main(String[] args) 
	{
		new register3();
	}

}
