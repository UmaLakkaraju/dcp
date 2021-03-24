package dcp;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class DCP03 {
	StringBuilder str=new StringBuilder();
   public String serializeHelper(TreeNode root){
	   if(root==null){
		  str.append("null,"); 
	   }else{
	  str.append(String.valueOf(root.val)+",");
	   serializeHelper(root.left);
	   serializeHelper(root.right);
	   }
	
	   return str.toString();
   }
	
	
   public String serialize(TreeNode root) {
	    return serializeHelper(root);
	  }
   public TreeNode deSerializeHelper(List<String> datalist){
	   if(datalist.get(0).equals("null")){
		   datalist.remove(0);
		   return null;
	   }
	   TreeNode root=new TreeNode(Integer.valueOf(datalist.get(0)));
	   datalist.remove(0);
	   root.left=deSerializeHelper(datalist);
	   root.right=deSerializeHelper(datalist);
	   return root;
   }
   public TreeNode deserialize(String data){
		String[] dataArr=data.split(",");
		List<String> datalist = new LinkedList<String>(Arrays.asList(dataArr));
		return deSerializeHelper(datalist);
	}
	
	public static void main(String[] str){
		TreeNode root=new TreeNode(1);
		TreeNode node2=new TreeNode(2);
		TreeNode node3=new TreeNode(3);
		TreeNode node4=new TreeNode(4);
		TreeNode node5=new TreeNode(5);
		root.left=node2;
		root.right=node3;
		node3.left=node4;
		node3.right=node5;
		DCP03 dcp03=new DCP03();
		System.out.println(dcp03.serialize(root));
		String serializedString=dcp03.serialize(root);
		dcp03.deserialize(serializedString);
		}

}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
   	  val = x; 
   	}
 }
