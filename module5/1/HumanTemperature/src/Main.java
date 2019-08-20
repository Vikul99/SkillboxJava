public class Main {
    public static void main(String[] args) {
        double[] patientTemperature = new double[30];

        int healthyPatientCount = 0;
        double temperature = 0.0;
        for (int i = 0; i < patientTemperature.length; ++i) {
            patientTemperature[i] = 32.0 + Math.random() * 8.0;
            temperature += patientTemperature[i];
            if (patientTemperature[i] > 36.2 && patientTemperature[i] < 36.9) {
                healthyPatientCount++;
            }
        }
        System.out.printf("Число здоровых пациентов %d", healthyPatientCount);
        System.out.printf("\nСредняя температура по больнице %.1f", temperature / patientTemperature.length);
    }
}
