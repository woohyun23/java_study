package hello.core;

import hello.core.discount.FixDiscountPolicy;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;

// AppConfig : 애플리케이션 전체를 구성하고 설정한다는 의미를 가지는 클래스
// 애플리케이션의 실제 동작에 필요한 구현 객체를 생성
// 생성한 객체 인스턴스의 참조(레퍼런스)를 생성자를 통해 주입(연결)
// MemberServiceImpl -> MemoryMemberRepository
// OrderServiceImpl  -> MemoryMemberRepository, FixDiscountPolicy
public class AppConfig {

    public MemberService memberService() {
        // 추상화에 의존하여 MemberServiceImpl 클래스에서
        // MemoryMemberRepository를 구성하는 것이 아닌
        // 생성자를 통해서 객체가 생성 -> 생성자 주입
        // : 의존 관계 주입
        return new MemberServiceImpl(new MemoryMemberRepository());
    }

    public OrderService orderService() {
        return new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());
    }
}
