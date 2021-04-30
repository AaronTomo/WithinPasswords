package uk.ac.tees.m2163843.withinpasswords;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {

    private Context context;
    private ArrayList account_id, account, username, password;

    CustomAdapter(Context context, ArrayList account_id, ArrayList account, ArrayList username, ArrayList password){

        this.context = context;
        this.account_id = account_id;
        this.account = account;
        this.username = username;
        this.password = password;

    }



    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.account_id_txt.setText(String.valueOf(account_id.get(position)));
        holder.account_txt.setText(String.valueOf(account.get(position)));
        holder.username_txt.setText(String.valueOf(username.get(position)));
        holder.password_txt.setText(String.valueOf(password.get(position)));
    }

    @Override
    public int getItemCount() {
        return account_id.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView account_id_txt, account_txt, username_txt, password_txt;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            account_id_txt = itemView.findViewById(R.id.finalaccountid);
            account_txt = itemView.findViewById(R.id.finalaccount);
            username_txt = itemView.findViewById(R.id.finalusername);
            password_txt = itemView.findViewById(R.id.finalpassword);


        }
    }
}
