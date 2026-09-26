class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        StringBuilder sb = new StringBuilder();

        HashMap<String, String> map = new HashMap<>();
        for(int i = 0; i < knowledge.size(); i++) {
            map.put(knowledge.get(i).get(0), knowledge.get(i).get(1));
        }

        int j = 0;
        while(j < s.length()) {
            if(s.charAt(j) == '(') {
                StringBuilder temp = new StringBuilder();
                j++;
                while(s.charAt(j) != ')') {
                    temp.append(s.charAt(j));
                    j++;
                }
                
                if(map.containsKey(temp.toString())) {
                    sb.append(map.get(temp.toString()));
                } else {
                    sb.append('?');
                }
                j++;
            } else {
                sb.append(s.charAt(j));
                j++;
            }
        }
        return sb.toString();
    }
}