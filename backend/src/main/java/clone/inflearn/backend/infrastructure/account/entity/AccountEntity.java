package clone.inflearn.backend.infrastructure.account.entity;

import clone.inflearn.backend.domain.account.enums.AccountRole;
import clone.inflearn.backend.domain.account.model.Account;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.Set;

@Entity
@Table(name = "account")
public class AccountEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String email;

    String password;

    Set<AccountRole> roles;

    public static AccountEntity from(Account account) {
        AccountEntity accountEntity = new AccountEntity();
        accountEntity.id = account.id();
        accountEntity.email = account.email();
        accountEntity.password = account.password();
        accountEntity.roles = account.roles();

        return accountEntity;
    }

    public Account toModel() {
        return Account.builder()
            .id(id)
            .email(email)
            .password(password)
            .roles(roles)
            .build();
    }
}
