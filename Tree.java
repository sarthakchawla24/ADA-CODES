import java.util.Scanner;
public class Tree{
	public static Node r;
	public static int flag=0;
	public static Node temp;
	static class Node{
		int data;
		Node right;
		Node left;
		public Node(int x){
			data=x;
			right= null;
			left= null;
		}
	}

	public Node insertBST(Node r, int e){
		if(r==null){
			Node n= new Node(0);
			n.data=e;
			n.left=null;
			n.right=null;
			r=n;
		}
		else if(e<=r.data){
			r.left=insertBST(r.left,e);
		}
		else{
			r.right=insertBST(r.right,e);
		}
		return r;
	}

	public Node search(Node r1,int e){
		if(r1==null){
			return r1;
		}
		else if(r1.data==e){
			return r1;
		}
		else if(e<r1.data){
			return search(r1.left,e);
		}
		else{
			return search(r1.right,e);
		}
	}

	public Node largest(Node r1){
		if(r1.right==null || r1==null){
			return r1;
		}
		else{
			return largest(r1.right);
		}
	}

	public void delete(Node r2, int e){
		Node t;
		if(r2==null){
			System.out.println("Element not found");
		}
		else if(flag!=0 && r2.right.data==e){
			r2.right=null;
		}
		else if(e<r2.data){
			temp=r2;
			delete(r2.left,e);
		}
		else if(e>r2.data){
			temp=r2;
			delete(r2.right,e);
		}
		else if(r2.left!=null && r2.right!=null){
			t= largest(r2.left);
			System.out.println("Deleted node: "+r2.data);
			r2.data= t.data;
			if(r2.left.data==r2.data){
				if(r2.left.left==null){
					r2.left=null;
				}
				else{
					r2.left=r2.left.left;
				}
			}
			else{
				flag=flag+1;
				delete(r2.left,t.data);
			}
		}
		else{
			if(r2.left==null && r2.right==null){
				System.out.println("Deleted node: "+r2.data);
				if(temp.data<r2.data){
					temp.right=null;
				}
				else{
					temp.left=null;
				}
			}
			else if(r2.left!=null){
				System.out.println("Deleted node: "+r2.data);
				r2.data=r2.left.data;
				r2.right=r2.left.right;
				r2.left=r2.left.left;
			}
			else{
				System.out.println("Deleted node: "+r2.data);
				r2.data=r2.right.data;
				r2.left=r2.right.left;
				r2.right=r2.right.right;
			}
		}
	}

	public void inorder(Node r1){
		if(r1!=null){
			inorder(r1.left);
			System.out.print(r1.data+" ");
			inorder(r1.right);
		}
	}

	public void preorder(Node r1){
		if(r1!=null){
			System.out.print(r1.data+" ");
			preorder(r1.left);
			preorder(r1.right);
		}
	}

	public void postorder(Node r1){
		if(r1!=null){
			postorder(r1.left);
			postorder(r1.right);
			System.out.print(r1.data+" ");
		}
	}


	public static void main(String[] args){
		Scanner sc= new Scanner(System.in);
		Tree tr= new Tree();
		System.out.println("Enter elements for tree(separated by comma): ");
		String j= sc.next();
		String[] arr;
		arr= j.split(",");
		Node r2=r;
		for(int i=0;i<arr.length;i++){
			int num= Integer.parseInt(arr[i]);
			Node r1=tr.insertBST(r2,num);
			r2=r1;
			r=r1;
		}
		int end=0;
		int g;
		while(end!=1){
			System.out.println();
			System.out.println("Enter your choice: ");
			System.out.println("1-Insert in BST ");
			System.out.println("2-Search an element ");
			System.out.println("3-Delete an element ");
			System.out.println("4-Inorder of BST ");
			System.out.println("5-Preorder of BST ");
			System.out.println("6-Postorder of BST ");
			System.out.println("7-Exit ");
			int v= sc.nextInt();
			switch(v){
				case 1:			
					System.out.println();
					System.out.println("Enter element to be inserted: ");
					int numb= sc.nextInt();
					tr.insertBST(r,numb);
					System.out.println();
					System.out.println("Press 1 to exit and 0 to continue: ");
					g=sc.nextInt();
					if(g==1){
						end=1;
					}
					break;
					
				case 2:
					System.out.println();
					System.out.println("Enter element to be searched: ");
					int numb1=sc.nextInt();
					Node t1=tr.search(r,numb1);
					if(t1==null){
						System.out.println("Element not found");
					}
					else{
						System.out.println("Element found");
					}
					System.out.println();
					System.out.println("Press 1 to exit and 0 to continue: ");
					g=sc.nextInt();
					if(g==1){
						end=1;
					}
					break;
					
				case 3:
					System.out.println();
					System.out.println("Enter element to be deleted: ");
					int numb2=sc.nextInt();
					tr.delete(r,numb2);
					System.out.println();
					System.out.println("Press 1 to exit and 0 to continue: ");
					g=sc.nextInt();
					if(g==1){
						end=1;
					}
					break;

				case 4:
					System.out.println("Inorder:");
					tr.inorder(r);
					System.out.println();
					System.out.println("Press 1 to exit and 0 to continue: ");
					g=sc.nextInt();
					if(g==1){
						end=1;
					}
					break;

				case 5:
					System.out.println("Preorder:");
					tr.preorder(r);
					System.out.println();
					System.out.println("Press 1 to exit and 0 to continue: ");
					g=sc.nextInt();
					if(g==1){
						end=1;
					}
					break;
				
				case 6:
					System.out.println("Postorder:");
					tr.postorder(r);
					System.out.println();
					System.out.println("Press 1 to exit and 0 to continue: ");
					g=sc.nextInt();
					if(g==1){
						end=1;
					}
					break;

				case 7:
					System.exit(0);

				default:
					System.out.println("Invalid choice");
				}
			}
	}
}