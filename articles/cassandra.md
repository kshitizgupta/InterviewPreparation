# Introduction

## Fault Tolerant
Data is automatically replicated to multiple nodes for fault-tolerance. Replication across multiple
data centres is supported. Failed nodes can be replaced with no down time. You dont ever lose data

## Performant
Its super fast. With no single point of failure. No reliance on master node or anthing as every node is 
independent of each other. Every node is identical.

## Scalable
Some of the lasrgest prod deployment includes apples with over 75000 nodes storing over 10PB of data
Netflix with about 2500 nodes with 450TB of data 1trillion requests per day.

## Durable
Its durable. We dont lose the data even if a data centre goes down.

## Elastic
Read and write throughputs increase linearly as new machines are added to the cluster with
no downtime or interruptions to the application.

# CAP Theorem
The CAP theorem (also called Brewer’s theorem) states that a distributed database system can only 
guarantee two out of these three characteristics: **Consistency**, **Availability**, and **Partition Tolerance**.

## Consistency
A system is said to be consistent if all nodes see same data at the same time. Simply put if we
perform a read operation, the system should return the value of most recent write operation i.e. all
nodes must return the same data.

## Availability
Availability in a distributed system means that the system must remain available 100% of the time. Every
request gets a response regardless of the current state of the node. This does not guarantee that the
read returns you the latest written data.

## Partition Tolerance
This condition states that the system does not fail regardless of if the messages are dropped
or delayed in between the nodes in a system. It is made possible by sufficiently replicating data
across combinations of nodes and networks. Function in case of network partition or failure
A network partition when one node is not able to communicate to other nodes or set of nodes.

A system can have any two properties out of the three. Can't have all the three. In most systems we gotto have the 
partition tolerance as some of the node is bound to go down. So the choice is basically between consistency and 
availability.


**AC**: mysql, postgresql
**CP**: mongodb, apache hbase, redis
**AP**: cassandra, dynamodb

Cassandra offers different levels of consistency which is configurable.

# How to model data in Cassandra?
De-normalization and duplication of data is the accepted approach in Cassandra

#### Normalization 
Dividing larger table into smaller ones or breaking into smaller tables to reduce duplicity of data is called normalization.

###### Advantages:
1. Smaller database, redundant data removed
2. Helps in easily managing the data, saves storage space

###### Disadvantages
1. To fetch the data it may require to join the tables which will affect the performance
2. Complex queries to fetch the data
3. Updating data is slow as there could be hard constraints like foreign key constraints between tabled
4. Read and write latency
5. Normalized data has to be in one data centre, they aren't distributed, so face problems like
    * Geographical delays
    * No support for big data, performs well upto a limit say 5TB of data

#### De-normalization
1. You need lower latency during read and write
2. Support for big data
3. Data can be retrieved across geography
4. No need to join data

Storing data i.e. disk space is cheap compared to CPU memory or network. Writes are cheap as well. 
If we need to perform extra writes in order to improve read efficiency then its a good choice to take.
Whats expensive is the reads.

This is the **Query First Approach**. We should think about the queries we need to support
in our application and design the tables accordingly. Aim should be that a read query is answered
by a reading a single table and partition. That's what will make the query absolutely efficient.


# Key Concepts
## Partition Rings And Token
Optimal reads involve accessing as few nodes per request. To know exactly what node containsthe data 
we want, cassandra uses partitioning data on partition key. 
The partition key is run through a hash function to generate a token. This token is used to identify
the node on which the data is stored. We can imagine all the nodes arranged in a hypothetical ring
like structure and the ranges falling on that ring are basically the token ranges allocated to
different nodes. All the partition keys resulting within a token range are directed to the node
corresponding to that token range. 
Such kind of hashing strategy is known as **Consistent Hashing**. When a node gets added or removed, there
is less amount of reshuffling of data required.

## Replication, Data Centres & Racks
Copies of data are created, so there is no single point of failure. Replication ensures fault tolerance and 
reliability.
Same piece of data could go into multiple data centres. If a data centre goes down for ex. if we have data centres
in US and EU and say EU goes down, then data shall still be available in US data centre.
Cassandra also has concept of racks. Rack in a data centre is a collection of connected machines. Like each data
centre might have multiple racks. Data can also be replicated to different racks in a data centre or different
racks in multiple data centres.
When we add a new node, we add it to a data centre and a rack.

How does cassandra knows where is a data replicated to?
2 strategies to determine this: Simple Strategy and Network Topology
Replication factor is defined for each keyspace. Based on replication factor, the data goes
around the partition ring and is replicated to different nodes. Obviously replication factor cant be more than 
no of nodes.

Network Topology strategy is much more complex. It allows us to set different replication factor in different 
data centres.

## Eventual Consistency
When data is replicated across several nodes, cassandra needs to synchronize that data as well. This is data
consistency. Eventual consistency is referred to synchronizing data is a distributed environment.
The data is not instantly but eventually consistent as it takes some time to replicate data to different nodes.
In that tiny amount of time, there is a chance that we do not get the latest written data.
But this is not as bad as it sounds.

The consistency is tunable and we can define the consistency level we need for read and writes. Its a 
cost we need to define as per the requirements of our applications. We can configure the no of nodes to
which data is replicated that must acknowledge the read and write operations before cassandra marks
those operations as successful.

## Primary Key
Is the partition key and is single, picked up from the firs column name mentioned in the
create table statement. For example below in both cases, isbn is the partition key

`CREATE TABLE books (
   isbn text,
   title text,
   author text,
  publisher text,
   category text,
   PRIMARY KEY (isbn)
);
CREATE TABLE books (
   isbn text,
   title text,
   author text,
   publisher text,
   category text,
   PRIMARY KEY (isbn, author, publisher)
);`

## Composite Key
isbn + author is the primary key

`CREATE TABLE books (
   isbn text,
   title text,
   author text,
   publisher text,
   category text,
   PRIMARY KEY ((isbn, author), publisher)
);`

## Compound Key & Clustering Keys
isbn is the primary key and author, publisher are the clustering keys. Clustering keys
are responsible for sorting data within a partition

`CREATE TABLE books (
   isbn text,
   title text,
   author text,
   publisher text,
   category text,
   PRIMARY KEY (isbn, author, publisher)
);`

To sort in descending order we need to add order by command

`CREATE TABLE books (
   isbn text,
   title text,
   author text,
   publisher text,
   category text,
   PRIMARY KEY (isbn, author, publisher)
);
WITH CLUSTERING ORDER BY (author DESC, publisher ASC);`

We should decide the order based on application requirements.

## Consistency Level
While writing, it represents the no of data to which data must be written atleast to and
acknowledged to declare a write as successful.

While reading, it represents the no of nodes which should respond to with data before I can
mark a read as successful.

PS: cassandra also looks at the timestamp of the data to decide the most recent data and 
returns that.

Consistency Level Quorom defines that majority of nodes acknowledge to the reads and writes.

# Gossip Protocol
Cassandra uses gossip protocol to discover node state for all nodes in a cluster. Nodes discover information
about other nodes by exchanging state information about themselves and other nodes they know about. Nodes dont
exchange information with every other node but only 3 nodes. This reduces network load and in a small period
of time information about all the nodes is propogated throught the cluster. This facilitates failure detection.

# Bloom Filters
This is a way to determine if a data set contains some data we are looking for or not. It answers in may exist or
definitely does not exist in a data set. 

# Write Path
A client can connect to any node in the cluster. The node to which it connects to is called the coordinator. 
Coordinator is responsible for serving the client's request. The consistency level determines the no. of nodes
coordinator has to refer to before replying to the client.

Every instance of cassandra is running in a JVM and has access to memory and disk. So it can store data in memory 
and disk.

Each node first writes the data to a commit log and then writes it to memtable. Writing to commit log ensures
durability as data is only written to the disk when memtable is flushed to the disk. The commit log is used to 
re-manufacture in case of node failures. 

Memtable is in memory. When memtable is flushed it creates SSTable is created on disk. Then the memtable and commit
logs are deleted. SStables are compacted into smaller no of ss tables.


# Read Path

Data could be stored in many locations - commit log, memtable, no of ss tables.

First we look at memtable and then ss tables. Decides based on the timestamp. Cassandra stores data in SSTable in an 
ordered format. To efficiently search in this data cassandra goes through a no. of steps:
1. Bloom Filter: Could tell data might be there or definitely not here.
2. Key Cache: Stores address of frequently accessed data
3. Partition Summary: This helps partition index becomes too long. Groups the partition index. Kind of partition 
index of partition index.
4. Partition Index: Maintains full sets of where different sets of data exists. Like partition index on country name, this
 will hold the information of where a particular country data starts in.

Caches are also written to dsk to rebuild in case of node failures.