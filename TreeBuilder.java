import java.util.*;

class Node 
{
    int data;
    Node left, right; 
    Node(int data) 
    {
        this.data = data; 
    }
}

public class TreeBuilder
{
    public static void main(String[] args) 
    {
        int[] inorder= {11, 62, 18, 7};
        int[] preorder= {11, 62, 7, 18};
        Node root = buildTree(inorder, preorder, 4); 
        postOrder(root);
    }

    public static void postOrder(Node root) 
    { 
        if (root == null)
            return;
        postOrder(root.left); 
        postOrder(root.right); 
        System.out.print(root.data + " ");
    }

    public static Node buildTree(int inorder[], int preorder[], int n)
    {
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < n; i++)
        {
            map.put(inorder[i], i);
        }

        return Helper(0, n-1, preorder, map);
    }

    public static int preIndex = 0;

    public static Node Helper(int left, int right, int[] preOrder, Map<Integer, Integer> map)
    {
        if (left > right)
            return null;

        int rootvalue = preOrder[preIndex++];
        Node root = new Node(rootvalue);

        int index = map.get(rootvalue);
        root.left = Helper(left, index-1, preOrder, map);
        root.right = Helper(index+1, right, preOrder, map);

        return root;
    }

}