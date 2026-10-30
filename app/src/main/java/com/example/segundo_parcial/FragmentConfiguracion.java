package com.example.segundo_parcial;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentConfiguracion extends Fragment {

    private TextView txtUsuarioLogueado;
    private Button btnCerrarSesion;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_configuracion, container, false);

        txtUsuarioLogueado = view.findViewById(R.id.txtUsuarioLogueado);
        btnCerrarSesion = view.findViewById(R.id.btnCerrarSesion);

        if (getArguments() != null) {
            String usuario = getArguments().getString("nombre_usuario", "Invitado");
            txtUsuarioLogueado.setText("Usuario conectado: " + usuario);
        }
        btnCerrarSesion.setOnClickListener(v -> {
            FragmentLogin loginFragment = new FragmentLogin();
            requireActivity().getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragmentContainer, loginFragment)
                    .commit();
        });

        return view;
    }
}