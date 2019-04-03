//find the Eulerian path

public class Solution {

	Map<String, PriorityQueue<String>> flights;
	LinkedList<String> path;
}

public class Solution {
	public List<String> findItinerary(String[][] tickets) {
		Map<String, PriorityQueue<String>> hashmap = new HashMap<>();
		List<String> list = new ArrayList<String>();
		String cur = "JFK";

		int length = tickets.length;
		for (int i = 0; i < length; i++) {
			if (!hashmap.containsKey(tickets[i][0])) {
				hashmap.put(tickets[i][0], new PriorityQueue<String>());
			}
			hashmap.get(tickets[i][0]).add(tickets)
		}
		
		dfs(cur, hashmap, list);
		Collections.reverse(list); //why reverse?
		return list;
	}


	public void dfs(String cur, Map<String, PriorityQueue<String>> hashmap, List<String> list) {
		while (hashmap.containsKey(cur) && !hashmap.get(cur).isEmpty()) {
			dfs(hashmap.get(cur).poll(), hashmap, list);
		}
		list.add(cur);
	}
}