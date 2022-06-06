package WeeklyContest296;

public class DesignATextEditor {
    class TextEditor {
    
        StringBuilder left;
        StringBuilder right;
        
        public TextEditor() {
            left = new StringBuilder();
            right = new StringBuilder();
        }
        
        public void addText(String text) {
            left.append(text);
            //System.out.println(left.toString() + " | " + right.toString());
        }
        
        public int deleteText(int k) {
            int l = left.length();
            left.setLength(Math.max(left.length() - k,0));
            //System.out.println(left.toString() + " | " + right.toString());
            return l - left.length();
        }
        
        public String cursorLeft(int k) {
            int i = Math.min(left.length(), k);
            right.insert(0, left.substring(left.length() - i));
            left.setLength(left.length() - i);
            //System.out.println(left.toString() + " | " + right.toString());
            return left.substring(Math.max(0,left.length() - 10));
        }
        
        public String cursorRight(int k) {
            int i = Math.min(right.length(), k);
            left.append(right.substring(0, i));
            right.delete(0,i);
            //System.out.println(left.toString() + " | " + right.toString());
            return left.substring(Math.max(0,left.length() - 10));
        }
    }
    
}
