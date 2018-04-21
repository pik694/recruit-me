package pik.pw.recruitme.app.model.users.domain;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.Repository;
import pik.pw.recruitme.app.infrastructure.mvc.ObjectNotFoundException;

interface UserRepository extends Repository<User, Integer> {

    User save(User user);

    User findById(Integer id);

    void deleteById(Integer id);

    Page<User> findAll(Pageable pageable);

    default User findByIdOrThrow(Integer id) {
        User user = findById(id);

        if (user == null) {
            throw new ObjectNotFoundException("User with id " + id);
        }
        return user;
    }

}
