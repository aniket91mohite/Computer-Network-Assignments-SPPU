import java.io.*;
import java.net.*;
import java.nio.charset.*;
public class udpclient
{
public static void main(String args[])throws Exception
{
DatagramSocket s=new DatagramSocket(1080);//port no. of host machine
InetAddress addr=InetAddress.getLocalHost();// "InetAddress addr=InetAddress.getByName("IP address of server machine") 
BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
String str1=" ";

while(!str1.equals("Bye"))
{
byte[] buf=new byte[20];
byte[] buf1=new byte[20];
str1=br.readLine();
buf=str1.getBytes();
DatagramPacket p1=new DatagramPacket(buf,buf.length,addr,1090);//port no. of server machine
s.send(p1);

DatagramPacket p2=new DatagramPacket(buf1,buf1.length);
s.receive(p2);

buf1=p2.getData(); 
String str2=new String(buf1,StandardCharsets.UTF_8);
System.out.println("Server says : " +str2);
}
}
}
