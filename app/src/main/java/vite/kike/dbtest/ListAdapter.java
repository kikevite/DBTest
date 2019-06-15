package vite.kike.dbtest;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {

    private List<Nota> listaNotas;
    private OnNotaClickedListener listener;

    public interface OnNotaClickedListener {
        void onNotaClicked(int pos);
    }

    ListAdapter(List<Nota> listaNotas, OnNotaClickedListener listener) {
        this.listaNotas = listaNotas;
        this.listener = listener;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView titulo;
        private TextView contenido;

        ViewHolder(View view) {
            super(view);
            titulo = view.findViewById(R.id.titulo_textview);
            contenido = view.findViewById(R.id.contenido_textview);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.lista_nota_item, viewGroup, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int pos) {
        viewHolder.titulo.setText(listaNotas.get(pos).getTitulo());
        viewHolder.contenido.setText(listaNotas.get(pos).getContenido());
        viewHolder.titulo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (listener != null) {
                    listener.onNotaClicked(pos);
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return listaNotas.size();
    }

}
