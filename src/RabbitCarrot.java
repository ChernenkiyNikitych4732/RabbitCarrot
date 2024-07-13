import java.util.*;

public class RabbitCarrot {
    static class Field {
        int carrotWeight;
        int count;

        Field(int carrotWeight, int count) {
            this.carrotWeight = carrotWeight;
            this.count = count;
        }
    }

    public static void main(String[] args) {
        List<Field> fields = Arrays.asList(
                new Field(1, Integer.MAX_VALUE),
                new Field(2, Integer.MAX_VALUE),
                new Field(3, Integer.MAX_VALUE),
                new Field(4, Integer.MAX_VALUE),
                new Field(5, Integer.MAX_VALUE)
        );

        int maxHops = 10;
        int maxWeightPerHop = 5;
        int totalWeight = 0;

        for (int i = 0; i < maxHops; i++) {
            int currentWeight = 0;
            List<Field> tempFileds = new ArrayList<>();

            for (Field field : fields) {
                while (field.count > 0 && currentWeight + field.carrotWeight <= maxWeightPerHop) {
                    currentWeight += field.carrotWeight;
                    field.count--;
                    tempFileds.add(new Field(field.carrotWeight, 1));
                }
            }

            totalWeight += currentWeight;
            System.out.println("Hop " + (i + 1) + ": Собрано " + currentWeight + " кг");

            for (Field tempField : tempFileds) {
                for (Field field : fields) {
                    if (field.carrotWeight == tempField.carrotWeight) {
                        break;
                    }
                }
            }
        }

        System.out.println("Общий вес собранной моркови: " + totalWeight + "кг");
    }
}