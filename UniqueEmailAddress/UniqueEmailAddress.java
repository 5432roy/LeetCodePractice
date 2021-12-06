package UniqueEmailAddress;
import java.util.*;
public class UniqueEmailAddress {

    public int numUniqueEmails(String[] emails){
        Set<String> set = new HashSet<>();
        for(String email : emails){
            String[] cur = email.split("@");
            String local = cur[0].replace(".", "");
            int i = local.indexOf("+");
            set.add(local.substring(0, (i < 0 ? local.length() : i)) + "@" + cur[1]);
        }
        return set.size();
    }
}
