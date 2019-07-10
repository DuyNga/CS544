package edu.mum.service.impl;

import edu.mum.dao.OwnerDao;
import edu.mum.domain.Owner;
import edu.mum.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class OwnerServiceImpl implements OwnerService {
   @Autowired
    OwnerDao ownerDao;

    @Override
    public void save(Owner owner) {
        ownerDao.save(owner);
    }
}
