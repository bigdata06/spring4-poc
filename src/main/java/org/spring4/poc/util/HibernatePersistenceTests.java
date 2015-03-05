package org.spring4.poc.util;



import org.springframework.orm.hibernate3.HibernateTemplate;

public abstract class HibernatePersistenceTests extends HibernateORMTestCase {

    protected HibernateTemplate hibernateTemplate;

    protected HibernatePersistenceTestsStrategy strategy;

    protected DatabaseResetStrategy resetStrategy;

    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

    public void setStrategy(HibernatePersistenceTestsStrategy strategy) {
        this.strategy = strategy;
    }

    protected void onSetUp() throws Exception {
        super.onSetUp();
        strategy.onSetUp();
    }

    public void setResetStrategy(
            DatabaseResetStrategy resetStrategy) {
        this.resetStrategy = resetStrategy;
    }

    @Override
    protected void onTearDown() throws Exception {
        super.onTearDown();
        strategy.onTearDown();
    }

    public void save(Object r) {
        hibernateTemplate.save(r);
    }

    public Object load(Class type, String id) {
        return hibernateTemplate.get(type, new Integer(id));
    }

    public void doWithTransaction(TxnCallback cb) {
        strategy.doWithTransaction(cb);
    }

    public HibernateTemplate getHibernateTemplate() {
        return hibernateTemplate;
    }

    protected void delete(Class type) {
        HibernateTemplate t = getHibernateTemplate();
        t.deleteAll(t.find("from " + type.getName()));
    }

    protected void delete(Object object) {
        getHibernateTemplate().delete(object);
    }

}