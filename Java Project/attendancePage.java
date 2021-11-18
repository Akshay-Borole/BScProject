
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
@SuppressWarnings("serial")
class attendance extends JFrame implements ActionListener
{
	PreparedStatement ps=null;
	ResultSet rs=null;
	Connection conn=null;	
	String jan,feb,mar,api,may,june,july,aug,sept,oct,nov,dec,s_id;
	int rows,m1,m2,m3,m4,m5,m6,m7,m8,m9,m10,m11,m12,id;
	JScrollPane jsp;
	JButton enter;
	JPanel p1,p2,p3,p4,p5,p6,p7,p8;
	JTextField tjan,tfeb,tmar,tapi,tmay,tjune,tjuly,taug,tsept,toct,tnov,tdec,tstudId;
	JLabel Attend,stud_id,ljan,lfeb,lmar,lapi,lmay,ljune,ljuly,laug,lsept,loct,lnov,ldec;
	attendance()
	{
		p1=new JPanel();p2=new JPanel();p3=new JPanel();
		p4=new JPanel();p5=new JPanel();p6=new JPanel();
		p7=new JPanel();p8=new JPanel();
		
		enter=new JButton("Submit");
		enter.setPreferredSize(new Dimension(100,30));
		
		Attend=new JLabel("Enter Monthly Attendance");
		Attend.setFont(new Font("Verdana",Font.BOLD,18));

		stud_id=new JLabel("Enter Student ID whose attendance is to be filled:");
		stud_id.setFont(new Font("Verdana",Font.PLAIN,16));
		
		ljan=new JLabel("January");
		ljan.setFont(new Font("Verdana",Font.PLAIN,16));
		lfeb=new JLabel("Febuary");
		lfeb.setFont(new Font("Verdana",Font.PLAIN,16));
		lmar=new JLabel("March");
		lmar.setFont(new Font("Verdana",Font.PLAIN,16));
		lapi=new JLabel("April");
		lapi.setFont(new Font("Verdana",Font.PLAIN,16));
		lmay=new JLabel("May");
		lmay.setFont(new Font("Verdana",Font.PLAIN,16));
		ljune=new JLabel("June");
		ljune.setFont(new Font("Verdana",Font.PLAIN,16));
		ljuly=new JLabel("July");
		ljuly.setFont(new Font("Verdana",Font.PLAIN,16));
		laug=new JLabel("August");
		laug.setFont(new Font("Verdana",Font.PLAIN,16));
		lsept=new JLabel("September");
		lsept.setFont(new Font("Verdana",Font.PLAIN,16));
		loct=new JLabel("October");
		loct.setFont(new Font("Verdana",Font.PLAIN,16));
		lnov=new JLabel("November");
		lnov.setFont(new Font("Verdana",Font.PLAIN,16));
		ldec=new JLabel("December");
		ldec.setFont(new Font("Verdana",Font.PLAIN,16));
		
		tstudId=new JTextField();
		tstudId.setPreferredSize(new Dimension(100,30));
		tjan=new JTextField(); 
		tjan.setPreferredSize(new Dimension(100,30));
		tfeb=new JTextField();
		tfeb.setPreferredSize(new Dimension(100,30));
		tmar=new JTextField();
		tmar.setPreferredSize(new Dimension(100,30));
		tapi=new JTextField();
		tapi.setPreferredSize(new Dimension(100,30));
		tmay=new JTextField();
		tmay.setPreferredSize(new Dimension(100,30));
		tjune=new JTextField();
		tjune.setPreferredSize(new Dimension(100,30));
		tjuly=new JTextField();
		tjuly.setPreferredSize(new Dimension(100,30));
		taug=new JTextField();
		taug.setPreferredSize(new Dimension(100,30));
		tsept=new JTextField();
		tsept.setPreferredSize(new Dimension(100,30));
		toct=new JTextField();
		toct.setPreferredSize(new Dimension(100,30));
		tnov=new JTextField();
		tnov.setPreferredSize(new Dimension(100,30));
		tdec=new JTextField();
		tdec.setPreferredSize(new Dimension(100,30));
		tstudId.setPreferredSize(new Dimension(100,30));
		//title
		p1.setLayout(new FlowLayout(FlowLayout.CENTER,0,60));
		p1.add(Attend);//this
		
		//Enter Student ID
		p4.setLayout(new FlowLayout(FlowLayout.CENTER,0,30));
		p4.add(stud_id);p4.add(tstudId);
		
		//Months and its text boxes
		p5.setLayout(new GridLayout(6,4,20,10));
		p5.add(ljan);p5.add(tjan); p5.add(lfeb);p5.add(tfeb);
		p5.add(lmar);p5.add(tmar); p5.add(lapi);p5.add(tapi);
		p5.add(lmay);p5.add(tmay); p5.add(ljune);p5.add(tjune);
		p5.add(ljuly);p5.add(tjuly); p5.add(laug);p5.add(taug);
		p5.add(lsept);p5.add(tsept); p5.add(loct);p5.add(toct);
		p5.add(lnov);p5.add(tnov); p5.add(ldec);p5.add(tdec);
		p6.setLayout(new FlowLayout(FlowLayout.CENTER));
		p6.add(p5);
		
		p8.setLayout(new FlowLayout(FlowLayout.CENTER,0,30));
		p8.add(enter);
		
		p7.setLayout(new GridLayout(4,1));
		p7.add(p1);p7.add(p4);p7.add(p6);p7.add(p8);
		
		enter.addActionListener(this);		
			
		jsp=new JScrollPane(p7);
		jsp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		jsp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);  
		add(jsp);
		setTitle("Enter Attendance");
		setSize(600,600);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
		
		public void actionPerformed(ActionEvent ae)
		{
			s_id=tstudId.getText();
			id=Integer.parseInt(s_id);
			jan=tjan.getText();
			m1=Integer.parseInt(jan);
			feb=tfeb.getText();
			m2=Integer.parseInt(feb);
			mar=tmar.getText();
			m3=Integer.parseInt(mar);
			api=tapi.getText();
			m4=Integer.parseInt(api);
			may=tmay.getText();
			m5=Integer.parseInt(may);
			june=tjune.getText();
			m6=Integer.parseInt(june);
			july=tjuly.getText();
			m7=Integer.parseInt(july);
			aug=taug.getText();
			m8=Integer.parseInt(aug);
			sept=tsept.getText();
			m9=Integer.parseInt(sept);
			oct=toct.getText();
			m10=Integer.parseInt(oct);
			nov=tnov.getText();
			m11=Integer.parseInt(nov);
			dec=tdec.getText();
			m12=Integer.parseInt(dec);
			if(ae.getSource()==enter)
			try
			{
				//load driver class
				Class.forName("org.postgresql.Driver");
				//Connect to database
				conn=DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","");
				ps=conn.prepareStatement("insert into attendance values(?,?,?,?,?,?,?,?,?,?,?,?,?);");
				ps.setInt(1,id);
				ps.setInt(2,m1);
				ps.setInt(3,m2);
				ps.setInt(4,m3);
				ps.setInt(5,m4);
				ps.setInt(6,m5);
				ps.setInt(7,m6);
				ps.setInt(8,m7);
				ps.setInt(9,m8);
				ps.setInt(10,m9);
				ps.setInt(11,m10);
				ps.setInt(12,m11);
				ps.setInt(13,m12);
				rows=ps.executeUpdate();
				if(rows>0)
				{
					JOptionPane.showMessageDialog(null,"Entered Successfully");
					dispose();
					System.out.println("Operation Sucessful");
				}
				else
					JOptionPane.showMessageDialog(null,"Please Enter correctly");
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
}
public class attendancePage 
{
	
	public static void main(String[] args) 
	{
		
		new attendance();
	}

}

