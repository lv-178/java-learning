public class Elevator {
    public int currentFloor = 1;
    public int maxFloor;
    public int minFloor;

    public Elevator(int minFloor, int maxFloor) {
        this.minFloor = minFloor;
        this.maxFloor = maxFloor;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public void moveDown() {
        if (currentFloor > minFloor) {
            currentFloor--;
        }
    }

    public void moveUp() {
        if (currentFloor < maxFloor) {
            currentFloor++;
        }
    }

    public void move(int floor) {
        if (floor > maxFloor | floor < minFloor) {
            System.out.println("В этом здании нет такого этажа");
            return;
        }
        if (currentFloor < floor) {
            while (currentFloor < floor) {
                moveUp();
            }
        } else if (currentFloor > floor) {
            while (currentFloor > floor) {
                moveDown();
            }
        } else {
            System.out.println("Вы уже на нужном этаже");
        }
        System.out.println("Этаж: " + currentFloor);
    }

}
