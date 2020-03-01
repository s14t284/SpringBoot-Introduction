package com.example.search.controllers;

import com.example.search.domains.Member;
import com.example.search.mappers.MemberMapper;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MemberController {
  private final MemberMapper memberMapper;

  // @AutowiredはDI(Dependency Injection)をしたいときに使う
  // MemberMapperを使いたいが，interfaceで定義しているため new できない
  // 引数の型のクラスのインスタンスがコンストラクタ中の引数に渡される
  @Autowired
  public MemberController(MemberMapper memberMapper) {
    this.memberMapper = memberMapper;
  }

  @GetMapping("/")
  public String index(Model model) {
    List<Member> members = memberMapper.all();
    // Viewがmembersという名前でmembers変数に格納されているリストを参照できるようにしている
    model.addAttribute("members", members);
    return "index";
  }

  @GetMapping("create")
  public String showCreateForm() {
    return "create";
  }

  @PostMapping("/create")
  public String create(@RequestParam("member_name") String memberName) {
    Member member = new Member(memberName);
    memberMapper.add(member);
    return "redirect:/";
  }
}
