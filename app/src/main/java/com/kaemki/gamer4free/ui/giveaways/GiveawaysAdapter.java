package com.kaemki.gamer4free.ui.giveaways;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.airbnb.lottie.LottieAnimationView;
import com.kaemki.gamer4free.GamesAPI.model.Giveaways;
import com.kaemki.gamer4free.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class GiveawaysAdapter extends RecyclerView.Adapter<GiveawaysAdapter.ViewHolder> {

    private ArrayList<Giveaways> listGiveaways = new ArrayList<Giveaways>();
    private OnGiveawaysListener onGiveawaysListener;


    public GiveawaysAdapter(){}

    public GiveawaysAdapter(ArrayList<Giveaways> listGiveaways, OnGiveawaysListener onGiveawaysListener){
        this.listGiveaways = listGiveaways;
        this.onGiveawaysListener = onGiveawaysListener;

    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_giveaways, parent, false);

        return new ViewHolder(view, onGiveawaysListener);
    }

    @Override
    public void onBindViewHolder(@NonNull GiveawaysAdapter.ViewHolder holder, int position) {



        Giveaways giveaways = listGiveaways.get(position);
        ArrayList<Integer> favGames = new ArrayList<>();


        String imgGiveaways = giveaways.getImage();
        Picasso.get().load(imgGiveaways).into(holder.giveawaysImg);

        // Insertamos título , y descripción e ID del juego
        holder.giveawaysName.setText(giveaways.getTitle());
        holder.giveawaysDesc.setText(giveaways.getDescription());

        // Comprobamos para que plataforma es y actualizamos el icono
        /*if (games.getPlatform().contains("Web Browser")){
            holder.platformIcon.setBackgroundResource(R.drawable.ic_baseline_web_asset_24);
        }*/

        // Asignamos genero en el Chip/Badge
        holder.badge.setText(giveaways.getType());


    }

    @Override
    public int getItemCount() {
        return listGiveaways.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        ImageView giveawaysImg;
        TextView giveawaysName;
        TextView giveawaysDesc;
        TextView badge;

        OnGiveawaysListener onGiveawaysListener;

        public ViewHolder(@NonNull View itemView, GiveawaysAdapter.OnGiveawaysListener onGiveawaysListener){

            super(itemView);
            giveawaysImg = itemView.findViewById(R.id.imgv_giveawaysImg);
            giveawaysName = itemView.findViewById(R.id.txtv_giveawaysName);
            giveawaysDesc = itemView.findViewById(R.id.txtv_giveawaysDesc);
            badge = itemView.findViewById(R.id.badge_type);
            this.onGiveawaysListener = onGiveawaysListener;

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            onGiveawaysListener.onGiveawaysClick(getAdapterPosition());
        }
    }

    public interface OnGiveawaysListener{

        void onGiveawaysClick(int position);

    }

    public OnGiveawaysListener getOnGiveawaysListener() {
        return onGiveawaysListener;
    }

    public void setOnGiveawaysListener(OnGiveawaysListener onGiveawaysListener) {
        this.onGiveawaysListener = onGiveawaysListener;
    }

    public ArrayList<Giveaways> getListGiveaways() {
        return listGiveaways;
    }

    public void setListGiveaways(ArrayList<Giveaways> listGiveaways) {
        this.listGiveaways = listGiveaways;
    }

    public void showToast(String string , View view) {
        CharSequence text = string;
        int duration = Toast.LENGTH_SHORT;
        Context context = view.getContext();
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }

}
