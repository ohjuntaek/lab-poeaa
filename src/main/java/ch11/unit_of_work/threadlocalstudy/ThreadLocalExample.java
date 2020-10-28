package ch11.unit_of_work.threadlocalstudy;

/**
 * @see <a href="https://javacan.tistory.com/entry/ThreadLocalUsage">자바캔 링크</a>
<pre>
{@code
- 장점 : 스레드 내에서 한 객체를 사용한다.
- 사용처 : 사용자 인증정보 전파, 트랜잭션 컨텍스트 전파 등
- 주의사항 : 변수에 보관된 데이터 사용이 끝나면 반드시 해당 데이터를 삭제해야 한다.
그렇지 않을 경우 재사용되는 스레드가 올바르지 않은 데이터를 참조할 수 있다..

> 왜? 뭐 가비지 컬렉터가 회수 안하겠지

}
</pre>
 */
public class ThreadLocalExample {
    public static void main(String[] args) {
        A a = new A();
        a.a();
    }
}

class Context {
    public static ThreadLocal<String> local = new ThreadLocal<>();
}

class A {
    public void a() {
        Context.local.set("a");
        System.out.println("========== ThreadLocal Set ==========");

        B b = new B();
        b.b();

        Context.local.remove();
        System.out.println("========== ThreadLocal Remove ==========");
    }
}

class B {
    public void b() {
        String a = Context.local.get();
        System.out.println("IN B : a = " + a);

        C c = new C();
        c.c();
    }
}

class C {
    public void c() {
        String a = Context.local.get();
        System.out.println("IN C : a = " + a);
    }
}
