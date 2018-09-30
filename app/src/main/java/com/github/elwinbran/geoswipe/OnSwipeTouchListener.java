package com.github.elwinbran.geoswipe;

import android.content.Context;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

/**
 * Should be able to detect swipes and be used as event handler.
 * (copied from stackoverflow <a>https://stackoverflow.com/questions/4139288/android-how-to-handle-right-to-left-swipe-gestures</a>)
 * @author Mirek Rusin
 */
public interface OnSwipeTouchListener extends OnTouchListener {

    public void onSwipeRight();

    public void onSwipeLeft();

    public void onSwipeTop();

    public void onSwipeBottom();
}