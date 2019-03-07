#include<iostream>
using namespace std;
int main()
{
  int fs,i,gs,f[10],g[10],rs,temp[10],k,j,crc[10];
  cout<<"Enter size of data:";
  cin>>fs;
  cout<<"Enter data:";
  for(i=0;i<fs;i++)
    cin>>f[i];
  cout<<"Enter size of key:";
  cin>>gs;
  cout<<"Enter key:";
  for(i=0;i<gs;i++)
    cin>>g[i];
  rs=gs-1;
  for(i=fs;i<fs+rs;i++)
    f[i]=0;
  for(i=0;i<fs+rs;i++)
    temp[i]=f[i];
    
  for(i=0;i<fs;i++)
  {
    k=i;j=0;
    if(temp[k]>=g[j])
    {
      for(k=i,j=0;j<gs;j++,k++)
      {
       if((temp[k]==1&&g[j]==1)||(temp[k]==0&&g[j]==0))
       {
          temp[k]=0;
       }
       else
       {  
          temp[k]=1;
       }
      }
    }
  }
  for(j=0,k=fs;j<rs;j++,k++)
  {
    crc[j]=temp[k];
  }
  for( i=0,j=fs;i<rs;i++,j++)
	{
		f[j]=crc[i];
	}
	cout<<"sender code is : ";
	for(int i=0;i<fs+rs;i++)
	{
		cout<<f[i];
	}
	
	
	
	cout<<"\n";
	
	

  cout<<"Enter received data:";
  for(i=0;i<fs+rs;i++)
    cin>>f[i];
  

  
  
  for(i=0;i<fs+rs;i++)
    temp[i]=f[i];
    
  for(i=0;i<fs;i++)
  {
    k=i;j=0;
    if(temp[k]>=g[j])
    {
      for(k=i,j=0;j<gs;j++,k++)
      {
       if((temp[k]==1&&g[j]==1)||(temp[k]==0&&g[j]==0))
       {
          temp[k]=0;
       }
       else
       {  
          temp[k]=1;
       }
      }
    }
  }
  for(j=0,k=fs;j<rs;j++,k++)
  {
    crc[j]=temp[k];
  }
  int flag=0;
  for(i=0;i<rs;i++)
{
	if(crc[i]==0)
	  continue;
	else
	  cout<<"\nReceived data is having error.";
	  flag=1;
	  break;
}
if(flag==0)
cout<<"\nReceived data is correct.\n";
}
  
