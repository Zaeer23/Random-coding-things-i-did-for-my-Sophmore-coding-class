public class PythagoreanTriplet {
    public static void main(String[] args) {
        int a, b = 0, c = 0;
        int sum = 1000;
        boolean found = false;

        for (a = 1; a < sum / 3; a++) {
            for (b = a + 1; b < sum / 2; b++) {
                c = sum - a - b;
                if (a * a + b * b == c * c) {
                    found = true;
                    break;
                }
            }
            if (found) {
                break;
            }
        }

        System.out.println("The Pythagorean triplet is: a = " + a + ", b = " + b + ", c = " + c);
        System.out.println("The product abc is: " + (a * b * c));
    }
}

