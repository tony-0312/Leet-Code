/*
deepest leaves.

Recall that:

The node of a binary tree is a leaf if and only if it has no children
The depth of the root of the tree is 0. if the depth of a node is d, the depth of each of its children is d + 1.
The lowest common ancestor of a set S of nodes, is the node A with the largest depth such that every node in S 
is in the subtree with root A.
 
Example 1:
Input: root = [3,5,1,6,2,0,8,null,null,7,4]
Output: [2,7,4]
Explanation: We return the node with value 2, colored in yellow in the diagram.
The nodes coloured in blue are the deepest leaf-nodes of the tree.
Note that nodes 6, 0, and 8 are also leaf nodes, but the depth of them is 2, but the depth of nodes 7 and 4 is 3.

Example 2:
Input: root = [1]
Output: [1]
Explanation: The root is the deepest node in the tree, and it's the lca of itself.

Example 3:
Input: root = [0,1,3,null,2]
Output: [2]
Explanation: The deepest leaf node in the tree is 2, the lca of one node is itself.
*/

import java.util.Queue;
import java.util.LinkedList;

class LCA{
	static Node root;
	
	static void insert(Integer[] values){
		if(values.length == 0) return;
		
		root = new Node(values[0]);
		Queue<Node> queue = new LinkedList<>();
		int i = 1;
		queue.add(root);
		while (i < values.length){
			Node curr = queue.poll();
			if(curr == null) continue;
			
			if(i < values.length){
				Integer val = values[i++];
				if(val != null){
					curr.left = new Node(val);
					queue.add(curr.left);
				}
				
			}
			
			if(i < values.length){
				Integer val = values[i++];
				if(val != null){
					curr.right = new Node(val);
					queue.add(curr.right);
				}
			}
		}
		
	}
	
	static void inorder(Node node){
		if(node != null){
			inorder(node.left);
			System.out.print(node.value + " ");
			inorder(node.right);
		}
	}
	
	static Node findLCA(Node root){
		return dfs(root).getKey();
	}
	
	static Pair<Node, Integer> dfs(Node node){
		if(node == null){
			return new Pair<>(null, 0);
		}
		
		Pair<Node, Integer> leftPair = dfs(node.left);
		Pair<Node, Integer> rightPair = dfs(node.right);
		
		int leftDepth = leftPair.getValue(), rightDepth = rightPair.getValue();
		
		if(leftDepth > rightDepth){
			return new Pair<>(leftPair.getKey(), leftDepth + 1);
		}
		
		if(leftDepth < rightDepth){
			return new Pair<>(rightPair.getKey(), rightDepth + 1);
		}

		return new Pair<>(node, leftDepth + 1); 
	}
	
	public static void main(String[] args){
		Integer[] values = {3,5,1,6,2,0,8,null,null,7,4};
		insert(values);
		//inorder(root);
		Node ans = findLCA(root);
		inorder(ans);
	}
}