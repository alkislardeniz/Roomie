package com.threek.roomie.Activities;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.threek.roomie.Fragments.House.BackpackFragment;
import com.threek.roomie.Fragments.Login.LoginFragment;
import com.threek.roomie.R;

import src.Game;
import src.Item;

public class BackpackActivity extends AppCompatActivity {

    private Game game;
    private CustomListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_backpack);

        getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("");

        game = Game.getInstance();

        if (game.getPlayer().getBackpack().getItemCount() == 0)
        {
            showDialog("Your backpack is empty!");
        }
        adapter = new CustomListAdapter();

        ListView listView = (ListView) findViewById(R.id.backpackList);
        listView.setAdapter(adapter);

        Button useAll = (Button) findViewById(R.id.useAll);
        useAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                game.getPlayer().useAllItems();
                adapter.notifyDataSetChanged();
            }
        });

        Button sellAll = (Button) findViewById(R.id.sellAll);
        sellAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                game.getPlayer().sellAllItems();
                adapter.notifyDataSetChanged();
            }
        });
    }

    // custom adapter for listview
    private class CustomListAdapter extends BaseAdapter
    {
        //public constructor
        public CustomListAdapter()
        {}

        @Override
        public int getCount() {
            return game.getBackPackItems().size(); //returns total of items in the list
        }

        @Override
        public Object getItem(int position) {
            return game.getBackPackItems().get(position); //returns list item at the specified position
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(final int position, View convertView, final ViewGroup parent)
        {
            // inflate the layout for each list row
            convertView = LayoutInflater.from(getApplicationContext()).inflate(R.layout.backpack_item, parent, false);

            // get current item to be displayed
            final Item currentItem = (Item) getItem(position);

            // get the TextView for item name and item description
            TextView itemText = (TextView) convertView.findViewById(R.id.itemText);
            itemText.setText(currentItem.getName());

            Button useButton = (Button) convertView.findViewById(R.id.useButton);
            useButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    game.getPlayer().useAnItem(position);
                    adapter.notifyDataSetChanged();
                }
            });

            Button sellButton = (Button) convertView.findViewById(R.id.sellButton);
            sellButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    game.getPlayer().sellAnItem(position);
                    adapter.notifyDataSetChanged();
                }
            });

            // returns the view for the current row
            return convertView;
        }
    }

    private void showDialog(String message)
    {
        AlertDialog alertDialog = new AlertDialog.Builder(this).create();
        alertDialog.setTitle("Warning!");
        alertDialog.setMessage(message);
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "Ok",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        alertDialog.show();
    }
}

