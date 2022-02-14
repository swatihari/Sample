package com.swathi.swathitest;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.BreakIterator;

public class MyThread extends Activity {
    EditText etName;
    Button btnHandler, btnThread;
    TextView tv, tv1;
    private BreakIterator edit_query;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thread);
        etName = findViewById(R.id.etname);
        btnHandler = findViewById(R.id.btnHandler);
        btnThread = findViewById(R.id.btnThread);
        tv = findViewById(R.id.tv);
        tv1 = findViewById(R.id.tv1);

        btnHandler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                runThread1();
            }
        });

        btnThread.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                runThread();
            }
        });


    }

    public void runThread1() {
        final String s1 = etName.getText().toString();
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        tv.setText(s1);
                    }
                });
            }
        }, 20000);
    }

    int i = 0;
    private void runThread() {
        new Thread() {
            public void run() {
                while (i++ < 1000) {
                    try {
                        runOnUiThread(new Runnable() {

                            @Override
                            public void run() {
                                btnThread.setText("#### " + i);
                            }
                        });
                        Thread.sleep(300);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    tv1.setText("HELLO");
                }
            }
        }.start();
    }
    boolean twice;
    Thread t;

    private void runfirstthread() {
        twice = true;
        if (twice) {
            final String s1 = edit_query.getText().toString();
            t = new Thread(new Runnable() {
                @Override
                public void run() {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            tv1.setText(t.getName());
                            twice = false;
                        }
                    });
                }
            });
            t.start();
            t.setName(s1);
            t.setPriority(Thread.MAX_PRIORITY);
        }
    }
}