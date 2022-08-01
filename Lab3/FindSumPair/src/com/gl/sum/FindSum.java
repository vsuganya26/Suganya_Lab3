package com.gl.sum;

import java.util.HashSet;
import java.util.Scanner;

public class FindSum {

	static class Node {
		int nodeData;
		Node leftNode, rightNode;
	};

	static Node newNode(int nodeData) {
		Node temp = new Node();
		temp.nodeData = nodeData;
		temp.leftNode = null;
		temp.rightNode = null;
		return temp;
	}

	public Node insert(Node root, int key) {
		if (root == null) {
			return newNode(key);
		}
		if (key < root.nodeData) {
			root.leftNode = insert(root.leftNode, key);
		} else {
			root.rightNode = insert(root.rightNode, key);
		}
		return root;
	}

	public boolean findPair(Node root, int sum, HashSet<Integer> set) {

		if (root == null) {
			return false;
		}
		if (findPair(root.leftNode, sum, set)) {
			return true;
		}
		if (set.contains(sum - root.nodeData)) {
			System.out.println("Sum =" + sum);
			System.out.println("Pair is (" + (sum - root.nodeData) + "," + root.nodeData + ")");
			return true;
		} else {
			set.add(root.nodeData);
		}
		return findPair(root.rightNode, sum, set);

	}

	public void findPairWithgivenSum(Node root, int sum) {
		HashSet<Integer> set = new HashSet<Integer>();

		if (!findPair(root, sum, set))
			System.out.println("Nodes are not found" + "\n");
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		Node root = null;
		FindSum fs = new FindSum();

		root = fs.insert(root, 40);
		root = fs.insert(root, 20);
		root = fs.insert(root, 60);
		root = fs.insert(root, 10);
		root = fs.insert(root, 30);
		root = fs.insert(root, 50);
		root = fs.insert(root, 70);

		System.out.println("Enter the sum:");
		int sum = sc.nextInt();
		fs.findPairWithgivenSum(root, sum);

	}

}
