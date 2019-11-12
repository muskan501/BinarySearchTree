package BST;

public class BinarySearchTree {
	class Node
	{
		int data;
		Node left,right;
		
		public Node(int data)
		{
			this.data=data;
			left=right=null;
		}
	}
	static Node root; 
    BinarySearchTree() {  
        root = null;  
    } 
    
    void insert(int data)
    { 
        root = insert1(root, data); 
     } 
    
    public Node insert1(Node root,int data)
    {
    	 if (root == null) { 
             root = new Node(data); 
             return root; 
         } 
         if (data < root.data) 
             root.left = insert1(root.left, data); 
         else if (data > root.data) 
             root.right = insert1(root.right, data); 
   
         return root; 
    }
    void inorder()
    {
    	inorder1(root);
    }
   public void inorder1(Node root)
    {
	   if (root != null)
	   { 
           inorder1(root.left); 
           System.out.println(root.data); 
           inorder1(root.right); 
       } 
    }
  public static int height() {
	  return height1(root);
  }
  
  static int height1(Node root)
  {
	  if(root==null)
	  {
		  return 0;
	  }
	  else
	  {
		  int l=height1(root.left);
		  int r=height1(root.right);
	  
	  if(l>r)
	  {
		  return (l+1);
	  }
	  else
	  {
		  return (r+1);
		  
	  }
	  }
  }
  public static void printLevelOrder()
  {
	  printLevelOrder1(root); 
  }
  public static void printLevelOrder1(Node root) 
  { 
      int h = height(); 
      int i; 
      for (i=1; i<=h; i++) 
      { 
          printGivenLevel(root, i); 
          System.out.println(); 
      } 
  } 
  /* Print nodes at a given level */
  public static void printGivenLevel(Node root, int level) 
  { 
      if (root == null) 
          return; 
      if (level == 1) 
          System.out.print(root.data+" "); 
      else if (level > 1) 
      { 
          printGivenLevel(root.left, level-1); 
          printGivenLevel(root.right, level-1); 
      } 
  } 
  public static void printLevelOrderReverse()
  {
	  reverseLevelOrder(root); 
  }
  public static void reverseLevelOrder(Node root)  
  { 
      int h = height(); 
      int i; 
      for (i = h; i >= 1; i--)  
      
      { 
          printGivenLevel(root, i); 
          System.out.println();
      } 
  } 
  public static void printEvenLevelOrder()
  {
	  evenLevelOrder(root); 
  }
  public static void evenLevelOrder(Node root)  
  { 
      int h = height(); 
      int i; 
      for (i=2; i<=h; i+=2) 
      { 
          printGivenLevelEven(root, i); 
          System.out.println(); 
      } 
  } 
  public static void printGivenLevelEven(Node root, int level) 
  { 
      if (root == null) 
          return; 
      if (level == 1) 
          System.out.print(root.data+" "); 
      else if (level > 1) 
      { 
          printGivenLevelEven(root.right, level-1); 
          printGivenLevelEven(root.left, level-1); 
      } 
  }
  public static void printSpiral()
  {
	  spiralOrder(root); 
  }
  public static void spiralOrder(Node root)  
  { 
      int h = height(); 
      int i; 
      for (i=1; i<=h; i++) 
      { 
    	  if(i%2==0)
    	  {
    		  printGivenLevel(root, i);
         
    	  }
    	  else
    	  {
    		  printGivenLevelEven(root, i); 
    	  }
          System.out.println(); 
      } 
  } 
 
    public static void main(String args[])
    {
    	BinarySearchTree t = new BinarySearchTree(); 
		t.insert(50); 
        t.insert(30); 
        t.insert(20); 
        t.insert(40); 
        t.insert(70); 
        t.insert(60); 
        t.insert(80); 
        t.insert(10);
        t.insert(25);
        t.inorder();
        System.out.println(t.height());
        t.printLevelOrder();
        t.printLevelOrderReverse();
        t.printEvenLevelOrder();
        t.printSpiral();
        
        
    }

}
