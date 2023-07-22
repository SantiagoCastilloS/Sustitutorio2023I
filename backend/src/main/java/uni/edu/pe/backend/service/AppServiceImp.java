package uni.edu.pe.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uni.edu.pe.backend.dao.AppDao;

@Service
@Transactional
public class AppServiceImp implements AppService {
    @Autowired
    private AppDao dao;
}
