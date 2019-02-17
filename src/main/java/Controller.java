import java.util.ArrayList;

public class Controller {
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(new InputStreamReader(System.in));
        ArrayList<Integer> inputList = new ArrayList<Integer>();
        int number = 0;
        System.out.println("Input list: " + inputList);
        System.out.println("Number: " + number);
        System.out.println("--------------------------------------------");
        Service service = new Service();
        System.out.println("Output list: " + service.choseNumbersFromListEqualsToNumber(inputList, number));
    }
}