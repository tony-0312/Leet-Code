/*

You are given an array of integers nums and the head of a linked list. Return the head of the modified linked list after 
removing all nodes from the linked list that have a value that exists in nums.

Example 1:
Input: nums = [1,2,3], head = [1,2,3,4,5]

Output: [4,5]

Explanation:
Remove the nodes with values 1, 2, and 3.

Example 2:
Input: nums = [1], head = [1,2,1,2,1,2]

Output: [2,2,2]

Explanation:
Remove the nodes with value 1.

Example 3:
Input: nums = [5], head = [1,2,3,4]

Output: [1,2,3,4]

Explanation:
No node has value 5.

Constraints:
1 <= nums.length <= 105
1 <= nums[i] <= 105
All elements in nums are unique.
The number of nodes in the given list is in the range [1, 105].
1 <= Node.val <= 105
The input is generated such that there is at least one node in the linked list that has a value not present in nums.

*/

import java.util.HashSet;
import java.util.Set;

class ListNode{
	
	int val;
	ListNode next;
	ListNode head;
	
	ListNode(){
		head = null;
	}
	
	ListNode(int val){
		this.val = val;
		this.next = null;
	}
	
	
	public void insertNode(int val){
		
		ListNode newNode = new ListNode(val);
		
		if(head == null){
			head = newNode;
			return;
		}
		
		ListNode temp = head;
		while(temp.next != null){
			
			temp = temp.next;
			
		}
		
		temp.next = newNode;
		
	}
	
	public void display(ListNode temp){
		
		
		
		while(temp != null){
			
			System.out.println(temp.val);
			temp = temp.next;
			
		}
		
	}
	
	public ListNode modifiedList(int[] nums, ListNode head) {
        
		if(head == null){
            return null;
        }
		
		Set<Integer> mpp = new HashSet<>();
		
		for(int num : nums){
			mpp.add(num);
		}
		
		while(head != null && mpp.contains(head.val)){
			head = head.next;
		}
		
		if(head == null){
            return null;
        }
		
		ListNode curr = head;
		
		while(curr.next != null){
			
			if(mpp.contains(curr.next.val)){
				curr.next = curr.next.next;
			}
			else{
				curr = curr.next;
			}
		}
		
		return head;
		
    }
	
}

public class Delete{
	
	public static void main(String[] args){
		
		ListNode obj = new ListNode();
		int[] heads = {1,2,3,4,5};
		for(int num : heads){
			
			obj.insertNode(num);
			
		}
		int[] nums = {1,2,3};
		ListNode newList = obj.modifiedList(nums, obj.head);
		obj.display(newList);
		
	}
	
}