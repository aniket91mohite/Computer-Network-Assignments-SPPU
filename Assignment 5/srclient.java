import java.net.*;
import java.io.*;
public class srclient
{
 public static void main(String args[])throws Exception
 {
 try{
  int p,n; 
  Socket s=new Socket("localhost",1053);
  DataInputStream din=new DataInputStream(s.getInputStream());
  DataOutputStream dout=new DataOutputStream(s.getOutputStream());
  int v[]= new int [20];
  System.out.println("Received frame");
  p=din.read();
  for(int i=0;i<p;i++)
  {
   v[i]=din.read();  
  }
  v[5]=-1;
  for(int i=0;i<p;i++)
  {
   System.out.println("frame "+v[i]);
  }
  for(int i=0;i<p;i++)
  {
   if(v[i]==-1)
   {
    System.out.println("Retransmit "+v[i]);
    n=i;
    dout.write(n);
   }
  }
  n=din.read();
  System.out.println("Retransmit "+v[n]);
  }
  catch(Exception e){}
 }
}
