import java.io.*;
import java.net.*;
import java.util.*;
public class tcp_multi_ser
{
	public static void main(String args[])
	{
		try
		{
			ServerSocket ss = new ServerSocket(1030);
			Socket s[]=new Socket[100];
			for(int i=0;i<100;i++)
			{
				s[i]=ss.accept();
				Thread t=new Multiple(s[i]);
				t.start();
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}

class Multiple extends Thread
{
	private Socket s;
	public Multiple(Socket i)
	{
		s=i;
	}
	public void run()
	{
		try
		{
		DataInputStream din = new DataInputStream(s.getInputStream());
		DataOutputStream dout = new DataOutputStream(s.getOutputStream());
		Scanner in=new Scanner(System.in);
		String name=din.readUTF();
		dout.writeUTF("hello "+name);
		String str1="",str2="";

		while(!str2.equalsIgnoreCase("Bye"))
			{
				str2 = din.readUTF();
				System.out.println(name+" : "+str2);
				str1 = in.nextLine();
				dout.writeUTF(str1);
			}
			dout.close();
			s.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}
