package srs;

import java.awt.BorderLayout;
import java.awt.Container;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class coursedisplay extends JFrame 
{
	
	public coursedisplay()
	{
		super("Display All");
		String heading[]={"FORMNO","COURSECODE","COURSEINFO","TOTALFEES","AMOUNTPAID","AMOUNTDUE"};
		String data[][];
		ArrayList<registration> list8;
		try
		{
				list8=UserDataReadWriteFromFile.readDataFromFile();
				data=new String[list8.size()][6];
				int r=0;
				for(registration re:list8)
				{
					data[r][0]=re.getfn();
					data[r][1]=re.getcoursecode();
					data[r][2]=re.getcourse();
					data[r][3]="6000";
					data[r][4]=re.getpay();
					data[r][5]=String.valueOf(6000-Integer.parseInt(re.getpay()));
					r++;
				}
				Container con=getContentPane();
				con.setLayout(new BorderLayout());
				
				JTable datatable=new JTable(data,heading);
				JScrollPane jsp=new JScrollPane(datatable);
				
				con.add(new JLabel("All Registration Details"),BorderLayout.NORTH);
				con.add(jsp,BorderLayout.CENTER);
				setSize(850,300);
				setLocation(200,200);
				setVisible(true);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}


