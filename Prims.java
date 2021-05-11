public class Prims {
	public static void main(String[] args) 
	{  
		int graph[][] = new int[][] { { 0, 9, 5, 2, 0},
			{ 9, 0, 0, 6, 5 }, 
			{ 5, 0, 0, 4, 5 }, 
			{ 2, 6, 4, 0, 4 },
			{ 0, 5, 5, 4, 0}};  
			int key[]=new int[5];
			int parent[]=new int[5];
			for(int i=0;i<key.length;i++)
			{
				key[i]=Integer.MAX_VALUE;
			}
			key[0]=0;
			parent[0]=-1;
			boolean Mst[]=new boolean[5];
		    for(int count=1;count<5;count++)
		    {
		    	int u=-1;
		    	int min=Integer.MAX_VALUE;
		    	for(int i=0;i<5;i++)
		    	{
		    		if(!Mst[i] && key[i]<min)
		    		{
		    			min=key[i];
		    			u=i;
		    		}
		    	}
		    	Mst[u]=true;
		    	for(int j=0;j<5;j++)
		    	 {
		    		if(!Mst[j] && graph[u][j]!=0 && graph[u][j]<key[j])
		    		{
		    			key[j]=graph[u][j];
		    			parent[j]=u;
		    		}
		    	    	
		    	 }		    	
		    }
		    
		    for(int i=1;i<5;i++)
			{   
			System.out.println(i+"----"+parent[i]+"="+ key[i]);
			}
		    int mincost=0;
			for(int i=0;i<5;i++)
			{   
			mincost=mincost+key[i];
			} 	
		   	System.out.print("Minimum cost:"+ mincost);
		
			}
}