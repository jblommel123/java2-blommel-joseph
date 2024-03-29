package edu.institution.asn11;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import org.junit.jupiter.params.shadow.com.univocity.parsers.common.processor.BeanWriterProcessor;
import org.junit.platform.engine.support.hierarchical.Node;


public class BST<E extends Comparable<E>> {

	protected TreeNode<E> root;
	protected int size = 0;
	protected int height = 0;
	public BST() { }
	
	public BST(E[] objects) {
		for (int i=0; i<objects.length; i++) {
			insert(objects[i]);
		}
	}
	
	public boolean search(E e) {
		TreeNode<E> current = root;
		
		while (current != null) {
			if (e.compareTo(current.element) < 0) {
				current = current.left;
			} else if (e.compareTo(current.element) > 0) {
				current = current.right;
			} else {
				return true;
			}
		}
		
		return false;
	}
	
	public boolean insert(E e) {
		if (root == null) {
			root = createNewNode(e);
		} else {
			TreeNode<E> parent = null;
			TreeNode<E> current = root;
			while (current != null) {
				if (e.compareTo(current.element) < 0) {
					parent = current;
					current = current.left;
				} else if (e.compareTo(current.element) > 0) {
					parent = current;
					current = current.right;
				} else {
					return false;
				}
			}
				
			if (e.compareTo(parent.element) < 0) {
				parent.left = createNewNode(e);
			} else {
				parent.right = createNewNode(e);
			}
		}
		
		size++;
		return true;
	}
	
	protected TreeNode<E> createNewNode(E e) {
		return new TreeNode<E>(e);
	}
	
	public void inorder() {
		inorder(root);
	}
	
	protected void inorder(TreeNode<E> root) {
		if (root == null) return;
		inorder(root.left);
		System.out.print(root.element + " ");
		inorder(root.right);
	}
	
	public void postorder() {
		postorder(root);
	}
	
	protected void postorder(TreeNode<E> root) {
		if (root == null) return;
		postorder(root.left);
		postorder(root.right);
		System.out.print(root.element + " ");
	}
	
	public void preorder() {
		preorder(root);
	}
	
	protected void preorder(TreeNode<E> root) {
		if (root == null) return;
		System.out.print(root.element + " ");
		preorder(root.left);
		preorder(root.right);
	}
	
	public int getSize() {
		return size;
	}
	
	public TreeNode<E> getRoot() {
		return root;
	}
	
	public ArrayList<TreeNode<E>> path(E e) {
		ArrayList<TreeNode<E>> list = new ArrayList<>();
		TreeNode<E> current = root;
		
		while (current != null) {
			list.add(current);
			if (e.compareTo(current.element) < 0) {
				current = current.left;
			} else if (e.compareTo(current.element) > 0) {
				current = current.right;
			} else {
				break;
			}
		}
		
		return list;
	}
	
	public boolean delete(E e) {
		TreeNode<E> parent = null;
		TreeNode<E> current = root;
		
		while (current != null) {
			if (e.compareTo(current.element) < 0) {
				parent = current;
				current = current.left;
			} else if (e.compareTo(current.element)> 0) {
				parent = current;
				current = current.right;
			} else {
				break;
			}
		}
		
		if (current == null) {
			return false;
		}
		
		if (current.left == null) {
			if (parent == null) {
				root = current.right;
			} else {
				if (e.compareTo(parent.element) < 0) {
					parent.left = current.right;
				} else {
					parent.right = current.right;
				}
			}
		} else {
			TreeNode<E> parentOfRightMost = current;
			TreeNode<E> rightMost = current.left;
			
			while (rightMost.right != null) {
				parentOfRightMost = rightMost;
				rightMost = rightMost.right;
			}
			
			current.element = rightMost.element;
			
			if (parentOfRightMost.right == rightMost) {
				parentOfRightMost.right = rightMost.left;
			} else {
				parentOfRightMost.left = rightMost.left;
			}
		}
		
		size--;
		return true;
	}
	
	public Iterator<E> iterator() {
		return new InorderIterator();
	}
	
	public void clear() {
		root = null;
		size = 0;
	}
	
	
	private class InorderIterator implements Iterator<E> {
		
		private ArrayList<E> list = new ArrayList<>();
		private int current = 0;
		
		public InorderIterator() {
			inorder();
		}
		
		private void inorder() {
			inorder(root);
		}
		
		private void inorder(TreeNode<E> root) {
			if (root == null) return;
			inorder(root.left);
			list.add(root.element);
			inorder(root.right);
		}
		
		public boolean hasNext() {
			return current < list.size();
		}
		
		public E next() {
			return list.get(current++);
		}
		
		public void remove() {
			delete(list.get(current));
			list.clear();
			inorder();
		}
	}
	
	/**
	* Traverses the nodes using the breadth-first traversal algorithm and
	* and returns a list of elements in the correct order.
	* @return the elements in the order that reflects a breadth-first traversal.
	* https://stackoverflow.com/questions/5262308/how-do-implement-a-breadth-first-traversal/5262484
	*/
	public List<E> breadthFirstTraversal(TreeNode<E> root) {
		
		if(root == null) {
			return null;
		}
		
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		Queue<TreeNode> queueToReturn = new LinkedList<TreeNode>();
		TreeNode<E> temp = root;
		queue.add(temp);
		queueToReturn.add(temp);
		int level = 0;
		
		while(!queue.isEmpty()) {
			
			TreeNode refNode = queue.remove();
			System.out.println(refNode.toString() + " - Node");
			
			if(refNode.left != null) {
				queue.add(refNode.left);
				queueToReturn.add(refNode.left);
				level++;
			}
			
			if(refNode.right != null) {
				queue.add(refNode.right);
				queueToReturn.add(refNode.right);
				
			}
			
		}
		
		return (List<E>) queueToReturn;
		
	}
	/**
	* Returns the number of edges between the tree's root and its furthest leaf.
	* @return the height.
	* https://www.geeksforgeeks.org/write-a-c-program-to-find-the-maximum-depth-or-height-of-a-tree/
	*/
	public int getHeight(TreeNode<E> node) {
		if(node == null) {
			return -1;
		}
		else {
			int ldepth = getHeight(node.left);
			int rdepth = getHeight(node.right);
			
			if(ldepth > rdepth) {
				return (ldepth+1);
			}
			else {
				return (rdepth + 1);
			}
		}
	}
	//https://www.geeksforgeeks.org/inorder-tree-traversal-without-recursion/
	public void nonRecursiveInorder(TreeNode<E> root) {
		
		if (root == null) {
			return;
		}
		
		Stack<TreeNode> nodes = new Stack<TreeNode>();
		TreeNode currentNode = root;
		
		while (currentNode != null || nodes.size() > 0) {
			while (currentNode != null) {
				nodes.push(currentNode);
				currentNode = currentNode.left;
			}
			
			currentNode = nodes.pop();
			
			System.out.println(currentNode.toString() + " - In non recursive order");
			
			currentNode = currentNode.right;
		}
		
		
	}
	
	
}
