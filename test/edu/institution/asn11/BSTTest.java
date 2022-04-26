package edu.institution.asn11;

import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class BSTTest {

	@Test 
	public void TestStringBST() {
		BST binarySearchTree = new BST<String>();
		binarySearchTree.root = new TreeNode<String>("Test");
		binarySearchTree.root.left = new TreeNode<String>("Korn");
		binarySearchTree.root.right = new TreeNode<String>("Maggots");
		binarySearchTree.root.left.left = new TreeNode<String>("String");
		
		
		
		System.out.println(binarySearchTree.getRoot());
		
		List<TreeNode> returnedList = binarySearchTree.breadthFirstTraversal(binarySearchTree.root);
		
		Assert.assertEquals(2, binarySearchTree.getHeight(binarySearchTree.root));
		
		Assert.assertEquals(new TreeNode<String>("Test").toString(), binarySearchTree.root.toString());
		
		
		
	}
	
	@Test
	public void TestIntegerBST() {
		
		BST binarySearchTreeSecond = new BST<Integer>();
		binarySearchTreeSecond.root = new TreeNode<Integer>(1);
		binarySearchTreeSecond.root.left = new TreeNode<Integer>(2);
		binarySearchTreeSecond.root.right = new TreeNode<Integer>(3);
		
		List<TreeNode> returnedList = binarySearchTreeSecond.breadthFirstTraversal(binarySearchTreeSecond.root);
		
		
		Assert.assertEquals(1, binarySearchTreeSecond.getHeight(binarySearchTreeSecond.root));
		Assert.assertEquals(new TreeNode<Integer>(1).toString(), binarySearchTreeSecond.root.toString());
		
	}
	
}
