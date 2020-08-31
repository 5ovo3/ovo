package kr.leejonghyup.ovo.main;

import lombok.RequiredArgsConstructor;
import org.qlrm.mapper.JpaResultMapper;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@org.springframework.stereotype.Repository
@RequiredArgsConstructor
public class MainRepository {
    private final EntityManager em;

    public List<Test> getList() {
        String sql = "";
        sql += "SELECT * FROM test_table ";

        Query executeQuery = em.createNativeQuery(sql);

        JpaResultMapper jpaResultMapper = new JpaResultMapper();
        List<Test> resultList = jpaResultMapper.list(executeQuery, Test.class);

        return resultList;
    }

}
