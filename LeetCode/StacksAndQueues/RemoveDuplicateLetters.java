/**
*
*
*
*/
public String removeDuplicateLetters(String s) {

	int[] count = new int[26]; //count the occurences of each character
	boolean[] visited = new boolean[26];
	for (char c : s.toCharArray()) {
		count[c - 'a']++;
	}
	Stack<Character> stack = new Stack<Character>(); 
	int index;
	for (char c : s.toCharArray()) {
		index = c - 'a';
		count[index]--; //decrese number of characters remaining in the string
		if (visited[index]) { //if current character is already visited, skip it
			continue;
		}
		while (!stack.isEmpty()  
					 && c < stack.peek()  
					 && count[stack.peek() - 'a'] != 0) {
			visited[stack.pop() - 'a'] = false;
		}
		stack.push(c); //add current character and mark it as visited
		visited[index] = true;
	}

	StringBuilder sb = new StringBuilder();
	//pop character from stack and build answer string from back
	while (!stack.isEmpty()) {
		sb.insert(0, stack.pop());
	}

	return sb.toString();
}