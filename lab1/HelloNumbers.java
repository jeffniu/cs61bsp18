public class HelloNumbers {
    public static void main(String[] args) {
        int i = 0;
        int sum = i;
        while (i < 10) {
            sum = sum + i;
            i ++;
            System.out.print(sum + " ");
        }
        System.out.println();
    }
}