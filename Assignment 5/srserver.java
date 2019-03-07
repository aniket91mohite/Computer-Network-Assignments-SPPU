import java.net.*;
import java.io.*;
public class srserver
{
 public static void main(String args[])throws Exception
 {
 try{
  int a[]={30,40,50,60,70,80,90},n;
  ServerSocket ss=new ServerSocket(1053);
  Socket s=ss.accept();
  DataInputStream din=new DataInputStream(s.getInputStream());
  DataOutputStream dout=new DataOutputStream(s.getOutputStream());
  System.out.println("No. of frames : "+a.length);
  n=a.length;
  dout.write(n);
  for(int i=0;i<n;i++)
  {
   dout.write(a[i]);
  }
  int j=din.read();
  dout.write(a[j]);
  }
  catch(Exception e){}
 }
}
