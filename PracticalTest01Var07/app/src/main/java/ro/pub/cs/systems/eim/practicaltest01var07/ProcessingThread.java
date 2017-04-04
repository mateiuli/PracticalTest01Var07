package ro.pub.cs.systems.eim.practicaltest01var07;

import android.content.Context;
import android.content.Intent;
import android.icu.text.DateFormat;


public class ProcessingThread extends Thread {

    private Context context;


    public ProcessingThread(Context context) {
        this.context = context;
    }

    @Override
    public void run() {
        while(true) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void sendMessage(int msgType) {
        Intent intent = new Intent();

//        Str
//        intent.setAction("act");
//        intent.putExtra("data", data);


        context.sendBroadcast(intent);
    }


}