package FindDuplicateFileInSystem;

import java.util.*;

public class FindDuplicateFileInSystem {
    public List<List<String>> findDuplicate(String[] paths) {
        HashMap<String,List<String>> seen = new HashMap<>();
        List<List<String>> res = new ArrayList<>();

        for(String str: paths) {
            String[] content = helper(str);
            seen.putIfAbsent(content[1], new ArrayList<>());
            seen.get(content[1]).add(content[0]);
        }

        for(List<String> list: seen.values()) {
            if(list.size() > 1) res.add(list);
        }

        return res;
    }

    private String[] helper(String str) {
        int index = str.length() - 2;
        while(str.charAt(index) != '(') {
            index--;
        }
        return new String[]{str.substring(0, index), str.substring(index + 1, str.length())};
    }
}
