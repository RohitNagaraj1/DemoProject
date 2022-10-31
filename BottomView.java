
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

class Pair
{
    public Node node;
    public int index;
    public Pair(Node node, int index)
    {
        this.node = node;
        this.index = index;
    }
}

public class BottomView 
{
    static Node root;
    public static void main(String[] args) 
    {
        root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        ArrayList < Integer > ans = bottomView(root); 
        for (Integer tmp: ans)
            System.out.println(tmp); 
    }

    static public ArrayList<Integer> bottomView(Node root) 
    {
        Map map = new TreeMap();
        Queue queue = new LinkedList();

        queue.add(new Pair(root, 0));

        while (queue.size() > 0)
        {
            Pair current = (Pair) queue.peek();
            map.put(current.index, current.node.data);
            queue.remove();

            if (current.node.left != null)
            {
                queue.add(new Pair(current.node.left, current.index-1));
            }

            if (current.node.right != null)
            {
                queue.add(new Pair(current.node.right, current.index+1));
            }
        }

        ArrayList result = new ArrayList();

        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();

        for (Map.Entry<Integer, Integer> entry : entries) 
        {
            result.add(entry.getValue());
        }

        return result;
    } 
}
