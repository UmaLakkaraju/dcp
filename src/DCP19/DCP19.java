package DCP19;

import java.util.Scanner;

public class DCP19 {

	
	
	public static void main(String[] args) {
		Scanner scn=  new Scanner(System.in);
		
		System.out.println("No of houses:");
		int homes=scn.nextInt();
		System.out.println("No of colours:");
		int colors=scn.nextInt();
		
        int[][] arr=new int[homes][colors];
        for(int i=0;i<homes;i++){
        	for(int j=0;j<colors;j++){
        		arr[i][j]=scn.nextInt();
        	}
        }
        int[][] costdata=new int[homes][colors];
        int least=Integer.MAX_VALUE;
        int sleast=Integer.MAX_VALUE;
        
        for(int i=0;i<colors;i++){
        	costdata[0][i]=arr[0][i];
        	if(arr[0][i]<=least){
        		sleast=least;
        		least=arr[0][i];
        	}else if(costdata[0][i]<=sleast){
        		sleast=arr[0][i];
        	}
        	
        	
        }
        for(int i=1;i<homes;i++ ){
        	int nleast=Integer.MAX_VALUE;
        	int nsleast=Integer.MAX_VALUE;
        	
        	for(int j=0;j<colors;j++){
        		if(least == costdata[i-1][j]){
        			costdata[i][j]=sleast+arr[i][j];	
        		}else{
        			costdata[i][j]=least+arr[i][j];
        		}
        		if(costdata[i][j]<=nleast){
            		nsleast=nleast;
            		nleast=costdata[i][j];
            	}else if(costdata[i][j]<=nsleast){
            		nsleast=costdata[i][j];
            	}
        		}
        	least=nleast;
            sleast=nsleast;
            
        }
      
        System.out.println("min"+least);
       
	}
    
}
/*
No of houses:
4
No of colours:
3

1 5 7
5 8 4
3 2 9
1 2 4

minimum cost8

**/


