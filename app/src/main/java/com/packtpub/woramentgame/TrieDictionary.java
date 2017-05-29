package com.packtpub.woramentgame;

/**
 * Created by sakshi on 30/5/17.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by sakshi on 11/5/17.
 */

public class TrieDictionary {

    public TrieNode root;
    int MIN_WORD_LENGTH=3;

    public TrieDictionary(InputStream wordListStream) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(wordListStream));
        root = new TrieNode();
        String line = null;
        while((line = in.readLine()) != null) {
            String word = line.trim();
            //System.out.println(word+" ");
            if (word.length() >= MIN_WORD_LENGTH)
                root.addWord(line.trim());

        }

    }
}