package com.example.convid_19selfscreeningtool;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.ikhiloyaimokhai.nigeriastatesandlgas.Nigeria;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private static final int SPINNER_HEIGHT = 500;
    EditText mFullname, mAge, mCommunity, mPhonenumber;
    //    Spinner stateSpinner;
    //declaring the radio group;
    RadioGroup mCough, mFever, mDifficultyInBreathing, mSneezing, mChestPain, mDiarrhoea, mFlu, mSoreThroatSymptoms,
            mContactWithFever, mContactWithCough, mContactWithDifficultBreathing, mContactWithSneeze, mContactWithChestpain,
            mContactWithDiarrhoea, mContactWithOtherFlu, mContactWithSoreThroat, mUnderlyingConditions, mSpecifyKidney, mSpecifyPregnancy,
            mSpecifyTB, mSpecifyDiabetes, mSpecifyLiver, mSpecifyChronicLungDisease, mSpecifyCancer, mSpecifyHeartDisease, mContactWithSuspectedCase,
            mContactWithConfirmedCase, mSpecifyHIV, mTreatment, mEnoughDrugsForThreeMonths;
    //declaring radio buttons
    RadioButton rbFever, rbCough, rbDifficultyInBreathing, rbSneezing, rbChestPain, rbDiarrhoea, rbFlu, rbSoreThroatSymptoms, rbSpecifyCancer,
            rbContactWithFever, rbContactWithCough, rbContactWithDifficultBreathing, rbContactWithSneeze, rbContactWithChestpain, rbSpecifyKidney, rbSpecifyTB,
            rbContactWithDiarrhoea, rbContactWithOtherFlu, rbContactWithSoreThroat, rbUnderlyingConditions, rbSpecifyPregnancy, rbSpecifyDiabetes, rbSpecifyLiver,
            rbSpecifyHeartDisease, rbSpecifyChronicLungDisease, rbContactWithSuspectedCase, rbContactWithConfirmedCase, rbSpecifyHIV, rbTreatment, rbEnoughDrugsForThreeMonths;
    Button mBtn_submit;
    ProgressBar mProgressBar;
    private Spinner mStateSpinner, mLgaSpinner, mGenderSpinner;
    private String mState, mLga, mGender;
    private List<String> states;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mStateSpinner = findViewById(R.id.stateSpinner);
        mLgaSpinner = findViewById(R.id.lgaSpinner);
        resizeSpinner(mStateSpinner, SPINNER_HEIGHT);
        resizeSpinner(mLgaSpinner, SPINNER_HEIGHT);

        states = Nigeria.getStates();

        //call to method that'll set up state and lga spinner
        setupSpinners();

        mGenderSpinner = findViewById(R.id.genderSpinner);

        mFullname = findViewById(R.id.edit_text_fullname);
        mAge = findViewById(R.id.edit_text_age);
        mCommunity = findViewById(R.id.edit_text_community);
        mPhonenumber = findViewById(R.id.edit_text_phone);


        mProgressBar = findViewById(R.id.progressBar);

        mFever = findViewById(R.id.radio_fever);
        mCough = findViewById(R.id.radio_cough);
        mDifficultyInBreathing = findViewById(R.id.radio_difficultBreathing);
        mSneezing = findViewById(R.id.radio_sneezingSymptoms);
        mChestPain = findViewById(R.id.radio_chestpainSymptoms);
        mDiarrhoea = findViewById(R.id.radio_diarrhoeaSymptoms);
        mFlu = findViewById(R.id.radio_fluSymptoms);
        mSoreThroatSymptoms = findViewById(R.id.radio_soreSymptoms);
        mContactWithFever = findViewById(R.id.radio_contactWithFever);
        mContactWithCough = findViewById(R.id.radio_contactWithCough);
        mContactWithDifficultBreathing = findViewById(R.id.radio_contactWithDifficultBreathing);
        mContactWithSneeze = findViewById(R.id.radio_contactWithSneeze);
        mContactWithChestpain = findViewById(R.id.radio_contactWithChestpain);
        mContactWithDiarrhoea = findViewById(R.id.radio_contactWithDiarrhoea);
        mContactWithOtherFlu = findViewById(R.id.radio_contactWithOtherFLu);
        mContactWithSoreThroat = findViewById(R.id.radio_contactWithSoreThroat);
        mUnderlyingConditions = findViewById(R.id.radio_condition);
        mSpecifyTB = findViewById(R.id.specifyTB);
        mSpecifyDiabetes = findViewById(R.id.radio_specifyDiabetes);
        mSpecifyLiver = findViewById(R.id.radio_specifyLiverDisease);
        mSpecifyChronicLungDisease = findViewById(R.id.radio_chronicLungDisease);
        mSpecifyCancer = findViewById(R.id.radio_specifyCancer);
        mSpecifyHeartDisease = findViewById(R.id.radio_heartDisease);
        mContactWithConfirmedCase = findViewById(R.id.radio_contactWithConfirmedCase);

        mContactWithSuspectedCase = findViewById(R.id.radio_contactWithSuspectedCase);

        mSpecifyKidney = findViewById(R.id.radio_specifyKidney);
        mSpecifyPregnancy = findViewById(R.id.radio_specifyPregnancy);
        mSpecifyHIV = findViewById(R.id.specifyHIV);
        mTreatment = findViewById(R.id.treatment);
        mEnoughDrugsForThreeMonths = findViewById(R.id.enoughDrugsForThreeMonths);

        mBtn_submit = findViewById(R.id.btn_submit);


        mProgressBar.setVisibility(View.GONE);

        mBtn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fullname = mFullname.getText().toString().trim();
                String age = mAge.getText().toString().trim();
                String phone = mPhonenumber.getText().toString();
                String gender = String.valueOf(mGenderSpinner.getSelectedItem());
                String state = String.valueOf(mStateSpinner.getSelectedItem());
                String lga = String.valueOf(mLgaSpinner.getSelectedItem());
                String community = mCommunity.getText().toString().trim();
                String feverSymptom = rbFever.getText().toString();
                String coughSymptom = rbCough.getText().toString();
                String difficultyInBreathingSymptom = rbDifficultyInBreathing.getText().toString();
                String sneezingSymptoms = rbSneezing.getText().toString();
                String chestPainSymptoms = rbChestPain.getText().toString();
                String diarrhoeaSymptoms = rbDiarrhoea.getText().toString();
                String fluSymptoms = rbFlu.getText().toString();
                String soreThroatSymptoms = rbSoreThroatSymptoms.getText().toString();
                String contactWithFever = rbContactWithFever.getText().toString();
                String contactWithCough = rbContactWithCough.getText().toString();
                String contactWithDifficultBreathing = rbContactWithDifficultBreathing.getText().toString();
                String contactWithSneeze = rbContactWithSneeze.getText().toString();
                String contactWithChestpain = rbContactWithDiarrhoea.getText().toString();
                String contactWithDiarrhoea = rbContactWithDiarrhoea.getText().toString();
                String contactWithOtherFlu = rbContactWithOtherFlu.getText().toString();
                String contactWithSoreThroat = rbContactWithSoreThroat.getText().toString();
                String underlyingConditions = rbUnderlyingConditions.getText().toString();
                String specifyKidney = rbSpecifyKidney.getText().toString();
                String specifyPregnancy = rbSpecifyPregnancy.getText().toString();
                String specifyTB = rbSpecifyTB.getText().toString();
                String specifyDiabetes = rbSpecifyDiabetes.getText().toString();
                String specifyLiver = rbSpecifyLiver.getText().toString();
                String specifyChronicLungDisease = rbSpecifyChronicLungDisease.getText().toString();
                String specifyCancer = rbSpecifyCancer.getText().toString();
                String specifyHeartDisease = rbSpecifyHeartDisease.getText().toString();
                String contactWithSuspectedCase = rbContactWithSuspectedCase.getText().toString();
                String contactWithConfirmedCase = rbContactWithConfirmedCase.getText().toString();
                String specifyHIV = rbSpecifyHIV.getText().toString();
                String treatment = rbTreatment.getText().toString();
                String enoughDrugsForThreeMonths = rbEnoughDrugsForThreeMonths.getText().toString();

                if (TextUtils.isEmpty(fullname)) {
                    mFullname.setError("Please Enter your Full name!");
                    mFullname.requestFocus();
                    return;
                }

                if (TextUtils.isEmpty(age)) {
                    mAge.setError("Please Enter your Age!");
                    mAge.requestFocus();
                    return;
                }
                if (TextUtils.isEmpty(phone)) {
                    mPhonenumber.setError("Please Enter Phone Number");
                    mPhonenumber.requestFocus();
                    return;
                }
                if (phone.length() != 11 && (phone.startsWith("070") || phone.startsWith("080")
                        || phone.startsWith("090")) || phone.startsWith("081")) {
                    mPhonenumber.setError("Enter a valid Phone Number!");
                    mPhonenumber.requestFocus();
                    return;
                }

                if (TextUtils.isEmpty(community)) {
                    mCommunity.setError("Please Enter your Community!");
                    mCommunity.requestFocus();
                    return;
                }

                mProgressBar.setVisibility(View.VISIBLE);
                Patients patients;
                patients = new Patients(fullname, age, phone, gender, community, feverSymptom,
                        coughSymptom, difficultyInBreathingSymptom, sneezingSymptoms, chestPainSymptoms,
                        diarrhoeaSymptoms, fluSymptoms, soreThroatSymptoms, contactWithFever, contactWithCough,
                        contactWithDifficultBreathing, contactWithSneeze, contactWithChestpain, contactWithDiarrhoea,
                        contactWithOtherFlu, contactWithSoreThroat, underlyingConditions, specifyKidney, specifyPregnancy,
                        specifyTB, specifyDiabetes, specifyLiver, specifyChronicLungDisease, specifyCancer, specifyHeartDisease,
                        contactWithSuspectedCase, contactWithConfirmedCase, specifyTB, treatment, enoughDrugsForThreeMonths
                );
                patients.setFullname(fullname);
                patients.setPhone(phone);
                patients.setState(state);
                patients.setGender(gender);
                patients.setLga(lga);
                patients.setAge(age);
                patients.setCommunity(community);
                patients.setFeverSymptom(feverSymptom);
                patients.setCoughSymptom(coughSymptom);
                patients.setDifficultyInBreathingSymptom(difficultyInBreathingSymptom);
                patients.setSneezingSymptoms(sneezingSymptoms);
                patients.setChestPainSymptoms(chestPainSymptoms);
                patients.setDiarrhoeaSymptoms(diarrhoeaSymptoms);
                patients.setSoreThroatSymptoms(soreThroatSymptoms);
                patients.setSpecifyKidney(specifyKidney);
                patients.setSpecifyPregnancy(specifyPregnancy);
                patients.setSpecifyTB(specifyTB);
                patients.setSpecifyDiabetes(specifyDiabetes);
                patients.setSpecifyLiver(specifyLiver);
                patients.setSpecifyChronicLungDisease(specifyChronicLungDisease);
                patients.setSpecifyCancer(specifyCancer);
                patients.setSpecifyHeartDisease(specifyHeartDisease);
                patients.setContactWithSuspectedCase(contactWithSuspectedCase);
                patients.setSpecifyHIV(specifyHIV);
                patients.setTreatment(treatment);
                patients.setEnoughDrugsForThreeMonths(enoughDrugsForThreeMonths);


                //Get database reference
                final DatabaseReference mPatients = FirebaseDatabase.getInstance().getReference("patients");
                //keep in sync
                mPatients.keepSynced(true);
                // new patient node would be created
                String patientData = mPatients.push().getKey();
                //System.out.println("Record - " + patientData);
                // pushing user to 'users' node using the userId
                assert patientData != null;
                //Task<Void> saveData = mPatients.child(patientData).child(fullname).setValue(patients);
                Task<Void> saveData = mPatients.child(fullname).child(fullname).setValue(patients);
                if (!saveData.isSuccessful()) {
                    if ((contactWithConfirmedCase.equals("Yes"))
                            &&((specifyCancer.equals("Yes")
                            || specifyPregnancy.equals("Yes")
                            || difficultyInBreathingSymptom.equals("Yes")
                            || specifyKidney.equals("Yes")
                            || specifyTB.equals("Yes")
                            || specifyDiabetes.equals("Yes")
                            || underlyingConditions.equals("Yes")
                            || specifyChronicLungDisease.equals("Yes")
                            || specifyHeartDisease.equals("Yes")))) {
                        Intent highRiskIntent = new Intent(MainActivity.this, HighRiskActivity.class);
                        startActivity(highRiskIntent);
                        finish();
                        Toast.makeText(MainActivity.this, "Data Saved Successfully", Toast.LENGTH_LONG).show();
                        mProgressBar.setVisibility(View.GONE);
                    } else if ((contactWithSuspectedCase.equals("Yes"))
                            &&((contactWithSneeze.equals("Yes")
                            || contactWithSoreThroat.equals("Yes")
                            || contactWithDifficultBreathing.equals("Yes")
                            || contactWithChestpain.equals("Yes")
                            || contactWithDiarrhoea.equals("Yes")
                            || contactWithCough.equals("Yes")
                            || contactWithFever.equals("Yes")
                            || contactWithOtherFlu.equals("Yes")))) {
                        Intent mediumRiskIntent = new Intent(MainActivity.this, MediumRiskActivity.class);
                        startActivity(mediumRiskIntent);
                        finish();

                        Toast.makeText(MainActivity.this, "Data Saved Successfully", Toast.LENGTH_LONG).show();
                        mProgressBar.setVisibility(View.GONE);

                    } else if ((specifyHIV.equals("Yes")) && (treatment.equals("No") || enoughDrugsForThreeMonths.equals("Yes"))) {
                        Intent hvIntent = new Intent(MainActivity.this, HivActivity.class);
                        startActivity(hvIntent);
                        finish();

                    } else {
                        Intent lowRiskIntent = new Intent(MainActivity.this, LowRiskActivity.class);
                        startActivity(lowRiskIntent);
                        finish();

                        Toast.makeText(MainActivity.this, "Data Saved Successfully", Toast.LENGTH_LONG).show();
                        mProgressBar.setVisibility(View.GONE);
                    }

                } else {
                    Toast.makeText(MainActivity.this, "Error Saving Data", Toast.LENGTH_SHORT).show();
                    mProgressBar.setVisibility(View.GONE);
                }
            }
        });


        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.gender_array, android.R.layout.simple_spinner_dropdown_item);
// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        mGenderSpinner.setAdapter(adapter);
    }


    /**
     * Method to set up the spinners
     */
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
                mState = (String) parent.getItemAtPosition(position);
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
                mLga = (String) parent.getItemAtPosition(position);
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

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        int radioButtonId2 = mFever.getCheckedRadioButtonId();
        rbFever = findViewById(radioButtonId2);

        int radioButtonId3 = mCough.getCheckedRadioButtonId();
        rbCough = findViewById(radioButtonId3);

        int radioButtonId4 = mDifficultyInBreathing.getCheckedRadioButtonId();
        rbDifficultyInBreathing = findViewById(radioButtonId4);

        int radioButtonId5 = mSneezing.getCheckedRadioButtonId();
        rbSneezing = findViewById(radioButtonId5);

        int radioButtonId6 = mChestPain.getCheckedRadioButtonId();
        rbChestPain = findViewById(radioButtonId6);

        int radioButtonId7 = mDiarrhoea.getCheckedRadioButtonId();
        rbDiarrhoea = findViewById(radioButtonId7);

        int radioButtonId8 = mFlu.getCheckedRadioButtonId();
        rbFlu = findViewById(radioButtonId8);

        int radioButtonId9 = mSoreThroatSymptoms.getCheckedRadioButtonId();
        rbSoreThroatSymptoms = findViewById(radioButtonId9);

        int radioButtonId10 = mContactWithFever.getCheckedRadioButtonId();
        rbContactWithFever = findViewById(radioButtonId10);

        int radioButtonId11 = mContactWithCough.getCheckedRadioButtonId();
        rbContactWithCough = findViewById(radioButtonId11);

        int radioButtonId12 = mContactWithDifficultBreathing.getCheckedRadioButtonId();
        rbContactWithDifficultBreathing = findViewById(radioButtonId12);

        int radioButtonId13 = mContactWithSneeze.getCheckedRadioButtonId();
        rbContactWithSneeze = findViewById(radioButtonId13);

        int radioButtonId14 = mContactWithChestpain.getCheckedRadioButtonId();
        rbContactWithChestpain = findViewById(radioButtonId14);

        int radioButtonId15 = mContactWithDiarrhoea.getCheckedRadioButtonId();
        rbContactWithDiarrhoea = findViewById(radioButtonId15);

        int radioButtonId16 = mContactWithOtherFlu.getCheckedRadioButtonId();
        rbContactWithOtherFlu = findViewById(radioButtonId16);

        int radioButtonId17 = mContactWithSoreThroat.getCheckedRadioButtonId();
        rbContactWithSoreThroat = findViewById(radioButtonId17);

        int radioButtonId18 = mUnderlyingConditions.getCheckedRadioButtonId();
        rbUnderlyingConditions = findViewById(radioButtonId18);

        int radioButtonId19 = mSpecifyKidney.getCheckedRadioButtonId();
        rbSpecifyKidney = findViewById(radioButtonId19);

        int radioButtonId20 = mSpecifyPregnancy.getCheckedRadioButtonId();
        rbSpecifyPregnancy = findViewById(radioButtonId20);

        int radioButtonId21 = mSpecifyTB.getCheckedRadioButtonId();
        rbSpecifyTB = findViewById(radioButtonId21);

        int radioButtonId22 = mSpecifyDiabetes.getCheckedRadioButtonId();
        rbSpecifyDiabetes = findViewById(radioButtonId22);

        int radioButtonId23 = mSpecifyLiver.getCheckedRadioButtonId();
        rbSpecifyLiver = findViewById(radioButtonId23);
        int radioButtonId24 = mSpecifyChronicLungDisease.getCheckedRadioButtonId();
        rbSpecifyChronicLungDisease = findViewById(radioButtonId24);

        int radioButtonId25 = mSpecifyCancer.getCheckedRadioButtonId();
        rbSpecifyCancer = findViewById(radioButtonId25);

        int radioButtonId26 = mSpecifyHeartDisease.getCheckedRadioButtonId();
        rbSpecifyHeartDisease = findViewById(radioButtonId26);

        int radioButtonId27 = mContactWithSuspectedCase.getCheckedRadioButtonId();
        rbContactWithSuspectedCase = findViewById(radioButtonId27);

        int radioButtonId28 = mContactWithConfirmedCase.getCheckedRadioButtonId();
        rbContactWithConfirmedCase = findViewById(radioButtonId28);

        int radioButtonId30 = mSpecifyHIV.getCheckedRadioButtonId();
        rbSpecifyHIV = findViewById(radioButtonId30);

        int radioButtonId31 = mTreatment.getCheckedRadioButtonId();
        rbTreatment = findViewById(radioButtonId31);

        int radioButtonId32 = mEnoughDrugsForThreeMonths.getCheckedRadioButtonId();
        rbEnoughDrugsForThreeMonths = findViewById(radioButtonId32);


        switch (view.getId()) {
            case R.id.radio_condition_no:
                if (checked)
                    findViewById(R.id.first_group).setVisibility(View.GONE);
                break;

            case R.id.radio_condition_yes:
                if (checked)
                    findViewById(R.id.first_group).setVisibility(View.VISIBLE);
                break;
        }

        switch (view.getId()) {
            case R.id.radio_specifyHIV_no:
                if (checked)
                    findViewById(R.id.second_group).setVisibility(View.GONE);
                break;

            case R.id.radio_specifyHIV_yes:
                if (checked)
                    findViewById(R.id.second_group).setVisibility(View.VISIBLE);
                break;
        }
    }

}