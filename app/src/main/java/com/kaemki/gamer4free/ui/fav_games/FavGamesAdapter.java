package com.kaemki.gamer4free.ui.fav_games;

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
import com.google.android.material.chip.Chip;
import com.kaemki.gamer4free.GamesAPI.model.Games;
import com.kaemki.gamer4free.R;
import com.kaemki.gamer4free.db.DbGames;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class FavGamesAdapter extends RecyclerView.Adapter<FavGamesAdapter.ViewHolder> {

    private ArrayList<Games> listGames = new ArrayList<Games>();
    private OnFavGamesListener onFavGamesListener;
    private Context mContext;

    public void setmContext(Context mContext) {
        this.mContext = mContext;
    }

    public FavGamesAdapter(){

    }

    public FavGamesAdapter(ArrayList<Games> listGames, OnFavGamesListener onFavGamesListener){
        this.listGames = listGames;
        this.onFavGamesListener = onFavGamesListener;

    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_games, parent, false);

        return new ViewHolder(view, onFavGamesListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {



        Games games = listGames.get(position);

        DbGames db = new DbGames(mContext);

        ArrayList<Games> favGames = db.listAllFavGames();
        ArrayList<Integer> favGamesIds = new ArrayList<>();
        for (Games game : favGames){
            favGamesIds.add(game.getId());
        }

        String imgGames = games.getThumbnail();
        Picasso.get().load(imgGames).into(holder.imgGames);

        // Insertamos título , y descripción e ID del juego
        holder.nameGames.setText(games.getTitle());
        holder.descGames.setText(games.getShortDescription());

        // Comprobamos para que plataforma es y actualizamos el icono
        if (games.getPlatform().contains("Web Browser")){
            holder.platformIcon.setBackgroundResource(R.drawable.ic_baseline_web_asset_24);
        }

        // Asignamos genero en el Chip/Badge
        holder.genre.setText(games.getGenre());
        // Damos funcionalidad al boton add

        // TODO: Recorrer lista y comprobar ID ,


        // Ponemos las animaciones de los botones que lo tienen
        if (favGamesIds.contains(games.getId())) {
            holder.buttonAdd.setSpeed(1);
            holder.buttonAdd.playAnimation();
        }
        holder.buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                // Si esta en la base de datos el ID del juego se pone la velocidad a 1 y se ejecuta la animacion

                if (!favGamesIds.contains(games.getId())){
                    holder.buttonAdd.setSpeed(1);
                    holder.buttonAdd.playAnimation();
                    // Instanciamos BD y añadimos la info del juego seleccionado en la bd
                    long id = db.insertFavGames(games.getTitle(),games.getThumbnail(),games.getPlatform(),games.getGenre(),games.getId());
                    // Si ha sido añadido mostramos Toast
                    if (id > 0) {
                        showToast("Añadido Juego Con ID ->" + games.getId(), view);
                        favGames.add(games);
                        favGamesIds.add(games.getId());
                    }else {
                        showToast("Error al guardar " + mContext.toString(), view);
                    }
                } else {
                    // Si no esta el ID del juego en la base de datos , se invierte la animación para desseleccionar
                    holder.buttonAdd.setSpeed(-2);
                    holder.buttonAdd.playAnimation();

                    if (db.deleteFavGames(games.getId())){
                        showToast("Eliminado Juego Con ID ->"+games.getId(),view);
                        favGames.remove(games.getId());
                        favGamesIds.remove(games.getId());
                    }

                }

            }

        });

    }
    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return listGames.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        ImageView imgGames;
        TextView nameGames;
        TextView descGames;
        LottieAnimationView buttonAdd;
        Chip genre;
        TextView platformIcon;
        OnFavGamesListener onGamesListener;

        public ViewHolder(@NonNull View itemView, OnFavGamesListener onGamesListener){

            super(itemView);
            imgGames = itemView.findViewById(R.id.imgv_gameImg);
            nameGames = itemView.findViewById(R.id.txtv_gameName);
            descGames = itemView.findViewById(R.id.txtv_gameDesc);
            buttonAdd = itemView.findViewById(R.id.button_add);
            genre = itemView.findViewById(R.id.chip_genre);
            platformIcon = itemView.findViewById(R.id.icon_platform);
            this.onGamesListener = onGamesListener;

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            onGamesListener.onGamesClick(getAdapterPosition());
        }
    }

    public interface OnFavGamesListener {

        void onGamesClick(int position);

    }

    public OnFavGamesListener getOnFavGamesListener() {
        return onFavGamesListener;
    }

    public void setOnFavGamesListener(OnFavGamesListener onFavGamesListener) {
        this.onFavGamesListener = onFavGamesListener;
    }

    public ArrayList<Games> getListGames() {
        return listGames;
    }

    public void setListGames(ArrayList<Games> listGames) {
        this.listGames = listGames;
    }

    public void showToast(String string , View view) {
        CharSequence text = string;
        int duration = Toast.LENGTH_SHORT;
        Context context = view.getContext();
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }

}
