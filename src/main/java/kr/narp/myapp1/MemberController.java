package kr.narp.myapp1;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.bit.mapper.MemberMapper;
import kr.bit.model.MemberVO;

@Controller
public class MemberController {
	
	@Autowired
	//private MembermemberMapper memberMapper;
	private MemberMapper memberMapper;
	
	@RequestMapping("/memberList.do")
	public String memberList(Model model) {
		
		List<MemberVO> list = memberMapper.memberList();
		
		model.addAttribute("list",list);
		
		return "memberList";
	}

	@RequestMapping("/memberInsert.do")
	public String memberInsert(MemberVO vo) { //파라미터 수집(VO)
		
		//인코딩(한글 깨지는 부분)
		
		int cnt = memberMapper.memberInsert(vo);
		
		
		return "redirect:/memberList.do";
	}

	@RequestMapping("/memberRegister.do")
	public String memberRegister() {
		
		
		return "memberRegister";
	}
	
	@RequestMapping("/memberDelete.do")
	public String memberDelete(@RequestParam("num") int su) { //파라미터 수집:num
		
		int cnt = memberMapper.memberDelete(su);
		
		return "redirect:/memberList.do";
	}
	
	@RequestMapping("/memberContent.do")
	public String memberContent(int num, Model model) {
		
		MemberVO vo = memberMapper.memberContent(num);
		
		model.addAttribute("vo", vo);
		
		return "memberContent";
	}
	
	@RequestMapping("/memberUpdate.do")
	public String memberUpdate(MemberVO vo) {
		
		int cnt = memberMapper.memberUpdate(vo);
		
		return "redirect:/memberList.do";
	}
	
	@RequestMapping("/memberAjaxList.do")
	public @ResponseBody List<MemberVO> membeerAjaxList() {
		
		List<MemberVO> list = memberMapper.memberList();
		
		//$.ajax() -> callback 함수로 응답 -> JSON
		
		return list; // Object->JSON: @ResponseBody-> API -(jackson-databind/jackson-mapper-asl) API
	}
	
	@RequestMapping("/form.do")
	public String form() {
		
		return "uploadForm";
	}

}












