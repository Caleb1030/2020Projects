package com.example.shoultzmadlibscifi.ui.madlibs;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.shoultzmadlibscifi.R;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

import java.util.Objects;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;

public class MadLibsFragment extends Fragment {

    private TextView mLetter1;       //instantiating the object it acts like a global variable
    private TextView mAdj;        //creating a field variable or a global variable
    private TextView mAdv;
    private TextView mPerson;
    private TextView mLocation;
    private TextView mNoun;
    private TextView mNoun2;
    private TextView mNoun3;
    private TextView mNoun4;
    private TextView mOccupation;
    private TextView mBody;
    private TextView mPlural;
    private TextView mNumber;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_madlibs, container, false);
        //final TextView textView = root.findViewById(R.id.text_slideshow);
        //My added code from SciFi name
        final LinearLayout inputLay = root.findViewById(R.id.inputLayout);
        mLetter1 = (TextView) root.findViewById(R.id.txtLetter);
        mAdj = (TextView) root.findViewById(R.id.txtAdj);
        mAdv = (TextView) root.findViewById(R.id.txtAdv);
        mPerson = (TextView) root.findViewById(R.id.txtPerson);
        mLocation = (TextView) root.findViewById(R.id.txtLocation);
        mNoun = (TextView) root.findViewById(R.id.txtNoun);
        mNoun2 = (TextView) root.findViewById(R.id.txtNoun2);
        mNoun3 = (TextView) root.findViewById(R.id.txtNoun3);
        mNoun4 = (TextView) root.findViewById(R.id.txtNoun4);
        mOccupation = (TextView) root.findViewById(R.id.txtOccupation);
        mBody = (TextView) root.findViewById(R.id.txtBody);
        mPlural = (TextView) root.findViewById(R.id.txtPlural);
        mNumber = (TextView) root.findViewById(R.id.txtNumber);
        final TextView outputText = (TextView) root.findViewById(R.id.txtOutput);
        //how to setup a snackbar
        //https://developer.android.com/training/snackbar/showing#java
        //https://stackoverflow.com/questions/32305627/snackbar-is-not-working-within-fragment-class
        final Snackbar mySnackbar = Snackbar.make(getActivity().findViewById(android.R.id.content), "Error: All boxes need to be filled", BaseTransientBottomBar.LENGTH_SHORT);
        //end of my code

        final Button restartMadLib = root.findViewById(R.id.restartMadLib);
        final Button createMadLib = root.findViewById(R.id.btnMadLibSubmit);
        createMadLib.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String letter1 = mLetter1.getText().toString();    //getText just gets the info out of the TextView
                String adj1 = mAdj.getText().toString();
                String adv1 = mAdv.getText().toString();
                String person1 = mPerson.getText().toString();
                String location1 = mLocation.getText().toString();
                String noun = mNoun.getText().toString();
                String noun2 = mNoun2.getText().toString();
                String noun3 = mNoun3.getText().toString();
                String noun4 = mNoun4.getText().toString();
                String occupation = mOccupation.getText().toString();
                String body = mBody.getText().toString();
                String plural = mPlural.getText().toString();
                String number = mNumber.getText().toString();

                if(!letter1.equals("") && !adj1.equals("") && !adv1.equals("") && !person1.equals("") && !mPerson.equals("") && !mLocation.equals("") && !mNoun.equals("") && !mNoun2.equals("") &&
                       !mNoun3.equals("") && !mNoun4.equals("") && !mOccupation.equals("") && !mBody.equals("") && !mPlural.equals("") && !mNumber.equals("")) {
                    inputLay.setVisibility(GONE);
                    outputText.setVisibility(VISIBLE);
                    createMadLib.setVisibility(GONE);
                    restartMadLib.setVisibility(VISIBLE);
                    String print = "";

                    print += (String.format("Julius Caesar was born in %s B. %s.\n", number, letter1));
                    print += (String.format("He was a %s general, between 49 and 58 B. C. he defeated the Gauls, the Goths, and the %s.\n", adv1, plural));
                    print += (String.format("After that, he %s became more famous and defeated Pompey at the battle of %s at Pharsala.\n", adj1, location1));
                    print += (String.format("The Romans then elected him permanent %s, and he used to walk around wearing a circlet of ivy leaves on his %s.\n", occupation, body));
                    print += (String.format("Then Caesar went to Eqypt, where he meet Cleopatra, the teenage Eqyption %s.\n", noun));
                    print += (String.format("When he conquered the Syrians in 46 B.C. he sent back a message saying, \"Veni, vedi, %s.\" \n", noun2));
                    print += (String.format("In 44 B.C., a soothsayer told Caesar to \"Beware the Ides of %s,\" but he ignored the warning and in March he was stabbed in the %s by a group of senators.\n", noun3, noun4));
                    print += (String.format("His last words were, \"Et tu %s?\"\n", person1));


                    outputText.setText(print);
                }
                else{
                    mySnackbar.show();
                }
            }
        });

        restartMadLib.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                outputText.setVisibility(GONE);
                restartMadLib.setVisibility(GONE);
                createMadLib.setVisibility(VISIBLE);
                inputLay.setVisibility(VISIBLE);
                mLetter1.setText("");
                mAdj.setText("");
                mAdv.setText("");
                mPerson.setText("");
                mLocation.setText("");
                mNoun.setText("");
                mNoun2.setText("");
                mNoun3.setText("");
                mNoun4.setText("");
                mOccupation.setText("");
                mBody.setText("");
                mPlural.setText("");
                mNumber.setText("");


            }
        });
        return root;
    }


}