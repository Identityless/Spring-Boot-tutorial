public class Main {
    public static void main(String[] args) {

        String url = "www.naver.com/books/it?page=10&size=20&name=spring-boot";

        // Base 64 encoding

        // + 추가기능 url encoding

        Encoder encoder = new Encoder(new UrlEncoder());    // 외부에서 사용하는 객체 주입받음 -> DI  (여기서는 객체를 개발자가 관리함.)
        String result = encoder.encode(url);
        System.out.println(result);

        // 같은 encoder를 계속 만들어야 하므로 추상화하여 인터페이스를 만듦
        // 인터페이스를 만들어 추상화 하였지만 메인의 코드는 변함이 없음
        // DI추가
    }
}