import java.io.*;
import java.net.*;
import java.nio.charset.*;
public class udp_multi_ser
{
public static void main(String args[])throws Exception
{
DatagramSocket s=new DatagramSocket(1090);
InetAddress addr=InetAddress.getByName("10.12.0.254");//IP address of client1
InetAddress addr=InetAddress.getByName("10.12.0.234");//IP address of client2
InetAddress addr=InetAddress.getByName("10.12.0.224");//IP address of client3
BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
String str1=" ";
while(!str1.equals("Bye"))
{
byte[] buf=new byte[20];
byte[] buf1=new byte[20];
DatagramPacket p2=new DatagramPacket(buf1,buf1.length);
s.receive(p2);
buf1=p2.getData();
String str2=new String(buf1,StandardCharsets.UTF_8);
System.out.println("Client says : " +str2);

str1=br.readLine();
buf=str1.getBytes();
DatagramPacket p1=new DatagramPacket(buf,buf.length,addr,1080);
s.send(p1);//for client 1
DatagramPacket p3=new DatagramPacket(buf,buf.length,addr,1080);
s.send(p3);//for client 2
DatagramPacket p4=new DatagramPacket(buf,buf.length,addr,1080);
s.send(p4);//for client 3
}
}
}
