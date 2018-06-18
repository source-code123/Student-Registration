package project;
import java.util.ArrayList;
public class update 
{
	public static void updateinfodata(int index,String fname,String idno,String movie)
	{
		ArrayList<registration> list1;
		
		list1=UserDataReadWriteFromFile.readDataFromFile();
		
		list1.get(index).setfname(fname);
		list1.get(index).setidno(idno);
		list1.get(index).setmovie(movie);
		UserDataReadWriteFromFile.writeDatatoFile(list1);
	}

}
