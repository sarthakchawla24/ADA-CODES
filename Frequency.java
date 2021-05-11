
import java.util.*;

class Frequency
	{
		public static void main(String args[])
			{
				Scanner x = new Scanner(System.in);

				int a[]=new int[5];
				
				int i,t,j, count=0;

				for(i=0;i<5;i++)
					{
						a[i]=x.nextInt();
					}


				for( i=0 ; i<5 ; i++ )
					{
						t=a[i];
						for(j=i+1;j<5;j++)
						{
							if( a[j]==t )
							{
								count++;
							}
						}
					}	
					System.out.println("\n"+count);
			}
	}
