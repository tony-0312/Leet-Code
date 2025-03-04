class ConvertTree{
    static Node sortedArrayToBSTRecur(int[] nums, int start, int end){
        if(start > end) return null;

        int mid = start + (end - start)/2;
        Node node = new Node(nums[mid]);

        node.left = sortedArrayToBSTRecur(nums, start, mid-1);
        node.right = sortedArrayToBSTRecur(nums, mid + 1, end);
        
        return node;
    }
    static Node sortedArrayToBST(int[] nums){
        return sortedArrayToBSTRecur(nums, 0, nums.length-1);
    }
    static void preOrderTraversal(Node node){
        if (node == null) return;
        
        System.out.print(node.data + " ");
        preOrderTraversal(node.left);
        preOrderTraversal(node.right);
    }
    public static void main(String[] args) {
        int[] nums = {-10,-3,0,5,9};
        Node node = sortedArrayToBST(nums);
        preOrderTraversal(node);
    }
}