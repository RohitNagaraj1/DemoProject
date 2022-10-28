import java.util.LinkedList;
import java.util.Queue;

public class CompleteBinaryTree 
{
    class TreeNode
    {
        public TreeNode left;
        public TreeNode right;
        public int data;

        public TreeNode(int data)
        {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static boolean IsCBT(TreeNode node)
    {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(node);
        boolean isLeftAbsent = false;

        while (!queue.isEmpty())
        {
            TreeNode current = queue.poll();

            if (current == null)
            {
                isLeftAbsent = true;
            }
            else
            {
                if (isLeftAbsent)
                {
                    return false;
                }
                queue.add(current.left);
                queue.add(current.right);
            }
        }
        return true;
    }

    public static void main(String[] args) 
    {
        CompleteBinaryTree cbt = new CompleteBinaryTree();
        TreeNode root = cbt.new TreeNode(5);
        root.left = cbt.new TreeNode(3);
        root.right = cbt.new TreeNode(7);
        root.left.left = cbt.new TreeNode(2);
        root.left.right = cbt.new TreeNode(4);
        root.right.left = cbt.new TreeNode(6);
        //root.right.right = cbt.new TreeNode(8);

        System.out.println(IsCBT(root));
    }
}
