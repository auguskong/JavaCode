/**
* Date: 10/30/2018
* Type: Graph BFS
* 数据结构: Queue + HashMap
*/

//为什么需要一个 HashMap?? A:用来保存复制好的节点，否则会丢失

import java.util.LinkedList;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Arrays;
import java.util.Queue;

public class CloneGraph {
	static class UndirectedGraphNode {
		int label;
        ArrayList<UndirectedGraphNode> neighbors;
        UndirectedGraphNode(int x) {
        	label = x;
        	neighbors = new ArrayList<UndirectedGraphNode>();
        }
	}

	static UndirectedGraphNode addNode(int val) {
    	UndirectedGraphNode testNode = new UndirectedGraphNode(val);
    	return testNode;
    }

    static void addEdges(UndirectedGraphNode n1, UndirectedGraphNode n2) {
    	n1.neighbors.add(n2);
    }

	public static void main(String[] args) {
		UndirectedGraphNode testNode = addNode(1);
		UndirectedGraphNode testNodeTwo = addNode(2);
		UndirectedGraphNode testNodeThree = addNode(3);
		UndirectedGraphNode testNodeOne = addNode(1);
		UndirectedGraphNode testNodeFour = addNode(4);
		UndirectedGraphNode testNodeFive = addNode(5);
		addEdges(testNode, testNodeTwo);
		addEdges(testNode, testNodeThree);
		addEdges(testNode, testNodeFour);
		//addEdges(testNodeThree, testNodeOne);
		addEdges(testNodeFour, testNodeFive);
		//showGraph(testNode);

		UndirectedGraphNode newNode = cloneGraph(testNode);
		showGraph(newNode);
	}

    private static UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node == null){
            return null;
        }
        // collecting new nodes
        HashMap<Integer, UndirectedGraphNode> map = new HashMap<>();
        // collecting old nodes
        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        queue.offer(node);
        map.put(node.label, new UndirectedGraphNode(node.label));
        while(!queue.isEmpty()){
            UndirectedGraphNode cur = queue.poll();
            UndirectedGraphNode curCopy = map.get(cur.label);
            for(UndirectedGraphNode neighbor : cur.neighbors){
                if(!map.containsKey(neighbor.label)){
                    UndirectedGraphNode newNode = new UndirectedGraphNode(neighbor.label);
                    queue.offer(neighbor);
                    map.put(newNode.label, newNode);
                }
                curCopy.neighbors.add(map.get(neighbor.label));
            }
        }
        return map.get(node.label);
    }

    private static void showGraph(UndirectedGraphNode node) {
    	if (node == null) {
    		return;
    	}

    	Queue<UndirectedGraphNode> queue = new LinkedList<>();
    	queue.add(node);

    	while (!queue.isEmpty()) {
    		UndirectedGraphNode curr = queue.poll();
    		System.out.println("Source: " + curr.label);
    		System.out.print("Edges: ");
    		for (UndirectedGraphNode n : curr.neighbors) {
    			System.out.print(n.label + " ");
    			queue.add(n);
    		}
    		System.out.println("\n");
    	}
    }
}