
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
@SuppressWarnings("serial")
class confirm extends JFrame implements ActionListener
{
	int rows;
	PreparedStatement ps=null;
	ResultSet rs=null;
	Connection conn=null;
	String pass,cpass;
	JLabel Enterpassword,Confirmpassword;
	JPasswordField t_password,t_confirmpassword;
	JPanel p1,p2,p6,p7,p3,p4,p5;
	JButton okbtn;
	confirm()
	{
		p1=new JPanel();p2=new JPanel();p3=new JPanel();p4=new JPanel();
		p5=new JPanel();p6=new JPanel();p7=new JPanel();
		
		Enterpassword=new JLabel("Enter Password");
		Enterpassword.setFont(new Font("Verdana", Font.PLAIN, 18));
		Confirmpassword=new JLabel("Confirm Password");
		Confirmpassword.setFont(new Font("Verdana", Font.PLAIN, 18));
		t_password=new JPasswordField();
		t_password.setPreferredSize(new Dimension(160,35));
		t_confirmpassword=new JPasswordField();
		t_confirmpassword.setPreferredSize(new Dimension(150,35));
		okbtn=new JButton("Ok");
		okbtn.setPreferredSize(new Dimension(150,35));
		okbtn.setFont(new Font("Verdana", Font.PLAIN, 18));
		
		p2.setLayout(new GridLayout(1,2,5,5));
		p2.add(Enterpassword);p2.add(t_password);
		p3.setLayout(new FlowLayout(FlowLayout.CENTER,40,40));
		p3.add(p2);
		
		p4.setLayout(new GridLayout(1,2,5,5));
		p4.add(Confirmpassword);p4.add(t_confirmpassword);
		p5.setLayout(new FlowLayout(FlowLayout.CENTER));
		p5.add(p4);
		
		p6.setLayout(new FlowLayout(FlowLayout.CENTER));
		p6.add(okbtn);
		
		p7.setLayout(new GridLayout(3,1,0,0));
		p7.add(p3);p7.add(p5);p7.add(p6);
	
		okbtn.addActionListener(this);
		
		add(p7);
		setTitle("Student Password Confirmation");
		setSize(400, 400);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	@SuppressWarnings("deprecation")
	public void actionPerformed(ActionEvent ae)
	{
		pass=t_password.getText();
		cpass=t_confirmpassword.getText();
		
		if(ae.getSource()==okbtn)
		{
			if(pass.equals(cpass))
			{
			dispose();
			new log();
			try
			{
			//load driver class
					Class.forName("org.postgresql.Driver");
					//Connect to database
					conn=DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","");
					ps=conn.prepareStatement("insert into loginInfo values(default,?)");
					ps.setString(1,cpass);
					rows=ps.executeUpdate();
					if(rows>0)
						System.out.println("Operation Sucessful");
					else
						System.out.println("Operation Failed");
			}
			catch(Exception excp)
			{
				excp.printStackTrace();
			}
		}
			else
				JOptionPane.showMessageDialog(null,"Please re-check the entered Password");;
		}
	}
}
public class confirmation 
{
	public static void main(String args[])
	{
		new confirm();
	}
}

			
