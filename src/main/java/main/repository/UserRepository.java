package main.repository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Андрей on 08.08.2017.
 */
@Repository
@Transactional(readOnly = true)
public class UserRepository {


}
