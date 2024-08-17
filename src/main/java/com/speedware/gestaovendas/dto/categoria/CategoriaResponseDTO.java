package com.speedware.gestaovendas.dto.categoria;

import com.speedware.gestaovendas.entities.Categoria;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(name = "Categoria Retorno DTO")
public class CategoriaResponseDTO {

    @Schema(description = "Código da categoria", example = "1")
    private Long codigo;

    @Schema(description = "Nome da categoria", example = "Eletrônicos")
    private String nome;
    
    public CategoriaResponseDTO(Long codigo, String nome) {
        this.codigo = codigo;
        this.nome = nome;
    }
    
    public static CategoriaResponseDTO converterParaCategoriaDTO(Categoria categoria) {
        return new CategoriaResponseDTO(categoria.getCodigo(), categoria.getNome());
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}

