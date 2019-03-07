#include<stdio.h>
int main()
{
 int data[7],recv[7],i,c1,c2,c4,c;
 printf("Enter the data bits : \n");
 scanf("%d%d%d%d",&data[0],&data[1],&data[2],&data[4]);
 data[6]=data[4]^data[2]^data[0];
 data[5]=data[4]^data[1]^data[0];
 data[3]=data[2]^data[1]^data[0];
 for(i=0;i<7;i++)
  printf("%d",data[i]);
 printf("\nEnter the received dataword : \n");
 for(i=0;i<7;i++)
  scanf("%d",&recv[i]);
 c1=recv[6]^recv[4]^recv[2]^recv[0];
 c2=recv[5]^recv[4]^recv[1]^recv[0];
 c4=recv[3]^recv[2]^recv[1]^recv[0];
 c=c4*4+c2*2+c1;
 if(c==0)
  printf("\nNo Error");
 else
 {
  printf("\nError at position %d",c);
 if(recv[7-c]==0)
  recv[7-c]=1;
 else
  recv[7-c]=0;
 printf("\ncorrected code : ");
 for(i=0;i<7;i++)
   printf("%d",recv[i]);
  printf("\n");
 }
}
