public class Man {
    private String name = "";
    private int age;
    private String adress;
    private int height;
    private int weight;

    public void setAge(int age){
        if(age >= 0){
            this.age = age;
        }
        else{
            System.out.println("유효하지 않은 나이 입니다!");
        }
    }
    int add(int a, int b){
        return a+b;
    }
}
