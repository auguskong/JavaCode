class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        List<String> res = new ArrayList<>();
        if (cpdomains == null || cpdomains.length == 0) {
            return res;
        }
        HashMap<String, Integer> map = new HashMap<>();
        for (String cp : cpdomains) {
            String[] splits = cp.split(" ");
            int count = Integer.valueOf(splits[0]);
            //System.out.println(count);
            //System.out.println("splits[1]: " + splits[1]);
            String url = splits[1];
            //System.out.println(domains.length);
            for (int i = 0; i < url.length(); i++) {
                if (url.charAt(i) == '.') {
                    String domain = url.substring(i + 1);
                    //System.out.println("domain: " + domain);
                    map.put(domain, map.getOrDefault(domain, 0) + count);
                }
            }
            // 将跳过的全url补上
            map.put(url, map.getOrDefault(url, 0) + count);
        }
        for (String d : map.keySet()) {
            res.add(map.get(d) + " " + d);
        }
        return res;
    }
}