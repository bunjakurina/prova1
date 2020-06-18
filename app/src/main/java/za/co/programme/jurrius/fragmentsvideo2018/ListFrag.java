package za.co.programme.jurrius.fragmentsvideo2018;


import android.app.ListFragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.app.Fragment;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;


/**
 * A simple {@link Fragment} subclass.
 */
public class ListFrag extends ListFragment {

    ItemSelected activity;

    public interface ItemSelected
    {
        void onItemSelected(int index);
    }

    public ListFrag() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        activity = (ItemSelected) context;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        String [] data = getResources().getStringArray(R.array.pieces);

        setListAdapter(new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, data));

        //the phone is in landscape mode
        if (this.getActivity().findViewById(R.id.layout_land) != null)
        {
            activity.onItemSelected(0);
        }



    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {

        activity.onItemSelected(position);

    }
}
