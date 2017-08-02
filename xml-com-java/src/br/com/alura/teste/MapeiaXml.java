package br.com.alura.teste;

import java.io.File;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import br.com.alura.model.Produto;
import br.com.alura.model.Venda;

public class MapeiaXml {
	public static void main(String[] args) throws JAXBException {

		JAXBContext jaxbContext = JAXBContext.newInstance(Venda.class);

		//xmlParaObjeto(jaxbContext);

		objetoParaXml(jaxbContext);
	}

	private static void objetoParaXml(JAXBContext jaxbContext) throws JAXBException {
		Marshaller marshaller = jaxbContext.createMarshaller();
		Venda venda = new Venda();

		venda.setFormaDePagamento("Débito");
		List<Produto> produtos = new ArrayList<>();
		produtos.add(new Produto("Livro de REGEX", 59.90));
		produtos.add(new Produto("Livro de Linux", 69.90));
		venda.setProdutos(produtos);

		StringWriter writer = new StringWriter();

		marshaller.marshal(venda, writer);

		System.out.println(writer.toString());
	}

	private static void xmlParaObjeto(JAXBContext jaxbContext) throws JAXBException {
		Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
		Venda venda = (Venda) unmarshaller.unmarshal(new File("src/vendas.xml"));
		System.out.println(venda);
	}
}
