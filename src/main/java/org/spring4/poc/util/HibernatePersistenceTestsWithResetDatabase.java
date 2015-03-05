package org.spring4.poc.util;

/**
 * Created by said on 04/03/2015.
 */


    public abstract class HibernatePersistenceTestsWithResetDatabase
            extends HibernatePersistenceTests {

        @Override
        protected void onSetUp() throws Exception {
            super.onSetUp();
            resetStrategy.resetDatabase();
        }
}
