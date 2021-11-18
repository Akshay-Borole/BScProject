
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
@SuppressWarnings("serial")
class medical extends JFrame implements ActionListener
{
	int rows,id,y;
	String issue,docName,hosName,docAddress,sid,year,mid;
	PreparedStatement ps=null;
	ResultSet rs=null;
	Connection conn=null;
	JPanel p1,p2,p3,p4,p5,p0;
	JButton generate,saveInfo;
	JScrollPane jsp;
	JLabel mtitle,studentID,studentname,medIssue,doctor,hospitalName,hospitalAddress,myear;
	JTextField t_studentID,t_studentname,t_medIssue,t_doctor,t_hospitalName,
	t_hospitalAddress,t_myear;
	medical()
	{
		p1=new JPanel();p2=new JPanel();p3=new JPanel();p4=new JPanel();
		p5=new JPanel();p0=new JPanel();
		
		mtitle=new JLabel("Medical Information Form");
		mtitle.setFont(new Font("Verdana",Font.BOLD,18));
		studentID=new JLabel("Student ID:");
		studentID.setFont(new Font("Verdana",Font.BOLD,14));
		studentname=new JLabel("Student Name:");
		studentname.setFont(new Font("Verdana",Font.BOLD,14));
		medIssue=new JLabel("Enter Medical Issue under treatement:");
		medIssue.setFont(new Font("Verdana",Font.BOLD,14));
		doctor=new JLabel("Enter the name of Doctor seen for treatement:");
		doctor.setFont(new Font("Verdana",Font.BOLD,14));
		hospitalName=new JLabel("Hospital name:");
		hospitalName.setFont(new Font("Verdana",Font.BOLD,14));
		myear=new JLabel("Treatement time(years)");
		myear.setFont(new Font("Verdana",Font.BOLD,14));
		hospitalAddress=new JLabel("Hospital Address:");
		hospitalAddress.setFont(new Font("Verdana",Font.BOLD,14));
		
		t_studentID=new JTextField();
		t_studentID.setPreferredSize(new Dimension(150,30));
		t_studentname=new JTextField();
		t_studentname.setPreferredSize(new Dimension(150,30));
		t_medIssue=new JTextField();
		t_medIssue.setPreferredSize(new Dimension(150,30));
		t_doctor=new JTextField();
		t_doctor.setPreferredSize(new Dimension(150,30));
		t_hospitalName=new JTextField();
		t_hospitalName.setPreferredSize(new Dimension(150,30));
		t_hospitalAddress=new JTextField();
		t_hospitalAddress.setPreferredSize(new Dimension(150,30));
		t_myear=new JTextField();
		t_myear.setPreferredSize(new Dimension(150,30));
		
		saveInfo=new JButton("Save");
		saveInfo.setPreferredSize(new Dimension(150,30));
		generate=new JButton("Click to view your Medical ID");
		generate.setPreferredSize(new Dimension(270,30));
	
		p0.setLayout(new FlowLayout(FlowLayout.CENTER,0,50));
		p0.add(mtitle); //this
	        p1.setLayout(new GridLayout(1,1));
		p1.add(p0);
	
		p2.setLayout(new GridLayout(6,2,5,10));
		p2.add(studentID); 		p2.add(t_studentID);
		p2.add(medIssue);  		p2.add(t_medIssue);
		p2.add(myear);     		p2.add(t_myear);
		p2.add(doctor);    		p2.add(t_doctor);
		p2.add(hospitalName);	p2.add(t_hospitalName);
		p2.add(hospitalAddress);p2.add(t_hospitalAddress);
		
		p3.setLayout(new FlowLayout(FlowLayout.CENTER));
		p3.add(p2); //this
		
		p4.setLayout(new FlowLayout(FlowLayout.CENTER,10,60));
		p4.add(saveInfo);p4.add(generate); //this
		
		p5.setLayout(new GridLayout(3,1));
		p5.add(p0);p5.add(p3);p5.add(p4);
		
		jsp=new JScrollPane(p5);
		jsp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		jsp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);  
		add(jsp);		

		saveInfo.addActionListener(this);
		generate.addActionListener(this);
		setSize(1000,750);
		setVisible(true);
		setDefaultCloseOperation(JFrame.ICONIFIED);
	}
	public void actionPerformed(ActionEvent ae)
	{
		sid=t_studentID.getText();
		id=Integer.parseInt(sid);
		year=t_myear.getText();
		y=Integer.parseInt(year);
		issue=t_medIssue.getText();
		docName=t_doctor.getText();
		hosName=t_hospitalName.getText();
		docAddress=t_hospitalAddress.getText();
		if(ae.getSource()==saveInfo)
		{
		try
		{
				//load driver class
				Class.forName("org.postgresql.Driver");
				//Connect to database
				conn=DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","");
				ps=conn.prepareStatement("insert into medical values(?,?,?,?,?,?)");
				ps.setInt(1,id);
				ps.setString(2,issue);
				ps.setInt(3,y);
				ps.setString(4,docName);
				ps.setString(5,hosName);
				ps.setString(6,docAddress);
				rows=ps.executeUpdate();
				if(rows>0)
				{
					JOptionPane.showMessageDialog(null,"Registered Successfully");
					System.out.println("Operation Sucessful");
				}
				else
				{
					JOptionPane.showMessageDialog(null,"Retry");
					System.out.println("Operation Failed");
				}
		}
		catch(Exception excp)
		{
			excp.printStackTrace();
		}
	}
		if(ae.getSource()==generate)
		{
			mid=sid.concat("MID");
			JOptionPane.showMessageDialog(null, "Your Medical ID is: "+mid);
		}
	}
}
public class MedicalRegistration 
{
	public static void main(String args[])
	{
		new medical();
	}
	}

