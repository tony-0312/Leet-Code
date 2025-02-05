import java.util.HashMap;
import java.util.Map;

class OccurenceEqual{
    static boolean isOccurenceEqual(String s){
        HashMap<Character, Integer> charMap = new HashMap<>();
        char[] charArray = s.toCharArray();
        for(char ch:charArray){
            if(charMap.containsKey(ch)){
                charMap.put(ch, charMap.get(ch)+1);
            }else{
                charMap.put(ch,1);
            }
        }
        int x = 0;
        for(Map.Entry entry:charMap.entrySet()){
            int frequency = (int) entry.getValue();
            if(frequency>0){
                if(x==0) x=frequency;
                else if(x!=frequency) return false;
            }
        }
        return true;
    }
    public static void main(String[] args){
        String str = "aaabb";
        System.out.print("Given String occurences are ");
        System.out.println(isOccurenceEqual(str)?"equal":"not equal");
    }
}