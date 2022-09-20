package test;

public class Calculator {
    private int value;


    public Calculator(){           // 디폴트 생성자
        this.value = 0;
    }

    public Calculator(int val){     // val값을 입력 받았을 때의 생성자
        this.value = val;
    }

    public void setValue(int value){    // value 필드 값 설정 메서드

        this.value = value;
    }

    public void add(int val) {      // 더하기 기능 메서드

        this.value += val;
    }

    public void add(int val, int val2){     // 더하기 기능 메서드 2 ( 2개의 값을 한번에 더함 )

        this.value += val+val2;
    }

    public void minus(int val){     // 빼기 기능 메서드

        this.value -= val;
    }

    public void multi(int val){     // 곱하기 기능 메서드
        this.value *= val;
    }

    public void divide(int val){        // 나누기 기능 메서드

        this.value /= val;
    }

    public int getValue() {     // value 필드의 값 반환 메서드

        return this.value;
    }
}




