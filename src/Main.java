import javax.print.attribute.standard.Fidelity;
import java.util.*;

public class Main {

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
                    "8.Object interaction " + '\n' +
                    "9.Divide into 2 categories " + '\n' +
                    "10.Add cargo to boat's vault " + '\n' +
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
                    break;

                    obj.sort(Comparator.comparingDouble(IdleonCharacter::getExperience));
                case 6:
                    //deep copy of element
                    break;
                case 7:
                    //binary search
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
