import java.util.*;

public class Main {

    private static int DeepCopyReference;

    public static void main(String[] args) throws CloneNotSupportedException{
        System.out.println("Початок роботи");

        Scanner scanner = new Scanner(System.in);

        ArrayList<IdleonCharacter> obj = new ArrayList<IdleonCharacter>();
        System.out.println("Введіть кількість елементів масиву: ");
        int n =scanner.nextInt();
        for(int i = 0; i < n; i++) {
            obj.add(new IdleonCharacter(
                            "Obj" +(i+1),
                            i+1,
                            i+0.1,
                            new String[]{" "}
                    )
            );
        }
        System.out.println(obj.toString());

        /*System.out.print("Бажаєте ввести параметри об'єктів? (y/n): ");
        String choice = scanner.nextLine();*/

        while(true) {
            System.out.println("Choose action:" + '\n' +
                    "1.List all elements " + '\n' +
                    "2.View element " + '\n' +
                    "3.Add element " + '\n' +
                    "4.Delete element " + '\n' +
                    "5.Sort " + '\n' +
                    "6.Add a copy of the element " + '\n' +
                    "7.Search on array " + '\n' +
                    "8.Interaction" + '\n' +
                    "9.Make tournament" + '\n' +
                    "11.Exit");
            int action = scanner.nextInt();
            int index = 0;
            switch (action) {
                case 1:
                    for (IdleonCharacter i : obj) {
                        System.out.println(i.toString());
                    }
                    break;
                case 2:
                    System.out.println("enter index of element you'd like to view:");
                    index = scanner.nextInt();
                    System.out.println(obj.get(index));
                    break;
                case 3:
                    //add element
                    System.out.println("Enter the position you'd like to put new object to:");
                    index = scanner.nextInt();
                    System.out.println("default or custom?");
                    scanner.nextLine();
                    int def_or_cus = scanner.nextInt();
                    IdleonCharacter objToAdd;
                    switch (def_or_cus){
                        case 1:
                            objToAdd = new IdleonCharacter();
                            obj.add(index, objToAdd);
                            break;
                        case 2:
                            System.out.println("enter the stats: String name, int level, double experience");
                            scanner.nextLine();
                            String name = scanner.nextLine();
                            int level = scanner.nextInt();
                            double XP = scanner.nextDouble();
                            String[] inv = new String[] {"a", "b", "c", "d", "aa", "bb", "cc", "dd"};
                            objToAdd = new IdleonCharacter(name, level, XP, inv);
                            obj.add(index, objToAdd);
                            break;
                    }

                    break;
                case 4:
                    System.out.println("enter the index of element you'd like to delete from array:");
                    index = scanner.nextInt();
                    obj.remove(index);
                    System.out.println("object removed successfully");
                    break;
                case 5:
                    Collections.sort(obj, new Comparator<IdleonCharacter>() {
                        @Override
                        public int compare(IdleonCharacter o1, IdleonCharacter o2) {
                            return Integer.compare(o1.getLevel(), o2.getLevel());
                        }
                    });
                    obj.sort(Comparator.comparingDouble(IdleonCharacter::getExperience));
                    break;
                case 6:
                    System.out.println("Enter the index of the element you'd like to copy:");
                    int copyIndex = scanner.nextInt();
                    try {
                        IdleonCharacter original = obj.get(copyIndex).clone();
                        if (original.getDeepCopyRef() != null) {
                            IdleonCharacter deepCopyRef = (IdleonCharacter) original.getDeepCopyRef().clone();
                            original.setDeepCopyRef(deepCopyRef);
                        }
                        obj.add(original);
                        System.out.println("Copy added successfully.");
                    } catch (CloneNotSupportedException e) {
                        System.out.println("Cloning not supported for this object.");
                    }
                    break;
                case 7:
                    System.out.println("Enter the parameters for search:");
                    System.out.print("Name: ");
                    String searchName = scanner.next();
                    System.out.print("Level: ");
                    int searchLevel = scanner.nextInt();
                    System.out.print("Experience: ");
                    double searchExperience = scanner.nextDouble();

                    IdleonCharacter searchObject = new IdleonCharacter(searchName, searchLevel, searchExperience, new String[0]);

                    Collections.sort(obj);

                    int searchIndex = Arrays.binarySearch(obj.toArray(), searchObject);

                    if (searchIndex >= 0) {
                        System.out.println("Object found at index: " + searchIndex);

                        for (int i = searchIndex + 1; i < obj.size(); i++) {
                            if (obj.get(i).compareTo(searchObject) == 0) {
                                System.out.println("Object found at index: " + i);
                            } else {
                                break;
                            }
                        }
                    } else {
                        System.out.println("Object not found in the array.");
                    }
                    break;
                case 8:
                    System.out.println("Enter parameters for the temporary object:");
                    System.out.print("Name: ");
                    String tempName = scanner.next();
                    System.out.print("Level: ");
                    int tempLevel = scanner.nextInt();
                    System.out.print("Experience: ");
                    double tempExperience = scanner.nextDouble();

                    IdleonCharacter tempObject = new IdleonCharacter(tempName, tempLevel, tempExperience, new String[0]);

                    for (IdleonCharacter character : obj) {
                        if (tempObject.getLevel() > character.getLevel()) {
                            System.out.println(tempObject.getName() + " is stronger than " + character.getName());
                        } else if (tempObject.getLevel() < character.getLevel()) {
                            System.out.println(tempObject.getName() + " is weaker than " + character.getName());
                        } else {
                            System.out.println(tempObject.getName() + " is as strong as " + character.getName());
                        }
                    }
                    break;
                case 9:
                    if (obj.size() % 2 != 0) {
                        System.out.println("Непарна кількість об'єктів у поточному масиві. Неможливо сформувати дві команди.");
                    } else {
                        ArrayList<IdleonCharacter> team1 = new ArrayList<>();
                        for (int i = 0; i < obj.size(); i += 2) {
                            team1.add(obj.get(i));
                        }

                        ArrayList<IdleonCharacter> team2 = new ArrayList<>();
                        for (int i = 1; i < obj.size(); i += 2) {
                            team2.add(obj.get(i));
                        }
                        if (IdleonCharacter.calculateTeamStrength(team1) > IdleonCharacter.calculateTeamStrength(team2)) {
                            System.out.println("Перша команда виграла!");
                        } else if (IdleonCharacter.calculateTeamStrength(team1) < IdleonCharacter.calculateTeamStrength(team2)) {
                            System.out.println("Друга команда виграла!");
                        } else {
                            System.out.println("Нічия!");
                        }
                    }
                    break;
            }
        }




        /*IdleonCharacter obj1;
        IdleonCharacter obj2;
        IdleonCharacter obj3;

        if (choice.equalsIgnoreCase("y")) {
            System.out.println("Введіть параметри для об'єкта 1:");
            System.out.print("Ім'я: ");
            String name1 = scanner.nextLine();
            System.out.print("Рівень: ");
            int level1 = scanner.nextInt();
            System.out.print("Досвід: ");
            double experience1 = scanner.nextDouble();
            scanner.nextLine();
            System.out.print("Інвентар: ");
            String[] inventory1 = scanner.nextLine().split(",");
            obj1 = new IdleonCharacter(name1, level1, experience1, inventory1);

            System.out.println("Введіть параметри для об'єкта 2:");
            System.out.print("Ім'я: ");
            String name2 = scanner.nextLine();
            System.out.print("Рівень: ");
            int level2 = scanner.nextInt();
            System.out.print("Досвід: ");
            double experience2 = scanner.nextDouble();
            scanner.nextLine();
            System.out.print("Інвентар: ");
            String[] inventory2 = scanner.nextLine().split(",");
            obj2 = new IdleonCharacter(name2, level2, experience2, inventory2);

            System.out.println("Введіть параметри для об'єкта 3:");
            System.out.print("Ім'я: ");
            String name3 = scanner.nextLine();
            System.out.print("Рівень: ");
            int level3 = scanner.nextInt();
            System.out.print("Досвід: ");
            double experience3 = scanner.nextDouble();
            scanner.nextLine();
            System.out.print("Інвентар: ");
            String[] inventory3 = scanner.nextLine().split(",");
            obj3 = new IdleonCharacter(name3, level3, experience3, inventory3);
        } else {
            obj1 = new IdleonCharacter("Player1", 1, 0.0, new String[10]);
            obj2 = new IdleonCharacter();
            obj3 = new IdleonCharacter();
        }*/

    }
}
