package org.spring4.poc.domain;

/**
 * Created by admin on 02/03/2015.
 */

    public class NoOverdraftAllowed extends OverdraftPolicyImpl {

        public void beforeDebitCheck(Account account,
                                     double originalBalance, double newBalance) throws MoneyTransferException {
            if (newBalance < 0) throw new MoneyTransferException();
        }

        public void afterDebitCheck(Account account,
                                    double originalBalance, double newBalance) {
        }
}
