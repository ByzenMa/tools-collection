package LeetCode;

public class WordDictionary {

    private class TrieNode {
        public TrieNode[] children = new TrieNode[26];
        public String item;
    }

    private TrieNode root;

    /**
     * Initialize your data structure here.
     */
    public WordDictionary() {
        root = new TrieNode();
    }

    /**
     * Adds a word into the data structure.
     */
    public void addWord(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            if (node.children[c - 'a'] == null) node.children[c - 'a'] = new TrieNode();
            node = node.children[c - 'a'];
        }
        node.item = word;
    }

    /**
     * Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter.
     */
    public boolean search(String word) {
        if (word == null || word.length() == 0) return false;
        return search(word, root, 0);
    }

    private boolean search(String word, TrieNode node, int lo) {
        if (lo == word.length()) return true;
        char c = word.charAt(lo);
        if (c != '.') {
            TrieNode child = node.children[word.charAt(lo) - 'a'];
            if (child != null) return search(word, child, lo + 1);
            else return false;
        } else {
            boolean find = false;
            for (int i = 0; i < 26; i++) {
                TrieNode child = node.children[i];
                if (child != null) find = find || search(word, child, lo + 1);
            }
            return find;
        }
    }

    public static void main(String[] args) {
        WordDictionary w = new WordDictionary();
        String[] ss = {"bad", "dad", "mad"};
        for (String s : ss) w.addWord(s);
//        System.out.println(w.search("pad"));
//        System.out.println(w.search("bad"));
        System.out.println(w.search(".ad"));
        System.out.println(w.search("b.."));
    }
}
