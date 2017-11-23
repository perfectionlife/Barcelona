package comanddrey_1.twitter.newb2.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;

import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import comanddrey_1.twitter.newb2.R;

public class FiveFragment extends Fragment{

    public static final String TAG  = "FiveFragmentTag";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.five_fragment, null);
        Button button = (Button) v.findViewById(R.id.btnGo);

        return v;
    }



}
