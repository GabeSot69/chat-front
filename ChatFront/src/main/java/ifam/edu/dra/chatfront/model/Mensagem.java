package ifam.edu.dra.chatfront.model;

import java.util.Calendar;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class Mensagem {

	private Long id;

	@NotNull(message = "O campo do Emissor não deve ficar vazio!")
	private Contato emissor;

	@NotBlank(message = "O campo do Conteúdo não deve ficar vazio!")
	private String conteudo;

	@NotNull(message = "O campo do Receptor não deve ficar vazio!")
	private Contato receptor;

	private Calendar datahora;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Contato getEmissor() {
		return emissor;
	}

	public void setEmissor(Contato emissor) {
		this.emissor = emissor;
	}

	public String getConteudo() {
		return conteudo;
	}

	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}

	public Contato getReceptor() {
		return receptor;
	}

	public void setReceptor(Contato receptor) {
		this.receptor = receptor;
	}

	public Calendar getDatahora() {
		return datahora;
	}

	public void setDatahora(Calendar datahora) {
		this.datahora = datahora;
	}

	@Override
	public String toString() {
		return "Mensagem [id=" + id + ", emissor=" + emissor + ", conteudo=" + conteudo + ", receptor=" + receptor
				+ ", datahora=" + datahora + "]";
	}
}