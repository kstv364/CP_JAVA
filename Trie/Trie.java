package Trie;

public class Trie {

	class TrieNode {

		TrieNode children[];
		boolean endOfWord;
		String word;

		public TrieNode() {
			children = new TrieNode[26];
			endOfWord = false;
			word = null;

		}
	}

	TrieNode root;

	/** Initialize your data structure here. */
	public Trie() {
		root = new TrieNode();
	}

	/** Inserts a word into the trie. */
	public void insert(String word) {
		TrieNode curr = root;
		char c;
		for (int i = 0; i < word.length(); i++) {
			c = word.charAt(i);
			if (curr.children[c - 'a'] != null) {
				curr = curr.children[c - 'a'];
			} else {
				curr.children[c - 'a'] = new TrieNode();
				curr = curr.children[c - 'a'];
			}
		}
		curr.endOfWord = true;
		curr.word = word;
	}

	/** Returns if the word is in the trie. */
	public boolean search(String word) {
		TrieNode curr = root;
		char c;
		for (int i = 0; i < word.length(); i++) {
			c = word.charAt(i);
			if (curr.children[c - 'a'] != null) {
				curr = curr.children[c - 'a'];
			} else {
				return false;
			}
		}
		return curr.endOfWord;
	}

	/**
	 * Returns if there is any word in the trie that starts with the given
	 * prefix.
	 */
	public boolean startsWith(String word) {
		TrieNode curr = root;
		char c;
		for (int i = 0; i < word.length(); i++) {
			c = word.charAt(i);
			if (curr.children[c - 'a'] != null) {
				curr = curr.children[c - 'a'];
			} else {
				return false;
			}
		}
		return true;
	}
}
