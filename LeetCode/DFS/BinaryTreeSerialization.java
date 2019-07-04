
//JiuZhang Solution - iterative solution using queue
public String serialize(TreeNode root) {
	if (root == null) {
		return "{}";
	}

	ArrayList<TreeNode> queue = new ArrayList<TreeNode>();
	queue.add(root);

	// 每次添加了新的元素之后都会重现更新queue.size(),直到没有新的元素添加进来
	for (int i = 0; i < queue.size(); i++) {
		TreeNode node = queue.get(i);
		if (node == null) {
			continue;
		}
		queue.add(node.left);
		queue.add(node.right);
	}

	// delete all the null node at the last line
	// 因为叶子节点不需要添加到serialization的结果之中
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
	TreeNode root = new TreeNode(Integer.parseInt(vals[0]));
	int index = 0;
	boolean isLeftChild = true;
	for (int i = 1; i < vals.length; i++) {
		if (!vals[i].equals("#")) {
			TreeNode node = new TreeNode(Integer.parseInt(vals[i]));
			if (isLeftChild) {
				queue.get(index).left = node;
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
		// 每个val后面都会跟着一个 ',' 单独把最后一个','去掉
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
		//递归的拆解是用一个全局变量在不断进行++,来缩小遍历范围
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