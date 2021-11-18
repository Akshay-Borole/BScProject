import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

@SuppressWarnings("serial")
class register2 extends JFrame implements ActionListener
{
	String teachId,teachName,teachDept,password,cpassword;
	int rows;
	JScrollPane jsp;
	PreparedStatement ps=null;
	ResultSet rs=null;
	Connection conn=null;
	JLabel heading,uniID,dept,mail,name,lpass,lcpass;
	JTextField t_uniID,t_dept,t_name;
	JPasswordField pass,cpass;
	JButton finish;
	JPanel p1,p2,p3,p4,p5,p6,p7,p8,p9,p10,p11,p12,p13;
	register2()
	{
		p1=new JPanel();p2=new JPanel();p3=new JPanel();p4=new JPanel();
		p5=new JPanel();p6=new JPanel();p7=new JPanel();p8=new JPanel();
		p9=new JPanel();p10=new JPanel();p11=new JPanel();p12=new JPanel();
		p13=new JPanel();
		
		heading=new JLabel("Teacher Registration Form");
		heading.setFont(new Font("Verdana", Font.BOLD, 18));
		
		uniID=new JLabel("Unique ID");
		uniID.setFont(new Font("Verdana", Font.BOLD, 16));
		
		dept=new JLabel("Department");
		dept.setFont(new Font("Verdana", Font.BOLD, 16));
		
		name=new JLabel("Name");
		name.setFont(new Font("Verdana", Font.BOLD, 16));
		
		lpass=new JLabel("Type a password");
		lpass.setFont(new Font("Verdana", Font.BOLD, 16));
		
		lcpass=new JLabel("Confirm the password");
		lcpass.setFont(new Font("Verdana", Font.BOLD, 16));

		
		finish=new JButton("Submit");
		finish.setPreferredSize(new Dimension(150,35));
		
		pass=new JPasswordField();
		pass.setPreferredSize(new Dimension(150,35));

		cpass=new JPasswordField();
		cpass.setPreferredSize(new Dimension(120,35));

		t_uniID=new JTextField();
		t_uniID.setPreferredSize(new Dimension(150,35));
		t_dept=new JTextField();
		t_dept.setPreferredSize(new Dimension(150,35));
		t_name=new JTextField();
		t_name.setPreferredSize(new Dimension(150,35));
		
		p1.setLayout(new FlowLayout(FlowLayout.CENTER,0,40));
		p1.add(heading);//this
		
		p2.setLayout(new GridLayout(1,2,0,0));
		p2.add(uniID);p2.add(t_uniID);
		p3.setLayout(new FlowLayout(FlowLayout.CENTER));
		p3.add(p2); //this
		
		p4.setLayout(new GridLayout(1,2,0,0));
		p4.add(name);p4.add(t_name);
		p5.setLayout(new FlowLayout(FlowLayout.CENTER));
		p5.add(p4);//this
		
		p6.setLayout(new GridLayout(1,2,0,0));
		p6.add(dept);p6.add(t_dept);
		p7.setLayout(new FlowLayout(FlowLayout.CENTER));
		p7.add(p6);//this
		
		p10.setLayout(new GridLayout(1,2,10,0));
		p10.add(lpass);p10.add(pass);
		p11.setLayout(new FlowLayout(FlowLayout.CENTER));
		p11.add(p10);//this
		
		p12.setLayout(new GridLayout(1,2,10,0));
		p12.add(lcpass);p12.add(cpass);
		p13.setLayout(new FlowLayout(FlowLayout.CENTER));
		p13.add(p12);//this
		
		
		p8.setLayout(new FlowLayout(FlowLayout.CENTER));
		p8.add(finish);//this
		
		
		p9.setLayout(new GridLayout(7,1,0,0));
		p9.add(p1);p9.add(p3);p9.add(p5);p9.add(p7);p9.add(p11);p9.add(p13);
		p9.add(p8);
        
		jsp=new JScrollPane(p9);
		jsp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		jsp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		
		finish.addActionListener(this);
		add(jsp);
		setSize(600,700);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	@SuppressWarnings("deprecation")
	public void actionPerformed(ActionEvent ae)
	{
		teachId=t_uniID.getText();
		teachName=t_name.getText();
		teachDept=t_dept.getText();
		password=pass.getText();
		cpassword=cpass.getText();
		if(ae.getSource()==finish && password.equals(cpassword))
		{
			dispose();
			new tlog();
			try
			{
				//load driver class
				Class.forName("org.postgresql.Driver");
				//Connect to database
				conn=DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","");
				ps=conn.prepareStatement("insert into teacher values(?,?,?,?,?);");
				ps.setString(1,teachId);
				ps.setString(2,teachName);
				ps.setString(3,teachDept);
				ps.setString(4,password);
				ps.setString(5,cpassword);
				rows=ps.executeUpdate();
				if(rows>0)
				{
					System.out.println("Operation Successful");
				}
				else
					System.out.println("Failed");

			
			}
			catch(Exception excp)
			{
				excp.printStackTrace();
			}
		}
		else
			JOptionPane.showMessageDialog(null,"Invalid User(Please Enter User ID and Password correctly)");
	}
}
public class RegistrationPage2 
{
	public static void main(String[] args) 
	{
		new register2();
	}

}

