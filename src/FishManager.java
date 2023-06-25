public class FishManager {
    private FishDatabase database;

    public FishManager(FishDatabase database) {
        this.database = database;
    }
    public void addFish(String species, String name, int tankSize, int minPh, int maxPh) {
        Fish fish = new Fish(0, species, name, tankSize, minPh, maxPh);
        database.addFish(fish);
        System.out.println("Fish added successfully.");
    }
    public void deleteFish(int id) {
        boolean deleted = database.deleteFish(id);
        if (deleted) {
            System.out.println("Fish deleted successfully.");
        } else {
            System.out.println("Fish not found with ID: " + id);
        }
    }
}
