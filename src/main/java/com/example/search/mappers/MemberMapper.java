package com.example.search.mappers;

import com.example.search.domains.Member;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {
  List<Member> all();
  List<Member> findByNameLike(String words);
  void add(Member member);
}
