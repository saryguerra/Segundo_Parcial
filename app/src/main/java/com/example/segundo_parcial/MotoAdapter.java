package com.example.segundo_parcial;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.squareup.picasso.Picasso;
import de.hdodenhof.circleimageview.CircleImageView;
import java.util.List;

public class MotoAdapter extends RecyclerView.Adapter<MotoAdapter.MotoViewHolder> {

    private List<Moto> listaMotos;

    public MotoAdapter(List<Moto> listaMotos) {
        this.listaMotos = listaMotos;
    }

    @NonNull
    @Override
    public MotoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_moto, parent, false);
        return new MotoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MotoViewHolder holder, int position) {
        Moto moto = listaMotos.get(position);
        holder.txtModelo.setText(moto.getModelo());
        holder.txtMarca.setText(moto.getMarca());
        holder.txtCilindraje.setText("Cilindraje: " + moto.getCilindraje());
        holder.txtPrecio.setText(moto.getPrecio());

        Picasso.with(holder.itemView.getContext())
                .load(moto.getImagenResId())
                .placeholder(R.drawable.ic_launcher_foreground)
                .error(R.drawable.ic_launcher_foreground)
                .into(holder.imgMoto);
    }

    @Override
    public int getItemCount() {
        return listaMotos.size();
    }

    public static class MotoViewHolder extends RecyclerView.ViewHolder {
        TextView txtModelo, txtMarca, txtCilindraje, txtPrecio;
        CircleImageView imgMoto;

        public MotoViewHolder(@NonNull View itemView) {
            super(itemView);
            txtModelo = itemView.findViewById(R.id.txtModelo);
            txtMarca = itemView.findViewById(R.id.txtMarca);
            txtCilindraje = itemView.findViewById(R.id.txtCilindraje);
            txtPrecio = itemView.findViewById(R.id.txtPrecio);
            imgMoto = itemView.findViewById(R.id.imgMoto);
        }
    }
}