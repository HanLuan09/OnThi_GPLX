package com.example.btl.fragment;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import android.view.*;
import android.widget.*;
import com.example.btl.R;
import com.example.btl.model.JsonResolve;
import com.google.gson.Gson;
import java.io.*;

public class VideoThuchhanhFragment extends Fragment {
    private VideoView videoView;
    public VideoThuchhanhFragment() {

    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_video_thuchhanh, container, false);

        InputStream in= getResources().openRawResource(R.raw.luatthi);
        InputStreamReader inreader=new InputStreamReader(in);
        BufferedReader bufreader=new BufferedReader(inreader);
        StringBuilder builder=new StringBuilder();
        Gson gson = new Gson();
        JsonResolve luatthi =gson.fromJson(bufreader,JsonResolve.class);
        ((TextView)view.findViewById(R.id.edtluatthi)).setText(luatthi.getContent());
        return view;
    }

    public void onViewStateRestored(@NonNull Bundle saveInstanceState) {
        super.onViewStateRestored(saveInstanceState);
        videoView = getActivity().findViewById(R.id.videoView);
        TestVideoView();
    }

    private void TestVideoView() {
        videoView.setVideoPath("android.resource://"+getActivity().getPackageName()+"/"+R.raw.thuchanh);
        MediaController mediaController = new MediaController(getActivity());
        mediaController.setAnchorView(videoView);
        videoView.setMediaController(mediaController);
    }

}