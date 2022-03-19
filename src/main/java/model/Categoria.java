package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "produto")
public class Categoria {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int codigo;

	@Column(length = 100)
	private String nome;

	@OneToMany(mappedBy = "categoria", cascade = CascadeType.ALL)
	private List<Produto> produtos;

}
