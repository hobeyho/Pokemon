package com.nickjwpark.pokemon;

import android.app.NotificationManager;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Pokemon pikachu = new Pokemon("Pikachu");
        pikachu.cry = "pika";
        pikachu.attack = "lightning bolt";
        pikachu.power_upgrade(2);
        pikachu.defense_upgrade(1);
        pikachu.health_upgrade(5);

        Pokemon mew = new Pokemon("Mew", "psychic", "mu", 3, 4, 2);

        LogLibrary.print(pikachu.introduce());
        LogLibrary.print(mew.introduce());
        LogLibrary.print("Fight start!");
        while(mew.health > 0 && pikachu.health > 0){
            pikachu.attacked(mew.attack());
            if(pikachu.health <= 0) {
                LogLibrary.print(mew.getName() + " won!");
                gameOver(mew.getName());
                break;
            }
            mew.attacked(pikachu.attack());
            if(mew.health <= 0) {
                LogLibrary.print(pikachu.getName() + " won!");
                gameOver(pikachu.getName());
                break;
            }
        }

    }

    public void gameOver(String winner){
        LogLibrary.print(winner + " won!");
        int notificationID = 1;
        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this);
        mBuilder.setSmallIcon(R.mipmap.ic_launcher);
        mBuilder.setContentTitle("Game Over!");
        mBuilder.setContentText(winner + " won!");
        NotificationManager mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        mNotificationManager.notify(notificationID, mBuilder.build());
    }

}
