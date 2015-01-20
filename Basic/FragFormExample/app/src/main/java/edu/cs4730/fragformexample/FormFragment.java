package edu.cs4730.fragformexample;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.text.TextWatcher;

/**
 * A simple {@link Fragment} subclass.
 */
public class FormFragment extends Fragment implements RadioGroup.OnCheckedChangeListener, TextWatcher,
        Button.OnClickListener {
    RadioGroup myRadioGroup;
    EditText et;
    Button btnalert;
    TextView label ;

    public FormFragment() {
        // Required empty public constructor
    }

    //OnCreateView is where everything is inflated and any listeners are setup at.
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View myView = inflater.inflate(R.layout.fragment_form, container, false);

        //EditText view setup and listner
        et = (EditText) myView.findViewById(R.id.ETname);
        et.addTextChangedListener(this);

        //the top label in the xml doc.
        label = (TextView) myView.findViewById(R.id.Label01);

        //setup the radio group with a listener.
        myRadioGroup = (RadioGroup) myView.findViewById(R.id.SndGroup);
        myRadioGroup.setOnCheckedChangeListener(this);

        //setup the button with a listener as well.
        btnalert = (Button) myView.findViewById(R.id.Button01);
        btnalert.setOnClickListener(this);

        return myView;
    }


    /*  Radio group listener for OnCheckedChangeListener */
    public void onCheckedChanged(RadioGroup group, int CheckedId) {
        if (group == myRadioGroup) { //if not myRadioGroup, we are in trouble!
            if (CheckedId == R.id.RB01) {
                // information radio button clicked
            } else if (CheckedId == R.id.RB02) {
                // Confirmation radio button clicked
            } else if (CheckedId == R.id.RB03) {
                // Warning radio button clicked
                Toast.makeText(getActivity(), "Warning!", Toast.LENGTH_LONG).show();
            }
        }
    }
    /* EditView listeners */
    public void onTextChanged (CharSequence s, int start, int before, int count) {
        if (et.length() >10) {
            Toast.makeText(getActivity(), "Long Word!", Toast.LENGTH_SHORT).show();
        }
    }
    public void beforeTextChanged( CharSequence s, int start, int count, int after) {
        //left blank
    }
    public void afterTextChanged(Editable s) {
        //left blank
    }

    /* button listener */
    public void onClick(View v) {
        if (v == btnalert) {
            Toast.makeText(getActivity(), "The button was pressed",Toast.LENGTH_SHORT).show();
        }

    }




}