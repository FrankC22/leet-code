import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams_49 {


    public static void main(String[] args) {

        //String arrays to be used as inputs:

        String[] case1 = {"eat", "tea", "tan", "ate", "nat", "bat"};
        String[] case2 = {"eat"};
        String[] case3 = {"a"};

        System.out.println("Case 1 Results: \n " +groupAnagrams(case1));
        System.out.println("Case 2 Results: \n " +groupAnagrams(case2));
        System.out.println("Case 3 Results: \n " +groupAnagrams(case3));
    }



    public static List<List<String>> groupAnagrams(String[] strs) {

        List<String> appendList; //Temp list that will be used to add the 'current' string to the list

        class ArrayWrapper {

            int[] charArray;

            public ArrayWrapper(){
                this.charArray = new int[26];
            }

            public int hashCode() {
                return Arrays.hashCode(this.charArray);
            }
        }

        HashMap<Integer, List<String>> map = new HashMap<>();
        ArrayWrapper wrapper;

        for(int i = 0; i < strs.length; i++) {

            wrapper = new ArrayWrapper();

            for(int j  = 0; j < strs[i].length(); j++) {
                wrapper.charArray[strs[i].charAt(j) - 'a']++;
            }

            if(map.containsKey(wrapper.hashCode())) {
                appendList = map.get(wrapper.hashCode());
            } else {
                appendList = new ArrayList<>();
            }

            appendList.add(strs[i]);
            map.put(wrapper.hashCode(), appendList);

        }
        return new ArrayList<>(map.values());
    }


}
