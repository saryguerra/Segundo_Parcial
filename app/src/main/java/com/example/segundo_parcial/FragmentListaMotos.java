package com.example.segundo_parcial;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class FragmentListaMotos extends Fragment {

    private RecyclerView recyclerView;
    private MotoAdapter motoAdapter;
    private List<Moto> listaMotos;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_lista_motos, container, false);

        recyclerView = view.findViewById(R.id.recyclerViewMotos);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        listaMotos = new ArrayList<>();
        listaMotos.add(new Moto("YZF R15", "Yamaha", "155cc", "$12.500.000", R.drawable.moto1));
        listaMotos.add(new Moto("CB 190R", "Honda", "184cc", "$10.200.000", R.drawable.moto2));
        listaMotos.add(new Moto("Gixxer SF", "Suzuki", "250cc", "$14.800.000", R.drawable.moto3));
        listaMotos.add(new Moto("KTM Duke 200", "KTM", "199cc", "$15.500.000", R.drawable.moto4));
        listaMotos.add(new Moto("MT-09", "Yamaha", "321cc", "$22.500.000", R.drawable.moto5));
        listaMotos.add(new Moto("Ninja 400", "Kawasaki", "399cc", "$28.000.000", R.drawable.moto6));

        motoAdapter = new MotoAdapter(listaMotos);
        recyclerView.setAdapter(motoAdapter);

        return view;
    }
}