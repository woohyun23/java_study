package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// AppConfig : 애플리케이션 전체를 구성하고 설정한다는 의미를 가지는 클래스
// 애플리케이션의 실제 동작에 필요한 구현 객체를 생성
// 생성한 객체 인스턴스의 참조(레퍼런스)를 생성자를 통해 주입(연결)
// MemberServiceImpl -> MemoryMemberRepository
// OrderServiceImpl  -> MemoryMemberRepository, FixDiscountPolicy

@Configuration
public class AppConfig {

    // @Bean memberService -> new MemoryMemberRepository() 호출
    // @Bean orderService -> new MemoryMemberRepository() 호출
    // 결과적으로, 각각 다른 2개의 MemoryMemberRepository가 생성되면서 singleton이 깨지는 것 처럼 보인다.
    // => singleton이 깨질까?


    @Bean
    public MemberService memberService() {
        // 추상화에 의존하여 MemberServiceImpl 클래스에서
        // MemoryMemberRepository를 구성하는 것이 아닌
        // 생성자를 통해서 객체가 생성 -> 생성자 주입
        // : 의존성 주입
        System.out.println("call AppConfig.memberService");
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        // DB를 변경하게 되면, 이 부분만 수정하면 수정 완료
        System.out.println("call AppConfig.memberRepository");
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService() {
        System.out.println("call AppConfig.orderService");
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        // 고정 금액 할인 -> 할인율 적용을 변경
        // return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }
}
