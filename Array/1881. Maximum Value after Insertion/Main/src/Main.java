public class Main {
    public static void main(String[] args) {
        String n = "-23246";
        int x = 2;
        maxnum(n,x);
        System.out.println("Out: "+ n);
    }

    public static void maxnum(String n , int x){
        boolean neg = false;
        if((n.charAt(0) - '0') < 0){
            n = n.substring(1);
            neg = true;
        }
        int num = Integer.parseInt(n);
        for(int i = 0;i<n.length();i++){
            if(neg){
                if(num > Integer.parseInt(n))
            }
        }
    }
}