package kr.leejonghyup.ovo.main;

import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@org.springframework.stereotype.Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MainService {
    private final MainRepository repository;

    public List<Test> getList() {

        return repository.getList();
    }
}
