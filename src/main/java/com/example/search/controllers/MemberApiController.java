package com.example.search.controllers;

import com.example.search.domains.Member;
import com.example.search.mappers.MemberMapper;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MemberApiController {

  private final MemberMapper memberMapper;

  @Autowired
  public MemberApiController(MemberMapper memberMapper) {
    this.memberMapper = memberMapper;
  }

  @GetMapping("/api/members")
  @ResponseBody
  public List<Member> all() {
    List<Member> members = memberMapper.all();
    return members;
  }

  @GetMapping("/api/members/{words}")
  @ResponseBody
  public List<Member> find(@PathVariable String words) {
    List<Member> members = memberMapper.findByNameLike(words);
    return members;
  }
}
