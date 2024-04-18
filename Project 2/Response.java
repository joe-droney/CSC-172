public class Response {
    private int id;
    private String gender;
    private int age;
    private int residence;
    private int education;
    private int incomeSource;
    private int maritalStatus;
    private int smoker;
    private int year;
    private String q9;
    private int q10;
    private int q11;
    private int q12;
    private int q13;
    private int q14;
    private int q15;
    private String q16;
    private int q17;
    private int q18;
    private int q19;
    private int q20;
    private int q21;
    private int q22;
    private String q23;
    private int q24;
    private int q25;
    private int q26;
    private int q27;
    private int q28;
    private int q29;
    private int q30;
    private int quality;

    public Response(int id, String string, int age, int residence, int education, int incomeSource, int maritalStatus, int smoker, int year, String q9, int q10, int q11, int q12, int q13, int q14, int q15, String q16, int q17, int q18, int q19, int q20, int q21, int q22, String q23, int q24, int q25, int q26, int q27, int q28, int q29, int q30) {
        this.id = id;
        this.setGender(string);
        this.age = age;
        this.residence = residence;
        this.education = education;
        this.incomeSource = incomeSource;
        this.maritalStatus = maritalStatus;
        this.smoker = smoker;
        this.year = year;
        this.q9 = q9;
        this.q10 = q10;
        this.q11 = q11;
        this.q12 = q12;
        this.q13 = q13;
        this.q14 = q14;
        this.q15 = q15;
        this.q16 = q16;
        this.q17 = q17;
        this.q18 = q18;
        this.q19 = q19;
        this.q20 = q20;
        this.q21 = q21;
        this.q22 = q22;
        this.q23 = q23;
        this.q24 = q24;
        this.q25 = q25;
        this.q26 = q26;
        this.q27 = q27;
        this.q28 = q28;
        this.q29 = q29;
        this.q30 = q30;
        this.calculateQuality();
    }

    public int getId() {
        return id;
    }

    public String getGender() {
        return gender;
    }

    private void setGender(String string) {
        switch (string) {
            case "F":
                this.gender = "F";
                break;
            case "M":
                this.gender = "M";
                break;
            
            default:
                this.gender = "-";
                break;
        }
    }

    public int getAge() {
        return age;
    }

    public int getResidence() {
        return residence;
    }

    public int getEducation() {
        return education;
    }

    public int getIncomeSource() {
        return incomeSource;
    }

    public int getMaritalStatus() {
        return maritalStatus;
    }

    public int getSmoker() {
        return smoker;
    }

    public int getYear() {
        return year;
    }

    public String getQ9() {
        return q9;
    }

    public int getQ10() {
        return q10;
    }

    public int getQ11() {
        return q11;
    }

    public int getQ12() {
        return q12;
    }

    public int getQ13() {
        return q13;
    }

    public int getQ14() {
        return q14;
    }

    public int getQ15() {
        return q15;
    }

    public String getQ16() {
        return q16;
    }

    public int getQ17() {
        return q17;
    }

    public int getQ18() {
        return q18;
    }

    public int getQ19() {
        return q19;
    }

    public int getQ20() {
        return q20;
    }

    public int getQ21() {
        return q21;
    }

    public int getQ22() {
        return q22;
    }

    public String getQ23() {
        return q23;
    }

    public int getQ24() {
        return q24;
    }

    public int getQ25() {
        return q25;
    }

    public int getQ26() {
        return q26;
    }

    public int getQ27() {
        return q27;
    }

    public int getQ28() {
        return q28;
    }

    public int getQ29() {
        return q29;
    }

    public int getQ30() {
        return q30;
    }

    public int getQuality() {
        return quality;
    }

    private void calculateQuality() {
        quality = q13 + q14 + q15 + q17 + q18 + q19 + q21 + q22 + q24 + q25 + q26 + q27 + q28 + q29 + q30;
    }

    public void printResponse() {
        System.out.println("Response ID: " + id);
        System.out.println("Gender: " + gender);
        System.out.println("Age group: " + getAgeGroup());
        System.out.println("Place of residence: " + residence);
        System.out.println("Education level: " + education);
        System.out.println("Source of income: " + incomeSource);
        System.out.println("Marital status: " + maritalStatus);
        System.out.println("Smoker: " + (smoker == 1 ? "Yes" : "No"));
    }

    private String getAgeGroup() {
        if (age < 30) {
            return "1";
        } else if (age >= 30 && age < 50) {
            return "2";
        } else {
            return "3";
        }
    }
}
