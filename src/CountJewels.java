public class CountJewels {


        public int numJewelsInStones(String J, String S) {
            int count = 0;
            for(int i = 0; i < S.length(); i++){
                char stone = S.charAt(i);
                for (int j = 0; j < J.length(); j++){
                    char jewel = J.charAt(j);
                    if (stone == jewel){
                        count ++;
                        break;
                    }
                }
            }
            return count;
        }
    }

