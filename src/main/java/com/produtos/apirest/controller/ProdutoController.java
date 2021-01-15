package com.produtos.apirest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

@RestController
@RequestMapping(value = "/api")
public class ProdutoController {

	@Autowired
	private ProdutoRepository produtoRepository;

	@GetMapping("/produtos")
	public List<Produto> listarProdutos() {
		return produtoRepository.findAll();
	}

	@GetMapping("/produto/{id}")
	public Produto buscarProduto(@PathVariable(value = "id") long id) {
		return produtoRepository.findById(id);
	}

	@PostMapping("/produto")
	public Produto salvarProduto(@RequestBody Produto produto) {
		return produtoRepository.save(produto);
	}

	@DeleteMapping("/produto/{id}")
	public void deletarProduto(@PathVariable(value = "id") long id) {
		produtoRepository.deleteById(id);
	}

	@PutMapping("/produto")
	public Produto atualizarProduto(@RequestBody Produto produto) {
		return produtoRepository.save(produto);
	}
}
