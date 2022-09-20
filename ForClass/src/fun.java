public class fun {
    private static int a = 0;  // a의 값은 0~100

    public void control(int set){
        if(set >= 0 && set <= 100){
            a = set;
        }
        else{
            System.out.println("잘못된 범위의 값이 입력됨.");
        }
    }

    public int printer(){
        return a;
    }
}
