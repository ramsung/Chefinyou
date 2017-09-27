package com.beyonity.chefinyou.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatEditText;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.beyonity.chefinyou.Constants;
import com.beyonity.chefinyou.R;
import com.beyonity.chefinyou.SignInTask;

import static com.beyonity.chefinyou.Constants.ORANGE;
import static com.beyonity.chefinyou.Utils.colorizeButton;

/**
 * Created by Valentun on 14.03.2017.
 */

public class SignInFragment extends Fragment {

    private AppCompatEditText inputEmail, inputPassword;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sign_in, container, false);

        inputEmail = (AppCompatEditText) view.findViewById(R.id.sign_in_name);
        inputPassword = (AppCompatEditText) view.findViewById(R.id.sign_in_password);

        AppCompatButton signIn = (AppCompatButton) view.findViewById(R.id.sign_in_submit);

        colorizeButton(signIn, ORANGE);

        signIn.setOnClickListener((View buttonView) -> {
            String email = inputEmail.getText().toString();
            String password = inputPassword.getText().toString();

            new SignInTask(getActivity(), view, Constants.AUTH_MODE.SIGN_IN).execute(email, password);
        });

        return view;
    }
}
