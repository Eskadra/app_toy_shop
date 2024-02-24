class Toy implements Comparable<Toy> {
    private String id;
    private String name;
    private int frequency;

    public Toy(String id, String name, int frequency) {
        this.id = id;
        this.name = name;
        this.frequency = frequency;
    }

    public int getFrequency() {
        return frequency;
    }

    @Override
    public int compareTo(Toy o) {
        return this.frequency - o.frequency;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Frequency: " + frequency;
    }
}