package com.example.mainmenu;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.View;

public class MainScreen extends View {

    private int screenWidth, screenHeight;
    private TypeSwitchSprite typeSwitchSprite;

    public MainScreen(Context context, int width, int height) {
        super(context);
        this.screenWidth = width;
        this.screenHeight = height;

        createSwitchTypeButton();
    }

    private void createSwitchTypeButton() {
        typeSwitchSprite = new TypeSwitchSprite(
                getContext(),
                screenWidth,
                screenHeight,
                3
        );

    TypeSwitchSprite.add(typeSwitchSprite);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        /*
        if (typeSwitchSprite.getCurrentType() == 0)
                //draw(canvas) type 1 screen
        else
               //draw(canvas) type 2 screen
       */

        typeSwitchSprite.draw(canvas);
    }

    @SuppressLint("ClickableViewAccessibility")
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float x = event.getX();
        float y = event.getY();


        handleSingleClick(x, y);

        return true;
    }

    private void handleSingleClick(float x, float y) {

        if (typeSwitchSprite.isSelected(x, y))
        {
            int temp = typeSwitchSprite.getCurrentType();
            typeSwitchSprite.handleButtonClick(x, y);
        }
        else
            return;
        invalidate();
    }

}
