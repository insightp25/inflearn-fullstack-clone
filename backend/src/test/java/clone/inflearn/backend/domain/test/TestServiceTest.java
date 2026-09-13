package clone.inflearn.backend.domain.test;

import clone.inflearn.backend.domain.test.port.TestRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
@Transactional
public class TestServiceTest {

    @Autowired
    TestRepository testRepository;

    @Test
    public void save() {
        // given
        clone.inflearn.backend.domain.test.model.Test test = clone.inflearn.backend.domain.test.model.Test.builder()
                .build();

        // when
        clone.inflearn.backend.domain.test.model.Test savedTest = this.testRepository.save(test);

        // then
        assertThat(savedTest.id()).isNotNull();
        assertThat(savedTest).isNotNull();
    }
}
