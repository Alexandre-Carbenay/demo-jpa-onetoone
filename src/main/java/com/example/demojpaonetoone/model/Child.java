package com.example.demojpaonetoone.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@NamedEntityGraph(name = "Child.withParent", attributeNodes = @NamedAttributeNode("parent"))
@Table(name = "child")
public class Child {

    @Id
    private Long   id;
    @Column
    private String value;
    @OneToOne(optional = false)
    @JoinColumn(name = "parent")
    private Parent parent;

}
