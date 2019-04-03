
//JiuZhang Solution - abandoned
public String serialize(TreeNode root) {
	if (root == null) {
		return "{}";
	}

	ArrayList<TreeNode> queue = new ArrayList<TreeNode>();
	queue.add(root);

	for (int i = 0; i < queue.size(); i++) {
		TreeNode node = queue.get(i);
		if (node == null) {
			continue;
		}
		queue.add(node.left);
		queue.add(node.right);
	}

	//delete all the null node at the last line
	while (queue.get(queue.size() - 1) == null) {
		queue.remove(queue.size() - 1);
	}

	StringBuilder sb = new StringBuilder();
	ab.append("{");
	sb.append(queue.get(0).val);
	for (int i = 1; i < queue.size(); i++) {
		if (queue.get(i) == null) {
			sb.append(",#");
		} else {
			sb.append(",");
			sb.append(queue.get(i).val);
		}
	}
	sb.append("}");
	return sb.toString();
}

public TreeNode deserialize(String data) {
	if (data.equals("{}")) {
		return null;
	}
	String[] vals = data.substring(1, data.length() - 1).split(",");
	//why there is a queue? 
	ArrayList<TreeNode> queue = new ArrayList<TreeNode>();
	TreeNode root = new TreeNode(Integer.parseInt(vals[i]));
	int index = 0;
	boolean isLeftChild = true;
	for (int i = 1; i < vals.length; i++) {
		if (!vals[i].equals("#")) {
			TreeNode node = new TreeNode(Integer.parseInt(vals[i]));
			if (isLeftChild) {
				queue.get(intdex).left = node;
			} else {
				queue.get(index).right = node;
			}
			queue.add(node);
		}
		if (!isLeftChild) {
			index++;
		}
		isLeftChild = !isLeftChild;
	}
	return root;
}

//Recursion Version
public class Codec {
	private void preorder(TreeNode root, StringBuilder sb) {
		if (root == null) {
			sb.append("#,");
			return;
		}
		sb.append(root.val + ",");
		preorder(root.left, sb);
		preorder(root.right, sb);
	}

	//Encodes a tree to a single string
	public String serialize(TreeNode root) {
		if (root == null) {
			return "{}";
		}
		StringBuilder sb = new StringBuilder();
		preorder(root, sb);
		String res = sb.toString();
		return res.substring(0, res.length()-1);
	}

	int index = 0;
	//Decodes your encoded data to tree

	//One function only finish one thing at a time
	/*
	deserialize() -> change String to String[]
	buildTree() -> change String[] to value, build new node, build the child node
	*/
	public TreeNode deserialize(String data) {
	//missing check for null
		if (data.equals("{}")) {
			return null;
		}
		String[] nodes = data.split(",");
		return buildTree(nodes);
	}

	private TreeNode buildTree(String[] nodes) {
		if (index >= nodes.length) {
			return null;
		}
		//The key for build all TreeNodes, don't use for loop
		String val = nodes[index++]; 
		if (val.equals("#")) {
			return null;
		}
		TreeNode node = new TreeNode(Integer.valueOf(val));
		node.left = buildTree(nodes);
		node.right = buildTree(nodes);
		return node;
	}
}