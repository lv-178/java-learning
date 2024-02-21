import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Elevator elevator = new Elevator(-3, 26);
        Dimensions dimensions = new Dimensions(50, 70, 30);
        Load load = new Load(dimensions, 23.6, "Moscow", "34abn2", false, true);
        dimensions.setHeight(234);
        load.setMass(90);
        System.out.println(load);
        Load load2 = load.setMass(30);
        System.out.println(load2);

        while (true) {
            System.out.print("Введите номер этажа: ");
            int floor = new Scanner(System.in).nextInt();
            elevator.move(floor);
        }
    }
}