package dcp.DCP23;

import java.util.LinkedList;
import java.util.Queue;

/*          
 * 		 x-1,y  
	
   x,y-1	x,y     x,y+1
         
   		   x+1,y
   		   
   up,left,right,down  
   		   
   		   
   		   */
           
public class DCP23 {
    
	public int ROW;
	public int COL;
	public int minSteps(boolean[][] mat,Point start,Point end){
		int rowNum[]={-1,0,0,1};
		int colNum[]={0,-1,1,0};
		 ROW=mat.length;
		 COL=mat[0].length;
		 	 
		 if(mat[start.x][start.y]  || mat[end.x][end.y] ){
			 return -1;
		 }
		 boolean[][] visited=new boolean[ROW][COL];
		 visited[start.x][start.y]=true;
		 //create q for bfs
		 Queue<QNode> q=new LinkedList<>();
		 QNode s=new QNode(start, 0);
		 q.add(s);
		 while(!q.isEmpty()){
			 QNode curr=q.peek();
			 Point pt=curr.pt;
			 //if reached destination
			 if(pt.x==end.x && end.y==pt.y){
				 return curr.dist;
			 }
			 //othewise dequeue the cell and get the adjacent cells
			 q.remove();
			 for(int i=0;i<4;i++){
				 int row=pt.x+rowNum[i];
				 int col=pt.y+colNum[i];
				 if(isValid(row,col)&& !mat[row][col] && !visited[row][col]){
					 visited[row][col]=true;
					 QNode adjCell=new QNode(new Point(row,col), curr.dist+1);
					 q.add(adjCell);
				 }
			 }
		 }
		 return -1;
	 }



	public boolean isValid(int row,int col){
		return (row >= 0) && (col >= 0) && (row < ROW) && (col<COL);
		
	}
	public static void main(String[] args) {
		boolean[][] matrix=new boolean[][]{
			{false,false,false,false},{true,true,false,true},{false,false,false,false},{false,false,false,false}
		};
		Point start=new Point(3, 0);
		Point end=new Point(0, 0);
        DCP23 dcp23 =new DCP23();
        System.out.println(dcp23.minSteps(matrix, start, end));
		
	}

}
class Point{
	int x;
	int y;
	Point(int x,int y){
		this.x=x;
		this.y=y;
	}
}

class QNode{
	Point pt;
	int dist;
	public QNode(Point pt,int dist){
		this.pt=pt;
		this.dist=dist;
	}

}