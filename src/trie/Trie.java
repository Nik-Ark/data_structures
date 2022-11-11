package trie;

public class Trie {
  private static final int NODE_NUM = 26;
  private TrieNode[] root;

  public Trie() {
    this.root = new TrieNode[NODE_NUM];
  }

  class TrieNode { // inner class is private by default
    private char letter;
    private boolean isWord;
    private TrieNode[] children;

    private TrieNode(char letter) {
      this.letter = letter;
      this.isWord = false;
      this.children = new TrieNode[NODE_NUM];
    }
  }
}
