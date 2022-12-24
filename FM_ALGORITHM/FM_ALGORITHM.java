import java.util.Scanner;
public class FM_ALGORITHM {
    int divider, multiplier, adder;
    int countEndingZeros(String binary_number) {
        int count = 0;
        for (int i = 0; i < binary_number.length(); i++) {
            if (binary_number.charAt(binary_number.length() - i - 1) == '0') {
                count++;
            } else {
                break;
            }
        }
        return count;
    }
    int useHashFunction1(int[] input_stream) {
        int result = 0;
        int[] hash = new int[input_stream.length];
        String[] binary_value = new String[input_stream.length];
        for (int i = 0; i < input_stream.length; i++) {
            hash[i] = (input_stream[i] * this.multiplier + this.adder) % 16;
            binary_value[i] = Integer.toBinaryString(hash[i]);
            System.out.printf("%5d      %5d       %5s       %5d\n", input_stream[i], hash[i], binary_value[i],
                    countEndingZeros(binary_value[i]));
            if (result < countEndingZeros(binary_value[i])) {
                result = countEndingZeros(binary_value[i]);
            }
        }
        return (int)Math.pow(2, result);
    }

    void setHashFunction(String input_hash) {
        String[] values = input_hash.split("mod");
        this.divider = Integer.parseInt(values[1]);
        if (values[0].charAt(0) == 'x') {
            this.multiplier = 1;
        } else {
            values = values[0].split("x");
            this.multiplier = Integer.parseInt(values[0]);
            if (values.length > 1) {
                this.adder = Integer.parseInt(values[1].substring(1));
            } else {
                this.adder = 0;
            }
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("******** FM Algorithm ********");
        System.out.println("Created by: Shivkumar Chauhan");
        System.out.println("Note: 1) Enter Mod function without any bracket, enter Steam values by spacing them by on space");
        System.out.print("Enter Length of the Stream : ");
        int length_of_stream=scanner.nextInt();
        int input_stream[] =new int[length_of_stream];
        System.out.println("Enter stream value one by one below");
        for (int i = 0; i < input_stream.length; i++) {
            input_stream[i]=scanner.nextInt();
        }
        System.out.print("Enter Hash Function : ");
        String inputhash = scanner.next();
        scanner.close();
        FM_ALGORITHM fm_ALGORITHM = new FM_ALGORITHM();
        fm_ALGORITHM.setHashFunction(inputhash);
        System.out.printf("stream      hash       binary      count of trailing 0s\n");
        int result = fm_ALGORITHM.useHashFunction1(input_stream);
        System.out.println("number of distrinct element is : " + result);
    }
}
