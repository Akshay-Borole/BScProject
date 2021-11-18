import java.sql.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
@SuppressWarnings("serial")
class feesInfo extends JFrame implements ActionListener
{
	String stud_id,sname,scource,stotalpaid,stotal,sremain;
	PreparedStatement ps=null;
	ResultSet rs=null;
	Connection conn=null;
	int rows,id;	
	JPanel p1,p2,p3,p4,p5,p6,p7,p8,p9,p10,p11,p12,p13,p14,p15;
	JLabel StudentName,StudentID,Course,TotalFees,TotalPaid,FeesRemaining,rtitle;
	JTextField t_StudentName,t_StudentID,t_Course,t_TotalFees,t_TotalPaid,t_FeesRemaining;	
	JButton submit;
	feesInfo()
	{
		
			p1=new JPanel();p2=new JPanel();p3=new JPanel();p4=new JPanel();
			p5=new JPanel();p6=new JPanel();p7=new JPanel();p8=new JPanel();
			p9=new JPanel();p10=new JPanel();p11=new JPanel();p12=new JPanel();
			p13=new JPanel();p14=new JPanel();p15=new JPanel();
			
			submit=new JButton("Submit");
			submit.setPreferredSize(new Dimension(150,30));			
			submit.addActionListener(this);

			StudentName=new JLabel("Student Name");
			StudentName.setFont(new Font("Verdana", Font.BOLD, 16));
			StudentID=new JLabel("Student ID");
			StudentID.setFont(new Font("Verdana", Font.BOLD, 16));
			Course=new JLabel("Course");
			Course.setFont(new Font("Verdana", Font.BOLD, 16));
			TotalFees=new JLabel("Total Fees");
			TotalFees.setFont(new Font("Verdana", Font.BOLD, 16));
			TotalPaid=new JLabel("Total Fees Paid");
			TotalPaid.setFont(new Font("Verdana", Font.BOLD, 16));
			FeesRemaining=new JLabel("Remaining Fees");
			FeesRemaining.setFont(new Font("Verdana", Font.BOLD, 16));
			rtitle=new JLabel("Fee Records");
			rtitle.setFont(new Font("Verdana", Font.BOLD, 18));
			
			t_StudentName=new JTextField();
			
			t_StudentName.setPreferredSize(new Dimension(150,30));
			
			t_StudentID=new JTextField();
			
			t_StudentID.setPreferredSize(new Dimension(150,30));
			
			t_Course=new JTextField();
			
			t_Course.setPreferredSize(new Dimension(150,30));
			
			t_TotalFees=new JTextField();
			
			t_TotalFees.setPreferredSize(new Dimension(150,30));
			
			t_TotalPaid=new JTextField();
			
			t_TotalPaid.setPreferredSize(new Dimension(150,30));
			
			t_FeesRemaining=new JTextField();
			
			t_FeesRemaining.setPreferredSize(new Dimension(150,30));
			
			p1.setLayout(new FlowLayout(FlowLayout.CENTER,0,30));
			p1.add(rtitle);//this
			
			p2.setLayout(new GridLayout(1,2,0,0));
			p2.add(StudentID);p2.add(t_StudentID);
			p3.setLayout(new FlowLayout(FlowLayout.CENTER));
			p3.add(p2); //this
			
			p4.setLayout(new GridLayout(1,2,0,0));
			p4.add(StudentName);p4.add(t_StudentName);
			p5.setLayout(new FlowLayout(FlowLayout.CENTER));
			p5.add(p4);//this
			
			p6.setLayout(new GridLayout(1,2,0,0));
			p6.add(Course);p6.add(t_Course);
			p7.setLayout(new FlowLayout(FlowLayout.CENTER));
			p7.add(p6);//this
			
			p8.setLayout(new GridLayout(1,2,0,0));
			p8.add(TotalPaid);p8.add(t_TotalPaid);
			p9.setLayout(new FlowLayout(FlowLayout.CENTER));
			p9.add(p8);//this

			p10.setLayout(new GridLayout(1,2,0,0));
			p10.add(TotalFees);p10.add(t_TotalFees);
			p11.setLayout(new FlowLayout(FlowLayout.CENTER));
			p11.add(p10);//this

			p12.setLayout(new GridLayout(1,2,0,0));
			p12.add(FeesRemaining);p12.add(t_FeesRemaining);
			p13.setLayout(new FlowLayout(FlowLayout.CENTER));
			p13.add(p12);//this
			
			p14.setLayout(new GridLayout(8,1,0,0));
			p14.add(p1);p14.add(p3);p14.add(p5);p14.add(p7);
			p14.add(p9);p14.add(p11);p14.add(p13);p14.add(p15);
			p15.setLayout(new FlowLayout(FlowLayout.CENTER));
			p15.add(submit);		
			
			setTitle("Enter Fees Information");
			add(p14);
			setSize(600,700);
			setVisible(true);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	public void actionPerformed(ActionEvent ae)
	{
			
		stud_id=t_StudentID.getText();
		id=Integer.parseInt(stud_id);
		sname=t_StudentName.getText();
		scource=t_Course.getText();
		stotalpaid=t_TotalPaid.getText();
		stotal=t_TotalFees.getText();
		sremain=t_FeesRemaining.getText();
		
		
		if(ae.getSource()==submit)
		{
			try
			{
				//load driver class
				Class.forName("org.postgresql.Driver");
				//Connect to database
				conn=DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","");
				ps=conn.prepareStatement("insert into feeRecord values(?,?,?,?,?,?)");
				ps.setInt(1,id);
				ps.setString(2,sname);
				ps.setString(3,scource);
				ps.setString(4,stotalpaid);
				ps.setString(5,stotal);
				ps.setString(6,sremain);
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
			catch(Exception ex)
			{
				ex.printStackTrace();
			}		
	}
}
}
public class enterFeesInfo 
{
	public static void main(String args[])
	{
		new feesInfo();
	}
}

