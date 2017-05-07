package hu.bme.iemqra.mobsoft.mobsoft.ui.foodmenu;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import hu.bme.iemqra.mobsoft.mobsoft.R;
import hu.bme.iemqra.mobsoft.mobsoft.model.Food;

/**
 * Created by czegl on 2017. 05. 07..
 */

public class FoodAdapter extends ArrayAdapter<Food> {

    public FoodAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<Food> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v = convertView;

        if (v == null) {
            LayoutInflater vi = LayoutInflater.from(getContext());
            v = vi.inflate(R.layout.food_list_item, null);
        }

        Food f = getItem(position);

        if(f != null){
            TextView name = (TextView) v.findViewById(R.id.food_name);
            TextView details = (TextView) v.findViewById(R.id.food_details);
            TextView price = (TextView) v.findViewById(R.id.food_price);

            name.setText(f.getName());
            details.setText(f.getDetails());
            price.setText(f.getPrice() + " Ft");
        }

        return v;
    }
}
