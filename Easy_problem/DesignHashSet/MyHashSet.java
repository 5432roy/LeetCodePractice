package DesignHashSet;
import java.util.*;
class MyHashSet {
    
    List<Integer> list;
    int load;
    int maxLoad;
    
    public MyHashSet() {
        maxLoad = 13;
        list = Arrays.asList(new Integer[maxLoad]);
        load = 0;
    }
    
    public void add(int key) {
        if(contains(key)) return;
        
        int hash = key % maxLoad;
        
        while(list.get(hash) != null && list.get(hash) >= 0) hash = (hash + 1) % maxLoad;
        
        list.set(hash, key);
        
        load++;
        
        if(((float)load / (float)maxLoad) > 0.7) rehash();
    }
    
    public void remove(int key) {
        int index = probing(key);
        if(index >= 0){
            list.set(index, -1);
            load--;
        }
    }
    
    
    public boolean contains(int key) {
        return probing(key) >= 0 ? true : false;
    }
    
    private int probing(int key){
        int index = key % maxLoad;
        int count = 0;
        while(count < maxLoad && list.get(index) != null){
            if(list.get(index) == key) return index;
            count++;
            index = (index + count) % maxLoad;
        }
        return -1;
    }
    
    private void rehash(){
        maxLoad = (maxLoad << 1) + 1;
        List<Integer> newList = Arrays.asList(new Integer[maxLoad]);
        for(int i = 0; i < list.size(); i++){
            if(list.get(i) == null || list.get(i) < 0) continue;
            int key = list.get(i);
            int hash = key % maxLoad;
            while(newList.get(hash) != null){
                hash = (hash + 1) % maxLoad; 
            }
            newList.set(hash, key);
        }
        this.list = newList;
    }
}
/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */