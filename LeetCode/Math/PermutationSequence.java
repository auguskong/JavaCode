Your input
4
15
stdout
fact: 6
index: 2
l: 14 index * fact: 12
fact: 2
index: 1
l: 2 index * fact: 2
fact: 1
index: 0
l: 0 index * fact: 0
fact: 1
index: 0
l: 0 index * fact: 0
Output
"3214"
Expected
"3214"

public class Solution {
    public String getPermutation(int n, int k) {
        StringBuilder sb = new StringBuilder();
        ArrayList<Integer> num = new ArrayList<Integer>();
        int fact = 1;
        for (int i = 1; i <= n; i++) {
            fact *= i;
            num.add(i);
        }
        for (int i = 0, l = k - 1; i < n; i++) {
            fact /= (n - i);
            System.out.println("fact: " + fact);
            int index = (l / fact);
            System.out.println("index: " + index);
            sb.append(num.remove(index));
            System.out.println("l: " + l + " index * fact: " + index * fact);
            l -= index * fact;
        }
        return sb.toString();
    }
}