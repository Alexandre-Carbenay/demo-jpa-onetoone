package com.example.demojpaonetoone.persistence;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demojpaonetoone.model.Child;
import com.example.demojpaonetoone.model.Parent;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ChildJpaRepositoryTest {

    @Autowired
    private ChildJpaRepository repository;

    @Test
    public void findAllWith3ChildrenAndTheirParents() {
        Collection<Child> children = repository.findAll();
        assertThat(children).isNotEmpty().hasSize(3);
        assertThat(children).containsExactlyInAnyOrder(child1(), child2(), child3());
    }

    @Test
    public void findOneWithItsParent() {
        Child child = repository.findOne(1L);
        assertThat(child).isEqualTo(child1());
    }

    private Child child1() {
        return Child.builder().id(1L).value("child1").parent(Parent.builder().id(1L).something("parent1").build())
                .build();
    }

    private Child child2() {
        return Child.builder().id(2L).value("child2").parent(Parent.builder().id(2L).something("parent2").build())
                .build();
    }

    private Child child3() {
        return Child.builder().id(3L).value("child3").parent(Parent.builder().id(3L).something("parent3").build())
                .build();
    }

}
