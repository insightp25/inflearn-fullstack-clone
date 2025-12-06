package clone.inflearn.backend.infrastructure.test;

import clone.inflearn.backend.infrastructure.test.entity.TestEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestJpaRepository extends JpaRepository<TestEntity, Long> {
}
