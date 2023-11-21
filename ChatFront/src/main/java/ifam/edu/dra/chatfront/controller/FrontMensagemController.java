package ifam.edu.dra.chatfront.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ifam.edu.dra.chatfront.model.Mensagem;
import ifam.edu.dra.chatfront.service.FrontMensagemService;

@RequestMapping("/mensagem")
@Controller
public class FrontMensagemController {

	@Autowired
	FrontMensagemService frontMensagemService;

	@GetMapping
	public String showMensagens(Model model) {
		List<Mensagem> mensagem = frontMensagemService.getMensagens();
		if (mensagem.isEmpty()) {
			return "redirect:/mensagem/new";
		} else {
			model.addAttribute("mensagens", mensagem);
			return "listMensagem";
		}
	}

	@GetMapping("/new")
	public String newMensagem(Mensagem mensagem) {
		return "newMensagem";
	}

	@PostMapping
	public String addMensagem(@Validated Mensagem mensagem, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "newMensagem";
		}
		frontMensagemService.setMensagem(mensagem);
		return "redirect:/mensagem";
	}
}