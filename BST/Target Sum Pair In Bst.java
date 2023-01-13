// https://course.acciojob.com/idle?question=0dd4bc90-7cd3-45f8-bd73-81ada8c52c67
import java.util.*;

class Node {
    int data;
    Node left, right;

    public Node(int item) {
        data = item;
        left = right = null;
    }
}

class BinarySearchTree {
    Node constructBST(int[] arr, int start, int end, Node root) {
        if (start > end)
            return null;
        int mid = (start + end) / 2;

        if (root == null)
            root = new Node(arr[mid]);

        root.left = constructBST(arr, start, mid - 1, root.left);
        root.right = constructBST(arr, mid + 1, end, root.right);

        return root;

    }
}

public class Main {
    public static void main(String[] args) throws Throwable {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int target = sc.nextInt();

        Arrays.sort(arr);
        Node root = null;
        BinarySearchTree bst = new BinarySearchTree();
        root = bst.constructBST(arr, 0, n - 1, root);

        Accio A = new Accio();
        A.targetSum(root, target);

        sc.close();
    }
}

class Accio {
    public boolean findcomp (Node root, int comp){
		if(root== null) return false;
		if(comp == root.data) return true;
		if(comp < root.data) return findcomp(root.left, comp);
		else return findcomp(root.right, comp);
	}

	boolean flag = false;
	public void targetpair(Node root, Node curr, int tar){
		if(curr == null) return ;

		targetpair(root, curr.left, tar);
		int comp = tar - curr.data;
		if(comp > curr.data){
			if(findcomp(root, comp) == true){
				System.out.println(curr.data + " " + comp);
				flag = true;
			}
		}
		targetpair(root, curr.right, tar);
	}

    public void targetSum(Node root, int tar)
    {
        targetpair(root, root, tar);
		if(flag == false) System.out.print(-1);
    }

}
