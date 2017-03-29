public class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] tf = new boolean[s.length()+1];
        tf[0] = true;
        // Set<String> dic = new HashSet<String>();
        // for(String str: wordDict){
            // dic.add(str);
        // }
        //这个方法是自己想出来的，不是最优，虽然也是DP
        // str.substring(i,i) is ""
                                                        //  而且就算 j = s.length() 也不会溢出
        for(int i = 0; i < s.length(); i++){
            if(tf[i] == true)
            for(int j = i+1; j < s.length() + 1; j++)
                if(wordDict.contains(s.substring(i,j))){// str.substring(i,i) is ""
                                                        //  而且就算 j = s.length() 也不会溢出
                    tf[j] = true;
               
            }
        }
        
        return tf[s.length()];
    }
}


public class Solution {
    public boolean wordBreak(String s, List<String> dict) {
        
        boolean[] f = new boolean[s.length() + 1];
        // Set<String> se = new Set<String>(dict.)
        f[0] = true;
        
        
        /* First DP
        for(int i = 1; i <= s.length(); i++){
            for(String str: dict){
                if(str.length() <= i){
                    if(f[i - str.length()]){
                        if(s.substring(i-str.length(), i).equals(str)){
                            f[i] = true;
                            break;
                        }
                    }
                }
            }
        }*/
        //这个办法 更加优化， 因为有break这个语句，我自己的方式不能用break
        //因为这个方法是从外（右）向内，刷新tf array，所以一旦遇到满足if条件，就可以break了
        //本质上对于i，在小于i的范围内寻找是否有满足条件的j
        //而我自己的方式是从内（左）向外，刷新tf array，本质上是 在已经知道 i已经满足true时，
        //寻找比i大，并且能满足条件的j，这样，每一次遍历，都得走完，而不能break
        //Second DP
        for(int i=1; i <= s.length(); i++){
            for(int j=0; j < i; j++){
                if(f[j] && dict.contains(s.substring(j, i))){
                    f[i] = true;
                    break;
                }
            }
        }
        
        return f[s.length()];
    }
}