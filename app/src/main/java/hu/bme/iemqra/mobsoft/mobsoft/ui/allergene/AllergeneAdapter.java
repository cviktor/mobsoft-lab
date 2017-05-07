package hu.bme.iemqra.mobsoft.mobsoft.ui.allergene;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import hu.bme.iemqra.mobsoft.mobsoft.R;
import hu.bme.iemqra.mobsoft.mobsoft.model.Allergene;

/**
 * Created by czegl on 2017. 05. 07..
 */

public class AllergeneAdapter extends ArrayAdapter<Allergene> {

    public AllergeneAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<Allergene> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v = convertView;

        if (v == null) {
            LayoutInflater vi = LayoutInflater.from(getContext());
            v = vi.inflate(R.layout.allergene_list_item, null);
        }

        Allergene a = getItem(position);

        if (a != null) {
            CheckBox item = (CheckBox) v.findViewById(R.id.allergene_list_item);
            item.setText(a.getName());
            item.setChecked(a.getChecked());
            item.setTag(a);
            item.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    ((Allergene) buttonView.getTag()).setChecked(isChecked);
                }
            });
        }

        return v;
    }
}
