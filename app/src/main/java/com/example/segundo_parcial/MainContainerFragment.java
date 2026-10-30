package com.example.segundo_parcial;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainContainerFragment extends Fragment {

    private String nombreUsuario = "";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main_container, container, false);

        if (getArguments() != null) {
            nombreUsuario = getArguments().getString("nombre_usuario", "Usuario");
        }

        BottomNavigationView bottomNavigationView = view.findViewById(R.id.bottomNavigation);

        cargarFragmento(new FragmentListaMotos());

        bottomNavigationView.setOnItemSelectedListener(item -> {
            Fragment selectedFragment = null;
            int itemId = item.getItemId();

            if (itemId == R.id.nav_inicio) {
                selectedFragment = new FragmentListaMotos();
            } else if (itemId == R.id.nav_configuracion) {
                selectedFragment = new FragmentConfiguracion();
                Bundle bundle = new Bundle();
                bundle.putString("nombre_usuario", nombreUsuario);
                selectedFragment.setArguments(bundle);
            }

            if (selectedFragment != null) {
                cargarFragmento(selectedFragment);
            }
            return true;
        });

        return view;
    }

    private void cargarFragmento(Fragment fragment) {
        requireActivity().getSupportFragmentManager().beginTransaction()
                .replace(R.id.navHostFragment, fragment)
                .commit();
    }
}