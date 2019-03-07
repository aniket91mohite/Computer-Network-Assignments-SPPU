import java.io.*;
import java.net.*;
import java.util.*;
public class tcp_multi_cli
{
public static void main(String args[]) throws Exception
{
	Socket s = new Socket("localhost",1030);
	DataInputStream din = new DataInputStream(s.getInputStream());
	DataOutputStream dout = new DataOutputStream(s.getOutputStream());
	Scanner in=new Scanner(System.in);
	System.out.print("Enter your name : ");
	String name=in.nextLine();
	dout.writeUTF(name);
	System.out.println("Server : "+din.readUTF());
	String str1="",str2="";

	while(!str1.equalsIgnoreCase("Bye"))
	{
		str1 = in.nextLine();
		dout.writeUTF(str1);
		str2 = din.readUTF();
		System.out.println("Server : "+str2);
	}
	dout.close();
	s.close();
}
}
