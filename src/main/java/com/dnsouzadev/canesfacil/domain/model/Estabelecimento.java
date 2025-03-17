package com.dnsouzadev.canesfacil.domain.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.proxy.HibernateProxy;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
public class Estabelecimento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String descricao;

    @Enumerated(EnumType.STRING)
    private Categorias categoria;

    private Endereco endereco;

    private String whatsapp;

    private BigDecimal precoFrete;

    private Boolean delivery = Boolean.TRUE;

    @OneToMany(mappedBy = "estabelecimento", cascade = CascadeType.ALL)
    private List<Produto> cardapio;

    @CreationTimestamp
    private LocalDateTime criadoEm;

    @UpdateTimestamp
    private LocalDateTime atualizadoEm;

    public void adicionarProduto(Produto produto) {
        produto.setEstabelecimento(this); // Define a relação bidirecional
        this.cardapio.add(produto);
    }

    public void removerProduto(Produto produto) {
        produto.setEstabelecimento(null); // Remove a relação
        this.cardapio.remove(produto);
    }



    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        Estabelecimento that = (Estabelecimento) o;
        return getId() != null && Objects.equals(getId(), that.getId());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }
}
