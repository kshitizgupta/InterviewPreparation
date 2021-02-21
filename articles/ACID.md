ACID Properties

Atomicity: Transaction is either completely done or not done.
Consistency: Ensures that data always remains in consistent state. If a transaction completes then all changes are applied to the database. It it errors out then everything is rolled back to the 
state when the transaction had originally started. If there is a system failure in middle of transaction, then too the rollback is done.
Isolation: Every transaction is individual and one transaction cant have the resut of another transaction until the transaction is completed.
Durability: Once the transaction completes, then the data is permanent in the database.