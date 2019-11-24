package roylee.dojo;

public class FizzBuzz {
    public String sayTheNumber(int i) {
        if (i % 7 == 0) {
            return "Whizz";
        }
        if (i % 15 == 0) {
            return "FizzBuzz";
        }
        if (i % 3 == 0) {
            return "Fizz";
        }
        if (i % 5 == 0) {
            return "Buzz";
        }
        if (String.valueOf(i).contains("3")) {
            return "Fizz";
        }
        return String.valueOf(i);
    }

    public static void main(String[] args) {
        FizzBuzz fizzBuzz = new FizzBuzz();
        for (int i = 1; i <= 100; i++) {
            String output = fizzBuzz.sayTheNumber(i);
            System.out.println(output);
        }
    }
}
