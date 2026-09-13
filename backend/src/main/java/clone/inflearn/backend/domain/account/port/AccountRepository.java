package clone.inflearn.backend.domain.account.port;

import clone.inflearn.backend.domain.account.model.Account;

public interface AccountRepository {

    Account save(Account account);

    Account findByEmail(String username);
}
