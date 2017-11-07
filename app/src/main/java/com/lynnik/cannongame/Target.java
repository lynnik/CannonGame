package com.lynnik.cannongame;

public class Target {

  private int mHitReward;

  public Target(CannonView view, int color, int hitReward,
                int x, int y, int width, int length, float velocityY) {
    super(view, color, CannonView.TARGET_SOUND_ID,
        x, y, width, length, velocityY);
    mHitReward = hitReward;
  }

  public int getHitReward() {
    return mHitReward;
  }
}
