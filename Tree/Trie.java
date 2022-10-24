/** 
 * Trie implementation
 *  
 *	Basics:
 *		- "Trie" is pronounced as "Try"
 *		- The name "Trie" is based from the word "ReTRIEval" 
 *		- Also known as Prefix Tree 
 * 
 *  Trie Properties
 *		- The root node of the trie always represents the null node. 
 *		- Each child of nodes is alphabetically sorted
 *		- Each node in the Trie tree can have a maximum of 26 children (A to Z). 
 *		- Each node, except for the root node, can store one letter of the alphabet.
 * 
 *  Use Cases: 
 *		- Spell Checker
 *		- Auto-complete
 *		- browser history
 * 
 * 
 */


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Trie
{
	// 26 characters for `a – z`
	private static final int CHAR_SIZE = 26;

	private boolean isChild;
	private List<Trie> children = null;

	// Constructor
	Trie(){
		isChild = false;
		children = new ArrayList<>(Collections.nCopies(CHAR_SIZE, null));
	}
	
	/**
	* Insert
	* 
	*/
	public void insert(String key){
		
		Trie curr = this;
		for (char c: key.toCharArray()){
			if (curr.children.get(c - 'a') == null) {
				curr.children.set(c - 'a', new Trie());
			}
			curr = curr.children.get(c - 'a');
		}
		curr.isChild = true;
	}

	/**
	 * Search 
	 */
	public boolean search(String key){
	
		Trie current = this;

		for (char c: key.toCharArray()){
			current = current.children.get(c - 'a');
			if (current == null) {
				return false;
			}
		}
		return current.isChild;
	}
}

class Main
{
	public static void main (String[] args)
	{
		// construct a new Trie node
		Trie trie = new Trie();

		trie.insert("tutorials");
		trie.insert("tutorial");
		trie.insert("tutor");

		System.out.println(trie.search("tuto"));			// true
		System.out.println(trie.search("tutorial"));   		// true
		System.out.println(trie.search("tutorials"));  		// true
		System.out.println(trie.search("tutorialsdojo"));   // false

		trie.insert("tutorialsdojo");

		System.out.println(trie.search("tuto"));			// true
		System.out.println(trie.search("tutorial"));   		// true
		System.out.println(trie.search("tutorials"));  		// true
		System.out.println(trie.search("tutorialsdojo"));   // true
	}
}
