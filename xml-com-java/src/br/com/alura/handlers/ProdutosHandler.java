package br.com.alura.handlers;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import br.com.alura.model.Produto;

public class ProdutosHandler extends DefaultHandler {

	private List<Produto> produtos = new ArrayList<>();
	private StringBuilder conteudo;
	private Produto produto;

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		// qname são as tags abertas do xml pela classe
		// System.out.println(qName);

		if (qName.equals("produto")) {
			produto = new Produto();
		}
		conteudo = new StringBuilder();
	}

	// começando a leitura do arquivo xml
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		conteudo.append(new String(ch, start, length));
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {

		switch (qName) {
		case "produto":
			produtos.add(produto);
			break;
		case "nome":
			produto.setNome(conteudo.toString());
			break;
		case "preco":
			double preco = Double.parseDouble(conteudo.toString());
			produto.setPreco(preco);
			break;
		default:
			break;
		}
	}

	public List<Produto> getProdutos() {
		return produtos;
	}
}
