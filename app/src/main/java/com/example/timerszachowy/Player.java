package com.example.timerszachowy;

import android.os.CountDownTimer;
import android.widget.Button;

public class Player {
    private int ileSekund;
    private boolean czyAktywny;
    private CountDownTimer countDownTimer;
    private Button button;

    public Player(boolean czyAktywny, Button button) {
        this.czyAktywny = czyAktywny;
        this.button = button;
        ileSekund = 180;
        if(czyAktywny){
            uruchomZegar();

        }
    }
    private void uruchomZegar(){
        countDownTimer = new CountDownTimer(ileSekund*1000, 1000) {
            @Override
            public void onFinish() {

            }

            @Override
            public void onTick(long l) {
                ileSekund = (int) l/1000;
                button.setText(String.valueOf(ileSekund));
            }
        };
        countDownTimer.start();
    }
}
