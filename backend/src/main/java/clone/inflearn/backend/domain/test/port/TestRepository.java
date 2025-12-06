package clone.inflearn.backend.domain.test.port;

import clone.inflearn.backend.domain.test.model.Test;

public interface TestRepository {

    Test save(Test test);
}
