import java.util.*;

public class LegendaryFarming {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //materials -> shards, fragments, motes
        //материал -> количество
        Map<String, Integer> materials = new TreeMap<>();   //1. fragments   2. motes  3. shards`
        materials.put("shards", 0);
        materials.put("fragments", 0);
        materials.put("motes", 0);
        //junk -> others
        Map<String, Integer> junks = new TreeMap<>();
        boolean isOver = false;
        while (!isOver) { //прекъсваме, когато купим item (isOver == true)
            String input = scanner.nextLine();
            String[] inputData = input.split(" ");
            //["3", "Motes", "5", "stones", "5", "Shards"]
            for (int index = 0; index < inputData.length; index += 2) { //Обходим всеки ред
                int quantity = Integer.parseInt(inputData[index]);
                String material = inputData[index + 1].toLowerCase();
                //проверка дали материалът е валиден -> shards, fragments, motes
                if (material.equals("shards") || material.equals("fragments") || material.equals("motes")) {
                    int currentQuantity = materials.get(material);
                    materials.put(material, currentQuantity +  quantity);
                    //проверак дали >= 250
                    if (materials.get(material) >= 250) {
                        //печелим item
                        if (material.equals("shards")) {
                            System.out.println("Shadowmourne obtained!");
                        } else if (material.equals("fragments")) {
                            System.out.println("Valanyr obtained!");
                        } else { //motes
                            System.out.println("Dragonwrath obtained!");
                        }
                        //намалям количеството на съответния материал с 250
                        materials.put(material, materials.get(material) - 250);
                        isOver = true;
                        break;
                    }
                } else {
                    //junk
                    //putIfAbsent -> добавя само ако ключа го няма
                    if (!junks.containsKey(material)) {
                        junks.put(material, quantity);
                    } else {
                        int currentQuantity = junks.get(material);
                        junks.put(material, currentQuantity + quantity);
                    }
                }
            }
        }

        //сортираме материалите по намаляващ ред (descending order) на количестовото
        //entry: material -> quantity
        materials.entrySet().stream().sorted((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()))
                .forEach(entry -> System.out.printf("%s: %d%n", entry.getKey(), entry.getValue()));

        junks.entrySet().forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));

    }
}

