// Print out DNS Record for an Internet Address

import java.net.InetAddress;
import java.net.UnknownHostException;

public class DNSLookup
{
    public static void main(String args[])
    {
        // explain what program does and how to use it 
        if (args.length != 1)
        {
            System.err.println("Enter command line argument asa a Internet Address or URL");
            System.exit(-1);
        }
        try
        {
            InetAddress inetAddress;   
         

            if (Character.isDigit(args[0].charAt(0)))    // if first character is a digit then assume is an ip address
            {  
                byte[] b = new byte[4];
                String[] bytes = args[0].split("[.]"); 
                for (int i = 0; i < bytes.length; i++)
                {
                    b[i] = new Integer(bytes[i]).byteValue();// convert address from string representation to byte array
                }
                
                inetAddress = InetAddress.getByAddress(b); // get Internet Address of this host address
            }
            else
            {   
                inetAddress = InetAddress.getByName(args[0]); // get host name of this Internet Address
            }
            
            System.out.println(inetAddress.getHostName() + "/" + inetAddress.getHostAddress()); // show the Internet Address as name/address
                      
        }
        catch (UnknownHostException exception)
        {
            System.err.println("ERROR: No Internet Address for '" + args[0] + "'");
        }
     
    }
}
