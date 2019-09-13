public class Ages {
    public static void main(String[] args) {
        int vasyaAge = 25;
        int katyaAge = 22;
        int mishaAge = 35;

        int min = -1;
        int middle = -1;
        int max = -1;

        if(vasyaAge > katyaAge) {
            min = katyaAge;
            max = vasyaAge;
        }
        else {
            min = vasyaAge;
            max = katyaAge;
        }

        if (mishaAge > max) {
            middle = max;
            max = mishaAge;
        }
        else if (mishaAge < min) {
            middle = min;
            min = mishaAge;
        }
        else
            middle = mishaAge;

        System.out.println("Min = " + min + "\nMiddle = " + middle + "\nMax = " + max);
    }
}
