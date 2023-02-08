package EncodeAndDecodeTinyUrl;
import java.util.*;
public class EncodeAndDecodeTinyUrl {
    /*
    public String encode(String longUrl) {
        return longUrl;
    }
    public String decode(String shortUrl) {
        return shortUrl;
    }
    */
       
    String prefix;
    HashMap<Integer,String[]> map;
    int count;
    
    public EncodeAndDecodeTinyUrl(){
        prefix = "short";
        map = new HashMap<>();
        count = 0;
    }
    
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        boolean tail = longUrl.charAt(longUrl.length() - 1) == '/';
        String[] sp = longUrl.split("//", 2);
        String[] url = sp[1].split("/");
        
        map.put(count, url);
        
        StringBuilder builder = new StringBuilder(sp[0] + "//");
        builder.append("short/");
        builder.append(count);
        if(tail) builder.append("/");
        count++;

        return builder.toString();
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        boolean tail = shortUrl.charAt(shortUrl.length() - 1) == '/';
        String[] sp = shortUrl.split("//", 2);
        String[] url = sp[1].split("/");
        
        StringBuilder builder = new StringBuilder(sp[0] + "/");
        
        if(url.length == 2 && url[0].equals(prefix)) {
            for(String str : map.get(Integer.parseInt(url[1]))) {
                builder.append("/" + str);
            }
            if(tail) builder.append("/");
            return builder.toString();
        }
        return null;
    }
    
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));

