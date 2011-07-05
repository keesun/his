package sample.member;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/member")
public class MemberController {

	@RequestMapping("/hi")
	public void hi(Model model){
		model.addAttribute("hi", "hi!!!!!!!!!!");
	}
	
}
