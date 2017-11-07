package com.lynnik.cannongame;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

public class GameElement {

  protected CannonView mCannonView;
  protected Paint mPaint = new Paint();
  protected Rect mShape;

  private float mVelocityY;
  private int mSoundId;

  public GameElement(CannonView view, int color, int soundId,
                     int x, int y, int width, int length, float velocityY) {
    mCannonView = view;
    mPaint.setColor(color);
    mShape = new Rect(x, y, x + width, y + length);
    mVelocityY = velocityY;
    mSoundId = soundId;
  }

  public void update(float interval) {
    mShape.offset(0, (int) (mVelocityY * interval));
    if (mShape.top < 0 && mVelocityY < 0
        || mShape.bottom > mCannonView.getScreenHeight() && mVelocityY > 0)
      mVelocityY *= -1;
  }

  public void draw(Canvas canvas) {
    canvas.drawRect(mShape, mPaint);
  }

  public void playSound() {
    mCannonView.playSound(mSoundId);
  }
}
