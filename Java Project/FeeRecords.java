import java.awt.*;
import javax.swing.*;

 @SuppressWarnings("serial")
class fees extends JFrame
{
	JPanel p1,p2,p3,p4,p5,p6,p7,p8,p9,p10,p11,p12,p13,p14;
	JLabel StudentName,StudentID,Course,TotalFees,TotalPaid,FeesRemaining,rtitle;
	JTextArea t_StudentName,t_StudentID,t_Course,t_TotalFees,t_TotalPaid,t_FeesRemaining;
	fees()
	{
		p1=new JPanel();p2=new JPanel();p3=new JPanel();p4=new JPanel();
		p5=new JPanel();p6=new JPanel();p7=new JPanel();p8=new JPanel();
		p9=new JPanel();p10=new JPanel();p11=new JPanel();p12=new JPanel();
		p13=new JPanel();p14=new JPanel();
		
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
		
		t_StudentName=new JTextArea();
		t_StudentName.setBackground(Color.lightGray);
		t_StudentName.setPreferredSize(new Dimension(150,30));
		
		t_StudentID=new JTextArea();
		t_StudentID.setBackground(Color.lightGray);
		t_StudentID.setPreferredSize(new Dimension(150,30));
		
		t_Course=new JTextArea();
		t_Course.setBackground(Color.lightGray);
		t_Course.setPreferredSize(new Dimension(150,30));
		
		t_TotalFees=new JTextArea();
		t_TotalFees.setBackground(Color.lightGray);
		t_TotalFees.setPreferredSize(new Dimension(150,30));
		
		t_TotalPaid=new JTextArea();
		t_TotalPaid.setBackground(Color.lightGray);
		t_TotalPaid.setPreferredSize(new Dimension(150,30));
		
		t_FeesRemaining=new JTextArea();
		t_FeesRemaining.setBackground(Color.lightGray);
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
		
		p14.setLayout(new GridLayout(7,1,0,0));
		p14.add(p1);p14.add(p3);p14.add(p5);p14.add(p7);
		p14.add(p9);p14.add(p11);p14.add(p13);
		
		 
		p1.setBackground(Color.white);
		p2.setBackground(Color.white);
		p3.setBackground(Color.white);
		p4.setBackground(Color.white);
		p5.setBackground(Color.white);
		p6.setBackground(Color.white);
		p7.setBackground(Color.white);
		p8.setBackground(Color.white);
		p9.setBackground(Color.white);
		p10.setBackground(Color.white);
		p11.setBackground(Color.white);
		p12.setBackground(Color.white);
		p13.setBackground(Color.white);
		p14.setBackground(Color.white);
		

		add(p14);
		setSize(600,700);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

public class FeeRecords 
{
	public static void main(String[] args) 
	{
		new fees();
	}

}
