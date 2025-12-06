package clone.inflearn.backend.infrastructure.test.entity;

import clone.inflearn.backend.domain.test.model.Test;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "test")
public class TestEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    public static TestEntity from(Test test) {
        return new TestEntity();
    }

    public Test toModel() {
        return Test.builder()
            .id(id)
            .build();
    }
}
