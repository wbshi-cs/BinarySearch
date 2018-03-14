
public class BinarySearchTree<Value> {
	//二叉搜索树是不完全的二叉树，每一个节点有键值对，左孩子的键永远小于节点的键，右孩子的键永远小于此节点的键
	//本算法的核心是：对于新插入的节点，首先和根节点的键比较，若小于，则再与左孩子比较，否则与右孩子比较，如此递归，直到找到一个空的节点存储此新的节点
	//算法优点：查找、删除、插入都是log(n)
	class Node{
		Comparable key;
		Value value;
		Node left;
		Node right;	
		//构造节点
		public Node(Comparable key,Value value){
			this.key=key;
			this.value=value;
			this.left=this.right=null;
		}
	}
	private Node root;
	int count;
	public int size(){
		return count;
	}
	public boolean isEmpty(){
		return count==0;
	}
	public void insert(Comparable key,Value value){
		root=insert(root,key,value);//插入节点
	}
	public boolean contain(Comparable key){
		return contain(root,key);
	}
	public BinarySearchTree<Value>.Node search(Comparable key){
		return search(root,key);
	}
	//前序遍历   先访问自己，然后是左孩子，接着右孩子
	public void preOrder(){
		perOrder(root);
	}
	private void perOrder(BinarySearchTree<Value>.Node root2) {
		// TODO Auto-generated method stub
		if (root2!=null){
			System.out.println(root2.key+"   "+root2.value);
			perOrder(root2.left);
			perOrder(root2.right);
			}
	}
	//中序遍历   先访问左孩子，再访问自己，最后右孩子     打印结果是根据key从小到大进行排列的
	public void inOrder(){
		inOrder(root);
	}
	private void inOrder(BinarySearchTree<Value>.Node root2) {
		// TODO Auto-generated method stub
		if (root2!=null){
			inOrder(root2.left);
			System.out.println(root2.key+"   "+root2.value);
			inOrder(root2.right);
			}
	}
	//后序遍历    先是左孩子，接着右孩子，最后自己    作用：用于释放左右孩子
	public void postOrde(){
		postOrder(root);
	}
	private void postOrder(BinarySearchTree<Value>.Node root2) {
		// TODO Auto-generated method stub
		if(root2!=null){
			postOrder(root2.left);
			postOrder(root2.right);
			System.out.println(root2.key+"   "+root2.value);
		}
	}
	 
	private BinarySearchTree<Value>.Node search(BinarySearchTree<Value>.Node root, Comparable key) {
		// TODO Auto-generated method stub
		if(root==null) return null;
		if(root.key.compareTo(key)==0) return root;
		else if(key.compareTo(root.key)<0) return search(root.left,key);
		else return search(root.right,key);
	}
	private boolean contain(Node root,Comparable key){
		if(root==null) return false;
		if(root.key.compareTo(key)==0) return true;
		else if(root.key.compareTo(key)>0){
			return contain(root.left,key);
		}else{
			return contain(root.right,key);
		}
		
	}
	private BinarySearchTree<Value>.Node insert(BinarySearchTree<Value>.Node root2, Comparable key, Value value) {
		// TODO Auto-generated method stub
		if(root2==null){ 
			count++;
			return new Node(key, value);
		}
		if(key.compareTo(root2.key)==0) root2.value=value; //若键相同，则更新值
		else if (key.compareTo(root2.key)<0) root2.left=insert(root2.left,key,value);//键小于节点的键，放置左孩子
		else root2.right=insert(root2.right,key,value);//键大于节点的键，放置右孩子
		return root2;//返回根节点
	}

}
