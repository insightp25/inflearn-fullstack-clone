package clone.inflearn.backend.domain.test;

import clone.inflearn.backend.domain.test.model.Test;
import clone.inflearn.backend.domain.test.port.TestRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TestService {

    private final TestRepository testRepository;

    @Transactional
    public Test create() {
        return testRepository.save(Test.builder().build());
    }
}
