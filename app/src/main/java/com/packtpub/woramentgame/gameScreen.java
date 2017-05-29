package com.packtpub.woramentgame;

/**
 * Created by sakshi on 30/5/17.
 */

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.TextView;


public class gameScreen extends AppCompatActivity implements View.OnClickListener {
    private Wordament wordament;
    //private Wordament matrixToTrie;
    private ImageButton reset;
    private ImageButton search;
    private ImageButton start;
    private ImageButton clear;
    private ImageButton list;
    public static TextView noWord;
    private TextView text;
    public String input;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //connecting to UI
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_screen);
        text =(TextView) findViewById(R.id.text);
        input="";
        //***** noWord=(TextView) findViewById(R.id.noWord);
        //GridView and ImageAdapter
        final GridView board = (GridView) findViewById(R.id.gridview);
        wordament=new Wordament();
        final ImageAdapter myImageAdapter = new ImageAdapter(this,wordament);
        board.setAdapter(myImageAdapter);
        board.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                         @Override
                                         public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                                             input=input+Character.toString(wordament.grid[position/4][position%4]);
                                             text.setText(input);
                                         }
                                     }
        );

        //wordament.load();
        // wordament.matrixTrie();

        //Button Start
        start =(ImageButton)findViewById(R.id.start);
        start.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                wordament.load();
                noWord.setText(wordament.count());
                System.out.println("Finish");
            }
        });

        //Button clear

        clear =(ImageButton)findViewById(R.id.clear);
        clear.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                input="";
                text.setText(input);
            }
        });

        //Button list
        list =(ImageButton)findViewById(R.id.list);
        list.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                // Intent i = new Intent(getApplicationContext(), wordsList.class);
                // startActivity(i);
            }
        });


        //Button Search
        search =(ImageButton)findViewById(R.id.search);
        search.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                myImageAdapter.i=0;
                input = text.getText().toString();
                TrieDictionary td;
                td=MainActivity.dic;
                //System.out.println("gs root"+td.root);
                //wordament.load();
                //wordament.displaySet();
                int i= Color.parseColor("#A4C639");
                int j=Color.parseColor("#ff5454");
                if(wordament.inList(input))
                    text.setBackgroundColor(i);
                else
                    text.setBackgroundColor(j);
                //System.out.println("input--->"+input+" & "+wordament.isWord(input,td.root));
                //System.out.println("**"+wordament.contain(input));
               /*'
                int i=0;
                TrieNode tn;
                tn=td.root;
                while(input.length()>0){

                    i=input.charAt(0) - 'a';
                    input=input.substring(1);
                    System.out.println(tn.children[i].character);
                    System.out.println(tn.children[i].isWord);
                    tn=tn.children[i];
                }*/


            }
        });
        //Button Reset
        reset =(ImageButton)findViewById(R.id.reset);
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myImageAdapter.i=1;
                board.setAdapter(myImageAdapter);
                // wordament=new Wordament();
                //wordament.matrixTrie();
            }
        });



        //wordament.isWord("hello");
        //wordament.show();
    }

    @Override
    public void onClick(View v) {
    }
}
