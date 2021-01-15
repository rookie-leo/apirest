package com.produtos.apirest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.produtos.apirest.models.Produto;
import com.produtos.apirest.repository.ProdutoRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = "*")//Autoriza todos os dominioa a acessar a API
@RestController
@RequestMapping(value = "/api")
@Api(value = "API REST Produtos")
public class ProdutoController {

	@Autowired
	private ProdutoRepository produtoRepository;

	@GetMapping("/produtos")
	@ApiOperation(value = "Retorna uma lista de produtos cadastrados no BD")
	public List<Produto> listarProdutos() {
		return produtoRepository.findAll();
	}

	@ApiOperation(value = "Retorna um unico produto cadastrado no BD")
	@GetMapping("/produto/{id}")
	public Produto buscarProduto(@PathVariable(value = "id") long id) {
		return produtoRepository.findById(id);
	}

	@ApiOperation(value = "Cadastra um novo produto no BD")
	@PostMapping("/produto")
	public Produto salvarProduto(@RequestBody Produto produto) {
		return produtoRepository.save(produto);
	}

	@ApiOperation(value = "Delete um produto cadastrado no BD")
	@DeleteMapping("/produto/{id}")
	public void deletarProduto(@PathVariable(value = "id") long id) {
		produtoRepository.deleteById(id);
	}

	@ApiOperation(value = "Atualiza um produto cadastrado no BD")
	@PutMapping("/produto")
	public Produto atualizarProduto(@RequestBody Produto produto) {
		return produtoRepository.save(produto);
	}
}
