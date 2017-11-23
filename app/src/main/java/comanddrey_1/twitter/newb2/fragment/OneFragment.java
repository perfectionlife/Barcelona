package comanddrey_1.twitter.newb2.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import comanddrey_1.twitter.newb2.R;

public class OneFragment extends Fragment{

    public static final String TAG  = "OneFragmentTag";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.one_fragment, null);
        Toolbar myToolbar_f1 = (Toolbar) v.findViewById(R.id.toolbar_f1);


        return v;
    }
}
