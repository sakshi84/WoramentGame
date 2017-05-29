package com.packtpub.woramentgame;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sakshi on 30/5/17.
 */

public class TrieNode {
    private TrieNode parent;
    public TrieNode[] children;
    public boolean isLeaf;     //Quick way to check if any children exist
    public boolean isWord;     //Does this node represent the last character of a word
    public char character;     //The character this node represents

    public TrieNode() {
        children = new TrieNode[26];
        isLeaf = true;
        isWord = false;
        character='\0';
    }

    /**
     * Constructor for child node.
     */
    public TrieNode(char character) {
        this();
        this.isWord = false;
        this.character = character;
        children = new TrieNode[26];
        isLeaf = true;
    }

    /**
     * Adds a word to this node. This method is called recursively and
     * adds child nodes for each successive letter in the word, therefore basketball
     * recursive calls will be made with partial words.
     *
     * @param word the word to add
     */
    protected void addWord(String word) {

        isLeaf = false;
        int charPos = word.charAt(0) - 'a';
        if (children[charPos] == null) {
            children[charPos] = new TrieNode(word.charAt(0));
            children[charPos].parent = this;
        }
        if (word.length() > 1) {
            children[charPos].addWord(word.substring(1));
        } else {
            children[charPos].isWord = true;
            //System.out.println("is word true");
        }
    }

    protected TrieNode getNode(char c) {

        return children[c - 'a'];
    }

    protected List getWords() {            //Create a list to return
        List list = new ArrayList();        //If this node represents a word, add it
       /* if (isWord) {
            list.add(toString());
        }

        //If any children
        if (!isLeaf) {                    //Add any words belonging to any children
            for (int i = 0; i < children.length; i++) {
                if (children[i] != null) {
                    list.addAll(children[i].getWords());
                }
            }
        }*/
        return list;
    }
}