package project;
 
import java.io.Serializable;
public class registration implements Serializable
{
	private String fname;
	private String lname;
	private String idno;
	private String emailid;
	private String mobno;
	private String ad;
	private String city;
	private String movie;
	private String gender;
//	private String dob;
	private String ins;
	private String date;
	private String time;
	public registration(String fname,String lname,String idno,String emailid,String mobno,String ad,String city,String movie,
	 String gender,String ins,String date,String time )
	{
		super();
		this.fname=fname;
		this.lname=lname;
		this.idno=idno;
		this.emailid=emailid;
		this.mobno=mobno;
		this.ad=ad;
		this.city=city;
		this.movie=movie;
		this.gender=gender;
//		this.dob=dob;
		this.ins=ins;
		this.date=date;
		this.time=time;
	}
	public registration()
	{
		
	}
	public String getfname()
	{
		return fname;
	}
	public void setfname(String fname)
	{
		this.fname=fname;
	}
	public String getlname()
	{
		return lname;
	}
	public void setlname(String lname)
	{
		this.lname=lname;
	}
	public String getidno()
	{
		return idno;
	}
	public void setidno(String idno)
	{
		this.idno=idno;
	}
	public String getemailid()
	{
		return emailid;
	}
	public void setemailid(String emailid)
	{
		this.emailid=emailid;
	}
	public String getmobno()
	{
		return mobno;
	}
	public void setmobno(String mobno)
	{
		this.mobno=mobno;
	}
	public String getad()
	{
		return ad;
	}
	public void setad(String ad)
	{
		this.ad=ad;
	}
	public String getcity()
	{
		return city;
	}
	public void setcity(String city)
	{
		this.city=city;
	}
	public String getmovie()
	{
		return movie;
	}
	public void setmovie(String movie)
	{
		this.movie=movie;
	}
	public String getgender()
	{
		return gender;
	}
	public void setgender(String gender)
	{
		this.gender=gender;
	}
/*	public String getDob()
	{
		return dob;
	}
	public void setDob(String dob)
	{
		this.dob=dob;
	}*/
	public String getins()
	{
		return ins;
	}
	public void setins(String ins)
	{
		this.ins=ins;
	}
	public String getdate()
	{
		return date;
	}
	public void setdate(String date)
	{
		this.date=date;
	}
	public String gettime()
	{
		return time;
	}
	public void settime(String time)
	{
		this.time=time;
	}
}
