import java.io.FileWriter;
import java.io.IOException;
import java.util.PriorityQueue;

public class ToyQueue {
    private String[] ids;
    private String[] names;
    private int[] frequencies;

    public ToyQueue(String idString, String nameString, String frequencyString) {
        this.ids = idString.split(",");
        this.names = nameString.split(",");
        String[] frequencyStrings = frequencyString.split(",");
        this.frequencies = new int[frequencyStrings.length];
        for (int i = 0; i < frequencyStrings.length; i++) {
            this.frequencies[i] = Integer.parseInt(frequencyStrings[i]);
        }
    }

    public void addToQueue() {
        PriorityQueue<Toy> queue = new PriorityQueue<>((t1, t2) -> t2.getFrequency() - t1.getFrequency());

        for (int i = 0; i < ids.length; i++) {
            Toy toy = new Toy(ids[i], names[i], frequencies[i]);
            queue.add(toy);
        }

        try (FileWriter writer = new FileWriter("output.txt")) {
            for (int i = 0; i < 10 && !queue.isEmpty(); i++) {
                Toy toy = queue.poll();
                if (toy != null) {
                    writer.write(toy.toString() + "\n");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String idString = "1,2,3";
        String nameString = "Тедди,Кукла,Машинка";
        String frequencyString = "5,3,7";

        ToyQueue toyQueue = new ToyQueue(idString, nameString, frequencyString);
        toyQueue.addToQueue();
    }
}