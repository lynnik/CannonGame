package com.lynnik.cannongame;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;

public class Cannon {

  private int mBaseRadius;
  private int mBarrelLength;
  private Point mBarrelEnd;
  private double mBarrelAngle;
  private Cannonball mCannonball;
  private Paint mPaint = new Paint();
  private CannonView mCannonView;

  public Cannon(CannonView view, int baseRadius,
                int barrelLength, int barrelWidth) {
    mCannonView = view;
    mBaseRadius = baseRadius;
    mBarrelLength = barrelLength;
    mPaint.setStrokeWidth(barrelWidth);
    mPaint.setColor(Color.BLACK);
    align(Math.PI / 2);
  }

  public void align(double barrelAngle) {
    mBarrelAngle = barrelAngle;
    mBarrelEnd.x = (int) (mBarrelLength * Math.sin(barrelAngle));
    mBarrelEnd.y = (int) (-mBarrelLength * Math.cos(barrelAngle)
        + mCannonView.getScreenHeight() / 2);
  }

  public void fireCannonball() {
    int velocityX = (int) (CannonView.CANNONBALL_SPEED_PERCENT *
        mCannonView.getScreenWidth() * Math.sin(mBarrelAngle));

    int velocityY = (int) (CannonView.CANNONBALL_SPEED_PERCENT *
        mCannonView.getScreenWidth() * -Math.cos(mBarrelAngle));

    int radius = (int) (mCannonView.getScreenHeight() *
        CannonView.CANNONBALL_RADIUS_PERCENT);

    mCannonball = new Cannonball(mCannonView, Color.BLACK,
        CannonView.CANNON_SOUND_ID, -radius,
        mCannonView.getScreenHeight() / 2 - radius, radius, velocityX,
        velocityY);

    mCannonball.playSound();
  }

  public void draw(Canvas canvas) {
    canvas.drawLine(0, mCannonView.getScreenHeight() / 2, mBarrelEnd.x,
        mBarrelEnd.y, mPaint);

    canvas.drawCircle(0, (int) mCannonView.getScreenHeight() / 2,
        (int) mBaseRadius, mPaint);
  }

  public Cannonball getCannonball() {
    return mCannonball;
  }

  public void removeCannonball() {
    mCannonball = null;
  }
}
