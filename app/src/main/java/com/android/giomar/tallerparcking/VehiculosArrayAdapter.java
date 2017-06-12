package com.android.giomar.tallerparcking;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.widget.ArrayAdapter;

import java.util.List;

/**
 * Created by Giomar on 12/06/2017.
 */

public class VehiculosArrayAdapter extends ArrayAdapter<String> {
    public VehiculosArrayAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<String> objects) {
        super(context, resource, objects);
    }
}
