package org.spring4.poc.util;

/**
 * Created by admin on 04/03/2015.
 */
public interface TxnCallback {
    public void execute() throws Throwable;
}
