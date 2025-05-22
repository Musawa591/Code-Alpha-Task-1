import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SimpleCreditScor {
    
    // Weighting factors for different credit attributes
    private static final Map<String, Integer> attributeWeights = new HashMap<>();
    static {
        attributeWeights.put("income", 30);
        attributeWeights.put("paymentHistory", 25);
        attributeWeights.put("creditUtilization", 20);
        attributeWeights.put("creditHistoryLength", 15);
        attributeWeights.put("debtToIncome", 10);
    }
    
    // Calculate credit score (0-100)
    public static int calculateCreditScore(Map<String, Integer> applicantData) {
        int totalScore = 0;
        int totalWeight = 0;
        
        for (Map.Entry<String, Integer> entry : attributeWeights.entrySet()) {
            String attribute = entry.getKey();
            int weight = entry.getValue();
            
            if (applicantData.containsKey(attribute)) {
                int value = applicantData.get(attribute);
                totalScore += value * weight;
                totalWeight += weight;
            }
        }
        
        return totalWeight > 0 ? totalScore / totalWeight : 0;
    }
    
    // Determine creditworthiness category
    public static String getCreditworthiness(int score) {
        if (score >= 80) return "Excellent";
        if (score >= 70) return "Good";
        if (score >= 60) return "Fair";
        if (score >= 50) return "Poor";
        return "Very Poor";
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Simple Credit Scoring System");
        System.out.println("Enter the following information (1-100 scale):");
        
        Map<String, Integer> applicantData = new HashMap<>();
        
        System.out.print("Income level (1-100): ");
        applicantData.put("income", scanner.nextInt());
        
        System.out.print("Payment history (1-100): ");
        applicantData.put("paymentHistory", scanner.nextInt());
        
        System.out.print("Credit utilization (1-100): ");
        applicantData.put("creditUtilization", scanner.nextInt());
        
        System.out.print("Credit history length (1-100): ");
        applicantData.put("creditHistoryLength", scanner.nextInt());
        
        System.out.print("Debt-to-income ratio (1-100): ");
        applicantData.put("debtToIncome", scanner.nextInt());
        
        int score = calculateCreditScore(applicantData);
        String rating = getCreditworthiness(score);
        
        System.out.println("\nCredit Score Result:");
        System.out.println("Calculated Score: " + score);
        System.out.println("Credit Rating: " + rating);
        
        scanner.close();
    }
}
