public class main {
    public static void main(String[] args) {
        feibo(18);
    }
    public static int feibo(int n){
        if(n <=1){
            return n;
        }
        int first = 0 ;
        int second = 1;
        for (int i = 0; i <n-1 ; i++) {
            int sum = first +second;
            first=second;
            second=sum;
            System.out.println(first);

        }
        return second;

    }
}
