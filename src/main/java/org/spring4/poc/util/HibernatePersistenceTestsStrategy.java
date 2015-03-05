package org.spring4.poc.util;

/**
 * Created by admin on 04/03/2015.
 */

/**
 * A strategy for controlling how transactions are managed during a test
 * @author cer
 *
 */
public interface HibernatePersistenceTestsStrategy {

    /**
     * Called at the start of a test
     */
    void onSetUp();

    /**
     * Called at the end of a test
     */
    void onTearDown();

    /**
     * Called to execute part of a test within a "transaction"
     * @param cb
     */
    void doWithTransaction(TxnCallback cb);

}
