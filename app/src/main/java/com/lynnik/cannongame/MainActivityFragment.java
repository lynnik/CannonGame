package com.lynnik.cannongame;

import android.media.AudioManager;
import android.os.Bundle;
import android.app.Fragment;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class MainActivityFragment extends Fragment {

  private CannonView mCannonView;

  @Override
  public View onCreateView(
      LayoutInflater inflater,
      ViewGroup container,
      Bundle savedInstanceState) {
    View v = inflater.inflate(R.layout.fragment_main, container, false);

    mCannonView = v.findViewById(R.id.cannonView);

    return v;
  }

  @Override
  public void onActivityCreated(@Nullable Bundle savedInstanceState) {
    super.onActivityCreated(savedInstanceState);
    getActivity().setVolumeControlStream(AudioManager.STREAM_MUSIC);
  }

  @Override
  public void onPause() {
    super.onPause();
    mCannonView.stopGame();
  }

  @Override
  public void onDestroy() {
    super.onDestroy();
    mCannonView.releaseResources();
  }
}
