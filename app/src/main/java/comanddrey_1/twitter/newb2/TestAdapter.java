package comanddrey_1.twitter.newb2;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class TestAdapter extends RecyclerView.Adapter<TestAdapter.TestViewHolder>{

    private List<TestModel> list;

    @Override
    public TestViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(TestViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class TestViewHolder extends RecyclerView.ViewHolder{

        TextView textName, textCountry;

        public TestViewHolder(View itemView) {
            super(itemView);

            textName = itemView.findViewById(R.id.real_name);
            textCountry = itemView.findViewById(R.id.country);


        }
    }

}
