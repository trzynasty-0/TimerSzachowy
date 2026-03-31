package com.example.timerszachowy;

import android.content.res.ColorStateList;
import android.graphics.Color;
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
        ileSekund = 60;
        if(czyAktywny){
            uruchomZegar();

        }
    }

    public boolean isCzyAktywny() {
        return czyAktywny;
    }

    private void uruchomZegar(){
        countDownTimer = new CountDownTimer(ileSekund*1000, 100) {
            @Override
            public void onFinish() {

            }

            @Override
            public void onTick(long l) {
                ileSekund = (int) l/1000;
                button.setText(wyswietlCzas(ileSekund));
                if(ileSekund <= 30){
                    button.setTextColor(ileSekund%2 == 0 ? Color.parseColor("#FF0000") : Color.parseColor("#FFFFFF"));
                }
            }
        };
        countDownTimer.start();
    }
    private void zatrzymajZegar(){
        countDownTimer.cancel();
    }
    public void odwrocAktywnosc(){
        czyAktywny = !czyAktywny;
        if(czyAktywny) uruchomZegar();
        else zatrzymajZegar();
    }
    private String wyswietlCzas(int ile){
        int sekundy = ile%60;
        int minuty = ile/60;
        return String.format("%02d:%02d", minuty, sekundy);
    }

}
