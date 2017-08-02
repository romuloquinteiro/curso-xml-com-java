package br.com.alura.model;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

// dizendo que eh um elemento raiz
@XmlRootElement
// indicando que acessará as tags através dos campos
@XmlAccessorType(XmlAccessType.FIELD)
public class Venda {

	private String formaDePagamento;

	// indica que engloba  a tag produtos
	@XmlElementWrapper(name = "produtos")
	// e que dentro das tags produtos existirão outras tags, no caso, produto
	@XmlElement(name = "produto")
	private List<Produto> produtos;

	public String getFormaDePagamento() {
		return formaDePagamento;
	}

	public void setFormaDePagamento(String formaDePagamento) {
		this.formaDePagamento = formaDePagamento;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	@Override
	public String toString() {
		return "Forma de Pagamento: " + this.formaDePagamento + "\nprodutos:" + this.produtos;
	}
}
