package project;
import java.util.ArrayList;
public class search 
{
	public static int searchrollno(String roll)
	{
		ArrayList<registration> list2;
		int f=-1;
		try
		{
			list2=UserDataReadWriteFromFile.readDataFromFile();
			for(int p=0;p<list2.size();p++)
			{
				if(roll.equalsIgnoreCase(list2.get(p).getidno()))
				{
					f=p;
					break;
				}
			}
			return(f);
		}
		catch(Exception e)
		{
			System.out.println(e);
			return(-2);
		}
	}

}