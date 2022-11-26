package com.example.btl.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.*;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.*;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.SearchView;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import com.example.btl.*;
import com.example.btl.activity.*;
import com.example.btl.databinding.FragmentHomeBinding;
import java.util.ArrayList;

public class HomeFragment extends Fragment {
    private CardView thithu,gioithieu,bienbao,meothi;
    private ViewFlipper viewFlipper;
    private Button btTruoc,btSau;
    private SearchView searchView;
    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        View root = binding.getRoot();
        return root;
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
    public  void onViewStateRestored(@NonNull Bundle saveInstanceState) {
        super.onViewStateRestored(saveInstanceState);
        Anhxa();
        ControlCardView();
        ActionViewflipper();
        ControlSearchView();
    }

    private void Anhxa() {
        thithu =  getActivity().findViewById(R.id.CvThithu);
        gioithieu = getActivity().findViewById(R.id.Cvonthi);
        bienbao =  getActivity().findViewById(R.id.Cvbienbao);
        meothi =  getActivity().findViewById(R.id.CvMeothi);
        searchView = getActivity().findViewById(R.id.searchviewhome);
        viewFlipper=(ViewFlipper) getActivity().findViewById(R.id.viewflipper);
//        btTruoc = getActivity().findViewById(R.id.buttontruoc);
//        btSau = getActivity().findViewById(R.id.buttonsau);
    }

    private void ControlCardView() {

        thithu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent itthithu= new Intent(getActivity(), ChondeThithuActivity.class);
                startActivity(itthithu);
            }
        });
        gioithieu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent itthuchanh= new Intent(getActivity(), OntapActivity.class);
                startActivity(itthuchanh);
            }
        });
        bienbao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent itlythuyet= new Intent(getActivity(), HocBienBaoActivity.class);
                startActivity(itlythuyet);
            }
        });
        meothi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent itmeothi= new Intent(getActivity(), MeoThiLyThuyetActivity.class);
                startActivity(itmeothi);
            }
        });
    }
    private void ActionViewflipper() {
        ArrayList<Integer> arrayListVf = new ArrayList<>();
        arrayListVf.add(R.drawable.anh2t);
        arrayListVf.add(R.drawable.anh3);
        arrayListVf.add(R.drawable.anh4);
        arrayListVf.add(R.drawable.anh4t);
        arrayListVf.add(R.drawable.anh5);
        arrayListVf.add(R.drawable.anh6);
        arrayListVf.add(R.drawable.anh7);
        arrayListVf.add(R.drawable.anh8);
        for(int i =0; i<arrayListVf.size(); i++){
            ImageView imageView = new ImageView(getActivity());
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setImageResource(arrayListVf.get(i));
            viewFlipper.addView(imageView);
        }
        Animation in,out;
        in = AnimationUtils.loadAnimation(getActivity(), R.anim.fate_in);
        out= AnimationUtils.loadAnimation(getActivity(),R.anim.fate_out);
        viewFlipper.setInAnimation(in);
        viewFlipper.setOutAnimation(out);
        viewFlipper.setFlipInterval(5500);
        viewFlipper.setAutoStart(true);
//        btSau.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if(viewFlipper.isAutoStart()){
//                    viewFlipper.stopFlipping();
//                    viewFlipper.showNext();
//                    viewFlipper.startFlipping();
//                    viewFlipper.setAutoStart(true);
//                }
//            }
//        });
//        btTruoc.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if(viewFlipper.isAutoStart()){
//                    viewFlipper.stopFlipping();
//                    viewFlipper.showPrevious();
//                    viewFlipper.startFlipping();
//                    viewFlipper.setAutoStart(true);
//                }
//            }
//        });
    }
    private void ControlSearchView() {
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
//                searchAction(searchView.getQuery().toString().trim());
                return false;
            }

            @Override    public boolean onQueryTextChange(String newText) {
                return false;    }
        });
    }
}