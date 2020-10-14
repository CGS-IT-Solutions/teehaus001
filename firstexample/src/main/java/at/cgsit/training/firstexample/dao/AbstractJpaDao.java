package at.cgsit.training.firstexample.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;

@NoRepositoryBean
@Transactional
public abstract class AbstractJpaDao< T extends Serializable> extends HibernateDaoSupport implements IAbstractJpaDao<T> {

    private Class< T > clazz;

  @Autowired
  EntityManager entityManager;

  public final void setClazz( Class< T > clazzToSet ){
    this.clazz = clazzToSet;
  }

  @Override public T findOne(long id){
    return entityManager.find( clazz, id );
  }
  @Override public List< T > findAll(){
    return entityManager.createQuery( "from " + clazz.getName() )
        .getResultList();
  }

  @Transactional
  @Override public void create(T entity){
    entityManager.persist( entity );
  }

  @Override public T update(T entity){
    return entityManager.merge( entity );
  }

  @Override public void delete(T entity){
    entityManager.remove( entity );
  }
  @Override public void deleteById(long entityId){
    T entity = findOne( entityId );
    delete( entity );
  }
}
