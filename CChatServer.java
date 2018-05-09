import java.io.*;

import java.net.*;

public class ChatServer

{

  public static void main(String[] args) throws Exception

  {

      ServerSocket sersock = new ServerSocket(5549);

      System.out.println("Ready for chatting....");

      Socket sock = sersock.accept( );

      String clientIP = sock.getInetAddress().getHostAddress();
      String clientPort = ""+sock.getLocalPort();
      String clientHN = sock.getInetAddress().getHostName();
      System.out.println("CONNECT TO : " + clientIP +" "+clientPort);
                          
                              // reading from keyboard (keyRead object)

      BufferedReader keyRead = new BufferedReader(new InputStreamReader(System.in));

	                      // sending to client (pwrite object)

      OutputStream ostream = sock.getOutputStream(); 

      PrintWriter pwrite = new PrintWriter(ostream, true);

 			 // receiving from server ( receiveRead object)

      InputStream istream = sock.getInputStream();

      BufferedReader receiveRead = new BufferedReader(new InputStreamReader(istream));

      String receiveMessage, sendMessage; 
      System.out.println("ctrl c to exit...");             

      while(true){

	sendMessage= keyRead.readLine();

	    if(sendMessage.equalsIgnoreCase("IpAdd")){
		System.out.println(clientIP);
		pwrite.println("......");
		pwrite.flush();
		}

	    else if(sendMessage.equalsIgnoreCase("HostnameClient")){
		System.out.println(clientHN);
		pwrite.println("......");
		pwrite.flush();
		}

	    else if(sendMessage.equalsIgnoreCase("Portno")){
		System.out.println(clientPort);
		pwrite.println(".......");
		pwrite.flush(); }

	    else{
			pwrite.println(sendMessage);
			pwrite.flush();
	   
             }

        if((receiveMessage = receiveRead.readLine()) != null)  

    {

           System.out.println(receiveMessage);         

        }         

      }               

    }                    

}
