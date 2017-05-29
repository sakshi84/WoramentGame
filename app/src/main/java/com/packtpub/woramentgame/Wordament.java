package com.packtpub.woramentgame;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by sakshi on 30/5/17.
 */

public class Wordament {
    public static Set<String> wordsFound = new HashSet<String>();
    // private final int[] matrix;
    public final int i;
    public final char[][] grid;

    private TrieDictionary td;
    private TrieNode rootDic;
    public TrieNode matrixTrie;
    private char[] intoc= {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r'
            ,'s','t','u','v','w','x','y','z'};


    public Wordament(){
        //Initialized
        i=0;
        // matrix = new int[26];
        grid = new char[4][4];
        MainActivity m=new MainActivity();
        td=m.dic;
        rootDic=m.dic.root;


        /*
        List<String> temp = new ArrayList<String>(wordsFound);
        Collections.sort(temp, new Comparator<String>() {

            public int compare(String o1, String o2) {
                return o2.length() - o1.length();
            }
        });
        for (String word : temp) {
            System.out.println(word);
        }
*/
    }

    //shows the grid
    public void show(){
        int i,j;
        for(i=0;i<4;i++) {
            for(j=0;j<4;j++) {
                System.out.println("word print " + this.grid[i][j]);
            }
        }
    }

    //display all word in list
    public String count(){
        //load();
        //System.out.println("In Display Set");
        // Iterator iter = wordsFound.iterator();
        //while (iter.hasNext()) {
        return(Integer.toString(wordsFound.size()));
        //}
    }
    //storing words to grid
    public void setChar(int ib,int i){
//        matrix[i]=ib;
        if(i>=4&&i<20){

            grid[(i/4-1)][i%4]=intoc[ib];
            //System.out.println("matrix "+intoc[ib]);
            show();
        }
    }

    public boolean inList(String s){
        if(wordsFound.contains(s))
            return true;
        else
            return false;
    }
    //dic check
    public Boolean isWord(String word,TrieNode node) {
        word=word.toLowerCase();
        int i;
        i = word.charAt(0) - 'a';
        if(word.length()==1 && node.children[i]!=null && node.children[i].isWord)
            return true;
        if(word.length()>1 && node.children[i]!=null && !node.children[i].isLeaf){
            return(isWord(word.substring(1),node.children[i]));
        }
        return false;
    }
    /*
    *  word=word.toLowerCase();
        while (word.length() > 0 && node!=null) {
            int i;
            i = word.charAt(0) - 'a';

//            System.out.println(node.children[i].character);
//            System.out.println(node.children[i].isWord);

            if (word.length() == 1 && node.children[i].isWord)
                return true;

            word = word.substring(1);
            node = node.children[i];
        }

        return false;*/

    //matrix to list
    public void load(){
        //System.out.println("In Load");
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                boolean[][] visited = new boolean[4][4];
                traverse(visited,i, j,"");
            }
        }
        //System.out.println("out from Load");
    }

    // matrix traverse
    private void traverse(boolean[][] visited ,int i, int j, String current) {
        char c = this.grid[i][j];
        String newStr = current + Character.toString(c);
        // TrieNode next =new  TrieNode(c);
//        System.out.println("new string "+newStr);

        //if (next != null)
        visited[i][j] = true;
        //System.out.print("->"+newStr);
        if (newStr.length() > 2 && isWord(newStr,rootDic)) {
            wordsFound.add(newStr);
            System.out.println("added "+newStr+" "+newStr.length());
        }

        if (j < 3 && !visited[i][j + 1]) {
            traverse(visited, i, j + 1, newStr);
        }
        if (i < 3 && !visited[i + 1][j]) {
            traverse(visited, i + 1, j, newStr);
        }
        if (j > 0 && !visited[i][j - 1]) {
            traverse(visited, i, j - 1,newStr);
        }
        if (i > 0 && !visited[i - 1][j]) {
            traverse(visited, i - 1, j, newStr);
        }
        if (i < 3 && j < 3 && !visited[i + 1][j + 1]) {
            traverse( visited, i + 1, j + 1, newStr);
        }
        if (i < 3 && j > 0 && !visited[i + 1][j - 1]) {
            traverse(visited, i + 1, j - 1, newStr);
        }
        if (i > 0 && j > 0 && !visited[i - 1][j - 1]) {
            traverse(visited, i - 1, j - 1, newStr);
        }
        if (i > 0 && j < 3 && !visited[i - 1][j + 1]) {
            traverse(visited, i - 1, j + 1, newStr);
        }
        visited[i][j] = false;
        //}

    }
}