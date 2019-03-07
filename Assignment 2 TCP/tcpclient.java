import java.net.*;
import java.io.*;
public class tcpclient
{
 public static void main(String args[])throws Exception
 {
  Socket s=new Socket("localhost",1053);//instead of local host, for peer to peer  write server's IP address
  DataInputStream din=new DataInputStream(s.getInputStream());
  DataOutputStream dout=new DataOutputStream(s.getOutputStream());
  BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
  String str1=" ",str2=" ";
  while(!str1.equals("Bye"))
  {
	str1=br.readLine();
	dout.writeUTF(str1);
	str2=din.readUTF();
	System.out.println("Server says : "+str2);
  }
  s.close();
  dout.close();
 }
}

