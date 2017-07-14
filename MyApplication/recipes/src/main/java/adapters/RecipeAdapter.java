package adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.recipes.FullActivity;
import com.example.recipes.MainActivity;
import com.example.recipes.R;

import java.util.ArrayList;

import models.Recipe;

public class RecipeAdapter extends BaseAdapter {

    Context ctx;
    LayoutInflater lInflater;
    ArrayList<Recipe> objects;

    public RecipeAdapter(Context context, ArrayList<Recipe> recipes) {
        ctx = context;
        objects = recipes;
        lInflater = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return objects.size();
    }

    @Override
    public Object getItem(int position) {
        return objects.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;

        if (view == null)
            view = lInflater.inflate(R.layout.item, parent, false);

        Recipe p = getProduct(position);

        ((TextView) view.findViewById(R.id.tvName)).setText(p.name);
        ((TextView) view.findViewById(R.id.tvHard)).setText(p.hard + "");

        view.setOnClickListener((MainActivity)ctx);

        return view;
    }



    Recipe getProduct(int position) {
        return ((Recipe) getItem(position));
    }

}