package PageFactory;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class TestClass {
   static int soultion (@NotNull String s){
       ArrayList<Character> arr= new ArrayList<>();
       if (!s.isEmpty()) for (int i = 0; i<s.length(); i++){
           arr.add(s.charAt(i));
       }
       int count = 0;

           for (int i = 0; i<arr.size(); i++){
               if (arr.get(i+1)> arr.get(i)){
                   count++;
               }
               if (arr.contains(arr.get(i))){
                   break;
               }
           }
       return count;
   }
    public static void main(String[] args) {
        String s= "abcabcbb";
        System.out.println((s));

    }
}
