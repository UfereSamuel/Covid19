package com.ighub.covid19;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.ViewFlipper;

import com.ikhiloyaimokhai.nigeriastatesandlgas.Nigeria;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    private String name, community, age, state, lga, gender;

    private List<String> states;
    private ViewFlipper flipper;
    private Animation in, out;

    private static final int SPINNER_HEIGHT = 500;

    ArrayList<String> list;

    //section 1
    @BindView(R.id.etName)
    EditText etName;

    @BindView(R.id.etAge)
    EditText etAge;

    @BindView(R.id.spGender)
    Spinner spGender;

    @BindView(R.id.stateSpinner)
    Spinner mStateSpinner;

    @BindView(R.id.lgaSpinner)
    Spinner mLgaSpinner;

    @BindView(R.id.etCommunity)
    EditText etCommunity;

    @BindView(R.id.btnNext1)
    Button btnNext1;

    //section  2
    @BindView(R.id.fever1)
    CheckBox fever1;
    @BindView(R.id.cough1)
    CheckBox cough1;
    @BindView(R.id.breathing1)
    CheckBox breathing1;
    @BindView(R.id.sneezing1)
    CheckBox sneezing1;
    @BindView(R.id.throat1)
    CheckBox throat1;
    @BindView(R.id.headache1)
    CheckBox headache1;
    @BindView(R.id.chest1)
    CheckBox chest1;
    @BindView(R.id.diarrhoea1)
    CheckBox diarrhoea1;
    @BindView(R.id.flu1)
    CheckBox flu1;

    //section  2
    @BindView(R.id.fever2)
    CheckBox fever2;
    @BindView(R.id.cough2)
    CheckBox cough2;
    @BindView(R.id.breathing2)
    CheckBox breathing2;
    @BindView(R.id.sneezing2)
    CheckBox sneezing2;
    @BindView(R.id.throat2)
    CheckBox throat2;
    @BindView(R.id.headache2)
    CheckBox headache2;
    @BindView(R.id.chest2)
    CheckBox chest2;
    @BindView(R.id.diarrhoea2)
    CheckBox diarrhoea2;
    @BindView(R.id.flu2)
    CheckBox flu2;
    @BindView(R.id.btnNext2)
    Button btnNext2;

    //section 3
    @BindView(R.id.rbNo)
    RadioButton rbNo;
    @BindView(R.id.rbYes)
    RadioButton rbYes;

    @BindView(R.id.kidney1)
    CheckBox kidney;
    @BindView(R.id.hiv1)
    CheckBox hiv1;
    @BindView(R.id.diabetes1)
    CheckBox diabetes1;
    @BindView(R.id.liver1)
    CheckBox liver1;
    @BindView(R.id.lung1)
    CheckBox lung1;
    @BindView(R.id.cancer1)
    CheckBox cancer1;
    @BindView(R.id.heart1)
    CheckBox heart1;
    @BindView(R.id.partum1)
    CheckBox partum1;
    @BindView(R.id.pregnancy1)
    CheckBox pregnancy1;

    @BindView(R.id.btnSubmit)
    Button btnSubmit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        ButterKnife.bind(this);

        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

        flipper = findViewById(R.id.flipper);
        flipper.setDisplayedChild(0);

        in = AnimationUtils.loadAnimation(this, android.R.anim.slide_in_left);
        out = AnimationUtils.loadAnimation(this, android.R.anim.slide_out_right);


        resizeSpinner(mStateSpinner, SPINNER_HEIGHT);
        resizeSpinner(mLgaSpinner, SPINNER_HEIGHT);

        states = Nigeria.getStates();
        setupSpinners();

        validateInputs();


    }

    private void validateInputs() {
        btnNext1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = etName.getText().toString().trim();
                age = etAge.getText().toString().trim();
                community = etCommunity.getText().toString().trim();
                gender = spGender.getSelectedItem().toString();

                if (TextUtils.isEmpty(name)) {
                    etName.setError("empty field");
                    return;
                }
                if (TextUtils.isEmpty(age)) {
                    etAge.setError("field is required");
                    return;
                }
                if (TextUtils.isEmpty(community)) {
                    etCommunity.setError("field is required");
                    return;
                }
                if (gender.equalsIgnoreCase("Select your Gender")) {
                    Toast.makeText(MainActivity.this, "Select your Gender", Toast.LENGTH_SHORT).show();
                } else {
                    flipper.setInAnimation(in);
                    flipper.setOutAnimation(out);
                    flipper.showNext();
                }
            }
        });

        btnNext2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                list = new ArrayList<String>();

                for (String str : list) {

                    Toast.makeText(MainActivity.this, "you have selected:--"+str, Toast.LENGTH_SHORT).show();

//                    txt.setText("you have selected:--"+str);

                }
            }
        });

    }

    public void setupSpinners() {
        // Create adapter for spinner. The list options are from the String array it will use
        // the spinner will use the default layout
        //populates the quantity spinner ArrayList

        ArrayAdapter<String> statesAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, states);

        // Specify dropdown layout style - simple list view with 1 item per line
        statesAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        // Apply the adapter to the spinner
        statesAdapter.notifyDataSetChanged();
        mStateSpinner.setAdapter(statesAdapter);

        // Set the integer mSelected to the constant values
        mStateSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                state = (String) parent.getItemAtPosition(position);
                setUpStatesSpinner(position);
            }

            // Because AdapterView is an abstract class, onNothingSelected must be defined
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Unknown
            }
        });
    }


    /**
     * method to set up the state spinner
     *
     * @param position current position of the spinner
     */
    private void setUpStatesSpinner(int position) {
        List<String> list = new ArrayList<>(Nigeria.getLgasByState(states.get(position)));
        setUpLgaSpinner(list);
    }


    /**
     * Method to set up the local government areas corresponding to selected states
     *
     * @param lgas represents the local government areas of the selected state
     */
    private void setUpLgaSpinner(List<String> lgas) {

        ArrayAdapter lgaAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, lgas);
        lgaAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        lgaAdapter.notifyDataSetChanged();
        mLgaSpinner.setAdapter(lgaAdapter);

        mLgaSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long l) {
                lga = (String) parent.getItemAtPosition(position);
//                Toast.makeText(Building.this, "state: " + mState + " lga: " + mLga, Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
    }

    private void resizeSpinner(Spinner spinner, int height) {
        try {
            Field popup = Spinner.class.getDeclaredField("mPopup");
            popup.setAccessible(true);

            //Get private mPopup member variable and try cast to ListPopupWindow
            android.widget.ListPopupWindow popupWindow = (android.widget.ListPopupWindow) popup.get(spinner);

            //set popupWindow height to height
            popupWindow.setHeight(height);

        } catch (NoClassDefFoundError | ClassCastException | NoSuchFieldException | IllegalAccessException ex) {
            ex.printStackTrace();
        }
    }

    public void onCheckboxClicked(View view) {

        boolean checked = ((CheckBox) view).isChecked();

        switch (view.getId()) {
            case R.id.fever1:
                list.add(fever1.getTag().toString());

                break;
            case R.id.cough1:
                list.add(cough1.getTag().toString());

                break;

            case R.id.breathing1:
                list.add(breathing1.getTag().toString());

                break;
            case R.id.sneezing1:
                list.add(sneezing1.getTag().toString());

                break;
            case R.id.throat1:
                list.add(throat1.getTag().toString());

                break;
            case R.id.headache1:
                list.add(headache1.getTag().toString());

                break;
            case R.id.chest1:
                list.add(chest1.getTag().toString());

                break;
            case R.id.diarrhoea1:
                list.add(diarrhoea1.getTag().toString());

                break;
            case R.id.flu1:
                list.add(flu1.getTag().toString());

                break;

            case R.id.fever2:
                list.add(fever1.getTag().toString());

                break;
            case R.id.cough2:
                list.add(cough1.getTag().toString());

                break;

            case R.id.breathing2:
                list.add(breathing1.getTag().toString());

                break;
            case R.id.sneezing2:
                list.add(sneezing1.getTag().toString());

                break;
            case R.id.throat2:
                list.add(throat1.getTag().toString());

                break;
            case R.id.headache2:
                list.add(headache1.getTag().toString());

                break;
            case R.id.chest2:
                list.add(chest1.getTag().toString());

                break;
            case R.id.diarrhoea2:
                list.add(diarrhoea1.getTag().toString());

                break;
            case R.id.flu2:
                list.add(flu1.getTag().toString());

                break;

        }

    }

}
