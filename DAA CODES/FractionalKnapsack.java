import java.util.*;


class FractionalKnapsack {

    
    static class Items {
        int value;
        int weight;

        Items(int value, int weight) {
            this.value = value;
            this.weight = weight;
        }
    }

    static double Knapsack(int w, Items[] items) {
        Arrays.sort(items, new Comparator<Items>() {
            public int compare(Items a, Items b) {
                double r1 = (double) a.value / a.weight;
                double r2 = (double) b.value / b.weight;
                return Double.compare(r2, r1); // descending
            }
        });

        double totalVal = 0.0;
        for (Items item : items) {
            if (item.weight <= w) {
                totalVal += item.value;
                w -= item.weight;
            } else {
                double fraction = (double) item.value / item.weight;
                totalVal += fraction * w;
                break;
            }
        }
        return totalVal;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of items:");
        int n = sc.nextInt();

        Items[] item = new Items[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Enter the value and weight of item " + (i + 1) + ":");
            int value = sc.nextInt();
            int weight = sc.nextInt();
            item[i] = new Items(value, weight);
        }

        System.out.println("Enter the knapsack capacity:");
        int w = sc.nextInt();

        double maxValue = Knapsack(w, item);
        System.out.println("Maximum value in Knapsack: " + maxValue);
    }
}
