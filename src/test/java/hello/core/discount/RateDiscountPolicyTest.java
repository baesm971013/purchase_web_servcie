package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
public class RateDiscountPolicyTest {
    RateDiscountPolicy discountPolicy
            = new RateDiscountPolicy();

    @Test
    @DisplayName("vip는 10% 할인이 적용됩니다")
    void vip_o(){
        Member member = new Member(
                1L,"memberVIP", Grade.VIP);
        int discount = discountPolicy.discount(member,9000);
        assertThat(discount).isEqualTo(900);
    }
    @Test
    @DisplayName("vip가 아니면 할인이 적용안된다")
    void vip_x(){
        Member member = new Member(2L, "memberB", Grade.BASIC);
        int discount = discountPolicy.discount(member,10000);
        assertThat(discount).isEqualTo(0);

    }
}
