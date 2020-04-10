package datastructures;

import java.util.HashMap;

public class MyTrieTree {
	private class TrieNode {
		HashMap<Character, TrieNode> children;
		Boolean endOfWord;
	}
}
