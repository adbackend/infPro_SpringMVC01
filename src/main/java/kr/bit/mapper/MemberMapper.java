package kr.bit.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import kr.bit.model.MemberVO;

@Mapper //MyBatis(SqlSessionFactory+SqlSession)
public interface MemberMapper {
	
	@Select("select * from member")
	public List<MemberVO> memberList(); 
	@Insert(" insert into member(id, pass, name, age, email, phone) \r\n" + 
			"	    	values (\r\n" + 
			"	    		#{id}, \r\n" + 
			"	    		#{pass}, \r\n" + 
			"	    		#{name}, \r\n" + 
			"	    		#{age}, \r\n" + 
			"	    		#{email}, \r\n" + 
			"	    		#{phone}\r\n" + 
			")")
	public int memberInsert(MemberVO vo);
	@Delete(" delete from member where num = #{num}")
	public int memberDelete(int num);
	@Select("	    SELECT * FROM member WHERE num = #{num}\r\n" + 
			"")
	public MemberVO memberContent(int num);
	@Update("	    UPDATE member SET age=#{age}, \r\n" + 
			"	    				  email=#{email}, \r\n" + 
			"	    				  phone=#{phone} \r\n" + 
			"	    				  WHERE num=#{num}")
	public int memberUpdate(MemberVO vo);
	
}
