package com.project.lab_clinico.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "perfiles")
public class PerfilEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_perfil") // se mantiene en la BD como id_perfil
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_area", nullable = false)
    private AreaEntity area;

    private String nombre;

    @OneToMany(mappedBy = "perfil", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore // evita ciclos infinitos
    private List<PerfilParametroEntity> perfilParametros;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AreaEntity getArea() {
        return area;
    }

    public void setArea(AreaEntity area) {
        this.area = area;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<PerfilParametroEntity> getPerfilParametros() {
        return perfilParametros;
    }

    public void setPerfilParametros(List<PerfilParametroEntity> perfilParametros) {
        this.perfilParametros = perfilParametros;
    }
}
