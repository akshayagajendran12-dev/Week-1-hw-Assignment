public class BMICalculator {

    public static String getBmiStatus(double bmi) {
        if (bmi < 18.5) {
            return "Underweight";
        } else if (bmi < 25.0) {
            return "Normal";
        } else if (bmi < 30.0) {
            return "Overweight";
        } else {
            return "Obese";
        }
    }

    public static void printWellnessReport(
            double[] heights, double[] weights) {

        System.out.printf("%-10s %-12s %-12s %-12s %-15s%n",
                "Person", "Height(m)", "Weight(kg)", "BMI", "Status");

        System.out.println(
                "---------------------------------------------------------------");

        for (int i = 0; i < heights.length; i++) {
            double bmi = weights[i] / (heights[i] * heights[i]);

            System.out.printf("%-10d %-12.2f %-12.2f %-12.2f %-15s%n",
                    i + 1, heights[i], weights[i],
                    bmi, getBmiStatus(bmi));
        }
    }

    public static void main(String[] args) {
        double[] heights = {
            1.75, 1.60, 1.80, 1.65, 1.70,
            1.55, 1.85, 1.72, 1.68, 1.90
        };

        double[] weights = {
            70, 90, 85, 55, 78,
            48, 95, 68, 72, 80
        };

        printWellnessReport(heights, weights);
    }
}
