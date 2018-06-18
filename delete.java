package project;

import java.util.ArrayList;

public class delete 
{
	public static void deleteinfodata(int index)
	{
		ArrayList<registration> list3;
		list3=UserDataReadWriteFromFile.readDataFromFile();
		list3.remove(index);
		UserDataReadWriteFromFile.writeDatatoFile(list3);
	}
}

