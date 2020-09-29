package algorithms;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class MatchingBrackets {
    public static void main(String[] args) {
        //System.out.println(isBalanced("{}()[]"));
        System.out.println(isBalanced("{}[]"));
        System.out.println(isBalanced("{)[]"));
        System.out.println(isBalanced("({[(())]}[])"));


    }


    public static boolean isBalanced(String data){
        Map<Character,Character> mapping = new HashMap<>();
        mapping.put('{','}');
        mapping.put('(',')');
        mapping.put('[',']');
        //mapping.put('a','b');
        char[] brackets = data.toCharArray();
        Stack<Character> balancer = new Stack<>();
        for (Character key:brackets) {
            if(mapping.containsKey(key)){
                balancer.push(key);
            }else /*if(mapping.containsValue(key))*/{
                if(balancer.isEmpty()){
                    return false;
                }else if(!mapping.get(balancer.pop()).equals(key)){
                    return false;
                }
            }
        }
        if(!balancer.isEmpty()){
            return false;
        }
        return true;
    }
}
