package hello.core.singleton;

import hello.core.AppConfig;
import hello.core.member.MemberRepository;
import hello.core.member.MemberServiceImpl;
import hello.core.order.OrderServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;
public class ConfigurationSingletonTest  {

    @Test
    void cofigTest(){
        ApplicationContext ac
                = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberServiceImpl memberService
                = ac.getBean("memberService", MemberServiceImpl.class);
        OrderServiceImpl orderService
                = ac.getBean("orderService", OrderServiceImpl.class);
        MemberRepository mr
                = ac.getBean("memberRepository", MemberRepository.class);

        // 적응안되는 해피 해킹 배열로 지금 다른 키보드도 적응이 안된다.
        MemberRepository m1 = memberService.getMemberRepository();
        MemberRepository m2 = orderService.getMemberRepository();

        assertThat(m1).isEqualTo(m2);
        assertThat(m1).isEqualTo(m2);

    }
    @Test
    void configDeep(){
        ApplicationContext ac
                = new AnnotationConfigApplicationContext(AppConfig.class);
        AppConfig bean = ac.getBean(AppConfig.class);
        System.out.println(bean.getClass());
    }

}
