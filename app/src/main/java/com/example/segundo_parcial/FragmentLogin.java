package com.example.segundo_parcial;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentLogin extends Fragment {

    private EditText etUsuario, etPassword;
    private Button btnIngresar;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login, container, false);

        etUsuario = view.findViewById(R.id.etUsuario);
        etPassword = view.findViewById(R.id.etPassword);
        btnIngresar = view.findViewById(R.id.btnIngresar);

        btnIngresar.setOnClickListener(v -> {
            String usuario = etUsuario.getText().toString().trim();
            String password = etPassword.getText().toString().trim();

            if (usuario.isEmpty() || password.isEmpty()) {
                Toast.makeText(getContext(), "Por favor complete todos los campos", Toast.LENGTH_SHORT).show();
                return;
            }

            if (!password.equals("12345678")) {
                Toast.makeText(getContext(), "Contraseña incorrecta", Toast.LENGTH_SHORT).show();
                return;
            }

            Toast.makeText(getContext(), "Bienvenido, " + usuario, Toast.LENGTH_SHORT).show();

            MainContainerFragment contenedor = new MainContainerFragment();
            Bundle args = new Bundle();
            args.putString("nombre_usuario", usuario);
            contenedor.setArguments(args);

            requireActivity().getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragmentContainer, contenedor)
                    .commit();
        });

        return view;
    }
}