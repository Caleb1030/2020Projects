package com.example.shoultzmadlibscifi.ui.scifi;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.shoultzmadlibscifi.R;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

public class SciFiFragment extends Fragment {

    private TextView mFirstName;       //instantiating the object it acts like a global variable
    private TextView mLastName;        //creating a field variable or a global variable
    private TextView mCity;
    private TextView mSchool;
    private TextView mBrother;
    private TextView mSister;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_scifi, container, false);
        mFirstName = (TextView) root.findViewById(R.id.txtFirstName);
        mLastName = (TextView) root.findViewById(R.id.txtLastName);
        mCity = (TextView) root.findViewById(R.id.txtCity);
        mSchool = (TextView) root.findViewById(R.id.txtSchool);
        mBrother = (TextView) root.findViewById(R.id.txtBrother);
        mSister = (TextView) root.findViewById(R.id.txtSister);
        final TextView outputText = (TextView) root.findViewById(R.id.txtOutput);
        final Snackbar mySnackbar = Snackbar.make(getActivity().findViewById(android.R.id.content), "Error: All boxes need to be filled", BaseTransientBottomBar.LENGTH_SHORT);

        Button restart = root.findViewById(R.id.scifiRestart);
        Button createName = root.findViewById(R.id.btnSubmit);
        createName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String first = mFirstName.getText().toString();    //getText just gets the info out of the TextView
                String last = mLastName.getText().toString();
                String city = mCity.getText().toString();
                String school = mSchool.getText().toString();
                String brother = mBrother.getText().toString();
                String sister = mSister.getText().toString();

                if(!first.equals("") && !last.equals("") && !city.equals("") && !school.equals("") && !brother.equals("") && !sister.equals("")) {
                    int rF = (int) (Math.random() * first.length());        //copied for VSC
                    int rL = (int) (Math.random() * last.length());
                    int rC = (int) (Math.random() * city.length());
                    int rS = (int) (Math.random() * school.length());
                    int rB = (int) (Math.random() * brother.length());
                    int rSi = (int) (Math.random() * sister.length());

                    String sciFiFirst = first.substring(0, rF) + last.substring(rL);        //copied from VSC
                    String sciFiLast = city.substring(0, rC) + school.substring(rS);
                    String sciFiHome = brother.substring(0, rB) + sister.substring(rSi);


                    String finalText = "Hola " + sciFiFirst + " of " + sciFiHome + " son of " + sciFiLast;
                    outputText.setText(finalText);
                }
                else{
                    mySnackbar.show();
                }
            }
        });
        restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mFirstName.setText("");
                mLastName.setText("");
                mCity.setText("");
                mSchool.setText("");
                mBrother.setText("");
                mSister.setText("");
                outputText.setText("");
            }
        });
        return root;
    }
}