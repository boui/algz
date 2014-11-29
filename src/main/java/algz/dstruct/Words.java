package algz.dstruct;

import com.sun.xml.internal.fastinfoset.util.CharArray;

import java.util.*;

public class Words {
    private Map<String, List<String>> words = new HashMap<String, List<String>>();

    private Set<Integer> failedIndexes = new HashSet<Integer>();

    public Words(List<String> dictionary) {
        for (String w : dictionary) {
            String ws = sortString(w);
            if (words.containsKey(ws)) {
                words.get(ws).add(w);
            } else {
                List<String> list = new ArrayList<String>();
                list.add(w);
                words.put(ws, list);
            }
        }
    }

    public List<List<String>> parseSentence(String sentence) {
        Map<Integer, List<String>> map = new HashMap<Integer, List<String>>();
        getPerms(sentence, map, "", 0, 0);

        List<List<String>> list = new ArrayList<List<String>>();
        for (Map.Entry<Integer, List<String>> e : map.entrySet()) {
            list.add(e.getValue());
        }

//        Collections.reverse(list);
        return list;
    }

    //oehllowlrd
    private boolean getPerms(String sentence, Map<Integer, List<String>> result, String prev, int index, int wordN) {
        int n = sentence.length();

        if (n == 0) {
            if (words.containsKey(prev)) {
                if (!result.containsKey(wordN)) {
                    result.put(wordN, new ArrayList<String>());
                }
                result.get(wordN).addAll(words.get(prev));
            }
            return true;
        }

        String word = prev;
        int i = 0;
        while (i < n && !words.containsKey(word)) {
            word = sortedWord(word, sentence.charAt(i));
            i++;
        }

        if (words.containsKey(word)) {

            if(failedIndexes.contains(i)) {
                return false;
            }

            boolean exists = getPerms(sentence.substring(i, n), result, "", index + i, wordN + 1);

            if (exists) {
                if (!result.containsKey(wordN)) {
                    result.put(wordN, new ArrayList<String>());
                }
                result.get(wordN).addAll(words.get(word));
            } else {
                if (i == n) return false;

                failedIndexes.add(index);
                if (i < n) {
                    String prevs = sortedWord(word, sentence.charAt(i));
                    exists = getPerms(sentence.substring(i + 1, n), result, prevs, index + i, wordN);
                }
            }

            return exists;
        } else {
            return false;
        }
    }


    private String sortedWord(String word, Character c) {
        if ("".equals(word)) return c.toString();

        boolean f = false;
        char[] ca = word.toCharArray();
        StringBuilder r = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            if (!f && Character.compare(ca[i], c) > 0) {
                r.append(c);
                r.append(ca[i]);
                f = true;
            } else {
                r.append(ca[i]);
            }
        }

        if (!f) r.append(c);
        return r.toString();
    }

    private String sortString(String a) {
        char[] c = a.toCharArray();
        Arrays.sort(c);
        return new String(c);
    }

    public static void main(String[] args) {
        List<String> dictionary = new ArrayList<String>();
        dictionary.add("any");
        dictionary.add("ny");
        dictionary.add("nyidl");
        dictionary.add("dl");
        dictionary.add("idl");
        dictionary.add("anynny");
        dictionary.add("anynyn");
        dictionary.add("anyny");
        dictionary.add("n");


        Words w = new Words(dictionary);

        List<List<String>> list = w.parseSentence("anynnyidl");
        System.out.println(list);
    }
}
