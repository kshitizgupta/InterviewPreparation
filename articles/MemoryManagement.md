#### Java Memory Management

##### Garbage Collection

Removing from the heap those objects no longer reachable. Rather than looking for that, modern algos look for the objects which need to be retained 

###### Mark And Sweep

The programs execution is first paused. This is sometimes referred to as Stop the World event. Marking can 
not execute properly if there are any threads still executing. So all the threads in the application are paused. 
GC checks every single live reference. Looks for every variable on stack and follows its reference. The objects 
found on this chain are marked as being alive. Once all the objects that are referenced are marked for keeping a 
full scan of the heap takes place and the memory occupied by those objects not marked as used can then be freed up.
The objects that are being kept are moved into single continuous block of heap which prevents fragmented memory. 
The problem is that if there are lots of object which are not garbaged then application is paused as its a stop 
the world process.
To avoid this we have something called Generational Garbage Collection

###### Generational Garbage Collection

Most objects in Java live for a very short period of time. If an object survives one cycle of gc then it probably
means that that object is gonna live forever. The heap is divided into 2 sections. One is called young generation and 
one is called old generation. New objects are created in young gen. It fills up quite quickly as its small. When memory
is filled a gc takes place on young generation. Which is likely to be having many garbage memory. So this process should 
be quick enough. There are very few objects which need to be marked. All surviving objects are copied to old generation.
GC on young gen is called **Minor collection**. The one done on old gen is called **Major collection**, runs only if its needed.
This is a lot slower as it is much bigger block of memory to sweep, there will be many objects still alive and the compacting
process will also be lengthier.

New Generation is split into 3 components - Eden and survivor0(s0) and survivor1(s1). New objects are created in eden space. Once one gc 
happens, and the objects are moved into s0. When eden gets ful again, gc happens and any objects that survive are added to s0 and whole thing
gets moved into s1. Its the compacting process, avoids the holes in the memory. The objects are moved between s0 and s1 and once when an object
survives some prefixed no. of gcs, it is moved to old generation space.

###### PermGen/Metaspace
Java6
Permanent Generation space is a part of heap. Objects in permgen space will survive for ever, it is never gaced. If permgen goes out of memory then
application will crash. There are 2 types of objects which go into permgen - Internalised Strings and meta data for classes is stored here.
Running out of pergen space, it means our application has too many classes or internalised strings. Only fix is to increase of permgen space. There is no
mem leak in this space. 

Java7 
Internalised strings are no longer stored in perm gen and these are stored in heap and can be gc'ed.

Java8
Permgen is removed altogether and now we have **metaspace**. Its a separate area of memory, not a part of heap.

###### Types of GC

1. Serial: Uses single thread
2. Parallel: Multiple threads running
3. Mostly Concurrent:  Pauses application during marking of objects and resumes while sweeping. Two of this kind are MarkSweepGC and G1GC