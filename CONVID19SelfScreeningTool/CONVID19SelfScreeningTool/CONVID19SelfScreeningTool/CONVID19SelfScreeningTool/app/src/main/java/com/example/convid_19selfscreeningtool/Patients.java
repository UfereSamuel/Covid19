package com.example.convid_19selfscreeningtool;

public class Patients {

    private String fullname;
    private String age;
    private String phone;
    private String gender;
    private String state;
    private String lga;
    private String community;

    private String feverSymptom;
    private String coughSymptom;
    private String difficultyInBreathingSymptom;
    private String sneezingSymptoms;
    private String chestPainSymptoms;
    private String diarrhoeaSymptoms;
    private String fluSymptoms;
    private String soreThroatSymptoms;

    private String contactWithSuspectedCase;
    private String contactWithFever;
    private String contactWithCough;
    private String contactWithDifficultBreathing;
    private String contactWithSneeze;
    private String contactWithChestpain;
    private String contactWithDiarrhoea;
    private String contactWithOtherFLu;
    private String contactWithSoreThroat;

    private String underlyingConditions;
    private String specifyKidney;
    private String specifyPregnancy;
    private String specifyTB;
    private String specifyDiabetes;
    private String specifyLiver;
    private String specifyChronicLungDisease;
    private String specifyCancer;
    private String specifyHeartDisease;
    private String contactWithConfirmedCase;
    private String specifyHIV;
    private String treatment;
    private String enoughDrugsForThreeMonths;

    public Patients(String fullname, String age, String phone, String gender, String state, String lga, String community,
                    String feverSymptom, String coughSymptom, String difficultyInBreathingSymptom, String sneezingSymptoms,
                    String chestPainSymptoms, String diarrhoeaSymptoms, String fluSymptoms, String soreThroatSymptoms,
                    String contactWithSuspectedCase, String contactWithFever, String contactWithCough, String contactWithDifficultBreathing,
                    String contactWithSneeze, String contactWithChestpain, String contactWithDiarrhoea, String contactWithOtherFLu,
                    String contactWithSoreThroat, String underlyingConditions, String specifyKidney, String specifyPregnancy,
                    String specifyTB,
                    String specifyDiabetes, String specifyLiver, String specifyChronicLungDisease, String specifyCancer, String specifyHeartDisease,
                    String contactWithConfirmedCase, String specifyHIV, String treatment, String enoughDrugsForThreeMonths) {
        this.fullname = fullname;
        this.age = age;
        this.phone = phone;
        this.gender = gender;
        this.state = state;
        this.lga = lga;
        this.community = community;
        this.feverSymptom = feverSymptom;
        this.coughSymptom = coughSymptom;
        this.difficultyInBreathingSymptom = difficultyInBreathingSymptom;
        this.sneezingSymptoms = sneezingSymptoms;
        this.chestPainSymptoms = chestPainSymptoms;
        this.diarrhoeaSymptoms = diarrhoeaSymptoms;
        this.fluSymptoms = fluSymptoms;
        this.soreThroatSymptoms = soreThroatSymptoms;
        this.contactWithSuspectedCase = contactWithSuspectedCase;
        this.contactWithFever = contactWithFever;
        this.contactWithCough = contactWithCough;
        this.contactWithDifficultBreathing = contactWithDifficultBreathing;
        this.contactWithSneeze = contactWithSneeze;
        this.contactWithChestpain = contactWithChestpain;
        this.contactWithDiarrhoea = contactWithDiarrhoea;
        this.contactWithOtherFLu = contactWithOtherFLu;
        this.contactWithSoreThroat = contactWithSoreThroat;
        this.underlyingConditions = underlyingConditions;
        this.specifyKidney = specifyKidney;
        this.specifyPregnancy = specifyPregnancy;
        this.specifyTB = specifyTB;
        this.specifyDiabetes = specifyDiabetes;
        this.specifyLiver = specifyLiver;
        this.specifyChronicLungDisease = specifyChronicLungDisease;
        this.specifyCancer = specifyCancer;
        this.specifyHeartDisease = specifyHeartDisease;
        this.contactWithConfirmedCase = contactWithConfirmedCase;
        this.specifyHIV = specifyHIV;
        this.treatment = treatment;
        this.enoughDrugsForThreeMonths = enoughDrugsForThreeMonths;
    }

    public Patients(String fullname, String age, String phone, String gender, String community, String feverSymptom, String coughSymptom, String difficultyInBreathingSymptom, String sneezingSymptoms, String chestPainSymptoms, String diarrhoeaSymptoms, String fluSymptoms, String soreThroatSymptoms, String contactWithFever, String contactWithCough, String contactWithDifficultBreathing, String contactWithSneeze, String contactWithChestpain, String contactWithDiarrhoea, String contactWithOtherFlu, String contactWithSoreThroat, String underlyingConditions, String specifyKidney, String specifyPregnancy, String specifyTB, String specifyDiabetes, String specifyLiver, String specifyChronicLungDisease, String specifyCancer, String specifyHeartDisease, String contactWithSuspectedCase, String contactWithConfirmedCase, String specifyTB1, String treatment, String enoughDrugsForThreeMonths) {
    }




    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getLga() {
        return lga;
    }

    public void setLga(String lga) {
        this.lga = lga;
    }

    public String getCommunity() {
        return community;
    }

    public void setCommunity(String community) {
        this.community = community;
    }

    public String getFeverSymptom() {
        return feverSymptom;
    }

    public void setFeverSymptom(String feverSymptom) {
        this.feverSymptom = feverSymptom;
    }

    public String getCoughSymptom() {
        return coughSymptom;
    }

    public void setCoughSymptom(String coughSymptom) {
        this.coughSymptom = coughSymptom;
    }

    public String getDifficultyInBreathingSymptom() {
        return difficultyInBreathingSymptom;
    }

    public void setDifficultyInBreathingSymptom(String difficultyInBreathingSymptom) {
        this.difficultyInBreathingSymptom = difficultyInBreathingSymptom;
    }

    public String getSneezingSymptoms() {
        return sneezingSymptoms;
    }

    public void setSneezingSymptoms(String sneezingSymptoms) {
        this.sneezingSymptoms = sneezingSymptoms;
    }

    public String getChestPainSymptoms() {
        return chestPainSymptoms;
    }

    public void setChestPainSymptoms(String chestPainSymptoms) {
        this.chestPainSymptoms = chestPainSymptoms;
    }

    public String getDiarrhoeaSymptoms() {
        return diarrhoeaSymptoms;
    }

    public void setDiarrhoeaSymptoms(String diarrhoeaSymptoms) {
        this.diarrhoeaSymptoms = diarrhoeaSymptoms;
    }

    public String getFluSymptoms() {
        return fluSymptoms;
    }

    public void setFluSymptoms(String fluSymptoms) {
        this.fluSymptoms = fluSymptoms;
    }

    public String getSoreThroatSymptoms() {
        return soreThroatSymptoms;
    }

    public void setSoreThroatSymptoms(String soreThroatSymptoms) {
        this.soreThroatSymptoms = soreThroatSymptoms;
    }

    public String getContactWithSuspectedCase() {
        return contactWithSuspectedCase;
    }

    public void setContactWithSuspectedCase(String contactWithSuspectedCase) {
        this.contactWithSuspectedCase = contactWithSuspectedCase;
    }

    public String getContactWithFever() {
        return contactWithFever;
    }

    public void setContactWithFever(String contactWithFever) {
        this.contactWithFever = contactWithFever;
    }

    public String getContactWithCough() {
        return contactWithCough;
    }

    public void setContactWithCough(String contactWithCough) {
        this.contactWithCough = contactWithCough;
    }

    public String getContactWithDifficultBreathing() {
        return contactWithDifficultBreathing;
    }

    public void setContactWithDifficultBreathing(String contactWithDifficultBreathing) {
        this.contactWithDifficultBreathing = contactWithDifficultBreathing;
    }

    public String getContactWithSneeze() {
        return contactWithSneeze;
    }

    public void setContactWithSneeze(String contactWithSneeze) {
        this.contactWithSneeze = contactWithSneeze;
    }

    public String getContactWithChestpain() {
        return contactWithChestpain;
    }

    public void setContactWithChestpain(String contactWithChestpain) {
        this.contactWithChestpain = contactWithChestpain;
    }

    public String getContactWithDiarrhoea() {
        return contactWithDiarrhoea;
    }

    public void setContactWithDiarrhoea(String contactWithDiarrhoea) {
        this.contactWithDiarrhoea = contactWithDiarrhoea;
    }

    public String getContactWithOtherFLu() {
        return contactWithOtherFLu;
    }

    public void setContactWithOtherFLu(String contactWithOtherFLu) {
        this.contactWithOtherFLu = contactWithOtherFLu;
    }

    public String getContactWithSoreThroat() {
        return contactWithSoreThroat;
    }

    public void setContactWithSoreThroat(String contactWithSoreThroat) {
        this.contactWithSoreThroat = contactWithSoreThroat;
    }

    public String getUnderlyingConditions() {
        return underlyingConditions;
    }

    public void setUnderlyingConditions(String underlyingConditions) {
        this.underlyingConditions = underlyingConditions;
    }

    public String getSpecifyKidney() {
        return specifyKidney;
    }

    public void setSpecifyKidney(String specifyKidney) {
        this.specifyKidney = specifyKidney;
    }

    public String getSpecifyPregnancy() {
        return specifyPregnancy;
    }

    public void setSpecifyPregnancy(String specifyPregnancy) {
        this.specifyPregnancy = specifyPregnancy;
    }

    public String getSpecifyTB() {
        return specifyTB;
    }

    public void setSpecifyTB(String specifyTB) {
        this.specifyTB = specifyTB;
    }

    public String getSpecifyDiabetes() {
        return specifyDiabetes;
    }

    public void setSpecifyDiabetes(String specifyDiabetes) {
        this.specifyDiabetes = specifyDiabetes;
    }

    public String getSpecifyLiver() {
        return specifyLiver;
    }

    public void setSpecifyLiver(String specifyLiver) {
        this.specifyLiver = specifyLiver;
    }

    public String getSpecifyChronicLungDisease() {
        return specifyChronicLungDisease;
    }

    public void setSpecifyChronicLungDisease(String specifyChronicLungDisease) {
        this.specifyChronicLungDisease = specifyChronicLungDisease;
    }

    public String getSpecifyCancer() {
        return specifyCancer;
    }

    public void setSpecifyCancer(String specifyCancer) {
        this.specifyCancer = specifyCancer;
    }

    public String getSpecifyHeartDisease() {
        return specifyHeartDisease;
    }

    public void setSpecifyHeartDisease(String specifyHeartDisease) {
        this.specifyHeartDisease = specifyHeartDisease;
    }

    public String getContactWithConfirmedCase() {
        return contactWithConfirmedCase;
    }

    public void setContactWithConfirmedCase(String contactWithConfirmedCase) {
        this.contactWithConfirmedCase = contactWithConfirmedCase;
    }
    
    public String getSpecifyHIV(){
        return specifyHIV;
    }
    public void setSpecifyHIV(String specifyHIV){
        this.specifyHIV = specifyHIV;
    }

    public String getTreatment() {
        return treatment;
    }

    public void setTreatment(String treatment) {
        this.treatment = treatment;
    }

    public String getEnoughDrugsForThreeMonths() {
        return enoughDrugsForThreeMonths;
    }

    public void setEnoughDrugsForThreeMonths(String enoughDrugsForThreeMonths) {
        this.enoughDrugsForThreeMonths = enoughDrugsForThreeMonths;
    }
}