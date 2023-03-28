package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class RateDiscountPolicyTest {
    RateDiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("VIP member should be discounted 10%")
    void vip_o() {
        //given
        Member vipMember = new Member(1L, "vipMember", Grade.VIP);
        // when
        int discount = discountPolicy.discount(vipMember, 10000);
        // then
        assertThat(discount).isEqualTo(1000);
    }

    @Test
    @DisplayName("BASIC member should not be discounted")
    void vip_x() {
        //given
        Member basicMember = new Member(1L, "basicMember", Grade.BASIC);
        // when
        int discount = discountPolicy.discount(basicMember, 10000);
        // then
        assertThat(discount).isNotEqualTo(1000);
        assertThat(discount).isEqualTo(0);
    }
}