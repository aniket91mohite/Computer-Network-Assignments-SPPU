import
import
import
import
java.net.*;
java.io.*;
java.util.*;
java.math.*;
public class gbn_client
{
public static void main(String args[]) throws Exception
{
Socket s=new Socket("localhost",5001);
DataInputStream din=new DataInputStream(s.getInputStream());
DataOutputStream dout=new DataOutputStream(s.getOutputStream());
Scanner sc = new Scanner(System.in);
System.out.println("ENTER NUM OF FRAMES?");
int NumOfFrames = sc.nextInt();
dout.write(NumOfFrames);
System.out.println("communication? E=0 OR E=1");
int ch = sc.nextInt();
dout.write(ch);
if(ch==0)
{
System.out.println("recieving frames");
for(int i=0;i<NumOfFrames;i++)
{
int j = din.read();
System.out.println("sending ack for "+j);
dout.write(j);
}
}
else
{
System.out.println("recieving frames");
int check = 0;
for(int k = 0;k<NumOfFrames;k++)
{
int b = din.read();
if(b==check)
{
System.out.println("sending ack for "+b);
dout.write(b);
check++;
}
else
{
k--;
dout.write(-1);
}
}
}
}
}
