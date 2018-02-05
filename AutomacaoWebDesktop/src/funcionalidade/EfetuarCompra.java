package funcionalidade;

import pageObjects.PageCadastro;
import pageObjects.PageConfirmacaoPedido;
import pageObjects.PageConfirmacaoPedidoBoleto;
import pageObjects.PageEnderecos;
import pageObjects.PagePagamento;
import pageObjects.PagePrincipal;
import pageObjects.PageProduto;
import pageObjects.PageProdutoSelecionado;
import pageObjects.PageSacola;
import resource.DadosExecucao;

public class EfetuarCompra {

	public void efetuarPrimeiraCompra() throws Exception {
		
		PageCadastro pageCadastro = new PageCadastro();
		pageCadastro.preencherNome(DadosExecucao.getMassaHash("NOME"));
		pageCadastro.preencherSobrenome(DadosExecucao.getMassaHash("SOBRENOME"));
		pageCadastro.preencherSexo(DadosExecucao.getMassaHash("SEXO"));
		pageCadastro.preencherDiaNascimento(DadosExecucao.getMassaHash("DIANASC"));
		pageCadastro.preencherMesNascimento(DadosExecucao.getMassaHash("MESNASC"));
		pageCadastro.preencherAnoNascimento(DadosExecucao.getMassaHash("ANONASC"));
		pageCadastro.preencherCpf(DadosExecucao.getMassaHash("CPF"));
		pageCadastro.preencherCep(DadosExecucao.getMassaHash("CEP"));
		pageCadastro.preencherTipoEndereco(DadosExecucao.getMassaHash("TIPO_ENDERECO"));
		pageCadastro.preencherRua(DadosExecucao.getMassaHash("RUA"));
		pageCadastro.preencherNumero(DadosExecucao.getMassaHash("NUMERO"));
		pageCadastro.preencherComplemento(DadosExecucao.getMassaHash("COMPLEMENTO"));
		pageCadastro.preencherBairro(DadosExecucao.getMassaHash("BAIRRO"));
		pageCadastro.preencherUf(DadosExecucao.getMassaHash("UF"));
		pageCadastro.preencherCidade(DadosExecucao.getMassaHash("CIDADE"));
		pageCadastro.preencherReferencia(DadosExecucao.getMassaHash("REFERENCIA"));
		pageCadastro.preencherEnderecoEntrega(DadosExecucao.getMassaHash("ENDERECO_ENTREGA"));
		pageCadastro.preencherTelefone(DadosExecucao.getMassaHash("TELEFONE"));
		pageCadastro.preencherOutroTelefone(DadosExecucao.getMassaHash("OUTRO_TEL"));
		pageCadastro.checarAndamentoPedido(DadosExecucao.getMassaHash("ACOMPANHAR_PEDIDO"));
		pageCadastro.preencherSenha(DadosExecucao.getMassaHash("SENHA"));
		pageCadastro.checarReceberOferta(DadosExecucao.getMassaHash("RECEBER_OFERTAS"));
		pageCadastro.pressionarContinuar();
		
		PagePrincipal pagePrincipal = new PagePrincipal();
		pagePrincipal.buscarProduto(DadosExecucao.getMassaHash("PRODUTO"));
		
		PageProduto pageProduto = new PageProduto();
		pageProduto.selecionarProduto(DadosExecucao.getMassaHash("DESC_PRODUTO"));
		
		PageProdutoSelecionado pageProdutoSelecionado = new PageProdutoSelecionado();
		pageProdutoSelecionado.selecionarTamanho(DadosExecucao.getMassaHash("TAMANHO"));
		pageProdutoSelecionado.pressionarCompra();
		
		PageSacola pageSacola = new PageSacola();
		pageSacola.pressionarCalcularFrete();
		pageSacola.pressionarConcluirCompra();
		
		PagePagamento pagePagamento = new PagePagamento();
		pagePagamento.preencherNumeroCartao(DadosExecucao.getMassaHash("NUMERO_CARTAO"));
		pagePagamento.preencherNomeCartao(DadosExecucao.getMassaHash("NOME_CARTAO"));
		pagePagamento.preencherMesCartao(DadosExecucao.getMassaHash("MES_VALIDADE"));
		pagePagamento.preencherAnoCartao(DadosExecucao.getMassaHash("ANO_VALIDADE"));
		pagePagamento.preencherCodigoCartao(DadosExecucao.getMassaHash("CODIGO_SEGURANCA"));
		pagePagamento.selecionarFrete(DadosExecucao.getMassaHash("FRETE"), DadosExecucao.getMassaHash("DIA_AGENDAMENTO"), DadosExecucao.getMassaHash("PERIODO"), DadosExecucao.getMassaHash("ESTADO_RETIRADA"), DadosExecucao.getMassaHash("CIDADE_RETIRADA"), DadosExecucao.getMassaHash("BAIRRO_RETIRADA"));
		pagePagamento.preencherParcelamento(Integer.parseInt(DadosExecucao.getMassaHash("NUMERO_PARCELAS")));
		pagePagamento.pressionarCartaoCredito();
		
		PageConfirmacaoPedido pageConfirmacaoPedido = new PageConfirmacaoPedido();
		pageConfirmacaoPedido.veficarPedido(DadosExecucao.getMassaHash("USUARIO"));
		pageConfirmacaoPedido.pressionarLinkHome();
		
		
	}

	
	
	public void efetuarCompraAlterandoEndereco() throws Exception {
		
		PagePrincipal pagePrincipal = new PagePrincipal();
		pagePrincipal.buscarProduto(DadosExecucao.getMassaHash("PRODUTO"));
		
		PageProduto pageProduto = new PageProduto();
		pageProduto.selecionarProduto(DadosExecucao.getMassaHash("DESC_PRODUTO"));
		
		PageProdutoSelecionado pageProdutoSelecionado = new PageProdutoSelecionado();
		pageProdutoSelecionado.selecionarTamanho(DadosExecucao.getMassaHash("TAMANHO"));
		pageProdutoSelecionado.pressionarCompra();
		
		PageSacola pageSacola = new PageSacola();
		pageSacola.pressionarCalcularFrete();
		pageSacola.pressionarConcluirCompra();
		
		PagePagamento pagePagamento = new PagePagamento();
		pagePagamento.pressionarAlterarEndereco();
		
		PageEnderecos pageEnderecos = new PageEnderecos();
		pageEnderecos.pressionarCadastrarEndereco();
		pageEnderecos.preencherTituloEndereco(DadosExecucao.getMassaHash("TITULO_ENDERECO"));
		pageEnderecos.preencherDestinatario(DadosExecucao.getMassaHash("NOME"));
		pageEnderecos.preencherCep(DadosExecucao.getMassaHash("CEP"));
		pageEnderecos.preencherTipoEndereco(DadosExecucao.getMassaHash("TIPO_ENDERECO"));
		pageEnderecos.preencherRua(DadosExecucao.getMassaHash("RUA"));
		pageEnderecos.preencherNumero(DadosExecucao.getMassaHash("NUMERO"));
		pageEnderecos.preencherComplemento(DadosExecucao.getMassaHash("COMPLEMENTO"));
		pageEnderecos.preencherBairro(DadosExecucao.getMassaHash("BAIRRO"));
		pageEnderecos.preencherUf(DadosExecucao.getMassaHash("UF"));
		pageEnderecos.preencherCidade(DadosExecucao.getMassaHash("CIDADE"));
		pageEnderecos.preencherReferencia(DadosExecucao.getMassaHash("REFERENCIA"));
		pageEnderecos.pressionarSalvar();
		
		pagePagamento.preencherNumeroCartao(DadosExecucao.getMassaHash("NUMERO_CARTAO"));
		pagePagamento.preencherNomeCartao(DadosExecucao.getMassaHash("NOME_CARTAO"));
		pagePagamento.preencherMesCartao(DadosExecucao.getMassaHash("MES_VALIDADE"));
		pagePagamento.preencherAnoCartao(DadosExecucao.getMassaHash("ANO_VALIDADE"));
		pagePagamento.preencherCodigoCartao(DadosExecucao.getMassaHash("CODIGO_SEGURANCA"));
		pagePagamento.selecionarFrete(DadosExecucao.getMassaHash("FRETE"), DadosExecucao.getMassaHash("DIA_AGENDAMENTO"), DadosExecucao.getMassaHash("PERIODO"), DadosExecucao.getMassaHash("ESTADO_RETIRADA"), DadosExecucao.getMassaHash("CIDADE_RETIRADA"), DadosExecucao.getMassaHash("BAIRRO_RETIRADA"));
		pagePagamento.preencherParcelamento(Integer.parseInt(DadosExecucao.getMassaHash("NUMERO_PARCELAS")));
		pagePagamento.pressionarCartaoCredito();
				
		PageConfirmacaoPedido pageConfirmacaoPedido = new PageConfirmacaoPedido();
		pageConfirmacaoPedido.veficarPedido(DadosExecucao.getMassaHash("USUARIO"));
		pageConfirmacaoPedido.pressionarLinkHome();

		
	}

	
	public void efetuarCompraSelecionandoEndereco() throws Exception {

		PagePrincipal pagePrincipal = new PagePrincipal();
		pagePrincipal.buscarProduto(DadosExecucao.getMassaHash("PRODUTO"));
		
		PageProduto pageProduto = new PageProduto();
		pageProduto.selecionarProduto(DadosExecucao.getMassaHash("DESC_PRODUTO"));
		
		PageProdutoSelecionado pageProdutoSelecionado = new PageProdutoSelecionado();
		pageProdutoSelecionado.selecionarTamanho(DadosExecucao.getMassaHash("TAMANHO"));
		pageProdutoSelecionado.pressionarCompra();
		
		PageSacola pageSacola = new PageSacola();
		pageSacola.pressionarCalcularFrete();
		pageSacola.pressionarConcluirCompra();
		
		PagePagamento pagePagamento = new PagePagamento();
		pagePagamento.pressionarAlterarEndereco();
		
		PageEnderecos pageEnderecos = new PageEnderecos();
		pageEnderecos.selecionarEndereco(DadosExecucao.getMassaHash("ENDERECO"));
		
		pagePagamento.preencherNumeroCartao(DadosExecucao.getMassaHash("NUMERO_CARTAO"));
		pagePagamento.preencherNomeCartao(DadosExecucao.getMassaHash("NOME_CARTAO"));
		pagePagamento.preencherMesCartao(DadosExecucao.getMassaHash("MES_VALIDADE"));
		pagePagamento.preencherAnoCartao(DadosExecucao.getMassaHash("ANO_VALIDADE"));
		pagePagamento.preencherCodigoCartao(DadosExecucao.getMassaHash("CODIGO_SEGURANCA"));
		pagePagamento.selecionarFrete(DadosExecucao.getMassaHash("FRETE"), DadosExecucao.getMassaHash("DIA_AGENDAMENTO"), DadosExecucao.getMassaHash("PERIODO"), DadosExecucao.getMassaHash("ESTADO_RETIRADA"), DadosExecucao.getMassaHash("CIDADE_RETIRADA"), DadosExecucao.getMassaHash("BAIRRO_RETIRADA"));
		pagePagamento.preencherParcelamento(Integer.parseInt(DadosExecucao.getMassaHash("NUMERO_PARCELAS")));
		pagePagamento.pressionarCartaoCredito();
		
		PageConfirmacaoPedido pageConfirmacaoPedido = new PageConfirmacaoPedido();
		pageConfirmacaoPedido.veficarPedido(DadosExecucao.getMassaHash("USUARIO"));
		pageConfirmacaoPedido.pressionarLinkHome();

		
	}
	
	
	
	public void efetuarPrimeiraCompraBoleto() throws Exception {
		
		PageCadastro pageCadastro = new PageCadastro();
		pageCadastro.preencherNome(DadosExecucao.getMassaHash("NOME"));
		pageCadastro.preencherSobrenome(DadosExecucao.getMassaHash("SOBRENOME"));
		pageCadastro.preencherSexo(DadosExecucao.getMassaHash("SEXO"));
		pageCadastro.preencherDiaNascimento(DadosExecucao.getMassaHash("DIANASC"));
		pageCadastro.preencherMesNascimento(DadosExecucao.getMassaHash("MESNASC"));
		pageCadastro.preencherAnoNascimento(DadosExecucao.getMassaHash("ANONASC"));
		pageCadastro.preencherCpf(DadosExecucao.getMassaHash("CPF"));
		pageCadastro.preencherCep(DadosExecucao.getMassaHash("CEP"));
		pageCadastro.preencherTipoEndereco(DadosExecucao.getMassaHash("TIPO_ENDERECO"));
		pageCadastro.preencherRua(DadosExecucao.getMassaHash("RUA"));
		pageCadastro.preencherNumero(DadosExecucao.getMassaHash("NUMERO"));
		pageCadastro.preencherComplemento(DadosExecucao.getMassaHash("COMPLEMENTO"));
		pageCadastro.preencherBairro(DadosExecucao.getMassaHash("BAIRRO"));
		pageCadastro.preencherUf(DadosExecucao.getMassaHash("UF"));
		pageCadastro.preencherCidade(DadosExecucao.getMassaHash("CIDADE"));
		pageCadastro.preencherReferencia(DadosExecucao.getMassaHash("REFERENCIA"));
		pageCadastro.preencherEnderecoEntrega(DadosExecucao.getMassaHash("ENDERECO_ENTREGA"));
		pageCadastro.preencherTelefone(DadosExecucao.getMassaHash("TELEFONE"));
		pageCadastro.preencherOutroTelefone(DadosExecucao.getMassaHash("OUTRO_TEL"));
		pageCadastro.checarAndamentoPedido(DadosExecucao.getMassaHash("ACOMPANHAR_PEDIDO"));
		pageCadastro.preencherSenha(DadosExecucao.getMassaHash("SENHA"));
		pageCadastro.checarReceberOferta(DadosExecucao.getMassaHash("RECEBER_OFERTAS"));
		pageCadastro.pressionarContinuar();
		
		PagePrincipal pagePrincipal = new PagePrincipal();
		pagePrincipal.buscarProduto(DadosExecucao.getMassaHash("PRODUTO"));
		
		PageProduto pageProduto = new PageProduto();
		pageProduto.selecionarProduto(DadosExecucao.getMassaHash("DESC_PRODUTO"));
		
		PageProdutoSelecionado pageProdutoSelecionado = new PageProdutoSelecionado();
		pageProdutoSelecionado.selecionarTamanho(DadosExecucao.getMassaHash("TAMANHO"));
		pageProdutoSelecionado.pressionarCompra();
		
		PageSacola pageSacola = new PageSacola();
		pageSacola.pressionarCalcularFrete();
		pageSacola.pressionarConcluirCompra();
		
		PagePagamento pagePagamento = new PagePagamento();
		pagePagamento.selecionarFrete(DadosExecucao.getMassaHash("FRETE"), DadosExecucao.getMassaHash("DIA_AGENDAMENTO"), DadosExecucao.getMassaHash("PERIODO"), DadosExecucao.getMassaHash("ESTADO_RETIRADA"), DadosExecucao.getMassaHash("CIDADE_RETIRADA"), DadosExecucao.getMassaHash("BAIRRO_RETIRADA"));
		pagePagamento.pressionarBoleto();
		
		PageConfirmacaoPedidoBoleto pageConfirmacaoPedidoBoleto = new PageConfirmacaoPedidoBoleto();
		pageConfirmacaoPedidoBoleto.veficarPedido(DadosExecucao.getMassaHash("USUARIO"));
		pageConfirmacaoPedidoBoleto.pressionarLinkHome();
		
		
	}
	
	
	
	public void efetuarCompraAlterandoEnderecoBoleto() throws Exception {

		PagePrincipal pagePrincipal = new PagePrincipal();
		pagePrincipal.buscarProduto(DadosExecucao.getMassaHash("PRODUTO"));
		
		PageProduto pageProduto = new PageProduto();
		pageProduto.selecionarProduto(DadosExecucao.getMassaHash("DESC_PRODUTO"));
		
		PageProdutoSelecionado pageProdutoSelecionado = new PageProdutoSelecionado();
		pageProdutoSelecionado.selecionarTamanho(DadosExecucao.getMassaHash("TAMANHO"));
		pageProdutoSelecionado.pressionarCompra();
		
		PageSacola pageSacola = new PageSacola();
		pageSacola.pressionarCalcularFrete();
		pageSacola.pressionarConcluirCompra();
		
		PagePagamento pagePagamento = new PagePagamento();
		pagePagamento.pressionarAlterarEndereco();
		
		PageEnderecos pageEnderecos = new PageEnderecos();
		pageEnderecos.pressionarCadastrarEndereco();
		pageEnderecos.preencherTituloEndereco(DadosExecucao.getMassaHash("TITULO_ENDERECO"));
		pageEnderecos.preencherDestinatario(DadosExecucao.getMassaHash("NOME"));
		pageEnderecos.preencherCep(DadosExecucao.getMassaHash("CEP"));
		pageEnderecos.preencherTipoEndereco(DadosExecucao.getMassaHash("TIPO_ENDERECO"));
		pageEnderecos.preencherRua(DadosExecucao.getMassaHash("RUA"));
		pageEnderecos.preencherNumero(DadosExecucao.getMassaHash("NUMERO"));
		pageEnderecos.preencherComplemento(DadosExecucao.getMassaHash("COMPLEMENTO"));
		pageEnderecos.preencherBairro(DadosExecucao.getMassaHash("BAIRRO"));
		pageEnderecos.preencherUf(DadosExecucao.getMassaHash("UF"));
		pageEnderecos.preencherCidade(DadosExecucao.getMassaHash("CIDADE"));
		pageEnderecos.preencherReferencia(DadosExecucao.getMassaHash("REFERENCIA"));
		pageEnderecos.pressionarSalvar();
		
		pagePagamento.selecionarFrete(DadosExecucao.getMassaHash("FRETE"), DadosExecucao.getMassaHash("DIA_AGENDAMENTO"), DadosExecucao.getMassaHash("PERIODO"), DadosExecucao.getMassaHash("ESTADO_RETIRADA"), DadosExecucao.getMassaHash("CIDADE_RETIRADA"), DadosExecucao.getMassaHash("BAIRRO_RETIRADA"));
		pagePagamento.pressionarBoleto();
		
		PageConfirmacaoPedidoBoleto pageConfirmacaoPedidoBoleto = new PageConfirmacaoPedidoBoleto();
		pageConfirmacaoPedidoBoleto.veficarPedido(DadosExecucao.getMassaHash("USUARIO"));
		pageConfirmacaoPedidoBoleto.pressionarLinkHome();
		
	}

	
	public void efetuarCompraSelecionandoEnderecoBoleto() throws Exception {

		PagePrincipal pagePrincipal = new PagePrincipal();
		pagePrincipal.buscarProduto(DadosExecucao.getMassaHash("PRODUTO"));
		
		PageProduto pageProduto = new PageProduto();
		pageProduto.selecionarProduto(DadosExecucao.getMassaHash("DESC_PRODUTO"));
		
		PageProdutoSelecionado pageProdutoSelecionado = new PageProdutoSelecionado();
		pageProdutoSelecionado.selecionarTamanho(DadosExecucao.getMassaHash("TAMANHO"));
		pageProdutoSelecionado.pressionarCompra();
		
		PageSacola pageSacola = new PageSacola();
		pageSacola.pressionarCalcularFrete();
		pageSacola.pressionarConcluirCompra();
		
		PagePagamento pagePagamento = new PagePagamento();
		pagePagamento.pressionarAlterarEndereco();
		
		PageEnderecos pageEnderecos = new PageEnderecos();
		pageEnderecos.selecionarEndereco(DadosExecucao.getMassaHash("ENDERECO"));
		
		pagePagamento.selecionarFrete(DadosExecucao.getMassaHash("FRETE"), DadosExecucao.getMassaHash("DIA_AGENDAMENTO"), DadosExecucao.getMassaHash("PERIODO"), DadosExecucao.getMassaHash("ESTADO_RETIRADA"), DadosExecucao.getMassaHash("CIDADE_RETIRADA"), DadosExecucao.getMassaHash("BAIRRO_RETIRADA"));
		pagePagamento.pressionarBoleto();
		
		PageConfirmacaoPedidoBoleto pageConfirmacaoPedidoBoleto = new PageConfirmacaoPedidoBoleto();
		pageConfirmacaoPedidoBoleto.veficarPedido(DadosExecucao.getMassaHash("USUARIO"));
		pageConfirmacaoPedidoBoleto.pressionarLinkHome();
		
	}

}
