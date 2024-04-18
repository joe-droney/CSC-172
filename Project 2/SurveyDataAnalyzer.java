import java.util.Arrays;

public class SurveyDataAnalyzer {

    // Question 1: Gender Distribution
    public static int[] genderDistribution(CustomHashTable responses) {
        int[] distribution = new int[4];
        for (int i = 1; i <= responses.getNumberOfentires(); i++) {
            Response response = responses.search(i);
            if (response != null) {
                if (response.getGender().equalsIgnoreCase("F")) {
                    distribution[0]++;
                } else if (response.getGender().equalsIgnoreCase("M")) {
                    distribution[1]++;
                } else if (response.getGender().equalsIgnoreCase("O")) {
                    distribution[2]++;
                } else if (response.getGender().equalsIgnoreCase("-")) {
                    distribution[3]++;
                }
            }
        }
        return distribution;
    }

    // Question 2: Age Group Distribution
    public static int[] ageGroupDistribution(CustomHashTable customHashTable) {
        int[] ageGroupCounts = new int[4]; // Array to store counts for each age group
        for (int i = 1; i <= customHashTable.getNumberOfentires(); i++) {
            Response response = customHashTable.search(i);
            if (response != null) {
                int age = response.getAge();
                if (age < 30) {
                    ageGroupCounts[0]++;
                } else if (age >= 30 && age < 50) {
                    ageGroupCounts[1]++;
                } else if (age >= 50 && age < 70) {
                    ageGroupCounts[2]++;
                } else {
                    ageGroupCounts[3]++;
                }
            }
        }
        return ageGroupCounts;
    }

    // Question 3: Residence Distribution
    public static int[] residenceDistribution(CustomHashTable customHashTable) {
        int[] residenceCounts = new int[4]; // Array to store counts for each residence type
        for (int i = 1; i <= customHashTable.getNumberOfentires(); i++) {
            Response response = customHashTable.search(i);
            if (response != null) {
                int residence = response.getResidence();
                residenceCounts[residence - 1]++;
            }
        }
        return residenceCounts;
    }

    // Question 4: Education Distribution
    public static int[] educationDistribution(CustomHashTable customHashTable) {
        int[] educationCounts = new int[4]; // Array to store counts for each education level
        for (int i = 1; i <= customHashTable.getNumberOfentires(); i++) {
            Response response = customHashTable.search(i);
            if (response != null) {
                int education = response.getEducation();
                educationCounts[education - 1]++;
            }
        }
        return educationCounts;
    }

    // Question 5: Income Distribution
    public static int[] incomeDistribution(CustomHashTable customHashTable) {
        int[] incomeCounts = new int[4]; // Array to store counts for each income source
        for (int i = 1; i <= customHashTable.getNumberOfentires(); i++) {
            Response response = customHashTable.search(i);
            if (response != null) {
                int incomeSource = response.getIncomeSource();
                incomeCounts[incomeSource - 1]++;
            }
        }
        return incomeCounts;
    }

    // Question 6: Marital Distribution
    public static int[] maritalDistribution(CustomHashTable customHashTable) {
        int[] maritalCounts = new int[4]; // Array to store counts for each marital status
        for (int i = 1; i <= customHashTable.getNumberOfentires(); i++) {
            Response response = customHashTable.search(i);
            if (response != null) {
                int maritalStatus = response.getMaritalStatus();
                maritalCounts[maritalStatus - 1]++;
            }
        }
        return maritalCounts;
    }

    // Question 7: Smoker Distribution
    public static int[] smokerDistribution(CustomHashTable responses) {
        int[] distribution = new int[2];
        for (int i = 1; i <= responses.getNumberOfentires(); i++) {
            Response response = responses.search(i);
            if (response != null) {
                if (response.getSmoker() == 1) {
                    distribution[0]++;
                } else if (response.getSmoker() == 2) {
                    distribution[1]++;
                }
            }
        }
        return distribution;
    }

    // Question 8: Average Life Quality of All Respondents
    public static double lifeQualityGeneral(CustomHashTable customHashTable) {
        double totalQuality = 0;
        for (int i = 1; i <= customHashTable.getNumberOfentires(); i++) {
            Response response = customHashTable.search(i);
            if (response != null) {
                totalQuality += response.getQuality();
            }
        }
        return totalQuality / customHashTable.getNumberOfentires();
    }

    // Question 9: Average Life Quality Based on Gender
    public static double[] lifeQualityGenderBased(CustomHashTable responses) {
        double[] avgLifeQuality = new double[4];
        int[] genderDistribution = genderDistribution(responses);
        for (int i = 1; i <= responses.getNumberOfentires(); i++) {
            Response response = responses.search(i);
            if (response != null) {
                if (response.getGender().equalsIgnoreCase("F")) {
                    avgLifeQuality[0] += response.getQuality();
                } else if (response.getGender().equalsIgnoreCase("M")) {
                    avgLifeQuality[1] += response.getQuality();
                } else if (response.getGender().equalsIgnoreCase("O")) {
                    avgLifeQuality[2] += response.getQuality();
                } else if (response.getGender().equalsIgnoreCase("-")) {
                    avgLifeQuality[3] += response.getQuality();
                }
            }
        }
        for (int i = 0; i < 4; i++) {
            if (genderDistribution[i] != 0) {
                avgLifeQuality[i] /= genderDistribution[i];
            }
        }
        return avgLifeQuality;
    }

    public static void main(String[] args) {
        // Read survey data from file into CustomHashTable
        CustomHashTable customHashTable = ReadFile.readResponsesFromFile("responses.txt");

        // Call each analysis method to generate insights
        int[] genderDist = genderDistribution(customHashTable);
        System.out.println("Gender Distribution: " + Arrays.toString(genderDist));

        int[] ageGroupDist = ageGroupDistribution(customHashTable);
        System.out.println("Age Group Distribution: " + Arrays.toString(ageGroupDist));

        int[] residenceDist = residenceDistribution(customHashTable);
        System.out.println("Residence Distribution: " + Arrays.toString(residenceDist));

        int[] educationDist = educationDistribution(customHashTable);
        System.out.println("Education Distribution: " + Arrays.toString(educationDist));

        int[] incomeDist = incomeDistribution(customHashTable);
        System.out.println("Income Distribution: " + Arrays.toString(incomeDist));

        int[] maritalDist = maritalDistribution(customHashTable);
        System.out.println("Marital Distribution: " + Arrays.toString(maritalDist));

        int[] smokerDist = smokerDistribution(customHashTable);
        System.out.println("Smoker Distribution: " + Arrays.toString(smokerDist));

        double lifeQualityGen = lifeQualityGeneral(customHashTable);
        System.out.println("Average Life Quality of All Respondents: " + lifeQualityGen);

        double[] lifeQualityGender = lifeQualityGenderBased(customHashTable);
        System.out.println("Average Life Quality Based on Gender: " + Arrays.toString(lifeQualityGender));

        // Call other analysis methods similarly
    }
}
