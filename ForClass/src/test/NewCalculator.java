package test;

public class NewCalculator extends Calculator{

    public NewCalculator(int val){      // val 값을 입력 받았을 때의 생성자
        super(val); // 부모 클래스의 생성자 호출

    }

    public NewCalculator(){        // 디폴트 생성자
        super();    // 부모 클래스의 생성자 호출
    }


    public void powerValue(){
        int val = super.getValue();
        val = val * val;
        super.setValue(val);
    }

    public void add(int val) {      // add 메서드 오버라이딩
        super.setValue(super.getValue()+val);
        //this.value = this.value + val;
        if(!isUnder100()){      // value 필드의 값이 100 이하가 되도록 필터링 해주는 코드 추가
            super.setValue(100);
        }
    }

    public void add(int val, int val2) {    // add 메서드 오버라이딩 ( 두 개의 수가 입력된 경우 )
        super.setValue(super.getValue()+val+val2);
        if(!isUnder100()){      // 마찬가지로 value 필드의 값이 100 이하가 되도록 필터링 해주는 코드 추가
            super.setValue(100);
        }
    }

    public boolean isUnder100(){        // value 필드의 값이 100 이하인지 검사해 참, 거짓 값을 반환해주는 메서드
        if(super.getValue() > 100){
            return false;
        }
        else{
            return true;
        }
    }

    public String isOdd(int num){       // value 필드의 값이 짝수인지 홀수인지 검사해 문자열을 반환해주는 메서드
        if (num % 2 == 0)
            return "짝수입니다.";
        return "홀수입니다.";
    }
}
