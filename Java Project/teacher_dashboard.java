import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;

@SuppressWarnings("serial")
class tdashboard extends JFrame implements ActionListener
{
	JPanel p1,p2,p3,p4,p5,p6,p7,p8,p9,p10,p11,p12,p13,p14,p15,p16,p17,p18,p19,p20,p21,p22;
	JScrollPane jsp;
	JLabel user,notify,events,details,subject,credits;
	JRadioButton noti1,noti2,event1,event2,d1,d2,d3,stud1,stud2,clas;
	tdashboard()
	{
	    
		p1=new JPanel();p2=new JPanel();p3=new JPanel();p4=new JPanel();
		p5=new JPanel();p6=new JPanel();p7=new JPanel();p8=new JPanel();
		p9=new JPanel();p10=new JPanel();p11=new JPanel();p12=new JPanel();
		p13=new JPanel();p14=new JPanel();p15=new JPanel();p16=new JPanel();
		p17=new JPanel();p18=new JPanel();p19=new JPanel();p20=new JPanel();
		p21=new JPanel();p22=new JPanel();
		//images needed
		ImageIcon imgIcon = new ImageIcon("/home/dkale/Java Project/images/userIcon.png");
		JLabel userIcon = new JLabel(imgIcon);
		
		ImageIcon imgNotify = new ImageIcon("/home/dkale/Java Project/images/notify.png");
		JLabel notifyIcon = new JLabel(imgNotify);
		
		ImageIcon imgEvent = new ImageIcon("/home/dkale/Java Project/images/event.png");
		JLabel eventIcon = new JLabel(imgEvent);
		
		ImageIcon imgCourse = new ImageIcon("/home/dkale/Java Project/images/course.png");
		JLabel courseIcon = new JLabel(imgCourse);
		
		ImageIcon imgStud = new ImageIcon("/home/dkale/Java Project/images/userIcon.png");
		JLabel StudIcon = new JLabel(imgStud);
		
		ImageIcon imgSched = new ImageIcon("/home/dkale/Java Project/images/assign.png");
		JLabel schedIcon = new JLabel(imgSched);
		
		p1.setLayout(new CardLayout()); //For User and details of user
		p2.setLayout(new CardLayout()); //For Notifications
		p3.setLayout(new CardLayout()); //For Events or Programs
		p4.setLayout(new CardLayout()); // Course Details
		p5.setLayout(new CardLayout()); //Student Information
		p6.setLayout(new CardLayout()); //Credits or grades
		
		ButtonGroup bg=new ButtonGroup();
		bg.add(noti1);bg.add(noti2);bg.add(event1);bg.add(event2);
		bg.add(stud1);bg.add(stud2);bg.add(clas);
		
		//Design for user block p1
		user=new JLabel("User");
		user.setFont(new Font("Arial",Font.BOLD,18));
		p8.setLayout(new FlowLayout(FlowLayout.CENTER,10,0));
		p8.add(userIcon);p8.add(user);p1.add(p8);
		
		//Design for Notification p2
				notify=new JLabel("Notifications");
				notify.setFont(new Font("Arial",Font.BOLD,18));
				noti1=new JRadioButton("Teachers meeting schedule, Select to view");
				noti2=new JRadioButton("Exam dates, Select to view");
				p9.setLayout(new FlowLayout(FlowLayout.CENTER,10,0));
				p2.add(p9);
				noti1.setFont(new Font("Arial",Font.PLAIN,18));
				noti2.setFont(new Font("Arial",Font.PLAIN,18));
				p15.setLayout(new GridLayout(4,1));
				p15.add(notifyIcon);p15.add(notify);
				p15.add(noti1);p15.add(noti2);
				p9.add(p15);
				
				//Design For Events p3
				events=new JLabel("Events or Programs");
				events.setFont(new Font("Arial",Font.BOLD,18));
				event1=new JRadioButton("Campus Blood donation camp, Select to view");
				event2=new JRadioButton("Poster Competition, Select to view");
				p10.setLayout(new FlowLayout(FlowLayout.CENTER,10,0));
				p3.add(p10);
				event1.setFont(new Font("Arial",Font.PLAIN,18));
				event2.setFont(new Font("Arial",Font.PLAIN,18));
				p16.setLayout(new GridLayout(4,1));
				p16.add(eventIcon);p16.add(events);
				p16.add(event1);p16.add(event2);
				p10.add(p16);
		
		
		//Design for Respective Student Course Details and other details p4
		details=new JLabel("Course and Other Details");
		details.setFont(new Font("Arial",Font.BOLD,18));
		d1=new JRadioButton("Select, Subjects to teach");
		d2=new JRadioButton("Select, To view your attendance record");
		d3=new JRadioButton("Select, To set assignments for students");
		d1.setFont(new Font("Arial",Font.PLAIN,18));
		d2.setFont(new Font("Arial",Font.PLAIN,18));
		d3.setFont(new Font("Arial",Font.PLAIN,18));
		p11.setLayout(new FlowLayout(FlowLayout.CENTER));
		p4.add(p11);
		p17.setLayout(new GridLayout(5,1));
		p17.add(courseIcon);p17.add(details);
		p17.add(d1);p17.add(d2);p17.add(d3);
		p11.add(p17);
		
		//Design for Student Details p5
		subject=new JLabel("Student Details");
		subject.setFont(new Font("Arial",Font.BOLD,18));
		stud1=new JRadioButton("Select, To view Student Details");
		stud2=new JRadioButton("Select, To view and submit students attendance");
		stud2.addActionListener(this);
		stud1.setFont(new Font("Arial",Font.PLAIN,18));
		stud2.setFont(new Font("Arial",Font.PLAIN,18));
		p12.setLayout(new FlowLayout(FlowLayout.CENTER));
		p5.add(p12);
		p18.setLayout(new GridLayout(4,1));
		p18.add(StudIcon);p18.add(subject);
		p18.add(stud1);p18.add(stud2);
		p12.add(p18);
		
		//Design for Classes Schedule p6
		credits=new JLabel("Classes Schedule");
		credits.setFont(new Font("Arial",Font.BOLD,18));
		clas=new JRadioButton("Select, To view your Scheduled class,rooms and time");
		clas.setFont(new Font("Arial",Font.PLAIN,18));
		p13.setLayout(new FlowLayout(FlowLayout.CENTER));
		p6.add(p13);
		p19.setLayout(new GridLayout(3,1));
		p19.add(schedIcon);p19.add(credits);
		p19.add(clas);
		p13.add(p19);

		
	
		Border line = BorderFactory.createLineBorder(Color.LIGHT_GRAY);
		p1.setBorder(line);
		p2.setBorder(line);
		p3.setBorder(line);
		p4.setBorder(line);
		p5.setBorder(line);
		p6.setBorder(line);
		
		p7.setLayout(new GridLayout(2,3,5,5));
		p7.add(p1);p7.add(p2);p7.add(p3);
		p7.add(p4);p7.add(p5);p7.add(p6);
		
		jsp=new JScrollPane(p7);
		jsp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		jsp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);  
		add(jsp);
		setExtendedState(JFrame.MAXIMIZED_BOTH); 
		setResizable(false); //to prevent from being resized 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
	}
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==stud2)
		{
			new attendance();
		}
	}
}
public class teacher_dashboard 
{
	public static void main(String[] args) 
	{
		new tdashboard();
	}

}



