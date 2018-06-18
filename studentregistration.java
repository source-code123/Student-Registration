package srs;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.awt.Panel;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;

public class studentregistration extends JFrame 
{
	private JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13,l14,l15,l16,l17,l18;
	private JTextField tfname,tlname,temailid,tmobno,tgname,tad,tcol,tp,tfn;
	private JTextArea tadd;
	private JComboBox city,day,month,year;
	private JRadioButton rmale,rfemale,rothers,rjava,randroid,rphp,rnet,rpython;
	private JButton bregister,breset,bstudent,bcourse,bdelete,bupdate,bpay;
	private String sysdate,jseat;
	
	ArrayList<registration> userlist;
	
	registration r;
	
	public studentregistration(String title)
	{
		super(title);
		Container c=getContentPane();
		c.setLayout(new GridLayout(20,4));
		tfname=new JTextField(20);
		tlname=new JTextField(20);
		tgname=new JTextField(20);
		tad=new JTextField(20);
		temailid=new JTextField(20);
		tmobno=new JTextField(20);
		tcol=new JTextField(20);
		tp=new JTextField(20);
		tfn=new JTextField(20);
		
		tadd=new JTextArea(20,20);
		JScrollPane tapan=new JScrollPane(tadd);
		
		String ctvalue[]={"Kolkata","Delhi","Mumbai","Chennnai","Hyderabad","Pune","Bangalore"};
		city=new JComboBox(ctvalue);
		
		rmale=new JRadioButton("Male");
		rfemale=new JRadioButton("Female");
		rothers=new JRadioButton("Others");
		rjava=new JRadioButton("JAVA");
		rnet=new JRadioButton("DOTNET");
		rpython=new JRadioButton("PYTHON");
		rphp=new JRadioButton("PHP & MYSQL");
		randroid=new JRadioButton("ANDROID");
		
		
		ButtonGroup rgroup= new ButtonGroup();
		rgroup.add(rmale);
		rgroup.add(rfemale);
		rgroup.add(rothers);
		
		
		ButtonGroup rgroup1= new ButtonGroup();
		rgroup1.add(randroid);
		rgroup1.add(rjava);
		rgroup1.add(rpython);
		rgroup1.add(rphp);
		rgroup1.add(rnet);
		
		JPanel gpanel=new JPanel();
		gpanel.add(rmale);
		gpanel.add(rfemale);
		gpanel.add(rothers);
	
		String dvalue[]=new String[31];
		for(int i=0;i<=30;i++)
			dvalue[i]=String.valueOf(i+1);
		
		day=new JComboBox(dvalue);
		
		String mvalue[]=new String[12];
		int cnt=0;
		for(int i=0;i<=11;i++)
			mvalue[i]=String.valueOf(i+1);
		
		month=new JComboBox(mvalue);
		
		String yvalue[]=new String[17];
		for(int i=2000;i<=2016;i++)
		{
			yvalue[cnt]=String.valueOf(i);
			cnt++;
		}	
		year=new JComboBox(yvalue);
		
		JPanel dpanel=new JPanel();
		dpanel.add(day);
		dpanel.add(month);
		dpanel.add(year);
		
		
		JPanel cpanel=new JPanel();
		cpanel.add(rjava);
		cpanel.add(rpython);
		cpanel.add(rphp);
		cpanel.add(rnet);
		cpanel.add(randroid);
		
		bregister =new JButton("Register");
		bregister.addActionListener((e)->
		{
			int r=cseat(jseat);
			int d=checkpayment();
			if(d==1 && r==1)
				addInformation();
			
			
			
		});
		
		bstudent=new JButton("Student Details");
		bstudent.addActionListener((e)->
		{
			new DisplayAllData();
		});
		
		breset=new JButton("Reset");
		breset.addActionListener((e)->
		{
			resetFrame();
		});
		
		bcourse=new JButton("Course Details");
		bcourse.addActionListener((e)->
		{
			new coursedisplay();
		});
		
		bdelete=new JButton("Delete");
		bdelete.addActionListener((e)->
		{
			String fn=JOptionPane.showInputDialog(this,"Enter Form Number");
			delete(fn);

		});
		
		bpay=new JButton("Update Payment");
		bpay.addActionListener((e)->
		{
			String fn=JOptionPane.showInputDialog(this,"Enter Form Number");
			String p=JOptionPane.showInputDialog(this,"Enter Payment");
			payment(fn,p);

		});
		
		
		bupdate=new JButton("Update Details");
		bupdate.addActionListener((e)->
		{
			String fn=JOptionPane.showInputDialog("Enter the Form Number");
			String fname=JOptionPane.showInputDialog("Enter the First Name");
			String lname=JOptionPane.showInputDialog("Enter the Last Name");
			String gname=JOptionPane.showInputDialog("Enter the Guardian's Name");
			String mobno=JOptionPane.showInputDialog("Enter the Mobile Number");
			String ad=JOptionPane.showInputDialog("Enter the Address");
			update(fn,fname,lname,gname,ad,mobno);
		});
		Font f=new Font("baskerville old face",Font.BOLD,20);
		l15=new JLabel("STUDENT REGISTRATION");
		l15.setFont(f);
		l15.setForeground(Color.BLACK);
		
		Font f1=new Font("comic sans ms",Font.BOLD,14);
		l1=new JLabel("FIRST NAME :");
		l1.setFont(f1);
		l1.setForeground(Color.BLUE);
		
		l2=new JLabel("LAST NAME :");
		l2.setFont(f1);
		l2.setForeground(Color.BLUE);

		l18=new JLabel("FORM NO :");
		l18.setFont(f1);
		l18.setForeground(Color.BLUE);
		
			
		l3=new JLabel("GUARDIAN'S NAME :");
		l3.setFont(f1);
		l3.setForeground(Color.BLUE);
		
		l4=new JLabel("ADDRESS :");
		l4.setFont(f1);
		l4.setForeground(Color.BLUE);
		
		l5=new JLabel("CITY :");
		l5.setFont(f1);
		l5.setForeground(Color.BLUE);
		
		l6=new JLabel("GENDER :");
		l6.setFont(f1);
		l6.setForeground(Color.BLUE);

		l7=new JLabel("MOBILE NUMBER :");
		l7.setFont(f1);
		l7.setForeground(Color.BLUE);
		
		l8=new JLabel("EMAIL-ID :");
		l8.setFont(f1);
		l8.setForeground(Color.BLUE);

		l9=new JLabel("DATE OF BIRTH :");
		l9.setFont(f1);
		l9.setForeground(Color.BLUE);
		
		l10=new JLabel("COLLEGE NAME :");
		l10.setFont(f1);
		l10.setForeground(Color.BLUE);
		
		l11=new JLabel("COURSE :");
		l11.setFont(f1);
		l11.setForeground(Color.BLUE);
		
/*		l12=new JLabel("Course Fees :Rs 6000 For Each Course ");
		l12.setFont(f1);
		l12.setForeground(Color.BLACK);*/
		
		l13=new JLabel("PAYMENT :");
		l13.setFont(f1);
		l13.setForeground(Color.BLUE);
		
/*		l14=new JLabel("At Least Rs 2000 /-");
		l14.setFont(f1);
		l14.setForeground(Color.BLACK);
	*/	
		l16=new JLabel("CURRENT DATE :");
		l16.setFont(f1);
		l16.setForeground(Color.BLUE);
		
		LocalDate today=LocalDate.now();
		int day=today.getDayOfMonth();
		int month=today.getMonthValue();
		int year=today.getYear();
		
		sysdate=day+"/"+month+"/"+year;
		l17=new JLabel(sysdate);
		
		c.add(l15);c.add(new JLabel(""));
		c.add(l18);c.add(tfn);
		c.add(l1);c.add(tfname);c.add(l2);c.add(tlname);
		c.add(l3);c.add(tgname);
		c.add(l4);c.add(tad);
		c.add(l5);c.add(city);
		c.add(l6);c.add(gpanel);
		c.add(l7);c.add(tmobno);c.add(l8);c.add(temailid);
		c.add(l9);c.add(dpanel);
		c.add(l10);c.add(tcol);
		c.add(l11);c.add(cpanel);
	//	c.add(l12);
		c.add(l13);c.add(tp);
	//	c.add(l14);
		c.add(l16);c.add(l17);
		c.add(bregister);c.add(breset);
		c.add(bupdate);c.add(bstudent);
		c.add(bdelete);c.add(bcourse);
		c.add(bpay);
		
		
		setSize(1000,1000);
		setLocation(200,0);
		setResizable(false);
		setVisible(true);
	}
	
	public void createRegObj()
	{		
			
			String fn,fname,lname,gname,ad,ct,gn,mobno,emailid,dob,col,course,pay,coursecode;
				
				fn=tfn.getText().trim();
				fname=tfname.getText().trim();
				lname=tlname.getText().trim();
				gname=tgname.getText().trim();
				ad=tad.getText().trim();
				emailid=temailid.getText().trim();
				mobno=tmobno.getText().trim();
				col=tcol.getText().trim();
				pay=tp.getText().trim();
				ct=(String)city.getSelectedItem();
				
				gn="";
				if(rmale.isSelected())
				{
					gn="Male";
				}
				if(rfemale.isSelected())
				{
					gn="Female";
				}
				if(rothers.isSelected())
				{
					gn="Others";
				}
				
				String d=(String)day.getSelectedItem();
				String m=(String)month.getSelectedItem();
				String y=(String)year.getSelectedItem();
				
				dob=d+"-"+m+"-"+y;
				
				course="";
				coursecode="";
				jseat="2";
				if(rjava.isSelected())
				{
								course="JAVA";
								coursecode="590";
								
				}
				if(rpython.isSelected())
						{
								course="PYTHON";
								coursecode="591";
								
						}
				if(rphp.isSelected())
						{
								course="PHP";
								coursecode="592";
								
						}
				if(rnet.isSelected())
				{
						course="dotNET";
						coursecode="593";
						
				}
				if(randroid.isSelected())
				{
						course="ANDROID";
						coursecode="594";
						
				}
				
				
				
				r=new registration(fn,fname,lname,gname,ad,ct,gn,mobno,emailid,dob,col,course,pay,sysdate,coursecode,jseat);
	}
	public void addInformation()
	{
		createRegObj();
		
		userlist=UserDataReadWriteFromFile.readDataFromFile();
		userlist.add(r);
		UserDataReadWriteFromFile.writeDatatoFile(userlist);
		
		JOptionPane.showMessageDialog(this, "Registration Successful...");
		
		resetFrame();
	}
public void update(String rn,String fname,String lname,String gname,String ad,String mobno)
	{
		
		int k=search(rn);
		ArrayList<registration> list1;
		list1=UserDataReadWriteFromFile.readDataFromFile();
		list1.get(k).setfname(fname);
		list1.get(k).setlname(lname);
		list1.get(k).setad(ad);
		list1.get(k).setmobno(mobno);
		list1.get(k).setgname(gname);
		
		UserDataReadWriteFromFile.writeDatatoFile(list1);
		
	}
public String seatupdate(String jseat)
{
	int a=Integer.parseInt(jseat);	
		a--;
		jseat=String.valueOf(a);
	return jseat;
}
public int cseat(String jseat)
{	
	 String z=seatupdate(jseat);
	 int g=Integer.parseInt(z);
	if(g>0)
	{	
		return 1;
	}
	else
	{
		JOptionPane.showMessageDialog(null, "No Seats Available");
		return 0;
	}
}
	
	public void delete(String rn)
	{
		
		int k=search(rn);
		ArrayList<registration> list1;
		list1=UserDataReadWriteFromFile.readDataFromFile();
		list1.remove(k);
		UserDataReadWriteFromFile.writeDatatoFile(list1);
		
	}
	public void payment(String rn,String p)
	{
		
		int k=search(rn);
		int c,a;
		String g,b;
		ArrayList<registration> list1;
		list1=UserDataReadWriteFromFile.readDataFromFile();
		g=list1.get(k).getpay();
		c=Integer.parseInt(g);
		a=Integer.parseInt(p);
		c=c+a;
		b=String.valueOf(c);
		list1.get(k).setpay(b);
		UserDataReadWriteFromFile.writeDatatoFile(list1);
		
	}
	public void resetFrame()
	{
		this.dispose();
		new studentregistration("Registration....");
	}
	public static int search(String rn)
	{
		try{
		int f=-1;
		ArrayList<registration> list1;
		list1=UserDataReadWriteFromFile.readDataFromFile();
		for(int i=0;i<list1.size();i++)
		{	
			if(rn.equalsIgnoreCase(list1.get(i).getfn()))
			{
				f=i;
				break;
			}
		}
			return f;
		}
		catch(Exception e)
		{
			System.out.println(e);
			return -2;
		}
	}
	public int checkpayment()
	{
		String p=tp.getText();
		int c=Integer.parseInt(p);
		if(c<2000)
		{
			JOptionPane.showMessageDialog(null, "Minimum Payment is Rs 2000. ");
			return 0;
		
		}
		else
			return 1;
		
	}
	public static void main(String args[])
	{
		new studentregistration("Registration");
	}
}
