package hello.core.singleton;

import hello.core.AppConfig;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SingletonService{
    private static final SingletonService instance = new SingletonService();
    public static SingletonService getInstance(){
        return instance;
    }
    private SingletonService(){
    }
    public void logic(){
        System.out.println("싱글톤객체호출");
    }

    @Test
    void configTest(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = ac.getBean("memberService", MemberServiceImpl.class);
        OrderService orderService = ac.getBean("orderService", OrderServiceImpl.class);
        MemberRepository memberRepository = ac.getBean("memberRepository", MemberRepository.class);
        System.out.println(memberService.getMemberRepository());
        System.out.println(orderService.getMemberRepository());




    }

}
