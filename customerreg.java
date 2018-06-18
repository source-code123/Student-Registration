 package project;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.awt.Panel;
import javax.swing.AbstractButton;
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
//import javax.swing.JMenu;
//import javax.swing.JMenuBar;
//import javax.swing.JMenuItem;

public class customerreg extends JFrame 
{
	private JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13,l14,l15;
	private JTextField tfname,tlname,temailid,tidno,tmobno,tad;
//	private JTextArea tadd;
	private JComboBox city,movie;
	private JCheckBox ch,cs,cr,can,cc,cac;
	private JRadioButton rmale,rfemale;
	private JButton bregister,bshowall,bclearall,bsearch,bdelete,bupdate;
	private String sysdate,systime;
	
//	private final JMenuBar jmenubar;
	//private final JMenu jmenu;
	//private final JMenuItem jmenuregister,jmenushowall;
	
	ArrayList<registration> userlist;
	
	registration r;
	
	public customerreg(String title)
	{
		super(title);
		Container c=getContentPane();
		c.setLayout(new GridLayout(16,2));
		tfname=new JTextField(30);
		tlname=new JTextField(30);
		temailid=new JTextField(30);
		tidno= new JTextField(30);
		tmobno=new JTextField(30);
		tad=new JTextField(30);
			
		String ctvalue[]={"Kolkata","Delhi","Mumbai","Chennnai","Hyderabad","Pune","Bangalore"};
		city=new JComboBox(ctvalue);
		String movievalue[]={"kOI MIL GAYA","CONJURING 2","RAEES","AVENGERS","THE JUNGLE BOOK",
							"OK JAANU","BAL GANESH","3 IDIOTS","HATE STORY",
								"ANABELLE","HEYY BABY","SINGHAM","DRISHYAM","TRANSFORMERS","FELUDA","TERMINATOR","JURASSIC PARK","ANACONDA","DABANG"};
		movie=new JComboBox(movievalue);
	
		rmale=new JRadioButton("Male");
		rfemale=new JRadioButton("Female");
		
		ButtonGroup rgroup= new ButtonGroup();
		rgroup.add(rmale);
		rgroup.add(rfemale);
		JPanel gpanel=new JPanel();
		gpanel.add(rmale);
		gpanel.add(rfemale);
		
		ch=new JCheckBox("HORROR");
		cs=new JCheckBox("SCIENCEFICTION");
		cr=new JCheckBox("ROMANTIC");
		can=new JCheckBox("ANIMATED");
		cc=new JCheckBox("COMEDY");
		cac=new JCheckBox("ACTION");
		JPanel ipanel=new JPanel();
		ipanel.add(ch);
		ipanel.add(cs);
		ipanel.add(cr);
		ipanel.add(can);
		ipanel.add(cc);
		ipanel.add(cac);
		
		bregister =new JButton("Register");
		bregister.addActionListener((e)->
		{
			addInformation();
		});
		
		bshowall=new JButton("Show All");
		bshowall.addActionListener((e)->
		{
			new DisplayAllData();
		});
		
		bclearall=new JButton("Reset All");
		bclearall.addActionListener((e)->
		{
			resetFrame();
		});
		
		bsearch=new JButton("Search");
		bsearch.addActionListener((e)->
		{
			String idno=JOptionPane.showInputDialog("Enter the id Number");
			int k=search(idno);
		});
		
		bdelete=new JButton("Delete");
		bdelete.addActionListener((e)->
		{
			String idno=JOptionPane.showInputDialog(this,"Enter the id Number");
			delete(idno);

		});
		
		bupdate=new JButton("Update");
		bupdate.addActionListener((e)->
		{
			String fname=JOptionPane.showInputDialog("Enter the name");
			String idno=JOptionPane.showInputDialog("Enter the id");
			String movie=JOptionPane.showInputDialog("Enter the moviename");
			update(idno,fname,movie);
		});
		Font f=new Font("comic sans ms",Font.BOLD,40);
		l1=new JLabel("CUSTOMER'S REGISTRATION");
		l1.setFont(f);
		l1.setForeground(Color.BLACK);
		
		Font f1=new Font("comic sans ms",Font.BOLD,20);
		l2=new JLabel("ENTER FIRST NAME");
		l2.setFont(f1);
		l2.setForeground(Color.BLUE);
		
		l3=new JLabel("ENTER LAST NAME");
		l3.setFont(f1);
		l3.setForeground(Color.BLUE);

		
		l4=new JLabel("ENTER EMAILID");
		l4.setFont(f1);
		l4.setForeground(Color.BLUE);
		

		l5=new JLabel("ENTER IDNO");
		l5.setFont(f1);
		l5.setForeground(Color.BLUE);
		
		
		l6=new JLabel("ENTER MOBNO");
		l6.setFont(f1);
		l6.setForeground(Color.BLUE);
		
		l7=new JLabel("ENTER ADDRESS");
		l7.setFont(f1);
		l7.setForeground(Color.BLUE);
		
		l8=new JLabel("SELECT CITY");
		l8.setFont(f1);
		l8.setForeground(Color.BLUE);

		l9=new JLabel("SELECT MOVIE");
		l9.setFont(f1);
		l9.setForeground(Color.BLUE);

		
		l10=new JLabel("SELECT GENDER");
		l10.setFont(f1);
		l10.setForeground(Color.BLUE);
		
		l11=new JLabel("SELECT INTERESTS");
		l11.setFont(f1);
		l11.setForeground(Color.BLUE);

/*		l10=new JLabel("Select Date Of Birth");
		l7.setFont(f1);
		l7.setForeground(Color.BLUE);
		
		l8=new JLabel("Select Interests");
		l8.setFont(f1);
		l8.setForeground(Color.BLUE);*/
		
		l12=new JLabel("CURRENT DATE");
		l12.setFont(f1);
		l12.setForeground(Color.BLUE);
		
		/*l14=new JLabel("CURRENT DATE");
		l14.setFont(f1);
		l14.setForeground(Color.BLUE);
		*/
		LocalDate today=LocalDate.now();
		int day=today.getDayOfMonth();
		int month=today.getMonthValue();
		int year=today.getYear();
		
		sysdate=day+"/"+month+"/"+year;
		l13=new JLabel(sysdate);
		
		LocalTime time=LocalTime.now();
		int hr=time.getHour();
		int min=time.getMinute();
		int sec=time.getSecond();
		
		systime=hr+":"+min+":"+sec;
		l15=new JLabel(systime);
		
		l14=new JLabel("CURRENT TIME");
		l14.setFont(f1);
		l14.setForeground(Color.BLUE);
		
		c.add(l1);c.add(new JLabel(""));
		c.add(l2);c.add(tfname);
		c.add(l3);c.add(tlname);
		c.add(l4);c.add(temailid);
		c.add(l5);c.add(tidno);
		c.add(l6);c.add(tmobno);
		c.add(l7);c.add(tad);
		c.add(l8);c.add(city);
		c.add(l9);c.add(movie);
		c.add(l10);c.add(gpanel);
		c.add(l11);c.add(ipanel);
		c.add(l12);
		c.add(l13);
		c.add(l14);
		c.add(l15);
	//	c.add(l9);c.add(l11);
	//	c.add(l10);c.add(l12);
		c.add(bregister);c.add(bshowall);
		c.add(bclearall);c.add(bsearch);
		c.add(bdelete);c.add(bupdate);
		
		setSize(1300,600);
		setLocation(200,0);
		setResizable(false);
		setVisible(true);
	}
	
	public void createRegObj()
	{
			String fname,lname,emailid,idno,mobno,ad,ct,mv,gn,ins;
			
				fname=tfname.getText().trim();
				lname=tlname.getText().trim();
				emailid=temailid.getText().trim();
				idno=tidno.getText().trim();
				mobno=tmobno.getText().trim();
				ad=tad.getText().trim();
				ct=(String)city.getSelectedItem();
				mv=(String)movie.getSelectedItem();
				gn="";
				if(rmale.isSelected())
				{
					gn="Male";
				}
				if(rfemale.isSelected())
				{
					gn="Female";
				}
				
		/*		String d=(String)day.getSelectedItem();
				String m=(String)month.getSelectedItem();
				String y=(String)year.getSelectedItem();
				
				dob=d+"-"+m+"-"+y;
*/				
				ins="";
				if((ch.isSelected()))
						{
								ins="HORROR";
						}
				if((cs.isSelected()))
						{
								ins=ins+"SCIENCEFICTION";
						}
				if((cr.isSelected()))
						{
								ins=ins+"ROMANTIC";
						}
				if((can.isSelected()))
				{
						ins=ins+"ANIMATED";
				}
				if((cc.isSelected()))
				{
						ins=ins+"COMEDY";
				}
				if((cac.isSelected()))
				{
						ins=ins+"ACTION";
				}

				
				
				r=new registration(fname,lname,emailid,idno,mobno,ct,mv,gn,ins,sysdate,systime,ins);
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
	public void update(String fname,String idno,String movie)
	{
		
		int k=search(fname);
		ArrayList<registration> list1;
		list1=UserDataReadWriteFromFile.readDataFromFile();
		list1.get(k).setfname(fname);
		list1.get(k).setidno(idno);
		list1.get(k).setmovie(movie);
		UserDataReadWriteFromFile.writeDatatoFile(list1);
		
	}
	
	public void delete(String idno)
	{
		
		int k=search(idno);
		ArrayList<registration> list1;
		list1=UserDataReadWriteFromFile.readDataFromFile();
		list1.remove(k);
		UserDataReadWriteFromFile.writeDatatoFile(list1);
		
	}
	public void resetFrame()
	{
		this.dispose();
		new customerreg("Registration....");
	}
	public static int search(String idno)
	{
		try{
		int f=-1;
		ArrayList<registration> list1;
		list1=UserDataReadWriteFromFile.readDataFromFile();
		for(int i=0;i<list1.size();i++)
		{	
			if(idno.equalsIgnoreCase(list1.get(i).getidno()))
			{
				JOptionPane.showMessageDialog(null,"id Found");
				f=i;
				break;
			}
			else{
				JOptionPane.showMessageDialog(null, "Not Found");
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
	public static void main(String args[])
	{
		new customerreg("Registration....");
	}
}


