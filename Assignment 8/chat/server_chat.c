/* A simple server in the internet domain using TCP
   The port number is passed as an argument */
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <unistd.h>  //contains the declarations for functions that perform input/output operations at the operating system level
#include <sys/types.h> //unistd functions use file descriptors to reference files or devices
#include <sys/socket.h>  //defines the unsigned integral type sa_family_t,sockaddr structure that includes at least the following members.
#include <netinet/in.h>	  //for handling internet addresses

void error(const char *msg)
{
    perror(msg);
    exit(1);
}

int main(int argc,char *argv[])
{
     int sockfd, newsockfd, portno;
     socklen_t clilen;  // socklen_t is an unsigned opaque integral type of length of at least 32 bits.
     char buffer[255];
     struct sockaddr_in serv_addr, cli_addr;  //Structures for handling internet addresses
    
	 int n;
    	 if (argc < 2) 
	 {
		 fprintf(stderr,"ERROR, no port provided\n");
		 exit(1);
    	 }
    
     sockfd = socket(AF_INET,SOCK_STREAM,0); //create socket and return +ve value
    
     if (sockfd < 0) 
        error("ERROR opening socket");
    
     bzero((char *) &serv_addr, sizeof(serv_addr)); // places "sizeof()" zero-valued bytes in the area pointed to by (char *).
     
     portno = atoi(argv[1]);  //converts string data type to int data type.
    
	serv_addr.sin_family = AF_INET;
 	serv_addr.sin_addr.s_addr = INADDR_ANY;//allowed ur program to work without knowing the IP address of the machine it was running on.
 	serv_addr.sin_port = htons(portno);
   
	if (bind(sockfd, (struct sockaddr *) &serv_addr,sizeof(serv_addr)) < 0) //bind the socket for IP and Port mentioned in serv_addr
              error("ERROR on binding");

     listen(sockfd,5);  // listen for max 5 size queue through sockfd socket

     clilen = sizeof(cli_addr);

     newsockfd = accept(sockfd,(struct sockaddr *) &cli_addr,&clilen);
   
    if (newsockfd < 0) 
          error("ERROR on accept");
    
     while(1)
     {
	bzero(buffer,256);
	n = read(newsockfd,buffer,255);
        
	if (n < 0)
	 error("ERROR reading from socket");
          
           printf("Client: %s\n",buffer);
	
	bzero(buffer,256);
        fgets(buffer,255,stdin);
        n = write(newsockfd,buffer,strlen(buffer));
          
	if (n < 0) 
	error("ERROR writing to socket");
           
	int i=strncmp("Bye" , buffer, 3);
           
	if(i == 0)
               break;
     }
     close(newsockfd);
     close(sockfd);
     return 0; 
}
