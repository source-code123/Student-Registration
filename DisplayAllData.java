package project;

import java.awt.BorderLayout;
import java.awt.Container;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class DisplayAllData extends JFrame 
{
	public DisplayAllData()
	{
		super("Display All");
		String heading[]={"FNAME","LNAME","EmailId","Idno","Mobno","Address","City","Movie","Gender","Interests","Reg Date","Reg Time"};
		String data[][];
		ArrayList<registration> list;
		try
		{
				list=UserDataReadWriteFromFile.readDataFromFile();
				data=new String[list.size()][12];
				int r=0;
				for(registration re:list)
				{
					data[r][0]=re.getfname();
					data[r][1]=re.getlname();
					data[r][2]=re.getemailid();
					data[r][3]=re.getidno();
					data[r][4]=re.getmobno();
					data[r][5]=re.getad();
					data[r][6]=re.getcity();
					data[r][7]=re.getmovie();
					data[r][8]=re.getgender();
					data[r][9]=re.getins();
					data[r][10]=re.getdate();
					data[r][11]=re.gettime();
					r++;
				}
				Container con=getContentPane();
				con.setLayout(new BorderLayout());
				
				JTable datatable=new JTable(data,heading);
				JScrollPane jsp=new JScrollPane(datatable);
				
				con.add(new JLabel("All Registration Details"),BorderLayout.NORTH);
				con.add(jsp,BorderLayout.CENTER);
				setSize(1366,850);
				setLocation(200,200);
				setVisible(true);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}

