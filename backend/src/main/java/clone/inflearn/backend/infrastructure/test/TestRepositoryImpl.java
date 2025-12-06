package clone.inflearn.backend.infrastructure.test;

import clone.inflearn.backend.domain.test.model.Test;
import clone.inflearn.backend.domain.test.port.TestRepository;
import clone.inflearn.backend.infrastructure.test.entity.TestEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class TestRepositoryImpl implements TestRepository {

    private final TestJpaRepository testJpaRepository;

    @Override
    public Test save(Test test) {
        return testJpaRepository.save(TestEntity.from(test))
            .toModel();
    }
}
