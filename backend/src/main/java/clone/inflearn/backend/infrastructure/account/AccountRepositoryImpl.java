package clone.inflearn.backend.infrastructure.account;

import clone.inflearn.backend.domain.account.model.Account;
import clone.inflearn.backend.domain.account.port.AccountRepository;
import clone.inflearn.backend.infrastructure.account.entity.AccountEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class AccountRepositoryImpl implements AccountRepository {

    private final AccountJpaRepository accountJpaRepository;

    @Override
    public Account save(Account account) {
        return accountJpaRepository.save(AccountEntity.from(account))
            .toModel();
    }

    @Override
    public Account findByEmail(String username) {
        return accountJpaRepository.findByEmail(username)
            .orElseThrow(() -> new UsernameNotFoundException(username))
            .toModel();
    }
}
