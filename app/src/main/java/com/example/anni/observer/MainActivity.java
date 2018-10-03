package com.example.anni.observer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
        implements View.OnClickListener, ObserverCounter  {

    ObserverThread thread = null;
    ArrayList<ObserverThread> threads = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.addButton).setOnClickListener(this);

        thread = new ObserverThread();
        thread.setCounter(this);
    }

        public static void main(String[] args) {
            MainActivity ohjelma = new MainActivity();
            ohjelma.aloitaohjelma();
        }
        public void aloitaohjelma() {

            }
    @Override
    public void observeNow(final String Message) {
        MainActivity.this.runOnUiThread(new Runnable() {

            public void run() {
                TextView textView = findViewById(R.id.threadTextView);
                textView.append(Message);
            }
        });
    }

    public void onClick(View v) {
        thread = new ObserverThread();
        thread.identifier =threads.size();
        thread.counter = this;
        threads.add(thread);
        thread.start();
    }

    public void write(View v){
        System.out.println("New thread started with id: "+ thread.identifier);
    }
}


