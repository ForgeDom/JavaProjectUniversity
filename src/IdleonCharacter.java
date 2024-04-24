import java.util.Arrays;
import java.util.Cte double exomparator;
import java.util.Scanner;

public class IdleonCharacter implements Comparable<IdleonCharacter> {
    private String name;
    private int level;
    privaperience;
    private String[] inventory;
    private IdleonCharacter deepCopyRef;

    private static Scanner scanner = new Scanner(System.in);

    static {
        System.out.println("Static initialization block called.");
    }



    {
        System.out.println("Instance initialization block called.");
    }

    public IdleonCharacter(String name, int level, double experience, String[] inventory) {
        this.name = name;
        this.level = level;
        this.experience = experience;
        this.inventory = inventory;
        System.out.println("Constructor with parameters called.");
        print();
    }

    public IdleonCharacter() {
        this("Unnamed", 1, 0.0, new String[10]);
        System.out.println("Default constructor called.");
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public double getExperience() {
        return experience;
    }

    public void setExperience(double experience) {
        this.experience = experience;
    }

    public String[] getInventory() {
        return inventory;
    }

    public void setInventory(String[] inventory) {
        this.inventory = inventory;
    }

    public void levelUp() {
        level++;
        System.out.println(name + " leveled up! Current level: " + level);
    }

    public void gainExperience(double exp) {
        experience += exp;
        System.out.println(name + " gained " + exp + " experience!");
    }

    public void addItemToInventory(String item) {
        for (int i = 0; i < inventory.length; i++) {
            if (inventory[i] == null) {
                inventory[i] = item;
                System.out.println(name + " added " + item + " to inventory.");
                break;
            }
        }
    }

    public void print() {
        System.out.println("IdleonCharacter Details:");
        System.out.println("Name: " + name);
        System.out.println("Level: " + level);
        System.out.println("Experience: " + experience);
        System.out.println("Inventory:");
        for (String item : inventory) {
            if (item != null) {
                System.out.println("- " + item);
            }
        }
    }

    public static void interact(IdleonCharacter obj1, IdleonCharacter obj2, IdleonCharacter obj3, Scanner scanner) {
        System.out.println("Виберіть пару об'єктів для взаємодії:");
        System.out.println("1. Об'єкт 1 та Об'єкт 2");
        System.out.println("2. Об'єкт 1 та Об'єкт 3");
        System.out.println("3. Об'єкт 2 та Об'єкт 3");
        System.out.println("4. Об'єкт 2 та Об'єкт 1");
        System.out.println("5. Об'єкт 3 та Об'єкт 1");
        System.out.println("6. Об'єкт 3 та Об'єкт 2");
        System.out.print("Ваш вибір: ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                System.out.println("Взаємодія між Об'єктом 1 та Об'єктом 2:");
                interactObjects(obj1, obj2, scanner);
                break;
            case 2:
                System.out.println("Взаємодія між Об'єктом 1 та Об'єктом 3:");
                interactObjects(obj1, obj3, scanner);
                break;
            case 3:
                System.out.println("Взаємодія між Об'єктом 2 та Об'єктом 3:");
                interactObjects(obj2, obj3, scanner);
                break;
            case 4:
                System.out.println("Взаємодія між Об'єктом 2 та Об'єктом 1:");
                interactObjects(obj2, obj1, scanner);
                break;
            case 5:
                System.out.println("Взаємодія між Об'єктом 3 та Об'єктом 1:");
                interactObjects(obj3, obj1, scanner);
                break;
            case 6:
                System.out.println("Взаємодія між Об'єктом 3 та Об'єктом 2:");
                interactObjects(obj3, obj2, scanner);
                break;
            default:
                System.out.println("Невірний вибір.");
        }
    }

    public static void interactObjects(IdleonCharacter obj1, IdleonCharacter obj2, Scanner scanner) {
        System.out.println("Оберіть предмет з інвентаря Об'єкта 1 для передачі:");
        for (int i = 0; i < obj1.getInventory().length; i++) {
            if (obj1.getInventory()[i] != null) {
                System.out.println((i + 1) + ". " + obj1.getInventory()[i]);
            }
        }
        System.out.print("Ваш вибір: ");
        int itemChoice = scanner.nextInt();
        scanner.nextLine();

        if (itemChoice < 1 || itemChoice > obj1.getInventory().length || obj1.getInventory()[itemChoice - 1] == null) {
            System.out.println("Невірний вибір предмета.");
            return;
        }

        String item = obj1.getInventory()[itemChoice - 1];
        obj1.getInventory()[itemChoice - 1] = null;
        obj2.addItemToInventory(item);
    }

    public static void editObject(IdleonCharacter obj, Scanner scanner) {
        System.out.println("Введіть нові параметри для об'єкта:");
        System.out.print("Ім'я: ");
        obj.setName(scanner.nextLine());
        System.out.print("Рівень: ");
        obj.setLevel(scanner.nextInt());
        System.out.print("Досвід: ");
        obj.setExperience(scanner.nextDouble());
        scanner.nextLine();
        System.out.print("Інвентар: ");
        obj.setInventory(scanner.nextLine().split(","));
    }

    @Override
    public IdleonCharacter clone() throws CloneNotSupportedException {
        IdleonCharacter clonedCharacter = (IdleonCharacter) super.clone();
        clonedCharacter.setDeepCopyRef(this.deepCopyRef.clone());
        return clonedCharacter;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof IdleonCharacter)) return false;
        IdleonCharacter that = (IdleonCharacter) o;
        return level == that.level &&
                Double.compare(that.experience, experience) == 0 &&
                Arrays.equals(inventory, that.inventory) &&
                name.equals(that.name);
    }

    @Override
    public String toString() {
        return "IdleonCharacter{" +
                "name='" + name + '\'' +
                ", level=" + level +
                ", experience=" + experience +
                ", inventory=" + Arrays.toString(inventory) +
                '}';
    }

    public void setDeepCopyRef(IdleonCharacter deepCopyRef) {
        this.deepCopyRef = deepCopyRef;
    }

    public IdleonCharacter getDeepCopyRef() {
        return deepCopyRef;
    }

    @Override
    public int compareTo(IdleonCharacter o) {
        return 0;
    }
}