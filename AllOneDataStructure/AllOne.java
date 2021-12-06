package AllOneDataStructure;

import java.util.*;

//To be completed

class AllOne {

    class KeyNode {
        String key;
        int freq;
        public KeyNode (String key) {
            this.key = key;
            this.freq = 1;
        }
    }
    class FreqNode {
        int freq;
        FreqNode prev;
        FreqNode next;
        Set<KeyNode> set; // keep the insertion order
        public FreqNode (int freq, FreqNode prev, FreqNode next) {
            this.freq = freq;
            this.prev = prev;
            this.next = next;
            set = new LinkedHashSet<>();
        }
    }

    Map<String, KeyNode> keyMap;
    Map<Integer, FreqNode> freqMap;
    FreqNode head, tail;

    public AllOne() {
        head = null;
        tail = null;
        keyMap = new HashMap<>();
        freqMap = new HashMap<>();
    }


        
}
