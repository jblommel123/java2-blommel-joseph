package edu.institution.asn11;

import java.lang.ProcessHandle.Info;
import java.util.List;
import java.util.Queue;

public class BSTMain {

	public static void main(String[] args) {
		BST binarySearchTree = new BST<String>();
		TreeNode<String> root = new TreeNode<String>("Test");
		TreeNode<String> one = new TreeNode<String>("Korn");
		TreeNode<String> two = new TreeNode<String>("Maggots");
		TreeNode<String> three = new TreeNode<String>("String");

		
		binarySearchTree.root = root;
		binarySearchTree.root.left = one;
		binarySearchTree.root.right = two;
		binarySearchTree.root.left.left = three;
		
		System.out.println(binarySearchTree.getRoot());
		
		List<TreeNode> returnedList = binarySearchTree.breadthFirstTraversal(binarySearchTree.root);
		
		binarySearchTree.nonRecursiveInorder(binarySearchTree.root);
		
		
		
		
		
		System.out.println("Height is " + binarySearchTree.getHeight(binarySearchTree.root));
		
		BST binarySearchTreeSecond = new BST<Integer>();
		binarySearchTreeSecond.root = new TreeNode<Integer>(1);
		binarySearchTreeSecond.root.left = new TreeNode<Integer>(2);
		binarySearchTreeSecond.root.right = new TreeNode<Integer>(3);
		
		returnedList = binarySearchTreeSecond.breadthFirstTraversal(binarySearchTreeSecond.root);
		
		for (TreeNode treeNode : returnedList) {
			System.out.println(treeNode.toString());
		}
		
		System.out.println("Height is " + binarySearchTree.getHeight(binarySearchTreeSecond.root));
		
		

	}

}
