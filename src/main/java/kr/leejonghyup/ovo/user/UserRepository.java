package kr.leejonghyup.ovo.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;
import java.util.Map;

@Repository
@RequiredArgsConstructor
public class UserRepository {

    private final EntityManager em;

    public int insertUserInfo(Map map) {

        String sql = "";
        sql += "INSERT INTO UserInfo ";
        sql += "( email, password, name, tel, delete_yn, reg_date ) ";
        sql += "VALUES (?, ?, ?, ?, ?, ?) ";

        Query executeQuery = em.createNativeQuery(sql, User.class);
        executeQuery.setParameter(1, map.get("email"));
        executeQuery.setParameter(2, map.get("password"));
        executeQuery.setParameter(3, map.get("name"));
        executeQuery.setParameter(4, map.get("tel"));
        executeQuery.setParameter(5, map.get("delete_yn"));
        executeQuery.setParameter(6, map.get("reg_date"));

        return executeQuery.executeUpdate();
    }

    public List<User> emailCheck(String email) {

        String sql = "";
        sql += "SELECT * FROM UserInfo WHERE email = ? ";

        Query executeQuery = em.createNativeQuery(sql, User.class);
        executeQuery.setParameter(1, email);

        return executeQuery.getResultList();
    }

}
