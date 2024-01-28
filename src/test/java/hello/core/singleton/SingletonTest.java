package hello.core.singleton;

import hello.core.AppConfig;
import hello.core.member.MemberService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
public class SingletonTest {
    @Test
    @DisplayName("스프링 없는 순수한 DI 컨테이너")
    void pureContainer(){
        AppConfig appconfig = new AppConfig();
        MemberService memberService = appconfig.memberService();
        MemberService memberService2 = appconfig.memberService();
        System.out.println(memberService);
        System.out.println(memberService2);
        assertThat(memberService).isNotSameAs(memberService2);
    }

    @Test
    @DisplayName("싱글톤 패턴을 적용한 객체 사용")
    void singletonTest(){
        SingletonService s1 = SingletonService.getInstance();
        SingletonService s2 = SingletonService.getInstance();
        //assertThat(s1).isNotSameAs(s2);
        assertThat(s1).isSameAs(s2);
        //same ==
        //equal


    }
}
