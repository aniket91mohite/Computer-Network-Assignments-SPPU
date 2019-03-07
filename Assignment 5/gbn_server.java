import
import
import
import
java.net.*;
java.io.*;
java.util.*;
java.math.*;
public class gbn_server
{
public static void main(String args[]) throws Exception
{
ServerSocket ss=new ServerSocket(5001);
Socket s=ss.accept();
DataInputStream din=new DataInputStream(s.getInputStream());
DataOutputStream dout=new DataOutputStream(s.getOutputStream());
Scanner sc = new Scanner(System.in);
int NumOfFrames = din.read();
int ch = din.read();
if(ch==0)
{
for(int i=0;i<NumOfFrames;i++)
{
System.out.println("sending frames");
dout.write(i);
System.out.println("Waiting for ack");
try
{
Thread.sleep(2000);
}
catch(Exception e)
{}
int a = din.read();
System.out.println("ack recieved for "+a);
}
}
else
{
boolean f[]=new boolean[20];
for(int z=0;z<NumOfFrames;z++)
f[z]=false;
for(int k=0;k<NumOfFrames;k++)
{
if(k==2)
{
System.out.println("sending frame" +k);
}
else
{
System.out.println("sending frame" +k);
dout.write(k);
try
{
Thread.sleep(2000);
}
catch(Exception e)
{}
int c = din.read();
if(c!=255)
{
System.out.println("ack recieved
for "+c);
f[c]=true;
}
}
}
for(int a=0;a<NumOfFrames;a++){
if(f[a]==false)
{
dout.write(a);
try
{
Thread.sleep(2000);
}
catch(Exception e)
{}
int c = din.read();
f[c]=true;
System.out.println("ack recieved for
"+c);
}
}
}
}
}
